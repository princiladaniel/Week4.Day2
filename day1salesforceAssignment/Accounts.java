package week4.day1salesforceAssignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Accounts {

	public static void main(String[] args) throws InterruptedException {
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
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
			//4. Enter the password as " Password$123 "
		driver.findElement(By.id("password")).sendKeys("India$321");
			//5.click on the login button
		driver.findElement(By.id("Login")).click();
	 
			// Click on toggle menu button from the left corner 
		driver.findElement(By.xpath("//button[contains(@class,'slds-button slds-icon-waffle')]")).click();
			// Click view All and click Sales from App Launcher 
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
			// Click on Accounts tab 
		WebElement account = driver.findElement(By.xpath("(//span[text()='Accounts'])[1]"));
		driver.executeScript("arguments[0].click();", account);
		// Click on New button 
		driver.findElement(By.xpath("(//div[text()='New'])[1]")).click();
			//Enter 'your name' as account name 
		driver.findElement(By.xpath("(//input[@class='slds-input'])[2]")).sendKeys("Princila");
			Thread.sleep(2000);
		// Select Ownership as Public 
		WebElement ownerShip = driver.findElement(By.xpath("(//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value'])[3]"));
		driver.executeScript("arguments[0].scrollIntoView();", ownerShip);
		ownerShip.click();
		
		driver.findElement(By.xpath("//span[text()='Public']")).click();
			// Click save and verify Account name "
        driver.findElement(By.xpath("//button[text()='Save']")).click();
          //verify Account name
        Thread.sleep(2000);
        String verifyMsg = driver.findElement(By.xpath("//span[contains(@class,'toastMessage slds-text-heading')]/a")).getAttribute("title");
        System.out.println(verifyMsg);
        
        
	}

}
