package week3.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ErailSort {

	public static void main(String[] args) throws InterruptedException {
		// Launch the browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		// Step1: Launch the URL - https://erail.in/
		driver.get("https://erail.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		// Uncheck the check box - sort on date
		driver.findElement(By.id("chkSelectDateOnly")).click();
		// clear and type in the source station
		driver.findElement(By.id("txtStationFrom")).clear();
		driver.findElement(By.id("txtStationFrom")).sendKeys("GOLDEN TEMPLE M");
		// clear and type in the destination station
		driver.findElement(By.id("txtStationTo")).clear();
		driver.findElement(By.id("txtStationTo")).sendKeys("Mumbai Central");
		// Find all the train names using xpath and store it in a list
		List<String> trainNameList = new ArrayList<String>();
		List<WebElement> trainNames = driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr"));
		int size = trainNames.size();
		System.out.println(size);
		Thread.sleep(2000);
		// Use Java Collections sort to sort it and then print it
		for (int i = 1; i <= size; i++) {
		String arrange = driver.findElement(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr[" + i + "]/td[2]")).getText();
		trainNameList.add(arrange);
		Collections.sort(trainNameList);
		}
		System.out.println(trainNameList);
		}		
			
			}
			
			
			
			
		

	


