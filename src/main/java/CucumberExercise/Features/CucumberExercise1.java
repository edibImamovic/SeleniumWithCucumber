package CucumberExercise.Features;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;


/**
 * Created by edibi on 8.2.2017.
 */
public class CucumberExercise1 extends HelperClass {


    private String chrome = "CHROME";
    private String internetExplorer = "IE";
    private String firefox = "FIREFOX";
    String webpage= "http://www.laptopmag.com/";



    @Given("^Navigate to google web page$")
    public void webpageNavigation() throws Throwable {
        browserSelector(chrome);
        driver.navigate().to(webpage);
    }

    @When("^Click on google search$")
    public void clickOnTheBox() throws Throwable {

        driver.findElement(By.cssSelector("span#JgeUcJjl div.headerSearch > form > input")).sendKeys("where is my laptop? :)");
        driver.findElement(By.cssSelector("span#XiIcqhYC div.console.lastUnit > nav > ul > li:nth-child(6) > a")).click();

    }

    @Then("^Validate result of the given search$")
        public void searchValidaion() throws Throwable {
        driver.close();
    }

}
