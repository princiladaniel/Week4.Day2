package week3.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafSorttable {
	
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.get("http://www.leafground.com/pages/sorttable.html");
	//First get all the values of Name,store in a list and sort
	List<String> nameList = new ArrayList<String>();
	List<String> sortNameList = new ArrayList<String>();

	List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table_id']/tbody/tr"));
	int totalRow = rows.size();

	for (int i = 1; i <= totalRow; i++)

	{
		String text = driver.findElement(By.xpath("//table[@id='table_id']/tbody/tr[" + i + "]/td[2]")).getText();
		nameList.add(text);
		System.out.println(text);
	}
	Collections.sort(nameList);
	//Click on the Name header
	System.out.println(nameList);
	driver.findElement(By.xpath("//th[@aria-label=\"Name: activate to sort column ascending\"]")).click();
	
//3.Again get all the values and store in a List
	for (int i = 1; i <= totalRow; i++)

	{
		String text = driver.findElement(By.xpath("//table[@id='table_id']/tbody/tr[" + i + "]/td[2]")).getText();
		sortNameList.add(text);
		System.out.println(text);
	}
	//Compare both the list
	
	if (nameList.equals(sortNameList))
	{
		System.out.println("Validation Complete");
	}
	
}
}

