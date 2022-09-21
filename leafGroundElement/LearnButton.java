package leafGroundElement;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnButton {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver();
		 driver.get("http://www.leafground.com/");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		 driver.findElement(By.xpath("//h5[text()='Button']")).click();
		 //Click button to travel home page
		 driver.findElement(By.xpath("//label[text()='Click button to travel home page']")).click();
		 driver.navigate().forward();
		 //driver.findElement(By.xpath("//h5[text()='Button']")).click();
		 //Find position of button (x,y)
		 WebElement Position = driver.findElement(By.xpath("//button[@id='position']"));
		 Point xypoint= Position.getLocation();
		 int xvalue = xypoint.getX();
		 int yvalue = xypoint.getY();
		 System.out.println("The position of xand y:"+"x value"+xvalue + "  " +"y  value" +yvalue);
		 Thread.sleep(3000);
		 //Find button color
		 WebElement colourbutton = driver.findElement(By.xpath("//button[@id='color']"));
		 String colour = colourbutton.getCssValue("background-color");
		 System.out.println(colour);
		 //Find the height and width
		 WebElement sizebutton = driver.findElement(By.id("size"));
		 int height = sizebutton.getSize().getHeight();
		 int width = sizebutton.getSize().getWidth();
		 System.out.println("Height"+height+" "+"width"+width);
		 
		 }

}
