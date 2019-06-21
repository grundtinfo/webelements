package webelement;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ChoixSimpleOuMultipleElement_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String chromeDriverPath = "c:/tmp/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		
		interactingWithDropDown();

	}
	
	private static void interactingWithDropDown() {
		WebDriver driver = new ChromeDriver();
		
		try {
			Path sampleFile = Paths.get("pages/activity-2.html");
			driver.get(sampleFile.toUri().toString());
			
			Select singleChoiceList = new Select(driver.findElement(By.id("monthOfBirth")));
			
			if(!singleChoiceList.isMultiple() && singleChoiceList.getOptions().size() == 13) {
				System.out.println("Liste Simple ok.");
				singleChoiceList.selectByVisibleText("February");
				if(singleChoiceList.getFirstSelectedOption().getText().equalsIgnoreCase("February")) {
					System.out.println("February selected");
				} else {
					System.out.println("February is not selected");
				}
			} else {
				System.out.println("Something went wrong 1");
			}
			
			Select multipleChoiceList = new Select(driver.findElement(By.id("hobbies")));
			
			if(multipleChoiceList.isMultiple() && multipleChoiceList.getOptions().size() == 4) {
				System.out.println("Liste multiple ok.");
				multipleChoiceList.selectByVisibleText("Reading");
				multipleChoiceList.selectByVisibleText("Sports");
				multipleChoiceList.selectByVisibleText("Traveling");
				
				multipleChoiceList.deselectByVisibleText("Sports");
				
				if(multipleChoiceList.getAllSelectedOptions().size() == 2) {
					System.out.println("Multi select ok.");
				} else {
					System.out.println("Something went wrong 2");
				}
				
				List<String> expectedSelection = Arrays.asList("Reading", "Traveling");
				List<String> actualSelection = new ArrayList<String>();
				
				for (WebElement element : multipleChoiceList.getAllSelectedOptions()) {
					actualSelection.add(element.getText());
				}
				
				if (actualSelection.containsAll(expectedSelection)) {
					System.out.println("Multi select by foreach ok.");
				} else {
					System.out.println("Something went wrong 3");
				}
				
			} else {
				System.out.println("Something went wrong 4");
			}
		} finally {
			driver.quit();
		}
	}

}
