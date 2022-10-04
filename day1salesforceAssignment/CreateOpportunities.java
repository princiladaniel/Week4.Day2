package week4.day1salesforceAssignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOpportunities {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(option);

		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Password#123");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		WebElement opper = driver.findElement(By.xpath("//span[text()='Opportunities']"));
		driver.executeScript("arguments[0].click();",opper );
		driver.findElement(By.xpath("//div[text()='New']")).click();
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Testing");
		//driver.findElement(By.xpath("(//input[@class='slds-combobox__input slds-input'])[1]")).sendKeys("princila",Keys.ENTER);
		driver.findElement(By.xpath("//input[@name='CloseDate']")).sendKeys("09/16/2022",Keys.ENTER);
		driver.findElement(By.xpath("//button[contains(@class,'slds-combobox__input-value')]")).click();
		Thread.sleep(2000);
		WebElement stage  = driver.findElement(By.xpath("(//span[@class='slds-media__body'])[4]/span"));
		driver.executeScript("arguments[0].click();",stage);
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		
		String text = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();
		System.out.println(text);
		if(text.contains("Testing")) {
			System.out.println("verified");
		}
		else {
			System.out.println("Not verified");
		}
		
		/*
		 * TestCase:2-Opportunities

//setup the path	

//disable notifications
			
//manage ur window		
//add wait
// Login to https://login.salesforce.com
		
//enter username  .sendkeys()
		
//enter password //id=password
	
//click login button//id=Login
//Click on toggle menu button from the left corner//div[@class='slds-icon-waffle']
		
//Click view All and click Sales from App Launcher////button[text()='View All'],//p[text()='Sales']
		
//Click on Opportunity tab  ////span[text()='Opportunities']
		
//Click on New button//div[text()='New']

//Enter Opportunity Name////input[@name='Name']

//Enter 'your name' as account name//(//input[@class='slds-combobox__input slds-input'])[1]
		
//choose close date //input[@name='CloseDate']
		
//click stage(Needs Analysis)//button[contains(@class,'slds-combobox')]
							
//click save//button[text()='Save']
		
//verify message////span[contains(@class,'toastMessage')]
		
// Close the Browser

		 */
		
		

	}

}
