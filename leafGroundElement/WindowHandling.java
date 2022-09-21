package leafGroundElement;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandling {

	private static WebElement findElement;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver();
		 driver.get("http://www.leafground.com/pages/Window.html");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		 //1.Click button to open home page in New Window

		 String windowHandle = driver.getWindowHandle();
		 driver.findElement(By.id("home")).click();
		 //Find the number of opened windows
		 Set<String> Handles = driver.getWindowHandles();
		 
		 for (String newwindow : Handles) {
			 driver.switchTo().window(newwindow);
		 }
		 
			WebElement editbox=driver.findElement(By.xpath("//h5[text()='Edit']/following-sibling::img"));
             editbox.click();
             driver.close();
             
             Thread.sleep(2000);
		 
             driver.switchTo().window(windowHandle);
           
              WebElement openmultiple = driver.findElement(By.xpath("//button[text()='Open Multiple Windows']"));
             openmultiple.click();
             Thread.sleep(3000);
              int windowcount = driver.getWindowHandles().size();
             System.out.println(windowcount);
             //Close all except this window
             //Do not close me
             WebElement dontclose = driver.findElement(By.id("color"));
             dontclose.click();
             Thread.sleep(3000);
             Set<String>newwindowhandle = driver.getWindowHandles();
             for (String allwindow : newwindowhandle) {
            	 if (!allwindow.equals(windowHandle)) {
            		 driver.switchTo().window(allwindow);
				}
             }
             //Wait for 2 new Windows to open
				driver.findElement(By.id("color")).click();
				Thread.sleep(5000);
				 driver.close();
			}
		}
	


