package webelement;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TextAreaElement_4 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String chromeDriverPath = "c:/tmp/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		
		interactingWithTextAreas();
	}
	
	public static void interactingWithTextAreas() {
		WebDriver driver = new ChromeDriver();
		
		try {
			Path sampleFile = Paths.get("pages/activity-2.html");
			driver.get(sampleFile.toUri().toString());
			
			WebElement textArea = driver.findElement(By.id("aboutYourself"));
			
			if (textArea.isEnabled() && textArea.isDisplayed()) {
				// check if empty
				if ("".equals(textArea.getAttribute("value"))) {
					System.out.println("Text area void");
				} else {
					System.out.println("Text area NOT empty");
				}
				
				textArea.sendKeys("Hello World!");
				
				if ("Hello World!".equalsIgnoreCase(textArea.getAttribute("value"))) {
					System.out.println("Text area input ok.");
				} else {
					System.out.println("Something went wrong.");
				}
				
				textArea.clear();
				if ("".equals(textArea.getAttribute("value"))) {
					System.out.println("Text area is empty after clear()");
				} else {
					System.out.println("Text area was not cleaned");
				}
			} else {
				System.out.println("Text area is not visible and displayed");
			}
			
		} finally {
			driver.quit();
		}
	}

}
