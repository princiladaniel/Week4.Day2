package week4.day1salesforceAssignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Individuals {

	public static void main(String[] args) {
		//1.Launch the browser
				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-notifications");
				ChromeDriver driver=new ChromeDriver(options);
				//2.Load the url as " https://login.salesforce.com/ "
				driver.get("https://login.salesforce.com/");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
					
					//3.Enter the username as " ramkumar.ramaiah@testleaf.com "
				driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
					//4. Enter the password as " Password$123 "
				driver.findElement(By.id("password")).sendKeys("Password#123");
					//5.click on the login button
				driver.findElement(By.id("Login")).click();
			 
					// Click on toggle menu button from the left corner 
				driver.findElement(By.xpath("//button[contains(@class,'slds-button slds-icon-waffle')]")).click();
					// Click view All and click Sales from App Launcher 
				driver.findElement(By.xpath("//button[text()='View All']")).click();
				//05) Type Individuals on the Search box
				driver.findElement(By.xpath("//input[contains(@placeholder,'Search apps')]")).sendKeys("Individuals");
				//06) Click Individuals Link
				driver.findElement(By.xpath("//mark[text()='Individuals']")).click();
				//07) Click New
				driver.findElement(By.xpath("//div[text()='New']")).click();
				//08) Select Salutation with data (coming from excel) 
				driver.findElement(By.xpath("//a[@class='select']")).click();
				List<WebElement> salutation = driver.findElements(By.xpath("//a[@role='menuitemradio']"));
				int size = salutation.size();
				System.out.println(size);
				for (WebElement output : salutation) {
					System.out.println(output);
				}
				
				//09) Type Last Name 
				driver.findElement(By.xpath("//input[contains(@class,'firstName compoundBorder')]")).sendKeys("Princila",Keys.TAB);
				WebElement name = driver.findElement(By.xpath("//input[contains(@class,'lastName compound')]"));
				name.sendKeys("Edward");
				driver.findElement(By.xpath("//input[contains(@class,'lastName compound")).getAttribute("");
				//10) Click Save
				driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
				//11) Click on the App Launcher (dots)
				driver.findElement(By.xpath("//button[contains(@class,'slds-button slds-icon-waffle')]")).click();	
				//12) Click View All
				driver.findElement(By.xpath("//button[text()='View All']")).click();
				//13) Type Customers on the Search box
				driver.findElement(By.xpath("//input[contains(@placeholder,'Search apps')]")).sendKeys("Customers");
				//14) Click Customers Link
				driver.findElement(By.xpath("//mark[text()='Customers']")).click();
				//15) Click New
				driver.findElement(By.xpath("(//div[text()='New'])[3]")).click();
				//16) Type the same name provided in step 8 and confirm it appears
				
			   // driver.findElement(By.xpath("//input[contains(@class,' default input')]")).sendKeys(name);
				//17) Close the browser

	}

}
