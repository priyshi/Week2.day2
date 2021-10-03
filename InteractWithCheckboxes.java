package sunsep12;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InteractWithCheckboxes {

	public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("http://leafground.com/pages/checkbox.html");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(
				By.xpath("//label[text()='Select the languages that you know?']//following-sibling::div[1]//input"))
				.click();
		driver.findElement(
				By.xpath("//label[text()='Select the languages that you know?']//following-sibling::div[3]//input"))
				.click();

		if (driver.findElement(By.xpath("//label[text()='Confirm Selenium is checked']//following-sibling::div//input"))
				.isSelected()) {
			System.out.println(driver
					.findElement(By.xpath("//label[text()='Confirm Selenium is checked']//following-sibling::div"))
					.getText() + " is selected.");
		}

		List<WebElement> checkedBoxes = driver.findElements(
				By.xpath("//label[text()='DeSelect only checked']//following-sibling::div//input[@checked]"));
		for (WebElement webElement : checkedBoxes) {
			webElement.click();
		}

		List<WebElement> selectAllBoxes = driver.findElements(
				By.xpath("//label[text()='Select all below checkboxes ']//following-sibling::div//input"));
		for (WebElement webElement : selectAllBoxes) {
			webElement.click();
		}

	}
}