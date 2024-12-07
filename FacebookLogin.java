package sunsep12;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebookLogin {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://en-gb.facebook.com/");
		driver.getTitle();

		driver.findElement(By.linkText("Create New Account")).click();

		driver.findElement(By.name("firstname")).sendKeys("Pri");
		driver.findElement(By.name("lastname")).sendKeys("Bharathi");
		driver.findElement(By.name("reg_email__")).sendKeys("priyabharathi166@gmail.com");
		driver.findElement(By.name("reg_email_confirmation__")).sendKeys(driver.findElement(By.name("reg_email__")).getAttribute("value"));
		driver.findElement(By.id("password_step_input")).sendKeys("Javapri9@");

		Select day = new Select(driver.findElement(By.name("birthday_day")));
		day.selectByVisibleText("20");

		Select month = new Select(driver.findElement(By.name("birthday_month")));
		month.selectByVisibleText("Sep");

		Select year = new Select(driver.findElement(By.name("birthday_year")));
		year.selectByVisibleText("1111");

		driver.findElement(By.xpath("//input[@value='1']")).click();
		driver.findElement(By.name("websubmit")).click();

		System.out.print("Enter the security code page came successfully!!");
		String title = driver.getTitle();
		System.out.println(title);
		driver.close();

	}

}
