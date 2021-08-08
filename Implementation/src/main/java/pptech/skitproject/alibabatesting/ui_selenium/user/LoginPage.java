package pptech.skitproject.alibabatesting.ui_selenium.user;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import pptech.skitproject.alibabatesting.ui_selenium.BasePage;

import java.util.List;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() throws InterruptedException {
        Thread.sleep(5000);
        driver.get("https://passport.alibaba.com/icbu_login.htm?return_url=null&hasPreCheckLogin=true");
    }

    public boolean isLoaded() throws InterruptedException {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-form"))).isDisplayed();
    }

    public void signIn(String email, String password) throws InterruptedException {
        // email
        driver.findElement(By.id("fm-login-id")).sendKeys(email);

        // password
        driver.findElement(By.id("fm-login-password")).sendKeys(password);


        // submit button
        driver.findElement((By.cssSelector("input[value='Sign In']"))).click();
        Thread.sleep(3000);
    }

    public String getErrorMessage() {
        try {
            WebElement element = driver.findElement(By.id("//*[@id='login-error']/span[2]"));
            return element.getText(); // return the text of the error if it is displayed
        } catch (NoSuchElementException ex) {
            return "";
        }
    }

    public void checkSlideBar() {
        try {
            driver.switchTo().frame(0);
            WebElement slider = driver.findElement(By.id("nc_1_n1z"));
            Actions move = new Actions(driver);
            Action action = (Action) move.dragAndDropBy(slider, 319, 0).build();
            action.perform();
            Thread.sleep(5000);
        } catch (NoSuchElementException | InterruptedException ignored) {

        }
    }


    public boolean getRegionalSettings() {
        try {
            driver.manage().window().maximize();

            WebElement languageSelectList = driver.findElement(By.id("language-switch"));
            Select selectList = new Select(languageSelectList);

            List<String> englishElements = getSomeWebElements();
            // before choosing another language, get some elements from the current for later comparison

            selectList.selectByIndex(5);
            // For the purpose of testing, choosing 'Deutsch' as a primary language
            Thread.sleep(4000);
            // wait for new page to laod

            List<String> deutschElements = getSomeWebElements();

            return checkWebElementsLanguage(englishElements, deutschElements);
            // checking if the chosen web elements are different and have the appropriate language after the change
        } catch (Exception ignored) {
            return false;
        }
    }

    private boolean checkWebElementsLanguage(List<String> englishElements, List<String> deutschElements) {
        try {
            if(!englishElements.get(0).equals("Account:")
                && !deutschElements.get(0).equals("Konto:"))
                return false;
            if(!englishElements.get(1).equals("Password:")
                    && !deutschElements.get(1).equals("Passwort:"))
                return false;
            if(!englishElements.get(2).equals("Email address or member ID")
                    && !deutschElements.get(2).equals("E-Mail Anschrift oder Mitglied-ID"))
                return false;
            if(!englishElements.get(3).equals("Password")
                    && !deutschElements.get(3).equals("Passwort:"))
                return false;

            return true;
            // if everything is as it should be, the check returns true
        } catch (Exception ignored) {
            return false;
        }
    }

    private List<String> getSomeWebElements() {
        try {
            String accountLabel = driver.findElement(By.xpath("//*[@id=\"login-content\"]/dl[1]/dt/div/label")).getText();
            String passwordLabel = driver.findElement(By.xpath("//*[@id=\"login-content\"]/dl[2]/dt/div/label")).getText();
            String accountInputPlaceholder = driver.findElement(By.id("fm-login-id")).getAttribute("placeholder");
            String passwordInputPlaceholder = driver.findElement(By.id("fm-login-password")).getAttribute("placeholder");

            return List.of(accountLabel, passwordLabel, accountInputPlaceholder, passwordInputPlaceholder);
        } catch (Exception ignored) {
            return null;
        }
    }
}
