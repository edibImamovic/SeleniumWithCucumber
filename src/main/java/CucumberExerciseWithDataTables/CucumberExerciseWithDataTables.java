package CucumberExerciseWithDataTables;

import CucumberExercise.Features.HelperClass;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import java.nio.charset.IllegalCharsetNameException;

/**
 * Created by edibi on 9.2.2017.
 * This is exercise for selenium with cucumber framework
 * Testing for web site www.klix.ba , main idea is to at first, test menu bars.
 * On later tests my main goal is to create one full functional regression automated test for different web sites
 */
public class CucumberExerciseWithDataTables extends HelperClass {


    String webpage = "http://www.klix.ba/";

    @Before
    public void startUp() throws Throwable {
        browserSelector(chrome);
    }

    @After
    public void closeBrowsers() {
        try {
            driver.quit();
        } catch (Exception e) {
            e.getMessage();
        }

    }

    @Given("^I am on the Klix website$")
    public void navigateToWebsite() throws Throwable {
        driver.navigate().to(webpage);

    }

    @When("^I navigate to \"([^\"]*)\"$")
    public void clickOnLink(String link) throws Throwable {
        driver.findElement(By.className(link)).click();

//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.name(link)));
//        element.click();
    }

    @Then("^I check page is \"([^\"]*)\"$")
    public void checkPageTitle(String title) throws Throwable {

        String actualTitle = driver.getTitle();
        if (actualTitle.contains(title)) {
            closeBrowsers();
        } else {
            throw new IllegalCharsetNameException("Title is not the same");
        }
    }

}
