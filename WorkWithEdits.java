package sunsep12;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkWithEdits {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("http://leafground.com/pages/Edit.html");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.findElement(By.id("email")).sendKeys("testLeaf@gmail.com");

		String append = driver.findElement(By.xpath("//label[text()='Append a text and press keyboard tab']/following-sibling::input")).getAttribute("value");
		driver.findElement(By.xpath("//label[text()='Append a text and press keyboard tab']/following-sibling::input")).sendKeys(append.concat(" is successful"));
		driver.findElement(By.xpath("//label[text()='Append a text and press keyboard tab']/following-sibling::input")).sendKeys(Keys.TAB);

		Thread.sleep(100);
		String defaultString = driver.findElement(By.xpath("//label[text()='Get default text entered']/following-sibling::input")).getAttribute("value");
		System.out.println("Default String obtained: " + defaultString);

		if (driver.findElement(By.xpath("//label[text()='Confirm that edit field is disabled']/following-sibling::input")).getAttribute("disabled").equals("true")) {
			Thread.sleep(100);
			System.out.println("Last field is disabled");
			Thread.sleep(1000);
			//driver.close();

		}
	}

}
