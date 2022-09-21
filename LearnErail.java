package novBatch;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnErail {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://erail.in/");

		//Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebElement fromtrain = driver.findElement(By.id("txtStationFrom"));
		fromtrain.clear();
		fromtrain.sendKeys("TPJ",Keys.TAB);
		WebElement totrain = driver.findElement(By.id("txtStationTo"));
		totrain.clear();
		totrain.sendKeys("MS",Keys.TAB);
		//check the sort checkbox
		driver.findElement(By.id("chkSelectDateOnly")).click();
		WebElement table = driver.findElement(By.xpath("//table[@class='DataTable TrainList TrainListHeader']"));
		table.getText();
		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr"));
		System.out.println(rows.size());
		List<String>lsttrain=new ArrayList<String>();
		for (int i = 1; i < rows.size(); i++) {
			
		
		String text = driver.findElement(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr["+i+"]/td[2]")).getText();
		//System.out.println(text);
		
		
		
		if(text.contains("CHENNAI")) {
			
			System.out.println(text);
		}
		
		
		}
		
		
		
		
		
	}

}
