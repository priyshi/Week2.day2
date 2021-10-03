package sunsep12;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PlayWithRadioButtons {

	public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("http://leafground.com/pages/radio.html");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.id("yes")).click();

		String defaultChecked = driver.findElement(By.xpath(
				"//label[text()='Find default selected radio button']//following-sibling::label//input[@checked]/parent::label"))
				.getText();
		System.out.println("Default Selected : " + defaultChecked);

		List<WebElement> ageRadio = (List<WebElement>) driver.findElements(By.name("age"));
		for (WebElement webElement : ageRadio) {
			if (webElement.isSelected()) {

				String text = (String) ((JavascriptExecutor) driver).executeScript(
						"return arguments[0].nextSibling.textContent.replaceAll(\" \",\"\")", webElement);

				System.out.println("Default Selected in AGE: " + text.replaceAll("\n", ""));
				break;
			} else {
				webElement.findElement(By.xpath("//input[@value='0']")).click();
			}
		}

	}
}