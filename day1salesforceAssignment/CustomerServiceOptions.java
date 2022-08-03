package week4.day1salesforceAssignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class CustomerServiceOptions {

	public static void main(String[] args) throws InterruptedException {
		//1.Launch the browser
				WebDriverManager.chromedriver().setup();
				//ChromeOptions options = new ChromeOptions();
				//options.addArguments("--disable-notifications");
				ChromeDriver driver=new ChromeDriver();
				//2.Load the url as " https://login.salesforce.com/ "
				driver.get("https://login.salesforce.com/");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
					
					//3.Enter the username as " ramkumar.ramaiah@testleaf.com "
				driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
					//4. Enter the password as " Password$123 "
				driver.findElement(By.id("password")).sendKeys("Password$123");
					//5.click on the login button
				driver.findElement(By.id("Login")).click();
					//6.click on the learn more option in the Mobile publisher
				driver.findElement(By.xpath("//button[contains(@title,'Learn More')]")).click();
					//7.Switch to the next window using Windowhandles.
				Set<String> windowHandles = driver.getWindowHandles();
				List<String>lstWindow=new ArrayList<String>(windowHandles);
				driver.switchTo().window(lstWindow.get(1));
				
				//8. Click confirm on Confirm redirect
				driver.findElement(By.xpath("//button[text()='Confirm']")).click();
					//9.Get the title
				System.out.println(driver.getTitle());
				Shadow dom=new Shadow(driver);
				//4. Clilck on Products and Mousehover on Service 
				WebElement product = dom.findElementByXPath("//span[text()='Products']");
				product.click();
				Thread.sleep(2000);
				WebElement service = dom.findElementByXPath("//span[text()='Service']");
				Actions builder=new Actions(driver);
				builder.moveToElement(service).perform();
				builder.scrollToElement(service).perform();
			   //5. Click on Customer Services
				WebElement customService = dom.findElementByXPath("//a[text()='Customer Service']");
				customService.click();
				//6. Get the names Of Services Available 
			   List<WebElement> lstService = driver.findElements(By.xpath("//li/a[@class='page-list-item ']"));
			   int size = lstService.size();
			   System.out.println("Services Available:"+size);
			   for (int i = 0; i < size; i++) {
				   System.out.println(lstService.get(i).getText());
				
			}
				//7. Verify the title
			   System.out.println(driver.getTitle());

	}

}
