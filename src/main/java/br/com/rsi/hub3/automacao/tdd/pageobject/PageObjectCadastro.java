package br.com.rsi.hub3.automacao.tdd.pageobject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

public class PageObjectCadastro {
	private WebDriver driver;

	
	
	public PageObjectCadastro(WebDriver driver) {
		this.driver = driver;
	}
	
	public void Esperar1() {
		JavascriptExecutor javaScriptExecutor= (JavascriptExecutor) driver;
        javaScriptExecutor.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 5000);");
	}
	public void Esperar2() {
		JavascriptExecutor javaScriptExecutor= (JavascriptExecutor) driver;
        javaScriptExecutor.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 3000);");
	}
	
	public WebDriver PreenchendoCamposCadastroComSucesso() throws InterruptedException {
		driver.findElement(By.id("menuUserLink")).click();
		Esperar1();
		driver.findElement(By.xpath("//a[@class='create-new-account ng-scope']")).click();

		driver.findElement(By.name("usernameRegisterPage")).sendKeys("rafael199");
		driver.findElement(By.name("emailRegisterPage")).sendKeys("rgc.test199@gmail.com");
		driver.findElement(By.name("passwordRegisterPage")).sendKeys("Rafa123");
		driver.findElement(By.name("confirm_passwordRegisterPage")).sendKeys("Rafa123");

		driver.findElement(By.name("first_nameRegisterPage")).sendKeys("Rafael");
		driver.findElement(By.name("last_nameRegisterPage")).sendKeys("Gomes");
		driver.findElement(By.name("phone_numberRegisterPage")).sendKeys("11999990000");

		Esperar2();
		Select combobox = new Select(driver.findElement(By.name("countryListboxRegisterPage")));
		Esperar2();
		combobox.selectByVisibleText("Brazil");

		driver.findElement(By.name("cityRegisterPage")).sendKeys("Sao Paulo");
		driver.findElement(By.name("addressRegisterPage")).sendKeys("Rua Abcde, N 20");
		driver.findElement(By.name("state_/_province_/_regionRegisterPage")).sendKeys("SP");
		driver.findElement(By.name("postal_codeRegisterPage")).sendKeys("08455000");
		driver.findElement(By.name("i_agree")).click();
		driver.findElement(By.id("register_btnundefined")).click();
		return driver;
	}
	
	public WebDriver PreenchendoCamposCadastroSemSucesso() throws InterruptedException {
		driver.findElement(By.id("menuUserLink")).click();
		Esperar1();
		driver.findElement(By.xpath("//a[@class='create-new-account ng-scope']")).click();

		driver.findElement(By.name("usernameRegisterPage")).sendKeys("rafael05");
		driver.findElement(By.name("emailRegisterPage")).sendKeys("rgc.teste1@gmail.com");
		driver.findElement(By.name("passwordRegisterPage")).sendKeys("Rafa123");
		driver.findElement(By.name("confirm_passwordRegisterPage")).sendKeys("Rafa123");

		driver.findElement(By.name("first_nameRegisterPage")).sendKeys("Rafael");
		driver.findElement(By.name("last_nameRegisterPage")).sendKeys("Gomes");
		driver.findElement(By.name("phone_numberRegisterPage")).sendKeys("11999990000");

		Esperar2();
		Select combobox = new Select(driver.findElement(By.name("countryListboxRegisterPage")));
		Esperar2();
		combobox.selectByVisibleText("Brazil");

		driver.findElement(By.name("cityRegisterPage")).sendKeys("Sao Paulo");
		driver.findElement(By.name("addressRegisterPage")).sendKeys("Rua Abcde, N 20");
		driver.findElement(By.name("state_/_province_/_regionRegisterPage")).sendKeys("SP");
		driver.findElement(By.name("postal_codeRegisterPage")).sendKeys("08455000");
		driver.findElement(By.name("i_agree")).click();
		driver.findElement(By.id("register_btnundefined")).click();
		//Esperar2();
		return driver;
	}
}
