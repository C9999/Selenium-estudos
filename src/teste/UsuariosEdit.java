package teste;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UsuariosEdit {
	private ChromeDriver driver;

	@Before
	public void inicializa() {
		System.setProperty("webdriver.chrome.driver","C:\\Drivers-Tester\\3chromedriver.exe");
		this.driver = new ChromeDriver();
				
		UsuariosPage usuarios = new UsuariosPage(driver);
		usuarios.visita();
		usuarios.novo().cadastro("Scott Summers", "cyclope@x.com");
	}
	
	@Test
	public void deveEditarUsuario(){
		
		
		int posicao = 187; // 1o link de editar que aparecer
		//driver.findElements(By.linkText("editar")).get(posicao).click();
		
		driver.get("http://localhost:8080/usuarios/187/edit");
				
		WebElement nome = driver.findElement(By.name("usuario.nome"));
		WebElement email = driver.findElement(By.name("usuario.email"));

		nome.clear();
		email.clear();
		nome.sendKeys("Adriano Xavier");
		email.sendKeys("axavier@empresa.com.br");

		WebElement botaoSalvar = driver.findElement(By.id("btnSalvar"));
		botaoSalvar.click();//2a opção nome ou email.submit();
	}

}
