package SampleProj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Bing_Test {

	public static WebDriver driver;

	@Test
	public static void setUp() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
		options.addArguments("start-maximized");
		driver = new ChromeDriver(options);
		driver.get("https://www.google.com");
		System.out.println("Successfully Executed the Script.....!");
	}

	@AfterTest
	public void CloseBrowser() {
		driver.quit();
	}

}
