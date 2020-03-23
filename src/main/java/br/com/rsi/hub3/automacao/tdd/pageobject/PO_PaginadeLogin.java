package br.com.rsi.hub3.automacao.tdd.pageobject;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import br.com.rsi.hub3.automacao.excel.*;

public class PO_PaginadeLogin {
	private WebDriver driver;
	private WebElement validacao;
	private ReadExcelFile readFile;

	public PO_PaginadeLogin(WebDriver driver) {
		this.driver = driver;
	}

	public String EsperarValidacaoMsgErroLogin() {
		FluentWait wait = new FluentWait(driver);
		wait.withTimeout(15, TimeUnit.SECONDS); // Tempo total de espera at� encontrar
		wait.pollingEvery(1, TimeUnit.SECONDS); // De quanto em quanto verifica se o elemento j� pode ser utilizado
		wait.ignoring(NoSuchElementException.class); // ignorar tipos espec�ficos de exce��es enquanto aguarda
		validacao = driver.findElement(By.id("signInResultMessage"));
		wait.until(ExpectedConditions.textToBePresentInElement(validacao, "Incorrect user name or password.")); // Esperar																										// espera)
		return driver.findElement(By.id("signInResultMessage")).getText();
	}
	
	public void preencherLoginComExcel() throws Exception{
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Planilha1");
		int linha=0, coluna=0;
		String login = ExcelUtils.getCellData(linha, coluna);
		driver.findElement(By.name("username")).sendKeys(login);
		linha=1;
		String senha = ExcelUtils.getCellData(linha, coluna);
		driver.findElement(By.name("password")).sendKeys(senha);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	public WebDriver LoginComSucesso() throws Exception{
		driver.findElement(By.id("menuUserSVGPath")).click(); // Clicando no bot�o de acesso de usu�rios OK
		preencherLoginComExcel();	
		driver.findElement(By.xpath("/html/body/login-modal/div/div/div[3]/sec-form/sec-sender/button")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;
	}

	public WebDriver LoginSemSucesso() {
		driver.findElement(By.id("menuUserSVGPath")).click(); // Clicando no bot�o de acesso de usu�rios OK
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.name("username")).sendKeys("rafael");
		driver.findElement(By.name("password")).sendKeys("senhaErrada");
		driver.findElement(By.xpath("/html/body/login-modal/div/div/div[3]/sec-form/sec-sender/button")).click();
		return driver;

	}

}
