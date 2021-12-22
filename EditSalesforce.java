package december21;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditSalesforce {
	public static void main(String[] args) throws InterruptedException {
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
		WebElement opp = driver.findElement(By.xpath("(//a[@title='Opportunities']/span)"));
		driver.executeScript("arguments[0].click();", opp);
		//search the name in search  bar
		driver.findElement(By.xpath("//input[@name='Opportunity-search-input']")).sendKeys("salesforce Automation by pradeepkumar N",Keys.ENTER);
		Thread.sleep(5000);
		//click the dropdown
		driver.findElement(By.xpath("(//span[text()='Show Actions']/parent::span)[1]")).click();
		Thread.sleep(5000);
		//click the edit option
		driver.findElement(By.xpath("//div[text()='Edit']/parent::a")).click();
		//edit the date 
		WebElement date = driver.findElement(By.xpath("//input[@name='CloseDate']"));
		date.clear();
		date.sendKeys("12/22/2021");
		//edit the stage as perception analysis
		WebElement findElement2 = driver.findElement(By.xpath("//label[text()='Stage']/following::input[1]"));
		findElement2.click();
		WebElement perceptionanalysis = driver.findElement(By.xpath("//span[contains(@class,'slds-media')]/following::span[text()='Perception Analysis']"));
		perceptionanalysis.click();
		String attribute = perceptionanalysis.getAttribute("title");
		System.out.println(attribute);
		//entering the delivery status as in progress
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[contains(@class,'slds-form')]/following::label[text()='Delivery/Installation Status']")).click();
		driver.findElement(By.xpath("(//span[text()='In progress'])")).click();
		//enter the description
		driver.findElement(By.xpath("(//textarea[@class='slds-textarea'])")).sendKeys("SalesForce");
		//click the save button
		driver.findElement(By.xpath("(//button[@name='SaveEdit'])")).click();
		//check the perception analysis is clicked
		if(attribute.contains("Perception Analysis")) {
			System.out.println("verfied");
		}
		else {
			System.out.println("other");
		}
		driver.close();
		
	}

}
