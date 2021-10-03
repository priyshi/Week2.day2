package sunsep12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	/*http://leaftaps.com/opentaps/control/main

	1	Launch the browser
	2	Enter the username
	3	Enter the password
	4	Click Login
	5	Click crm/sfa link
	6	Click Leads link
	7	Click Find leads
	8	Click on Email
	9	Enter Email
	10	Click find leads button
	11	Capture name of First Resulting lead
	12	Click First Resulting lead
	13	Click Duplicate Lead
	14	Verify the title as 'Duplicate Lead'
	15	Click Create Lead
	16	Confirm the duplicated lead name is same as captured name
	17	Close the browser (Do not log out)
	
	*/
	public static void main(String[] args) throws InterruptedException {
		
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

		// Logged in User clicks CRM/SFA
		WebElement homePage = driver.findElement(By.linkText("CRM/SFA"));
		homePage.click();

		// Leads Tab - > CreateLead
		WebElement leadsTab = driver.findElement(By.linkText("Leads"));
		leadsTab.click();

		WebElement createLeadButton = driver.findElement(By.linkText("Find Leads"));
		createLeadButton.click();

		driver.findElement(By.xpath("//span[text()='Email']")).click();

		driver.findElement(By.name("emailAddress")).sendKeys("testleaf@gmail.com");

		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

	    String attribute = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName'][1]/a")).getAttribute("value");
	   
		driver.findElement(By.id("//a[@id='ext-gen906']")).click();

		driver.findElement(By.linkText("Duplicate Lead")).click();

		String title = driver.getTitle();
		title.contains("Duplicate Lead");

		WebElement createLeadSubmit = driver.findElement(By.className("smallSubmit"));
		createLeadSubmit.click();

        if(attribute.equals(driver.findElement(By.id("viewLead_firstName_sp")).getText())) {

			System.out.println("Duplicate Lead created " + attribute);
			driver.close();
	
		

	}

}
}

