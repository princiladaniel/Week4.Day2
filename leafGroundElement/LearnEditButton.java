package leafGroundElement;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnEditButton {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver();
		 driver.get("http://www.leafground.com/");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		 driver.findElement(By.xpath("//h5[text()='Edit']")).click();
		 driver.findElement(By.id("email")).sendKeys("princila.testleaf.com");
		 driver.findElement(By.xpath("//input[@value='Append ']")).sendKeys("Selenium");
		 //driver.findElement(By.xpath("//input[@value='TestLeaf']")).click();
		 String defaultText=driver.findElement(By.xpath("//input[@value='TestLeaf']")).getAttribute("value");
		 System.out.println(defaultText);
		driver.findElement(By.xpath("//input[@value='Clear me!!']")).clear();
		WebElement Disabled = driver.findElement(By.xpath("//input[@disabled='true']"));
		boolean enabled = Disabled.isEnabled();
		System.out.println(enabled);
	}

}
