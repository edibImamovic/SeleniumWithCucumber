package CucumberExercise.Features;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by edibi on 8.2.2017.
 */
public class BrowserSelector {

    public String GoogleChrome(String webpage){
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\edibi\\Desktop\\selenium tests\\CucumberExercise1\\chromedriver.exe");
        return webpage;
    }

}
