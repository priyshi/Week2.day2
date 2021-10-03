package sunsep12;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.Select;

public class SeleniumDropdown {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("http://www.leafground.com/pages/Dropdown.html");
		
		WebElement dropDown1= driver.findElement(By.id("dropdown1"));
		Select drop1= new Select(dropDown1);
		
		WebElement dropDown2= driver.findElement(By.name("dropdown2"));
		Select drop2= new Select(dropDown2);
		
		WebElement dropDown3= driver.findElement(By.id("dropdown3"));
		Select drop3= new Select(dropDown3);
		
		WebElement dropDown4= driver.findElement(By.className("dropdown"));
		Select drop4= new Select(dropDown4);
		
		drop1.selectByIndex(4);
		drop2.selectByVisibleText("Loadrunner");
		drop3.selectByValue("4");
		drop4.selectByValue("4");

		driver.findElement(By.xpath("//option[text()='You can also use sendKeys to select']/parent::select")).sendKeys("Loadrunner");
		driver.findElement(By.xpath("//option[text()='Select your programs']/parent::select")).sendKeys("Loadrunner");
	    
	
			


	}

}
