package EbayTestcase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.nio.charset.IllegalCharsetNameException;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class StepDefinition extends EbayTestcase.HelperClass {
    String dropdownName = "Cell Phones & Accessories";
    String webpage = "http://www.ebay.com/";
    String france = "From France"; // create countries by variables

    Double priceRange = 6356.89;
    String scrollTo = "vFoot";


    @Given("^Navigate to ebay page$")
    public void OpenEbayPage() throws Throwable {
        browserSelector(chrome);
        driver.navigate().to(webpage);
    }

    @When("^I click on All Categories dropdown ,select product and I want to search for it$")
    public void SearchForProductInAllCategoriesDropdown() throws Throwable {
        Select DropdownSearch = new Select(driver.findElement(By.name("_sacat")));
        DropdownSearch.selectByVisibleText(dropdownName);
        driver.findElement(By.id("gh-btn")).click();
    }

    @When("^we validate that we are on a rigt page and click on link for Cell phone and smartphone$")
    public void titleValidationAndSelectingCellphone() throws Throwable {
        if (!driver.getTitle().equalsIgnoreCase("Cell Phones - Smartphones & Mobile Accessories - New & Used | eBay")) {
            throw new IllegalCharsetNameException("You are not on right page");
        }

        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[3]/ul/div/li[1]/ul/li[4]/a")).click();

    }

    @When("^we select brand apple$")
    public void SelectingBrand() throws Throwable {

        driver.findElement(By.id("e1-32")).click();

    }

    @Then("^validate that we are on right tab$")
    public void validateRightTab() throws Throwable {

        if (!driver.getTitle().equalsIgnoreCase("Apple Smartphones | eBay")) {
            throw new IllegalCharsetNameException("You are not on right page");
        }

    }

    @When("^we are on apple page select by sorting higest price from first page$")
    public void SelectHighestPrice() throws Throwable {

        try {
            driver.findElement(By.cssSelector("div#DashSortByContainer ul.sel > li > a")).click();
            driver.findElement(By.cssSelector("ul#SortMenu li:nth-child(5) > a")).click();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @When("^find selected price from given country$")
    public void findSelectedPriceFromGivenCountry() throws Throwable {

                    List<WebElement> links = SelectCountry(france).findElements(By.className("lvtitle"));
                    for (WebElement lnk : links) {

                        WebElement linkSiblingCountry = lnk.findElement(By.xpath("following::ul[2]"));
                        WebElement linkSiblingPrice = lnk.findElement(By.xpath("following::ul[1]"));
                        String linkSiblings = linkSiblingCountry.getText();

                        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
                        Number number = format.parse(String.valueOf(linkSiblingPrice.getText()));

                        double price = number.doubleValue();

                        String linkSiblingsPrc = String.valueOf(price);
                        String doubleConversion = String.valueOf(priceRange);

                        if (linkSiblings.contains(france) && linkSiblingsPrc.contains(doubleConversion)) {

                            ScrollingMethod(scrollTo);
                            lnk.click();
                        }
                    }


                }


    @Then("^validate that we are on right page$")
    public void validate_that_we_are_on_right_page() throws Throwable {

    }

}