package teste;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeTestePorClasse {
	private ChromeDriver driver;
	private UsuariosPage usuarios;
	String n = "Marcelo Mattos";
	String e = "m5@mm.com.br";
	int i = 51;
	
	@Before
	public void inicializa() {
		System.setProperty("webdriver.chrome.driver","C:\\Drivers-Tester\\3chromedriver.exe");
		this.driver = new ChromeDriver();
		this.usuarios = new UsuariosPage(driver);
		//UsuariosPage usuarios = new UsuariosPage(driver); sem o this essa linha vai pro metodo de teste
		//driver.get("http://localhost:8080/apenas-teste/limpa"); limpa o banco de dados
	}
	
//	@Test
//	public void deveAdicionarUmUsuarioPorClasse(){
//		usuarios.visita();
//		usuarios.novo().cadastro(n, e);
//		assertTrue(usuarios.existeNaListagem(n, e));
//	}
	
	@Test
	public void deveAlterarUmUsuario() {
		usuarios.visita();
		usuarios.novo().cadastro("Ronaldo Luiz de Albuquerque", "ronaldo2009@terra.com.br");
		usuarios.altera(205).para("José da Silva", "jose@silva.com");

		assertFalse(usuarios.existeNaListagem("Ronaldo Luiz de Albuquerque", "ronaldo2009@terra.com.br"));
		assertTrue(usuarios.existeNaListagem("José da Silva", "jose@silva.com"));
	}
	
//	@Test
//	public void deveDeletarUmUsuario(){
//		driver.get("http://localhost:8080/usuarios");
//		i = 51;
//		while(i < 100){
//			usuarios.deletaUsuarioNaPosicao(1);
//		}
//	}
	
}
