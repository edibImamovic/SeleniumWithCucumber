package CucumberExercise.Features;

import com.sun.javafx.geom.IllegalPathStateException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by edibi on 8.2.2017.
 * <p>
 * This is simple selenium test with cucumber framework named cucumber exercise 1.
 * Workflow for this exercise is > select browser in which you need to test page.Naviga to webpage (google) ,
 * add some text in search box and press search. After test is done there should be image of test in resource folder.
 * NOTE: Please change path to your path and there is some issues with internet explorer and finding elements.
 */
public class CucumberExercise1 extends HelperClass {


    String webpage = "http://www.google.com/";

    /**
     * This method navigate to webpage (google.com) and user is able to select one of the given browsers.
     *
     * @throws Throwable
     */

    @Given("^Navigate to google web page$")
    public void webpageNavigation() throws Throwable {
        browserSelector(chrome);
        driver.get(webpage);
    }

    /**
     * This method select search box add some text and press search button
     *
     * @throws Throwable
     */

    @When("^Click on google search$")
    public void clickOnTheBox() throws Throwable {
        driver.findElement(By.xpath("id('lst-ib')")).sendKeys("comtrade");
        driver.findElement(By.className("sbico-c")).click();

    }

    /**
     * This method is final method in my test , after validation of test , we take screenshot and put it in resource folder
     *
     * @throws Throwable
     */

    @Then("^Validate result of the given search$")
    public void searchValidaion() throws Throwable {
        imageCapture(cucumberExercise1png);
        driver.close();
    }

}
