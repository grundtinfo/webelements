package webelement;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Overview_1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String chromeDriverPath = "c:/tmp/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		
		gettingStaleElementReferenceException();
	}
	
	public static void gettingStaleElementReferenceException() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		try {
			Path sampleFile = Paths.get("pages/activity-1.html");
			driver.get(sampleFile.toUri().toString());
			
			WebElement spanish = driver.findElement(By.id("spanish"));
			spanish.click();
			
			WebElement email = driver.findElement(By.id("inputEmail"));
			
			email.sendKeys("email@gmail.com");
			
			Thread.sleep(5000);
			
			//We use g 
			if (email.getAttribute("value").equalsIgnoreCase("email@gmail.com")) {
				System.out.println("=> 'email@gmail.com' tapé");
			} else {
				System.out.println("Mauvais script");
			}
		} finally {
			// TODO: handle finally clause
			driver.quit();
		}
	}

}
