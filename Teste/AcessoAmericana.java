package Teste;

import static org.junit.Assert.*;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;

public class AcessoAmericana {

	// Declarando um objeto do tipo WebDriver, utilizado pelo Selenium WebDriver.
    private static WebDriver driver;
 
    // M�todo que inicia tudo que for necess�rio para o teste
    // Cria uma inst�ncia do navegador e abre a p�gina.
    @BeforeClass
    public static void setUpTest(){
    	System.setProperty("webdriver.chrome.driver","C:\\Desafio\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.americanas.com.br/");
        driver.manage().window().maximize(); //Maximizar a tela
    }
 
    // M�todo que finaliza o teste, fechando a inst�ncia do WebDriver.    
    @AfterClass
    public static void tearDownTest() throws IOException{
    	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); //Realiza a captura da tela
		FileUtils.copyFile(scrFile, new File("C:\\Picture\\TelaCapturadaAmericana.jpg")); //Cola a captura no local indicado
		driver.quit();
    }
 
    // 1- Entre em um grande portal de com�rcio online (Valida��o atrav�s do getTitle)
    @Test
    public void ateste1(){
        assertEquals("Americanas - Tudo. A toda hora. Em qualquer lugar.", driver.getTitle());
    }
    
    // 2- Fa�a uma busca por um produto
    @Test
    public void bteste2(){
    	WebElement busca = driver.findElement(By.name("conteudo"));
        busca.sendKeys("notebook");        
        driver.findElement(By.id("h_search-btn")).click();        
        }
    
    //3- Valide o retorno da busca
    @Test
    public void cteste3(){
    	
    	assertEquals("Notebook em Promo��o nas Lojas Americanas.com", driver.getTitle());
    }
    
    //4 - Escolha um produto na lista
    @Test
    public void dteste4(){
    	WebElement produto = driver.findElement(By.cssSelector(".product-grid-item:nth-child(6) .Placeholder-kse9g2-2"));
    	produto.click();        
        }
    
    //5- Adicione o carrinho
    @Test
    public void dteste5(){
    	WebElement botao = driver.findElement(By.id("btn-buy"));
    	botao.click();        
        }
    
    //6- Valide o produto no carrinho
    
 
}
