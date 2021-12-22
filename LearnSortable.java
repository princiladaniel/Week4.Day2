package week4.Day2;

import javax.tools.DocumentationTool.Location;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnSortable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/sortable/");
		driver.manage().window().maximize();
		//https://jqueryui.com/sortable
		driver.switchTo().frame(0);
		/*WebElement item1 = driver.findElement (By.xpath("(//ul[@id='sortable']/li)[1]"));
		WebElement item6 = driver.findElement (By.xpath("(//ul[@id='sortable']/li)[6]"));
		 Point location = item6.getLocation();
		int x=location.getX();
		int y=location.getY();
		Actions builder=new Actions(driver);
		builder.dragAndDropBy(item1, x, y).perform();*/
		
		
		//driver.switchTo().frame(0);
		WebElement item1 = driver.findElement(By.xpath("//ul[@id='sortable']//li[1]"));
		WebElement item2 = driver.findElement(By.xpath("//ul[@id='sortable']//li[2]"));
		WebElement item3 = driver.findElement(By.xpath("//ul[@id='sortable']//li[3]"));
		WebElement item4 = driver.findElement(By.xpath("//ul[@id='sortable']//li[4]"));
		WebElement item5 = driver.findElement(By.xpath("//ul[@id='sortable']//li[5]"));
		WebElement item6 = driver.findElement(By.xpath("//ul[@id='sortable']//li[6]"));
		WebElement item7 = driver.findElement(By.xpath("//ul[@id='sortable']//li[7]"));
		Actions builder = new Actions(driver);
		builder.dragAndDrop(item7, item1).dragAndDrop(item6, item1).dragAndDrop(item5, item1).dragAndDrop(item4, item1)
				.dragAndDrop(item3, item1).dragAndDrop(item2, item1).perform();
		
	}


	
}
