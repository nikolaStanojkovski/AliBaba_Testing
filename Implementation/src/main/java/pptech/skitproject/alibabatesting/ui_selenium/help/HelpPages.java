package pptech.skitproject.alibabatesting.ui_selenium.help;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.core.annotation.Order;
import org.testng.annotations.Test;
import pptech.skitproject.alibabatesting.ui_selenium.BasePage;
import pptech.skitproject.alibabatesting.ui_selenium.Setup;
import pptech.skitproject.alibabatesting.ui_selenium.home.HomePage;

import java.util.ArrayList;
import java.util.List;

public class HelpPages extends BasePage {

    public HelpPages(WebDriver driver) {
        super(driver);
    }

    public boolean getHelpSection() {
        try {
            HomePage homePage = new HomePage(driver);
            homePage.open();
            driver.manage().window().maximize();
            Thread.sleep(2000);

            WebElement helpSection = driver.findElement(By.xpath("//*[@id=\"J_SC_header\"]/header/div[4]/div/div[3]/ul/li[6]"));

            return helpSection != null && helpSection.isDisplayed();
            // check if the section is existent on the home page
        } catch (Exception ignored) {
            return false;
        }
    }

    public boolean getHelpSectionLinks() {
        try {
            HomePage homePage = new HomePage(driver);
            homePage.open();
            driver.manage().window().maximize();
            Thread.sleep(2000);

            Actions action = new Actions(driver);
            WebElement hoverIconSection = driver.findElement(By.xpath("//*[@id=\"J_SC_header\"]/header/div[4]/div/div[3]/ul/li[6]"));
            action.moveToElement(hoverIconSection).build().perform();;
            List<WebElement> helpLinks = driver.findElement(By.xpath("//*[@id=\"J_SC_header\"]/header/div[4]/div/div[3]/ul/li[6]/div/ul"))
                    .findElements(By.className("sc-hd-text-warp")); // get all link names in the list

            for(WebElement link : helpLinks) {
                if(!link.getText().equals("For Buyers")
                    && !link.getText().equals("For Suppliers")
                    && !link.getText().equals("Submit a Dispute")
                    && !link.getText().equals("Report IPR Infringement")
                    && !link.getText().equals("Report Abuse"))
                    return false;
            } // check if all appropriate links are given in the navigation

            return true;
            // if all checks are passed, the section is fully correct
        } catch (Exception ignored) {
            return false;
        }
    }


    public boolean getBuyersPageLink() {
        try {
            HomePage homePage = new HomePage(driver);
            homePage.open();
            driver.manage().window().maximize();
            Thread.sleep(2000);

            Actions action = new Actions(driver);
            WebElement hoverIconSection = driver.findElement(By.xpath("//*[@id=\"J_SC_header\"]/header/div[4]/div/div[3]/ul/li[6]"));
            action.moveToElement(hoverIconSection)
                    .moveToElement(driver.findElement(By.xpath("/html/body/div[1]/header/div[4]/div/div[3]/ul/li[6]/div/ul/li[1]/a")))
                    .click().build().perform();

            Thread.sleep(4000);
            // wait for page to load

            ArrayList<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(windowHandles.get(1));
            // switch to the newly opened tab

            return driver.getCurrentUrl().equals("https://service.alibaba.com/page/home?pageId=122&language=en");
            // check if the adequate page was successfully opened
        } catch (Exception ignored) {
            return false;
        }
    }

    public boolean getBuyersPage() {
        try {
            driver.get("https://service.alibaba.com/page/home?pageId=122&language=en");
            Thread.sleep(4000);
            // wait for the page to load
            driver.manage().window().maximize();
            Thread.sleep(2000);

            WebElement pageHelpSection = driver.findElement(By.id("helphub"));
            WebElement pageHelpTitle = driver.findElement(By.xpath("//*[@id=\"helphub\"]/div[2]/div/div[1]/span"));
            WebElement pageHelpToolsSection = driver.findElement(By.xpath("//*[@id=\"helphub\"]/div[4]"));
            WebElement pageHelpLearningCenterSection = driver.findElement(By.xpath("//*[@id=\"helphub\"]/div[5]"));
            WebElement pageHelpContactSection = driver.findElement(By.xpath("//*[@id=\"helphub\"]/div[6]"));

            return pageHelpSection != null && pageHelpSection.isDisplayed()
                    && pageHelpTitle != null && pageHelpTitle.isDisplayed() && pageHelpTitle.getText().contains("Help Center for Buyer")
                    && pageHelpToolsSection != null && pageHelpToolsSection.isDisplayed()
                    && pageHelpLearningCenterSection != null && pageHelpLearningCenterSection.isDisplayed()
                    && pageHelpContactSection != null && pageHelpContactSection.isDisplayed();
            // check if the page is loaded with all the appropriate sections and info along with them
        } catch (Exception ignored) {
            return false;
        }
    }

    public boolean getSuppliersPageLink() {
        try {
            HomePage homePage = new HomePage(driver);
            homePage.open();
            driver.manage().window().maximize();
            Thread.sleep(2000);

            Actions action = new Actions(driver);
            WebElement hoverIconSection = driver.findElement(By.xpath("//*[@id=\"J_SC_header\"]/header/div[4]/div/div[3]/ul/li[6]"));
            action.moveToElement(hoverIconSection)
                    .moveToElement(driver.findElement(By.xpath("/html/body/div[1]/header/div[4]/div/div[3]/ul/li[6]/div/ul/li[2]/a")))
                    .click().build().perform();

            Thread.sleep(4000);
            // wait for page to load

            ArrayList<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(windowHandles.get(1));
            // switch to the newly opened tab

            return driver.getCurrentUrl().equals("https://service.alibaba.com/page/home?pageId=123&language=en");
            // check if the adequate page was successfully opened
        } catch (Exception ignored) {
            return false;
        }
    }

    public boolean getSuppliersPage() {
        try {
            driver.get("https://service.alibaba.com/page/home?pageId=123&language=en");
            Thread.sleep(4000);
            // wait for the page to load
            driver.manage().window().maximize();
            Thread.sleep(2000);

            WebElement pageHelpSection = driver.findElement(By.id("helphub"));
            WebElement pageHelpTitle = driver.findElement(By.xpath("//*[@id=\"helphub\"]/div[2]/div/div[1]/span"));
            WebElement pageHelpToolsSection = driver.findElement(By.xpath("//*[@id=\"helphub\"]/div[4]"));
            WebElement pageHelpLearningCenterSection = driver.findElement(By.xpath("//*[@id=\"helphub\"]/div[5]"));
            WebElement pageHelpContactSection = driver.findElement(By.xpath("//*[@id=\"helphub\"]/div[6]"));

            return pageHelpSection != null && pageHelpSection.isDisplayed()
                    && pageHelpTitle != null && pageHelpTitle.isDisplayed() && pageHelpTitle.getText().contains("Help Center for Global Gold Supplier")
                    && pageHelpToolsSection != null && pageHelpToolsSection.isDisplayed()
                    && pageHelpLearningCenterSection != null && pageHelpLearningCenterSection.isDisplayed()
                    && pageHelpContactSection != null && pageHelpContactSection.isDisplayed();
            // check if the page is loaded with all the appropriate sections and info along with them
        } catch (Exception ignored) {
            return false;
        }
    }

    public boolean getSubmitDispute() {
        try {
            HomePage homePage = new HomePage(driver);
            homePage.open();
            driver.manage().window().maximize();
            Thread.sleep(2000);

            Actions action = new Actions(driver);
            WebElement hoverIconSection = driver.findElement(By.xpath("//*[@id=\"J_SC_header\"]/header/div[4]/div/div[3]/ul/li[6]"));
            action.moveToElement(hoverIconSection)
                    .moveToElement(driver.findElement(By.xpath("/html/body/div[1]/header/div[4]/div/div[3]/ul/li[6]/div/ul/li[3]/a")))
                    .click().build().perform();

            Thread.sleep(4000);
            // wait for page to load

            ArrayList<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(windowHandles.get(1));
            // switch to the newly opened tab

            return driver.getCurrentUrl().contains("https://passport.alibaba.com/icbu_login.htm");
            // check if the login page was opened (therefore checking if the link successfully works because we need to login before sending a dispute
        } catch (Exception ignored) {
            return false;
        }
    }

    public boolean getReportInfringementLink() throws InterruptedException {
        try {
            HomePage homePage = new HomePage(driver);
            homePage.open();
            driver.manage().window().maximize();
            Thread.sleep(2000);

            Actions action = new Actions(driver);
            WebElement hoverIconSection = driver.findElement(By.xpath("//*[@id=\"J_SC_header\"]/header/div[4]/div/div[3]/ul/li[6]"));
            action.moveToElement(hoverIconSection)
                    .moveToElement(driver.findElement(By.xpath("/html/body/div[1]/header/div[4]/div/div[3]/ul/li[6]/div/ul/li[4]/a")))
                    .click().build().perform();

            Thread.sleep(4000);
            // wait for page to load

            ArrayList<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(windowHandles.get(1));
            // switch to the newly opened tab
            Thread.sleep(2000);

            return driver.getCurrentUrl().contains("https://ipp.alibabagroup.com/index.htm?spm=a2700.8293689.scGlobalHomeHeader.728.2ce267af");
            // check if the adequate page was successfully opened
        } catch (Exception ignored) {
            return false;
        }
    }
    
    public boolean getReportInfringement() {
        try {
            driver.get("https://ipp.alibabagroup.com/index.htm?spm=a2700.8293689.scGlobalHomeHeader.728.2ce267af");
            Thread.sleep(4000);
            // wait for the page to load
            driver.manage().window().maximize();
            Thread.sleep(2000);

            String title = driver.getTitle();

            WebElement pageNavigation = driver.findElement(By.id("j-main-nav"));
            WebElement pageSlider = driver.findElement(By.id("mod-banner-slide"));
            WebElement pageEntrySection = driver.findElement(By.id("mod-entry"));
            WebElement pageInfoSection = driver.findElement(By.id("mod-info"));
            WebElement pageNewsSection = driver.findElement(By.className("item-news"));
            WebElement pageFAQSection = driver.findElement(By.className("item-raq"));

            return title.equals("Alibaba Group - Intellectual Property Protection Platform (IPP platform)")
                    && pageNavigation != null && pageNavigation.isDisplayed()
                    && pageSlider != null && pageSlider.isDisplayed()
                    && pageEntrySection != null && pageEntrySection.isDisplayed()
                    && pageInfoSection != null && pageInfoSection.isDisplayed()
                    && pageNewsSection != null && pageNewsSection.isDisplayed()
                    && pageFAQSection != null && pageFAQSection.isDisplayed();
            // check if all adequate sections in the page are existent and correct along with the correct title
        } catch (Exception ignored) {
            return false;
        }
    }

    public boolean getReportAbuse() {
        try {
            HomePage homePage = new HomePage(driver);
            homePage.open();
            driver.manage().window().maximize();
            Thread.sleep(2000);

            Actions action = new Actions(driver);
            WebElement hoverIconSection = driver.findElement(By.xpath("//*[@id=\"J_SC_header\"]/header/div[4]/div/div[3]/ul/li[6]"));
            action.moveToElement(hoverIconSection)
                    .moveToElement(driver.findElement(By.xpath("/html/body/div[1]/header/div[4]/div/div[3]/ul/li[6]/div/ul/li[5]/a")))
                    .click().build().perform();

            Thread.sleep(4000);
            // wait for page to load

            ArrayList<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(windowHandles.get(1));
            // switch to the newly opened tab

            return driver.getCurrentUrl().contains("https://passport.alibaba.com/icbu_login.htm");
            // check if the login page was opened (therefore checking if the link successfully works because we need to login before sending a dispute
        } catch (Exception ignored) {
            return false;
        }
    }
}
