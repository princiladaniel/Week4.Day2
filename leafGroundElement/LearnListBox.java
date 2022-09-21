package leafGroundElement;

import java.time.Duration;
import java.util.List;

//import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;


public class LearnListBox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriverManager.chromedriver().setup();
ChromeDriver driver=new ChromeDriver();
driver.get("http://leafground.com/pages/Dropdown.html");
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
//selectByIndex
WebElement eleFirstDropDown=driver.findElement(By.id("dropdown1"));
Select dropdown1=new Select(eleFirstDropDown);
dropdown1.selectByIndex(0);
//selectByVisibleTexts
WebElement secdropdown = driver.findElement(By.name("dropdown2"));
Select dropdown2=new Select(secdropdown);
dropdown2.selectByVisibleText("Select training program using Text");
//selectByValue
WebElement thirddrop = driver.findElement(By.id("dropdown3"));
Select dropdown3=new Select(thirddrop);
dropdown3.selectByValue("0");
//Get the number of dropdown options
Select optionSelect = new Select(driver.findElement(By.xpath("//select[@class='dropdown']")));
List <WebElement> elementCount = optionSelect.getOptions();
System.out.println(elementCount.size());
//You can also use sendKeys to select
driver.findElement(By.xpath("(//div[@class='example']/select)[5]")).sendKeys("UFT/QTP");
//Select your programs
driver.findElement(By.xpath("//option[text()='Select your programs']")).click();
driver.findElement(By.xpath("//option[@disabled='true']/following-sibling::option[4]")).click();
	}

}
// other method Get the number of dropdown options
/*Select optionSelect= new Select(driver.findElement(By.xpath("//select[@class='dropdown']")));
List<WebElement>option=optionSelect.getOptions();
int size = option.size();
System.out.println(size);*/

/*Select selection= new Select(driver.findElement(By.xpath("//select[@class='dropdown']")));
int size=selection.getOptions().size();
System.out.println(size);*/