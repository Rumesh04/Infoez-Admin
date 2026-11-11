package base;

import java.io.File;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Base_Class {
	
	protected static WebDriver driver;
	protected static WebDriverWait wait;
	protected static JavascriptExecutor js;
	protected static Actions A;
    //protected static page_object_model.PomClass
	
	
	public static void browser_Launch() {
		
		WebDriverManager.edgedriver().setup();
		
		driver = new EdgeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		js = (JavascriptExecutor)driver;
		
	}
	
	public static void button(WebElement element) {
		element.click();
	}
	
	public static void setText(WebElement element, String value) {
		element.sendKeys(value);
	}
	
	public static void setTextWithEnter(WebElement element, String value) {
		
		element.sendKeys(value, Keys.ENTER);
	}
	
	public static void waitImpletic() {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public static void elementToBeClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	
	public static void visibleOfElement(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void visibleOfAllElement(List<WebElement> element) {
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
	}
	
	public static void select(WebElement element, String value) {
		Select S = new Select(element);
		S.selectByVisibleText(value);
	}
	
	public static void iterateWebElement(List<WebElement> list, int size) {
		for(int i=0;i<size;i++) {
			try {
				Thread.sleep(3000);
			}catch (Exception e) {
				e.printStackTrace();
			}
//			String text = list.get(i).getText();
//			if(text.equalsIgnoreCase(option)) {
//				System.out.println("All the Option: "+option);
//			}else {
//				System.out.println("Correct option is not displayed");
//			}
			System.out.println(list.get(i).getText() + " | ");
 		    System.out.println();
			
		}
	}
	
	public String screenShot(WebDriver driver1, String scenario) {
		String timeStamp = LocalDateTime.now().toString().replace(":", "-");
		String filePath =  System.getProperty("user.dir") + "/screenShot/" + scenario + " - " + timeStamp + ".png";
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File des = new File(filePath);
		try {
		    FileUtils.copyFile(src, des);
		}catch (Exception e) {
			throw new RuntimeException("SCreenshot not capture");
		}
		return filePath;
		
	}
	
	public void hiddenButton(WebElement element) {
		js.executeScript("arguments[0].click();", element);
	}
	
	public static void selectRole(List<WebElement> list, int size, String option) {
		for(int i=0;i<size;i++) {
			try {
				Thread.sleep(3000);
			}catch (Exception e) {
				e.printStackTrace();
			}
			String text = list.get(i).getText();
			if(text.equalsIgnoreCase(option)) {
				System.out.println("All the Option: "+option);
			}else {
				System.out.println("Correct option is not displayed");
			}
			
		}
	}
	
//	public void selectCategory(String heading) {
//		page_object_model.PomClass pom = new page_object_model.PomClass();
//		//Select S = new Select(pom.getRoleColumn());
//		int size = S.getOptions().size();
//		for(int i=0;i<size;i++) {
//		        String text = S.getOptions().get(i).getText();
//			if(text.equalsIgnoreCase(heading)) {
//				S.selectByVisibleText(text);
//				return;
//			}
//		}
//		throw new RuntimeException("Status option is not selected: "+heading);
//	
//	}
	
	
}
