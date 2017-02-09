package CucumberExercise.Features;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


/**
 * Created by edibi on 8.2.2017.
 */
public class CucumberExercise1 extends BrowserSelector {

    WebDriver driver = new ChromeDriver();


    @Given("^Navigate to google web page$")
    public void webpageNavigation() throws Throwable {
        String webpage = GoogleChrome("http://www.google.com");
        driver.navigate().to(webpage);
    }

    @When("^Click on google search$")
    public void clickOnTheBox() throws Throwable {
        boolean webPageName  = driver.getTitle().contains("Google");
        if (webPageName){
        driver.findElement(By.id("lst-ib")).sendKeys("this is my test");
        driver.findElement(By.name("btnG")).click();

        }
    }

    @Then("^Validate result of the given search$")
        public void searchValidaion() throws Throwable {
//        driver.close();
    }
}
