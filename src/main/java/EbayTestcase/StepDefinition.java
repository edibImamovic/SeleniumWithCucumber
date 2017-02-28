package EbayTestcase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.nio.charset.IllegalCharsetNameException;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class StepDefinition extends EbayTestcase.HelperClass {
    String dropdownName = "Cell Phones & Accessories";
    String dropdownPrice = "Price: highest first";
    String webpage = "http://www.ebay.com/";
    String country = "From France";
    Double priceRange = 6356.89;


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
    public String find_lowest_price_from_Canada() throws Throwable {

        List<WebElement> ttN = driver.findElements(By.xpath("//*[@id=\"ListViewInner\"]"));
        for (WebElement div : ttN) {
            NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
            List<WebElement> prices = div.findElements(By.cssSelector("ul.lvprices.left.space-zero > li.lvprice.prc"));
            for (WebElement pr : prices) {

                Number number = format.parse(String.valueOf(pr.getText()));
                double price = number.doubleValue();

                if (price == priceRange) {

                    String priceRtn = String.valueOf(price);
                    return priceRtn;
                }


            }


        }

        throw new IllegalCharsetNameException("Please provide valid price ");
    }

    @When("^select country$")
    public void countrySelector() throws Throwable {


        List<WebElement> cntry = driver.findElements(By.xpath("//*[@id=\"ListViewInner\"]"));
        for (WebElement div : cntry) {
            List<WebElement> cntr = div.findElements(By.cssSelector("ul.lvdetails.left.space-zero.full-width"));
            for (WebElement cn : cntr) {

                String countrySwitch = String.valueOf(cn.getText());
                if (countrySwitch.contains(country)) {
                    WebElement parent = cn.findElement(By.xpath(".."));
                    List<WebElement> links = parent.findElements(By.className("lvtitle"));
                    for (WebElement lnk : links) {

                        WebElement linkSiblingCountry = lnk.findElement(By.xpath("following::ul[2]"));
                        WebElement linkSiblingPrice = lnk.findElement(By.xpath("following::ul[1]"));
                        String linkSiblings = linkSiblingCountry.getText();

                        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
                        Number number = format.parse(String.valueOf(linkSiblingPrice.getText()));

                        double price = number.doubleValue();

                        String linkSiblingsPrc = String.valueOf(price);
                        String doubleConversion = String.valueOf(priceRange);

                        if (linkSiblings.contains(country) && linkSiblingsPrc.contains(doubleConversion)) {

                            WebElement element = driver.findElement(By.id("vFoot"));
                            Actions actions = new Actions(driver);
                            actions.moveToElement(element);
                            actions.perform();
                            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                            lnk.click();
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