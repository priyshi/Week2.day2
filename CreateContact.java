package sunsep12;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

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

		WebElement createContactButton = driver.findElement(By.linkText("Create Contact"));
		createContactButton.click();

		WebElement firstNameField = driver.findElement(By.id("firstNameField"));
		firstNameField.sendKeys("Pri");

		WebElement lastNameField = driver.findElement(By.id("lastNameField"));
		lastNameField.sendKeys("D");

		WebElement firstNameLocalField = driver.findElement(By.id("createContactForm_firstNameLocal"));
		firstNameLocalField.sendKeys("Shine");

		WebElement lastNameLocalField = driver.findElement(By.id("createContactForm_lastNameLocal"));
       lastNameLocalField.sendKeys("D");

		WebElement DescField = driver.findElement(By.id("createContactForm_description"));
		DescField.sendKeys("Hi");


		WebElement createLeadSubmit = driver.findElement(By.className("smallSubmit"));
		createLeadSubmit.click();

		WebElement editContactButton = driver.findElement(By.linkText("Edit"));
		editContactButton.click();

		WebElement updateDescField = driver.findElement(By.id("updateContactForm_description"));
		updateDescField.clear();

		WebElement impNoteDescField = driver.findElement(By.id("updateContactForm_importantNote"));
		impNoteDescField.sendKeys("Newly Updated");

		//driver.findElement(By.xpath("//input[@value='Update']")).click();
		
		WebElement Update = driver.findElement(By.className("smallSubmit"));
		Update.click();

		String title = driver.getTitle();
		System.out.println("Page Title" + title);

		System.out.println("Successfull");
		
		//driver.close();

	}

}
