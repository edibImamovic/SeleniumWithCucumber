package CucumberExercise.Features;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.nio.charset.IllegalCharsetNameException;

/**
 * Created by edibi on 8.2.2017.
 * Helper class for CucumberExercise1
 */
public class HelperClass {

    WebDriver driver = null;

    protected String browserSelector(String selector) throws Throwable {

        if (selector.equalsIgnoreCase("CHROME")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\edibi\\Desktop\\selenium tests\\CucumberExercise1\\resources\\chromedriver.exe"); // change path to folder where you put driver
            driver = new ChromeDriver();
            return selector;
        } else if (selector.equalsIgnoreCase("FIREFOX")) {
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\edibi\\Desktop\\selenium tests\\CucumberExercise1\\resources\\geckodriver.exe"); // change path to folder where you put driver
            DesiredCapabilities cap = DesiredCapabilities.firefox();
            cap.setCapability("marionette", true);
            driver = new FirefoxDriver();
            return selector;
        } else if (selector.equalsIgnoreCase("IE")) {
            System.setProperty("webdriver.ie.driver", "C:\\Users\\edibi\\Desktop\\selenium tests\\CucumberExercise1\\resources\\IEDriverServer.exe"); // change path to folder where you put driver
            driver = new InternetExplorerDriver();
            return selector;
        }
        throw new IllegalCharsetNameException("Select one of the three browsers CHROME , Firefox or IE"); // if the user do not select any of the given browsers throw a Exception
    }
}
