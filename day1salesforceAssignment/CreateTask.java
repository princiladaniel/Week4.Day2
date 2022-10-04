package week4.day1salesforceAssignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateTask {

	public static void main(String[] args) {
	/*
	 * Testcase:3-Create Task


2) Click Login
3) Login with the credentials
4) Click on Global Actions SVG icon(App Launcher)
5) Click view all


	 */
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
				driver.findElement(By.xpath("//input[contains(@placeholder,'Search apps')]")).sendKeys("Task");
				//6) Type task and select task
				driver.findElement(By.xpath("//mark[text()='Task']")).click();
	            //7) Click New Task under dropdown icon
				
				//8) Enter subject as "Bootcamp "       
				
				//9) Select status as 'Waiting on someone else'
				//10) Save and verify the 'Task created' message
	}

}
