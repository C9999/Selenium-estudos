package teste;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;


public class LanceSystemTeste {
	private ChromeDriver driver;
	private LeiloesPage leiloes;
	
	@Before
	public void inicializa(){
		System.setProperty("webdriver.chrome.driver","C:\\Drivers-Tester\\3chromedriver.exe");
		driver = new ChromeDriver();
		leiloes = new LeiloesPage(driver);
		
		//cenario padrão
		UsuariosPage usuarios = new UsuariosPage(driver);
		usuarios.visita();
		usuarios.novo().cadastro("Paulo Silveira", "paulo@s.com");
		usuarios.novo().cadastro("Guga Mafra", "gg@m.com");
		
		LeiloesPage leiloes = new LeiloesPage(driver);
		leiloes.visita();
		leiloes.novo().preenche("Bike", 99, "Paulo Silveira", false);
	}
	
	@Test
	public void deveFazerUmLance(){
		DetalhesDoLeilaoPage lances = leiloes.detalhes(1);
				
		lances.lance("Guga Mafra", 150);
		
		assertTrue(lances.existeLance("Guga Mafra", 150.0));
	}
}
