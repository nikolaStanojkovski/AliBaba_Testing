package pptech.skitproject.alibabatesting.ui_selenium.home;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pptech.skitproject.alibabatesting.ui_selenium.BasePage;

import java.util.List;

public class CategoriesPage extends BasePage {

    public CategoriesPage(WebDriver driver) {
        super(driver);
    }

    public void openMain() throws InterruptedException {
        Thread.sleep(5000);
        driver.get("https://www.alibaba.com/Products");
    }

    public void openSpecificCategory() throws InterruptedException {
        Thread.sleep(5000);
        driver.get("https://www.alibaba.com/Toys-Hobbies_p26");
    }

    public boolean isLoadedMain() throws InterruptedException {
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("category")))).isDisplayed();
    }

    public boolean isLoadedSpecificCategory() throws InterruptedException {
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("pageContent")))).isDisplayed();
    }


    public boolean getCategoriesListing() {
        try {
            WebElement titleCategoryNavigation = driver.findElement(By.xpath("//*[@id=\"category\"]/h2"));
            WebElement categoryNavigation = driver.findElement(By.xpath("//*[@id=\"category\"]/table[1]"));

            return titleCategoryNavigation.getText().equals("Products by Category") && categoryNavigation != null;
        } catch (Exception ignored) {
            return false;
        }
    }

    public boolean getAllCategoriesListing() {
        try {
            driver.manage().window().maximize();
            // window needs to be full screen in order or load all account icons
            Thread.sleep(1500); // wait until elements are loaded

            List<WebElement> categoryItems = driver.findElements(By.className("desc"));
            int counter = 0;
            for(WebElement element : categoryItems) {
                String text = element.getText();
                if(text.contains("Agriculture & Food") ||
                        text.contains("Apparel,Textiles & Accessories") ||
                        text.contains("Auto & Transportation") ||
                        text.contains("Bags, Shoes & Accessories") ||
                        text.contains("Electronics") ||
                        text.contains("Electrical Equipment, Components & Telecoms") ||
                        text.contains("Gifts, Sports & Toys") ||
                        text.contains("Health & Beauty") ||
                        text.contains("Home, Lights & Construction") ||
                        text.contains("Machinery, Industrial Parts & Tools") ||
                        text.contains("Metallurgy, Chemicals, Rubber & Plastics") ||
                        text.contains("Packaging, Advertising & Office"))
                    counter++;
            }

            return counter == 12; // the website contains 12 main categories with lots of subcategories
        } catch (Exception ignored) {
            return false;
        }
    }

    public boolean getAllCategoriesInSections() {
        try {
            driver.manage().window().maximize();
            // window needs to be full screen in order or load all account icons
            Thread.sleep(1500); // wait until elements are loaded

            List<WebElement> categoryItems = driver.findElements(By.className("big-title"));
            int counter = 0;
            for(WebElement element : categoryItems) {
                String text = element.getText();
                if(text.contains("Agriculture & Food") ||
                        text.contains("Apparel,Textiles & Accessories") ||
                        text.contains("Auto & Transportation") ||
                        text.contains("Bags, Shoes & Accessories") ||
                        text.contains("Electronics") ||
                        text.contains("Electrical Equipment, Components & Telecoms") ||
                        text.contains("Gifts, Sports & Toys") ||
                        text.contains("Health & Beauty") ||
                        text.contains("Home, Lights & Construction") ||
                        text.contains("Machinery, Industrial Parts & Tools") ||
                        text.contains("Metallurgy, Chemicals, Rubber & Plastics") ||
                        text.contains("Packaging, Advertising & Office"))
                    counter++;
            }

            return counter == 12; // the website contains 12 main categories with lots of subcategories
        } catch (Exception ignored) {
            return false;
        }
    }

    public boolean getSubcategoryListing() {
        try {
            List<WebElement> subcategories = driver.findElements(By.className("sub-item")); // check if there are sections with subcategories
            for(WebElement element : subcategories) {
                if(element.findElements(By.tagName("li")).size() == 0)
                    return false; // check if every category section has list of subcategories
            }

            return true; // this means that all category sections have a list of subcategories in them
        } catch (Exception ignored) {
            return false;
        }
    }

    public boolean getToSpecificCategorySection() throws InterruptedException {
        driver.manage().window().maximize();
        // window needs to be full screen in order or load all account icons
        Thread.sleep(1500); // wait until elements are loaded

        // For test purposes we are navigating to the "Gifts, Sports & Toys" specific category section
        WebElement link = driver.findElement(By.xpath("//*[@id=\"category\"]/table[1]/tbody/tr[2]/td[1]/a"));
        link.click();

        // wait for page to navigate to the section
        Thread.sleep(500);

        WebElement toysElement = driver.findElement(By.className("anchor7-wrap"));
        String toysClassElement = toysElement.getAttribute("class");

        return toysClassElement.contains("selected");
        // check if the list item was selected therefore checking if the window position was changed, because the class selected changes the particular window position
    }

    public void navigateToSpecificCategoryPage() throws InterruptedException {
        driver.manage().window().maximize();
        // window needs to be full screen in order or load all account icons
        Thread.sleep(1500); // wait until elements are loaded
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        js.executeScript("window.scrollBy(0,2500)"); // scroll down to the section first, because it is not loaded at first

        // For test purposes we are navigating to the "toys hobbies" specific category page
        WebElement link = driver.findElement(By.xpath("//*[@id=\"category\"]/div[3]/div[1]/div[7]/div/div[3]/h4/a"));
        link.click();

        // wait for page to load
        Thread.sleep(4000);
    }

    public void navigateToSpecificSubcategoryPage() throws InterruptedException {
        driver.manage().window().maximize();
        // window needs to be full screen in order or load all account icons
        Thread.sleep(1500); // wait until elements are loaded
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        js.executeScript("window.scrollBy(0,2500)"); // scroll down to the section first, because it is not loaded at first

        // For test purposes we are navigating to the "classic toys" specific category page
        WebElement link = driver.findElement(By.xpath("//*[@id=\"category\"]/div[3]/div[1]/div[7]/div/div[3]/div/ul/li[5]/a"));
        link.click();

        // wait for page to load
        Thread.sleep(4000);
    }
}
