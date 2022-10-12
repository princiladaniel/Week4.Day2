package week7.day1;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;

import io.github.bonigarcia.wdm.WebDriverManager;
public class LearnChangeButtonColour{

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		//Launch the browser
		ChromeDriver driver = new ChromeDriver();
		//load the URL
		driver.navigate().to("https://leafground.com/button.xhtml");
		//Maxi the Browser
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		  WebElement colour =
		  driver.findElement(By.xpath("//button[@name='j_idt88:j_idt100']")); String
		  cssValue = colour.getCssValue("background-color");
		  System.out.println(cssValue);
		  
		  Actions builder=new Actions(driver); builder.moveToElement(colour).perform();
		  WebElement after =
		  driver.findElement(By.xpath("(//span[text()='Success'])[1]")); String
		  cssValue2 = after.getCssValue("background-color"); 
		  System.out.println(cssValue2);
		 if(cssValue.contains(cssValue2)) {
			 System.out.println("Colour Not changed");
		 }
		 else {
			 System.out.println("colour changed");
		 }
		

	}

}
