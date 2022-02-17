package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceowAssignment {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		//Step1: Load ServiceNow application URL 
		driver.get("https://dev69571.service-now.com");
		//Step2: Enter username (Check for frame before entering the username)
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("user_name")).sendKeys("admin");
		//Step3: Enter password 
		driver.findElement(By.id("user_password")).sendKeys("Service@123");
		//Step4: Click Login
		driver.findElement(By.id("sysverb_login")).click();
		//Step5: Search “incident “ Filter Navigator
		driver.findElement(By.id("filter")).sendKeys("incident");
		//Step6: Click “All”
		driver.findElement(By.xpath("(//div[text()='All'])[2]")).click();
		//Step7: Click New button
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("sysverb_new")).click();
		//Step8: Select a value for Caller and Enter value for short_description
		driver.findElement(By.id("lookup.incident.caller_id")).click();
		Set<String>handles=driver.getWindowHandles();
		List<String>handlesList =new ArrayList<String>();
		handlesList.addAll(handles);
		driver.switchTo().window(handlesList.get(1));
		driver.findElement(By.className("glide_ref_item_link")).click();
		driver.switchTo().window(handlesList.get(0));
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("incident.short_description")).sendKeys("Added Description");
		
		//Step9: Read the incident number and save it a variable
		String incident= driver.findElement(By.id("incident.number")).getAttribute("value");
		
		//Step10: Click on Submit button
		driver.findElement(By.id("sysverb_insert_bottom")).click();
		//Step 11: Search the same incident number in the next search screen as below
		driver.findElement(By.xpath("(//label[text()='Search']/following::input)[1]")).sendKeys(incident);
		driver.findElement(By.xpath("(//label[text()='Search']/following::input)[1]")).sendKeys(Keys.ENTER);
		String searchincident = driver.findElement(By.xpath("//a[@class='linked formlink']")).getText();
		if(searchincident.equals(incident)) {
			System.out.println("Incident Created");
		}
		else {
			System.out.println("Incident  Not Created");
		}
		//Step12: Verify the incident is created successful and take snapshot of the created incident.
		File source = driver.getScreenshotAs(OutputType.FILE);
		File dest=new File("Screenshot/incident.png");
		FileUtils.copyFile(source, dest);
		
	}

}
