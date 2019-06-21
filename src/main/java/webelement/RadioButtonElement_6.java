package webelement;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtonElement_6 {

	public static void main(String[] args) {
		String chromeDriverPath = "c:/tmp/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		
		interactingWithRadioButton();
	}
	
	public static void interactingWithRadioButton() {
		WebDriver driver = new ChromeDriver();
		
		try {
			Path sampleFile = Paths.get("pages/activity-2.html");
			driver.get(sampleFile.toUri().toString());
			
			WebElement masters = driver.findElement(By.cssSelector("input[value='masters']"));
			if (masters.isEnabled() && masters.isDisplayed()) {
				System.out.println("Radio button enabled and visible.");
				if (!masters.isSelected()) {
					masters.click();
					if (masters.isSelected()) {
						System.out.println("'Masters' option selected.");
					} else {
						System.out.println("'Masters' option was not selected.");
					}
				}
			} else {
				System.out.println("Radio button not enabled or not visible or both.");
			}
		} finally {
			driver.quit();
		}
	}

}
