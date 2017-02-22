package teste;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeTeste {
	
	private ChromeDriver driver;

	@Before
	public void inicializa() {
		System.setProperty("webdriver.chrome.driver","C:\\Drivers-Tester\\3chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void deveAdicionarUmUsuario() {
		
		//driver.get("http://localhost:8080/usuarios/new");
		driver.get("http://localhost:8080/usuarios");        
		driver.findElement(By.linkText("Novo Usuário")).click();
				
		WebElement nome = driver.findElement(By.name("usuario.nome"));
		WebElement email = driver.findElement(By.name("usuario.email"));

		nome.sendKeys("Adriano Xavier");
		email.sendKeys("axavier@empresa.com.br");

		WebElement botaoSalvar = driver.findElement(By.id("btnSalvar"));
		botaoSalvar.click();
		
		boolean achouNome = driver.getPageSource().contains("Adriano Xavier");
		boolean achouEmail = driver.getPageSource().contains("axavier@empresa.com.br");
		
		System.out.println("Nome = "+achouNome+ ", Email = "+achouEmail);
				
		assertTrue(achouNome);
		assertTrue(achouEmail);
	
	}
	
	/*@After
	public void finaliza(){
		driver.close();
	}*/
}
