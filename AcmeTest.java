package sunsep12;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AcmeTest {
	/*1. Load url "https://acme-test.uipath.com/login"
	2. Enter email as "kumar.testleaf@gmail.com"
	3. Enter Password as "leaf@12"
	4. Click login button
	5. Get the title of the page and print
	6. Click on Log Out
	7. Close the browser (use -driver.close())
	*/

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://acme-test.uipath.com/login");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.findElement(By.id("email")).sendKeys("kumar.testleaf@gmail.com");
		driver.findElement(By.id("password")).sendKeys("leaf@12");

		String title = driver.getTitle();
		System.out.println("Title : " + title);

		driver.findElement(By.xpath("//button[@type='submit']")).click();

		System.out.println("successfully Logged in ");

		driver.findElement(By.linkText("Log Out")).click();

		System.out.println("successfully Logged out ");
		
        Thread.sleep(100);
		driver.close();
	}

	}


