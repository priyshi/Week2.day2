package sunsep12;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/login");

		WebElement userName = driver.findElement(By.id("username"));
		userName.sendKeys("demosalesmanager");

		WebElement passWord = driver.findElement(By.id("password"));
		passWord.sendKeys("crmsfa");

		WebElement loginButton = driver.findElement(By.className("decorativeSubmit"));
		loginButton.click();


		WebElement homePage = driver.findElement(By.linkText("CRM/SFA"));
		homePage.click();

		WebElement leadsTab = driver.findElement(By.linkText("Leads"));
		leadsTab.click();

		WebElement createLeadButton = driver.findElement(By.linkText("Find Leads"));
		createLeadButton.click();

		driver.findElement(By.xpath("//span[text()='Phone']")).click();

		driver.findElement(By.name("phoneNumber")).sendKeys("91");

		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

		String leadId = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId'][1]/a")).getText();

		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId'][1]/a")).click();

		System.out.println("Deleting id : " + leadId);
		driver.findElement(By.linkText("Delete")).click();

		driver.findElement(By.linkText("Find Leads")).click();

		driver.findElement(By.name("id")).sendKeys(leadId);

		
		System.out.println("Again Searching the deleted id : " + leadId);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

		
		System.out.println("After deleting : " + driver.findElement(By.xpath("//div[@class='x-paging-info']")).getText());

		if ((driver.findElement(By.xpath("//div[@class='x-paging-info']")).getText()).contains("No records to display")) {
			System.out.println("Deleted Lead successfully");
			//driver.close();

	}

	}
	
}
	
	



