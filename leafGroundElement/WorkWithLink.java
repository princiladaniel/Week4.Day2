package leafGroundElement;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkWithLink {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver();
		 driver.get("http://www.leafground.com/");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		 driver.navigate().to("http://www.leafground.co"
		 		+ "m/pages/Link.html");
		 //driver.findElement(By.xpath("//h5[text()='HyperLink']")).click();
		 //Go to Home Page
		 driver.findElement(By.linkText("Go to Home Page")).click();
		 Thread.sleep(3000);
		 driver.navigate().back();
	//Find where am supposed to go without clicking me?
			
			 WebElement goingto = driver.findElement(By.linkText("Find where am supposed to go without clicking me?"));
			 String clicking = goingto.getAttribute("href");
			 System.out.println(clicking);
			 
			 //Verify am I broken?
			// String text = driver.findElement(By.xpath("html[1]")).getText();
			 //System.out.println(text);
			 driver.findElement(By.linkText("Verify am I broken?")).click();
				String title = driver.getTitle();
				System.out.println(title);
				if(title.contains("404")) 
					
					System.out.println("broken Link ");
				
				else 
					System.out.println("not broken Link");
				driver.navigate().back();
				driver.findElement(By.linkText("Go to Home Page")).click();
				driver.navigate().back();
				//Go to Home Page (Interact with same link name)
				 String link1 = driver.findElement(By.linkText("Go to Home Page")).getAttribute("href");
				 
                 driver.findElement(By.linkText("Go to Home Page")).getAttribute("href");
                 
				//How many links are available in this page?
               
				List<WebElement> totalLink = driver.findElements(By.tagName("a"));
				int Linkcount = totalLink.size();
				System.out.println("links are available:"+Linkcount);
				
			   
			
			
			
		}

		
		 
	}


