package teste;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeiloesSystemTeste {

	private WebDriver driver;
	private LeiloesPage leiloes;
	
	@Before
	public void inicializa() {
		System.setProperty("webdriver.chrome.driver","C:\\Drivers-Tester\\3chromedriver.exe");
		this.driver = new ChromeDriver();
		this.leiloes = new LeiloesPage(driver);
		
		UsuariosPage usuarios = new UsuariosPage(driver);
		usuarios.visita();
		usuarios.novo().cadastro("Jon Esteban", "jj@2.com");
	}
	
	@Test
	public void deveCadastrarUmLeilao(){
		
		leiloes.visita();
		NovoLeilaoPage novoLeilao = leiloes.novo();
		novoLeilao.preenche("PC", 2952, "Jon Esteban", false);
						
		assertTrue(leiloes.exite("PC", 2952, "J Enrique", false));
	}
	
	/*@Test
	public void validacaoSemUsuarioEValor(){
		
		leiloes.visita();
		NovoLeilaoPage novoLeilao = leiloes.novo();
		novoLeilao.preencheFaltandoDados("Paulo Henrique", true);
		
		assertTrue(leiloes.exiteNomeEmailInvalido("Nome obrigatorio!", "Valor inicial deve ser maior que zero!"));
		
		//OU
		//NovoLeilaoPage novoLeilao = leiloes.novo();
		//novoLeilao.preenche("Fogão", 423, "Paulo Henrique", true);
		//novoLeilao.preencheFaltandoDados("J Enrique", true);
		
		//assertTrue(leiloes.validacaoDeProdutoApareceu() || leiloes.validacaoDeValorApareceu());
	}*/	
}
