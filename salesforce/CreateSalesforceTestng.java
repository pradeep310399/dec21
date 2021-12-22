package salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateSalesforceTestng extends CommonClass {
	@Test
	public void runCreateSalesforce() {
		
		//click the new button
		driver.findElement(By.xpath("(//div[text()='New'])[1]")).click();
		//enter the opportunity name
		WebElement opportunityName = driver.findElement(By.xpath("(//input[@name='Name'])[1]"));
		opportunityName.sendKeys("Salesforce Automation by Pradeepkumar N");
		opportunityName.getAttribute("value");
		System.out.println(opportunityName.getAttribute("value"));
		//enter the date
		driver.findElement(By.xpath("(//input[@name='CloseDate'])[1]")).sendKeys("12/21/2021");
		//identify the stage bar
		WebElement findElement2 = driver.findElement(By.xpath("(//div[@class='slds-combobox__form-element slds-input-has-icon slds-input-has-icon_right'])[3]"));
		findElement2.click();
		//select the need analysis option
		driver.findElement(By.xpath("(//span[@class='slds-media__body']/span)[4]")).click();
		//click the save button
		driver.findElement(By.xpath("(//button[@name='SaveEdit'])")).click();
		String title = driver.getTitle();
		System.out.println(driver.getTitle());
		if(title.contains("salesforce Automation by pradeepkumar N")) {
			System.out.println("verified");
		}else {
			System.out.println("other");
		}
		
		
         
		
		
		
		
		
	}

}
