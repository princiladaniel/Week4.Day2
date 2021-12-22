package week4.Day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnDragDrop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
	
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("http://www.leafground.com/pages/drop.html");
		
		driver.manage().window().maximize();
		
		//driver.switchTo().frame(0);
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target=driver.findElement(By.id("droppable"));
		//create object for Actions class and pass the driver as argument
		Actions builder=new Actions(driver);
		builder.dragAndDrop(source, target).perform();
		//https://jqueryui.com/droppable
		/* driver.get("https://jqueryui.com/droppable");
		driver.switchTo().frame(0);
		WebElement source = driver.findElement(By.xpath("//div[@id='draggable']/p"));
		WebElement target = driver.findElement(By.xpath("//div[@id='droppable']/p"));
		Actions builder = new Actions(driver);
		builder.dragAndDrop(source, target).perform(); */
	}

}
