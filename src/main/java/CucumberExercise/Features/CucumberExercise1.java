package CucumberExercise.Features;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import static org.apache.commons.io.FileUtils.copyFile;

/**
 * Created by edibi on 8.2.2017.
 * <p>
 * This is simple selenium test with cucumber framework named cucumber exercise 1.
 * Workflow for this exercise is > select browser in which you need to test page.Naviga to webpage (google) ,
 * add some text in search box and press search. After test is done there should be image of test in resource folder.
 * NOTE: Please change path to your path and there is some issues with internet explorer and finding elements.
 */
public class CucumberExercise1 extends HelperClass {

    private String chrome = "CHROME";
    private String internetExplorer = "IE";
    private String firefox = "FIREFOX";
    private String webpage = "http://www.google.com/";
    private String imageValidation = "C:\\Users\\edibi\\Desktop\\selenium tests\\CucumberExercise1\\resources\\screenshot1.png";

    // This method navigate to webpage (google.com) and user is able to select one of the given browsers.
    @Given("^Navigate to google web page$")
    public void webpageNavigation() throws Throwable {
        browserSelector(chrome);
        driver.get(webpage);
    }

    // This method select search box add some text and press search button
    @When("^Click on google search$")
    public void clickOnTheBox() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 19);
        driver.findElement(By.xpath("id('lst-ib')")).sendKeys("where is my test? :)");
        driver.findElement(By.className("sbico-c")).click();

    }

    // This method is final method in my test , after validation of test , we take screenshot and put it in resource folder
    @Then("^Validate result of the given search$")
    public void searchValidaion() throws Throwable {
        driver.getCurrentUrl();
        File screenshotValidator = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        copyFile(screenshotValidator, new File(imageValidation));
        driver.close();
    }

}
