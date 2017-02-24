
package EbayTestcase;

import com.sun.javafx.geom.IllegalPathStateException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.nio.charset.IllegalCharsetNameException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;

public class StepDefinition extends EbayTestcase.HelperClass {
    String dropdownName = "Cell Phones & Accessories";
    String dropdownPrice = "Price: highest first";
    String webpage = "http://www.ebay.com/";
    String country = "From Ukraine";
    double priceRange = 4199.99;


    @Given("^I want to go to ebay page$")
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

    @When("^find lowest price from Canada$")
    public void find_lowest_price_from_Canada() throws Throwable {

        countrySelector(country);
    }


    private void countrySelector(String country) throws IllegalPathStateException, ParseException {
        List<WebElement> cntry = driver.findElements(By.xpath("//*[@id=\"ListViewInner\"]"));
        for (WebElement div : cntry) {
            List<WebElement> cntr = div.findElements(By.cssSelector("ul.lvdetails.left.space-zero.full-width"));
            for (WebElement cn : cntr) {
                WebElement parent = cn.findElement(By.xpath(".."));

                for (WebElement divPr : cntry) {
                    NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
                    List<WebElement> prices = divPr.findElements(By.cssSelector("ul.lvprices.left.space-zero > li.lvprice.prc"));
                    for (WebElement pr : prices) {


                        String countrySwitch = String.valueOf(cn.getText());

                        if (countrySwitch.contains(country)) {
                            List<WebElement> links = parent.findElements(By.className("vip"));

                            String parent23 = links.toString();

                            for (WebElement div1 : links) {


                                Number number = format.parse(String.valueOf(pr.getText()));
                                System.out.println(number);
                                if (parent23.contains(number.toString())) {
                                    div1.click();
                                }


                            }


                        }

                    }

                }

            }

        }
    }


//    private void linkFinder() throws IllegalPathStateException {
//        List<WebElement> links = driver.findElements(By.xpath("//*[@id=\"ListViewInner\"]"));
//        for (WebElement div : links) {
//            List<WebElement> lnk = div.findElements(By.className("vip"));
//            for (WebElement cn : lnk) {
//                cn.click();
//
//            }
//
//        }
//        throw new IllegalPathStateException("Please provide valid link");
//    }

    @Then("^validate that we are on right page$")
    public void validate_that_we_are_on_right_page() throws Throwable {

    }


}


