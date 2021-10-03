package sunsep12;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BondWithButton {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("http://leafground.com/pages/Button.html");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		System.out.println("'Get Position' button corrdinates : (" + driver.findElement(By.id("position")).getLocation().getX()+ "," + driver.findElement(By.id("position")).getLocation().getY() + ")");

		System.out.println("'Get Color' button : " + driver.findElement(By.id("color")).getAttribute("style"));

		System.out.println("'Get Size' button  :" + driver.findElement(By.id("size")).getCssValue("height") + ","+ driver.findElement(By.id("size")).getCssValue("width"));

		System.out.println("Navigated to home");
		driver.findElement(By.id("home")).click();

		Thread.sleep(2000);
		//driver.close();

	}

}
