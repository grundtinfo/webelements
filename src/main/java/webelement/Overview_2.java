package webelement;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Overview_2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String chromeDriverPath = "c:/tmp/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		
		avoidingStaleElementReferenceException();
	}
	
	private static void avoidingStaleElementReferenceException() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		try {
			Path sampleFile = Paths.get("pages/activity-1.html");
			driver.get(sampleFile.toUri().toString());
			WebElement email = driver.findElement(By.id("inputEmail"));
			WebElement spanish = driver.findElement(By.id("spanish"));
			spanish.click();
			
			int tries = 0;
			while (tries < 2) {
				try {
					email.sendKeys("email@gmail.com");
					Thread.sleep(1000);
					
					if (email.getAttribute("value").equalsIgnoreCase("email@gmail.com")) {
						System.out.println("=> 'email@gmail.com' tapé");
					} else {
						System.out.println("Wrong script");
					}
				} catch (StaleElementReferenceException e) {
					// TODO: handle exception
					email = driver.findElement(By.id("inputEmail"));
				}
				tries++;
				
				
			}
		} finally {
			// TODO: handle finally clause
			driver.quit();
		}
	}

}
