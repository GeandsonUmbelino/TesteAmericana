package Teste;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class CapturarTelaComTakesScreenshot {
	public static void main(String[]args) throws IOException{
		
		System.setProperty("webdriver.chrome.driver","C:\\Desafio\\chromedriver.exe");
		WebDriver  driver = new ChromeDriver();
		
		driver.get("https://www.globo.com/"); //Acessar a página de login da globo.com
		driver.manage().window().maximize(); //Maximizar a tela 
	  	
	  	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); //Realiza a captura da tela
		FileUtils.copyFile(scrFile, new File("C:\\Picture\\TelaCapturada.jpg")); //Cola a captura no local indicado
	  	
	  	System.out.println("Tela capturada com sucesso utilizando Selenium"); //Mensagem para confirmar captura 
	  	
	  	Screenshot fullscreen = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver); //Capturando utilizando o Ashot
	  	ImageIO.write(fullscreen.getImage(), "jpg", new File("C:\\Picture\\TelaFullCapturada.jpg")); //Cola a captura no local indicado
	  	
	  	System.out.println("Tela FULL capturada com sucesso utilizando Selenium"); //Mensagem para confirmar captura FULL
	  	
	}
	
}