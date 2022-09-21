package testCase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkWithImage {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver();
		 driver.get("http://leafground.com/pages/Image.html");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		
		 //Click on this image to go home page

		 driver.findElement(By.xpath("//div[contains(@class,'large-6 small-12')]//img")).click();
		 driver.navigate().back();
		 WebElement brokenImage = driver.findElement(By. xpath("(//div[contains(@class,'large-6 small-12')]//img)[2]"));
		 driver.findElement(By.xpath(null));
				  if(brokenImage.getAttribute("src") !="0") {
				  System.out.println("The image is broken");
				  
				  } else { System.out.println("The image is not broken"); }
				 
		 
			/*
			 * WebElement brokenImage = driver.findElement(By.
			 * xpath("(//div[contains(@class,'large-6 small-12')]//img)[2]"));
			 * if(brokenImage.getAttribute("naturalWidth").equals("0")) {
			 * System.out.println("The image is broken");
			 * 
			 * } else { System.out.println("The image is not broken"); }
			 */
		 WebElement keyboard = driver.findElement(By.xpath("(//div[contains(@class,'large-6 small-12')]//img)[3]"));
		 Actions builder=new Actions(driver);
			builder.click( keyboard).perform();
			String title = driver.getTitle();
			System.out.println(title);
		
		
	}	

}
