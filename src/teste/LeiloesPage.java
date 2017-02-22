package teste;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LeiloesPage {

	private WebDriver driver;
	
	public LeiloesPage(WebDriver driver){
		this.driver = driver;
	}
	
	public void visita(){
		driver.get("http://localhost:8080/leiloes");
		// driver.get(new URLDaAplicacao().getUrlBase() + "/usuarios");
	}
	
	public NovoLeilaoPage novo(){
		driver.findElement(By.linkText("Novo Leilão")).click();
		return new NovoLeilaoPage(driver);
	}
	
	public boolean exite(String produto, double valor, String usuario, boolean usado){
		return driver.getPageSource().contains(produto) &&
				driver.getPageSource().contains(String.valueOf(valor)) &&
				driver.getPageSource().contains(usado ? "Sim": "Não");
	}

	public boolean exiteNomeEmailInvalido(String SemProduto, String SemValor) {
		return 	driver.getPageSource().contains(("Nome obrigatorio!")) ||  
				driver.getPageSource().contains(("Valor inicial deve ser maior que zero!"));
	}
	
	 public boolean validacaoDeProdutoApareceu() {
	        return driver.getPageSource().contains("Nome obrigatorio!");
	 }

	 public boolean validacaoDeValorApareceu() {
		 return driver.getPageSource().contains("Valor inicial deve ser maior que zero!");
	 }

	public DetalhesDoLeilaoPage detalhes(int posicao) {
		List<WebElement> elementos = driver.findElements(By.linkText("exibir"));
		elementos.get(posicao -1).click();
		
		return new DetalhesDoLeilaoPage(driver);
	}

}
