package week4.day1salesforceAssignment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class AdministratorCertifications {

	public static void main(String[] args) throws IOException, InterruptedException {
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
				
				//4. Click confirm on Confirm redirect
				driver.findElement(By.xpath("//button[text()='Confirm']")).click();
					//9.Get the title
				System.out.println(driver.getTitle());
				Shadow dom=new Shadow(driver);
				//5. Click Resources and mouse hover on Learning On Trailhead
				WebElement resource = dom.findElementByXPath("//span[text()='Resources']");
				resource.click();
				Thread.sleep(2000);
				WebElement trailHead = dom.findElementByXPath("//span[text()='Learning on Trailhead']");
				Actions builder=new Actions(driver);
				builder.moveToElement(trailHead).perform();
				builder.scrollToElement(trailHead).perform();
				//6. Clilck on Salesforce Certifications
				WebElement sales = dom.findElementByXPath("//a[text()='Salesforce Certification']");
				 driver.executeScript("arguments[0].click();", sales);
				//6. Click on Ceritification Administrator
				driver.findElement(By.xpath("//a[text()='Administrator']")).click();
				//7. Navigate to Certification - Administrator Overview window
				Set<String> windowHandles1 = driver.getWindowHandles();
				List<String>lstWindow1=new ArrayList<String>(windowHandles1);
				driver.switchTo().window(lstWindow1.get(1));
				//8. Verify the Certifications available for Administrator Certifications should be displayed
                WebElement scrol = driver.findElement(By.xpath("//h1[text()='Earn your Credential']"));
                builder.scrollToElement(scrol).perform();
            
       		 File source = driver.getScreenshotAs(OutputType.FILE);
       		 File dest = new File("./screenshort/snap1.png");
       		 FileUtils.copyFile(source, dest);
	}

}
