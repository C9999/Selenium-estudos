package teste;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UsuariosSystemTeste {
	
	private FirefoxDriver driver;
	
	
	
	@Before
	public void inicializa(){
		System.setProperty("webdriver.gecko.driver", "C:\\Drivers-Tester\\geckodriver.exe");
		driver = new FirefoxDriver();	
		
	}
	
	@Test
	public void DeveAdicionarUsuario(){
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://localhost:8080/usuarios/new");
		//driver.get("http://localhost:8080/usuarios");        
		//driver.findElement(By.linkText("Novo Usuário")).click();
		
		WebElement nome = driver.findElement(By.name("usuario.nome"));
		WebElement email = driver.findElement(By.name("usuario.email"));

		nome.sendKeys("Adriano Xavier");
		email.sendKeys("axavier@empresa.com.br");

		WebElement botaoSalvar = driver.findElement(By.id("btnSalvar"));
		botaoSalvar.click();//2a opção nome ou email.submit();

		//WebDriverWait wait = new WebDriverWait(driver, 200);
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnSalvar")));
		//driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
		//Thread.sleep(300);

		boolean achouNome = driver.getPageSource().contains("Adriano Xavier");
		boolean achouEmail = driver.getPageSource().contains("axavier@empresa.com.br");

		//assertTrue(achouNome);
		//assertTrue(achouEmail);	

	}
	
	@After
	public void finaliza(){
		driver.close();
	}

}
