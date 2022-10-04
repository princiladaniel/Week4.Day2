package week4.day1salesforceAssignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Chatter {

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
		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
			//4. Enter the password as " Password$123 "
		driver.findElement(By.id("password")).sendKeys("Password#123");
			//5.click on the login button
		driver.findElement(By.id("Login")).click();
	 
			// Click on toggle menu button from the left corner 
		driver.findElement(By.xpath("//button[contains(@class,'slds-button slds-icon-waffle')]")).click();
			// Click view All and click Sales from App Launcher 
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//input[contains(@placeholder,'Search apps')]")).sendKeys("content");
		driver.findElement(By.xpath("//mark[text()='Content']")).click();
		WebElement chatter = driver.findElement(By.xpath("//span[text()='Chatter']"));
		driver.executeScript("arguments[0].click();",chatter );
		Thread.sleep(2000);
		String title = driver.getTitle();
		if(title.contains("Chatter Home")) {
			System.out.println("Title Matched");
		}
		else {
			System.out.println("Title Not Matched");
		}
		driver.findElement(By.xpath("//span[text()='Question']")).click();
		driver.findElement(By.xpath("//textarea[contains(@class,'cuf-questionTitle')]")).sendKeys("What is sales forces",Keys.TAB);
		driver.findElement(By.xpath("//div[contains(@class,'ql-editor ql-blank')]")).sendKeys("CRM BASED");
		driver.findElement(By.xpath("//button[text()='Ask']")).click();
		Thread.sleep(2000);
		String question = driver.findElement(By.xpath("(//span[@class='uiOutputText'])[3]")).getText();
		System.out.println(question);
		if(question.equalsIgnoreCase(question)) {
			System.out.println("Question Appears");
		}
		else {
			System.out.println("Question Not Appears");
		}

	}

}
