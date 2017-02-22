package teste;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NovoUsuarioPage {
	private final WebDriver driver;

	public NovoUsuarioPage(WebDriver driver){
		this.driver = driver;
	}
	
	public void cadastro(String nome, String email){
		WebElement txtNome = driver.findElement(By.name("usuario.nome"));
		WebElement txtEmail = driver.findElement(By.name("usuario.email"));

		txtNome.sendKeys(nome);
		txtEmail.sendKeys(email);

		txtNome.submit();
	}

}
