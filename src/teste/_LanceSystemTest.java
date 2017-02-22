package teste;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _LanceSystemTest {
	private ChromeDriver driver;
	private LeiloesPage leiloes;


	@Before
	public void criaCenario() {
		System.setProperty("webdriver.chrome.driver","C:\\Drivers-Tester\\3chromedriver.exe");
		driver = new ChromeDriver();
		DetalhesDoLeilaoPage lances = new DetalhesDoLeilaoPage(driver);
		leiloes = new LeiloesPage(driver);
	


		new CriadorDeCenarios(driver)
		.umUsuario("Paulo Henrique", "paulo@henrique.com")
		.umUsuario("José Alberto", "jose@alberto.com")
		.umLeilao("Paulo Henrique", "Geladeira", 100, false);


	}

	@Test
	public void deveFazerUmLance(){
		DetalhesDoLeilaoPage lances = leiloes.detalhes(1);

		lances.lance("Paulo Henrique", 150);

		assertTrue(lances.existeLance("Paulo Henrique", 150.0));
	}
}
