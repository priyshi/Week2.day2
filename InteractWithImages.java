package sunsep12;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InteractWithImages{

	public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("http://leafground.com/pages/Image.html");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		System.out.println("\nClicking Image to navigate");
		driver.findElement(By.xpath("//img[contains(@src,'home')]")).click();

		Thread.sleep(2000);
		System.out.println("Back to Image Page");
		driver.navigate().back();

		System.out.println("\nVerifying is broken Image:");

		if (driver.findElement(By.xpath("//img[contains(@src,'abcd')]")).getAttribute("naturalWidth").equals("0")) {
			System.out.println("Broken Image");
		} else {
			System.out.println("Valid Image");
		}

		System.out.println("\nClicking Image to navigate!!!");
		driver.findElement(By.xpath("//img[contains(@src,'keyboard')]")).click();

		Thread.sleep(2000);
		//driver.close();

	}
}
