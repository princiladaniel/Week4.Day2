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

public class ArchitectCertifications {

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
		
		//4. Click confirm on Confirm redirect
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
			//9.Get the title
		System.out.println(driver.getTitle());
		Shadow dom=new Shadow(driver);
		//5. Click Resources and mouse hover on Learning On Trailhead
		WebElement resource = dom.findElementByXPath("//span[text()='Learning']");
		resource.click();
		Thread.sleep(2000);
		WebElement trailHead = dom.findElementByXPath("//span[text()='Learning on Trailhead']");
		Actions builder=new Actions(driver);
		builder.moveToElement(trailHead).perform();
		builder.scrollToElement(trailHead).perform();
		//6. Clilck on Salesforce Certifications
		WebElement sales = dom.findElementByXPath("//a[text()='Salesforce Certification']");
		 driver.executeScript("arguments[0].click();", sales);
			//7. Choose Your Role as Salesforce Architect
		 driver.findElement(By.xpath("(//a[@class='roleMenu_no-underline'])[2]")).click();
			//8. Get the Text(Summary) of Salesforce Architect 
		 String summary = driver.findElement(By.xpath("//div[contains(@class,'cert-site_text slds-text')]")).getText();
			System.out.println("Summary of Salesforce Architect:"+summary);
		 //9. Get the List of Salesforce Architect Certifications Available
			List<WebElement> lstCertificate= driver.findElements(By.xpath("//div[@class='credentials-card_title']/a"));
			int size = lstCertificate.size();
			System.out.println("Size of Certificate"+size);
			for (int i = 0; i <lstCertificate.size() ; i++) {
				System.out.println(lstCertificate.get(i).getText());
				
			}
			//10. Click on Application Architect 
			driver.findElement(By.xpath("(//div[@class='credentials-card_title']/a)[1]")).click();
			//11.Get the List of Certifications available
			List<WebElement> ArchitectCertifications = driver.findElements(By.xpath("//div[@class='credentials-card_title']/a"));
			Thread.sleep(2000);
			int size2 = ArchitectCertifications.size(); 
			System.out.println("ArchitectCertifications:"+size2);
			for (int j = 0; j < size2; j++) {
				System.out.println(ArchitectCertifications.get(j).getText());
				
			}
			
	}

}
