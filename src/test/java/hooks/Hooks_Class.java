package hooks;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import base.Base_Class;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class Hooks_Class extends Base_Class {
	
	@Before
	public static void start() {
		Base_Class.browser_Launch();
		driver.manage().window().maximize();	
	}
	
	@After
	public void tear(Scenario scenario) throws IOException {
		if(scenario.isFailed()) {
			String screenShotpath = screenShot(driver, scenario.getName());
		    byte[] screenShot = Files.readAllBytes(new File(screenShotpath).toPath());
			scenario.attach(screenShot, "image/png", scenario.getName());
		}
//		if(driver != null) {
//			driver.quit();
//			}
	}

}
