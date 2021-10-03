package sunsep12;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesForce {
	    //SalesForce:
		// Step 1: Download and set the path 
		// Step 2: Launch the chromebrowser
		// Step 3: Load the URL 
	    //https://www.salesforce.com/in/form/signup/freetrial-sales/?d=70130000000Enyk
		// Step 4: Maximise the window
		// Step 5: Add implicit wait
		// Step 6: Fill in all the text boxes
		// Step 7: Handle all the dropdowns
		// Step 8: Click the check box
		// Step 9: Close the browser
		//*Note: No need click Start my freeTrial
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.salesforce.com/in/form/signup/freetrial-sales/?d=70130000000Enyk");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.name("UserFirstName")).sendKeys("Priya");
		driver.findElement(By.name("UserLastName")).sendKeys("D");
		driver.findElement(By.name("UserEmail")).sendKeys("priyabhrathi@gmail.com");

		WebElement titleDropDown = driver.findElement(By.name("UserTitle"));
		Select title = new Select(titleDropDown);
		title.selectByVisibleText("Developer / Software Engineer / Analyst");

		driver.findElement(By.name("CompanyName")).sendKeys("TestLeaf");
		driver.findElement(By.name("UserPhone")).sendKeys("9677103928");

		WebElement employeesDropDown = driver.findElement(By.name("CompanyEmployees"));
		Select employees = new Select(employeesDropDown);
		employees.selectByVisibleText("1501+ employees");

		WebElement cntryDropDown = driver.findElement(By.name("CompanyCountry"));
		Select cntry = new Select(cntryDropDown);
		cntry.selectByVisibleText("India");

		driver.findElement(By.xpath("//div[@class='checkbox-ui']")).click();

		System.out.println("Completed Sales Force");
        
		driver.close();
	}

}
