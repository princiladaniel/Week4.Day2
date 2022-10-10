package action;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Irctc {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		//from
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@role='searchbox'])[1]")).sendKeys("CHENNAI EGMORE - MS");
		//to
		driver.findElement(By.xpath("(//input[@role='searchbox'])[2]")).sendKeys("MADURAI JN - MDU",Keys.TAB);
		
		//calender
	   
	    driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar ng-tns-c58-10']//tr[3]/td[2]"));
		
	    //search button
		driver.findElement(By.xpath("//button[text()='Search']")).click();
		List<WebElement> lst = driver.findElements(By.tagName("table"));
	    int size = lst.size();
	    for (int i = 1; i <size; i++) {
	    	System.out.println(lst.get(i).getText());
			
		}
	    System.out.println(size);
	    List<WebElement> row = driver.findElements(By.tagName("tr"));
	    int size2 = row.size();
	    System.out.println(size2);
	}

}
