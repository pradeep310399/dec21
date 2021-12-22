package december21;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesforceCreateLead {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//enter the url
		driver.get("https://login.salesforce.com/");
		//Enter the username and password
		driver.findElement(By.id("username")).sendKeys("earth@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Bootcamp@123");
		//click the login button
		driver.findElement(By.id("Login")).click();
		//click the toggle button
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		//click the view all button
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		//click the sales option
		driver.findElement(By.xpath("//p[text()='Manage your sales process with accounts, leads, opportunities, and...']")).click();
		//click on the opportunities tab
		WebElement opp = driver.findElement(By.xpath("//span[text()='Opportunities']"));
        driver.executeScript("arguments[0].click();", opp);
		opp.click();
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
		
		driver.close();
         
		
		
		
		
		
	}

}
