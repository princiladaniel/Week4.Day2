package leafGroundElement;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnCheckBox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * //Pseudo Code
		 * 
		 * 1. Launch URL "http://www.leafground.com/"
		 * 
		 * 2. Click on CheckBox
		 * 
		 * 3. Select the Options for Select the languages that you know?
		 * 
		 * 4. Confirm Selenium is Checked 
		 * 
		 * 5.  DeSelect IamSelected CheckBox
		 * 
		 * 6. Select all the checkBoxes Available in (Select all below checkBoxes)
		 */
		WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver();
		 driver.get("http://www.leafground.com/");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		 driver.findElement(By.xpath("//h5[text()='Checkbox']")).click();
		 driver.findElement(By.xpath("//label[text()='Select the languages that you know?']"));
		 driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		 WebElement Selenium  = driver.findElement(By.xpath("//label[text()='Confirm Selenium is checked']/following::input"));
		 boolean Seleniumselected=Selenium.isSelected();
		 System.out.println(Seleniumselected);
		 WebElement FirstElement = driver.findElement(By.xpath("//label[text()='DeSelect only checked']/following::input"));
	
		 if(FirstElement.isSelected()) {
			 FirstElement.click();
		 }
     WebElement SecondElement = driver.findElement(By.xpath("//label[text()='DeSelect only checked']/following::input[2]"));
         if(SecondElement.isSelected()) {
		// TODO Auto-generated method st
        	 SecondElement.click();
        	 List <WebElement>AllCheckboxes =driver.findElements(By.xpath("//label[text()='Select all below checkboxes ']/following::input"));
        	    
        	    int size = AllCheckboxes.size();
        	    System.out.println(size);
        	    
        	    
        	    for(int i = 0; i<size; i++) {
        	        
        	        AllCheckboxes.get(i).click();
	}

}
}
}