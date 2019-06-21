package webelement;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FindElement_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String chromeDriverPath = "c:/tmp/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		
		LocatingElements();

	}
	
	public static void LocatingElements() {
		WebDriver driver = new ChromeDriver();
		try {
			Path sampleFile = Paths.get("pages/activity-2.html");
			driver.get(sampleFile.toUri().toString());
			
			// Using Id
			WebElement lastName = driver.findElement(By.id("lastName"));
			if (lastName.isDisplayed()) {
				System.out.println("lastname is visible");
			} else {
				System.out.println("Wrong script 1");
			}
			
			// using name
			WebElement hobbies = driver.findElement(By.name("hobbies"));
			if (hobbies.isDisplayed()) {
				System.out.println("hobbies is visible");
			} else {
				System.out.println("Wrong script 2");
			}
			
			// using class-name
			WebElement firstName = driver.findElement(By.className("form-control"));
			if (firstName.isDisplayed()) {
				System.out.println("firstName is visible");
			} else {
				System.out.println("Wrong script 3");
			}
			
			//using html tag
			List<WebElement> div = driver.findElements(By.tagName("div"));
			if (div.size() > 0) {
				System.out.println("more than zero divs on the page");
			} else {
				System.out.println("Wrong script 4");
			}
			
			// using link
			WebElement spanishLink = driver.findElement(By.linkText("Spanish"));
			String link = spanishLink.getAttribute("href");
			if (!"".contentEquals(link)) {
				System.out.println("the link was found");
			} else {
				System.out.println("Wrong script 5");
			}
			
			//using xpath
			Select dayOfBirth = new Select(driver.findElement(By.xpath("//select")));
			if (dayOfBirth.getOptions().size() > 0) {
				System.out.println("the element was found");
			} else {
				System.out.println("Wrong script 6");
			}
			
			// using CSS
			WebElement firstNameWithCss = driver.findElement(By.cssSelector("#firstName"));
			if (firstNameWithCss.isDisplayed()) {
				System.out.println("firstName with CSS is visible");
			} else {
				System.out.println("Wrong script 7");
			}
		} finally {
			driver.quit();
		}
	}

}
