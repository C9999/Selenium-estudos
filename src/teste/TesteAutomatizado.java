package teste;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteAutomatizado {
	
	@Test
	public void teste() {
		//System.setProperty("webdriver.gecko.driver", "C:\\Drivers-Tester\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver","C:\\Drivers-Tester\\3chromedriver.exe");
		
		//WebDriver driver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com.br");
		
		WebElement campoDeTexto = driver.findElement(By.name("q"));
		
		campoDeTexto.sendKeys("Alura");
		campoDeTexto.submit();
	}
}
	