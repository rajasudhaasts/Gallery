package Skydesk;

import static org.testng.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Gallery {
	public static WebDriver driver;
	@Test
	public void loginPage() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver(); 
		driver.get("https://gallery.skydesk.in/default.aspx");
		driver.manage().window().maximize();
		driver.findElement(By.id("txtEmail")).sendKeys("demo@skydesk.in");
		driver.findElement(By.id("txtPass")).sendKeys("demo");
		driver.findElement(By.id("btnLogin")).click(); 
		Thread.sleep(5000);
	}
	
	@Test
	public void verifyLogin()
	{
		String actualTitle = "Skydesk - Gallery Dashboard";
		String expectTitle = driver.getTitle();
		assertEquals(actualTitle, expectTitle, "Title Mismatched");
		
	}
	
	@Test
	public void dashboard()
	{
		System.out.println(driver.findElement(By.xpath("(//p[@class='text-uppercase'])")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("(//p[@class='text-uppercase'])[2]")).isDisplayed());
	}
	

}
