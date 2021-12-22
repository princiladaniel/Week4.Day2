package week4.Day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnSelectable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/selectable/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		//https://jqueryui.com/selectable
		driver.switchTo().frame(0);
		WebElement item1 = driver.findElement (By.xpath("//li[text()='Item 1']"));//li[text()='Item 1']
		WebElement item5 = driver.findElement (By.xpath("//li[text()='Item 5']"));
		WebElement item3 = driver.findElement(By.xpath("//li[text()='Item 3']"));
		Actions builder=new Actions(driver);
		//builder.clickAndHold(item1).moveToElement(item5).release().perform();
		builder.keyDown(Keys.CONTROL).click(item1).click(item5).click(item3).keyUp(Keys.CONTROL).perform();	
		}

}
