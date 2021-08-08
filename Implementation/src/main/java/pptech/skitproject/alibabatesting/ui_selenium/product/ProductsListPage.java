package pptech.skitproject.alibabatesting.ui_selenium.product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pptech.skitproject.alibabatesting.ui_selenium.BasePage;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ProductsListPage extends BasePage {

    public ProductsListPage(WebDriver driver) {
        super(driver);
    }

    public void open() throws InterruptedException {
        Thread.sleep(5000);
        driver.get("https://www.alibaba.com/electrical-equipment-supplies/connectors-terminals/p5_p14190406?spm=a27aq.industry_category_productlist.scGlobalHomeHeader.532.325048dafeaFeq");
        // using the "Connectors Terminals" Products list, for purposes of testing the products list
    }

    public boolean isLoaded() throws InterruptedException {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("pageContent"))).isDisplayed();
    }

    public boolean getProductsType() {
        try {
            WebElement title = driver.findElement(By.xpath("//*[@id='page-path']/div/h1"));

            return title.isDisplayed() && title.getText().equals("Connectors & Terminals");
        } catch (Exception ignored) {
            return false;
        }
    }

    public boolean getProductsList() {
        try {
            WebElement productsListSection = driver.findElement(By.id("right-content"));
            List<WebElement> productsList = driver.findElements(By.className("flexColFloor"));

            return productsListSection != null && productsListSection.isDisplayed()
                    && productsList != null && productsList.size() != 0;
            // the products are displayed if the section with the products is displayed and the number of cart items is above 0
        } catch (Exception ignored) {
            return false;
        }
    }

    public boolean getProductImage() {
        try {
            // For the purpose of testing, first item of the product list is taken and checked
            WebElement product = driver.findElement(By.xpath("//*[@id='mod_2_10454002']"));
            WebElement image = driver.findElement(By.xpath("//*[@id=\"mod_2_10454002\"]/div/a/div/div[1]"));

            return product != null && product.isDisplayed() &&
                    image != null && image.isDisplayed();
            // return true if the product is displayed and the particular image in it is displayed
        } catch (Exception ignored) {
            return false;
        }
    }

    public boolean getProductTitle() {
        try {
            // For the purpose of testing, first item of the product list is taken and checked
            WebElement product = driver.findElement(By.xpath("//*[@id='mod_2_10454002']"));
            WebElement title = driver.findElement(By.xpath("//*[@id=\"mod_2_10454002\"]/div/a/div/div[2]/div[1]/span"));

            return product != null && product.isDisplayed() &&
                    title != null && title.isDisplayed() && title.getText().equals("10cm rf jumper assembly n plug to sma plug for semi-rigid rg141 jumper cables");
            // return true if the product is displayed and the particular title for the product is displayed
        } catch (Exception ignored) {
            return false;
        }
    }

    public boolean getProductPrice() {
        try {
            // For the purpose of testing, first item of the product list is taken and checked
            WebElement product = driver.findElement(By.xpath("//*[@id='mod_2_10454002']"));
            WebElement price = driver.findElement(By.xpath("//*[@id=\"mod_2_10454002\"]/div/a/div/div[2]/div[2]/span"));
            String[] parts = price.getText().split(" - ");
            String minPrice = parts[0];
            String maxPrice = parts[1];

            return product != null && product.isDisplayed() && price.isDisplayed()
                    && minPrice.equals("$0.80") && maxPrice.equals("$1.00");
            // return true if the product is displayed and the particular minimal and maximum price for the product is displayed (therefore the full price range is displayed)
        } catch (Exception ignored) {
            return false;
        }
    }

    public boolean getProductMOQ() {
        try {
            // For the purpose of testing, first item of the product list is taken and checked
            WebElement product = driver.findElement(By.xpath("//*[@id='mod_2_10454002']"));
            WebElement moq = driver.findElement(By.xpath("//*[@id=\"mod_2_10454002\"]/div/a/div/div[2]/div[3]/div[1]/span"));

            return product != null && product.isDisplayed() &&
                    moq != null && moq.isDisplayed() && moq.getText().equals("10.0 Pieces");
            // return true if the product is displayed and the particular MOQ quantity for the product is displayed
        } catch (Exception ignored) {
            return false;
        }
    }

    public boolean getProductLink() {
        try {
            // For the purpose of testing, first item of the product list is taken and checked
            WebElement product = driver.findElement(By.xpath("//*[@id='mod_2_10454002']"));
            WebElement productLink = driver.findElement(By.xpath("//*[@id=\"mod_2_10454002\"]/div/a"));

            return product != null && product.isDisplayed() &&
                    productLink != null && productLink.isDisplayed() && productLink.getTagName().equals("a");
            // return true if the product is displayed and the particular link for it is displayed (the tag is 'a' for links)
        } catch (Exception ignored) {
            return false;
        }
    }

    public boolean getAboutSuppliersSection() {
        try {
            WebElement section = driver.findElement(By.xpath("//*[@id=\"__seobox\"]/div[1]"));
            WebElement title = driver.findElement(By.xpath("//*[@id=\"__seobox\"]/div[1]/div[1]"));

            return section != null && section.isDisplayed() &&
                    title != null && title.isDisplayed() && title.getText().equals("About product and suppliers:");
            // return true if the section is displayed and the particular title for it is displayed and correct
        } catch (Exception ignored) {
            return false;
        }
    }

    public boolean getRelatedProductsSection() {
        try {
            WebElement section = driver.findElement(By.xpath("//*[@id=\"__seobox\"]/div[2]"));
            WebElement title = driver.findElement(By.xpath("//*[@id=\"__seobox\"]/div[2]/div[1]"));

            return section != null && section.isDisplayed() &&
                    title != null && title.isDisplayed() && title.getText().equals("Related Searches:");
            // return true if the section is displayed and the particular title for it is displayed and correct
        } catch (Exception ignored) {
            return false;
        }
    }


    public boolean getRegionalSettings() {
        try {
            driver.manage().window().maximize();
            Thread.sleep(1500); // wait until elements are loaded

            Actions action = new Actions(driver);
            WebElement languageCurrencySection = driver.findElement(By.xpath("/html/body/div[1]/header/div[4]/div/div[4]/div[3]/div"));
            action.moveToElement(languageCurrencySection).build().perform();
            // hover over the section to make the form to appear

            WebElement regionalSettingsTitle = driver.findElement(By.xpath("/html/body/div[1]/header/div[4]/div/div[4]/div[3]/div/div/div[2]/div[1]/b"));

            Thread.sleep(2000);
            if(regionalSettingsTitle.getText().contains("Regional Settings")) {
                WebElement languageDropdownList = driver.findElement(By.xpath("/html/body/div[1]/header/div[4]/div/div[4]/div[3]/div/div/div[2]/div[2]/div/div"));
                WebElement currencyDropdownList = driver.findElement(By.xpath("/html/body/div[1]/header/div[4]/div/div[4]/div[3]/div/div/div[2]/div[3]/div/div"));

                Thread.sleep(2000);
                action.moveToElement(languageDropdownList).click().build().perform();
                Thread.sleep(2000); // wait for select to show up
                driver.findElement(By.xpath("/html/body/div[1]/header/div[4]/div/div[4]/div[3]/div/div/div[2]/div[2]/div/div/div[2]/ul/li/ul/li[2]")).click();
                Thread.sleep(2000);
                // wait for language to be saved

                Thread.sleep(2000);
                action.moveToElement(currencyDropdownList).click().build().perform();
                Thread.sleep(2000);
                driver.findElement(By.xpath("/html/body/div[1]/header/div[4]/div/div[4]/div[3]/div/div/div[2]/div[3]/div/div/div[2]/ul/li[1]/ul/li[2]")).click();
                Thread.sleep(1500);
                // wait for currency to be saved

                WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"J_SC_header\"]/header/div[4]/div/div[4]/div[3]/div/div/div[2]/div[5]/button"));

                List<String> englishElementsLanguage = findSomeWebElementsTestingLanguage();
                List<String> dollarElementsCurrency = findSomeWebElementsTestingCurrency();
                // get some elements before changing language and currency for later check

                submitButton.click();
                Thread.sleep(5000);
                // make the language and currency change

                List<String> deutschElementsLanguage = findSomeWebElementsTestingLanguage();
                List<String> euroElementsCurrency = findSomeWebElementsTestingCurrency();
                // get some elements for the check

                return makeLanguageCheck(Objects.requireNonNull(englishElementsLanguage), deutschElementsLanguage)
                        && makeCurrencyCheck(Objects.requireNonNull(dollarElementsCurrency), euroElementsCurrency);
                // make the language and currency web elements check
            } else
                return false;
        } catch (Exception ignored) {
            return false;
        }
    }

    private boolean makeLanguageCheck(List<String> englishElementsLanguage, List<String> deutschElementsLanguage) {
        if(!englishElementsLanguage.get(0).equals("Recommended For You") ||
                !deutschElementsLanguage.get(0).equals("Empfehlungen für Sie"))
            return false;
        if(!englishElementsLanguage.get(1).equals("Categories") ||
                !deutschElementsLanguage.get(1).equals("Kategorien"))
            return false;
        if(!englishElementsLanguage.get(2).equals("What are you looking for...") ||
                !deutschElementsLanguage.get(2).equals("Wonach suchen Sie?"))
            return false;

        return true;
    }

    private boolean makeCurrencyCheck(List<String> dollarElementsCurrency, List<String> euroElementsCurrency) {
        return dollarElementsCurrency.stream().noneMatch(i -> i.contains("€"))
                && euroElementsCurrency.stream().noneMatch(i -> i.contains("$"));
        // check if the currencies were changed in the price element
    }

    private List<String> findSomeWebElementsTestingLanguage() {
        try {
            WebElement recommendationsTitle = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[2]/div/div/h2/span"));
            WebElement categoriesTitle = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div[1]"));
            WebElement searchInputPlaceholder = driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/div[3]/div/div/form/div[2]/input"));

            return List.of(recommendationsTitle.getText(), categoriesTitle.getText(), searchInputPlaceholder.getAttribute("placeholder"));
        } catch (Exception ignored) {
            return null;
        }
    }

    private List<String> findSomeWebElementsTestingCurrency() {
        try {
            List<WebElement> allSpanElements = driver.findElements(By.tagName("span"));
            // all span elements, some of which contain the currency

            return allSpanElements.stream().map(WebElement::getText).collect(Collectors.toList());
        } catch (Exception ignored) {
            return null;
        }
    }
}
