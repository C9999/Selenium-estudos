package teste;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class EmailSystemTeste {
	@Test
	public void naoDeveAdicionarUmUsuarioSemNome() {
		System.setProperty("webdriver.gecko.driver", "C:\\Drivers-Tester\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://localhost:8080/usuarios/new");

		WebElement email = driver.findElement(By.name("usuario.email"));

		email.sendKeys("ronaldo2009@terra.com.br");
		email.submit();

		assertTrue(driver.getPageSource().contains("Nome obrigatorio!"));

		driver.close();

	}

}
