package Teste;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;

public class TesteBasicoJUnit {

	// Declarando um objeto do tipo WebDriver, utilizado pelo Selenium WebDriver.
    private static WebDriver driver;
 
    // M�todo que inicia tudo que for necess�rio para o teste
    // Cria uma inst�ncia do navegador e abre a p�gina.
    @BeforeClass
    public static void setUpTest(){
    	System.setProperty("webdriver.chrome.driver","C:\\Desafio\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://minhaconta.globo.com/");
    }
 
    // M�todo que finaliza o teste, fechando a inst�ncia do WebDriver.    
    @AfterClass
    public static void tearDownTest(){
        driver.quit();
    }
 
    // Testa t�tulo "Login".
    @Test
    public void testaTituloDaPagina(){
        assertEquals("Login", driver.getTitle());
    }
 
    // M�todo que testa o login.
    @Test
    public void testaLogin() {
 
    // Instancia um novo objeto do tipo "WebElement", e passa como par�metro
    // um elemento da tela cujo valor do atributo "name" seja igual a "login".
    WebElement element = driver.findElement(By.name("login"));
     
    // Insere dados no elemento "usuario".
    element.sendKeys("TESTE");
 
    // Atribui ao objeto �element� o elemento de atributo "name" igual a "password".
    element = driver.findElement(By.name("password"));
 
    // Insere dados no elemento "senha".
    element.sendKeys("TESTE");
 
    }
}
