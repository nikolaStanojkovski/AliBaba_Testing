package pptech.skitproject.alibabatesting.ui_selenium.user;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pptech.skitproject.alibabatesting.models.TradeRole;
import pptech.skitproject.alibabatesting.ui_selenium.BasePage;

public class RegistrationPage extends BasePage {

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void open(){
        driver.get("https://passport.alibaba.com/member/us/reg/fast/union_reg.htm?_regfrom=ICBU_UNION_REG&_lang=en_US&_regbizsource=main_page&tg=https%3A%2F%2Fwww.alibaba.com");
    }

    public boolean isLoaded() throws InterruptedException {
        Thread.sleep(5000);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("schema-form"))).isDisplayed();
    }

    public void signUp(TradeRole tradeRole, String email, String password, String confirmPassword, String companyName, String fullName, String phoneNumber, Boolean verification, Boolean agreement) throws InterruptedException {

        // no need for country input, the website detects the location alone

        // trade role
        if(tradeRole == TradeRole.BUYER)
            driver.findElement(By.cssSelector("input[value='buyer']")).click();
        else if(tradeRole == TradeRole.SELLER)
            driver.findElement(By.cssSelector("input[value='seller']")).click();
        else if(tradeRole == TradeRole.BOTH)
            driver.findElement(By.cssSelector("input[value='both']")).click();


        // email
        driver.findElement(By.id("email")).sendKeys(email);

        // password
        driver.findElement(By.id("password")).sendKeys(password);

        // confirm password
        driver.findElement(By.id("rePassword")).sendKeys(confirmPassword);

        // company name
        driver.findElement(By.id("companyName")).sendKeys(companyName);

        // full name
        if(fullName != null && !fullName.equals("")) {
            String[] nameParts = fullName.split("\\s+");
            driver.findElement(By.name("firstName")).sendKeys(nameParts[0]);
            if(nameParts.length == 2) {
                driver.findElement(By.name("lastName")).sendKeys(nameParts[1]);
            } // input the second part only if the full name has the string
        }


        // phone number
        if(phoneNumber != null && !phoneNumber.equals("")) {
            String[] phoneParts = phoneNumber.split("-");
            if(phoneParts.length > 1) {
                driver.findElement(By.name("phoneArea")).sendKeys(phoneParts[1]);
                if(phoneParts.length > 2) {
                    driver.findElement(By.name("phoneNumber")).sendKeys(phoneParts[2]);
                }
            }
        }

        // verification slidebar
        if(verification) {
            WebElement slider = driver.findElement(By.id("nc_1_n1z"));
            Actions move = new Actions(driver);
            Action action = (Action) move.dragAndDropBy(slider, 260, 0).build();
            action.perform();
        }

        // agreement checkbox
        if(agreement) {
            driver.findElement(By.xpath("//*[@id=\"container\"]/div/form/div/div[10]/div/div[1]/label/input")).click();
        }

        // submit click
        driver.findElement(By.name("loginAction")).click();
        Thread.sleep(8000);
    }

    public Boolean bannerIsOpened(){
        WebElement element;
        try {
            element = driver.findElement(By.id("dialog-header-0")); // email verification dialog
        } catch (NoSuchElementException ex) {
            element = driver.findElement(By.id("baxia-dialog-content")); // scam verification dialog
        }
        return element.isDisplayed();
    }

    public String getTradeRoleError() {
        try {
            WebElement element = driver.findElement(By.xpath("//*[@id=\"container\"]/div/form/div/div[2]/div/div[2]"));
            return element.getText(); // return the text of the error if it is displayed
        } catch (NoSuchElementException ex) {
            return "";
        }
    }

    public String getEmailError() {
        try {
            WebElement element = driver.findElement(By.xpath("//*[@id=\"container\"]/div/form/div/div[3]/div/div"));
            return element.getText(); // return the text of the error if it is displayed
        } catch (NoSuchElementException ex) {
            return "";
        }
    }

    public String getPasswordError() {
        try {
            WebElement element = driver.findElement(By.xpath("//*[@id=\"container\"]/div/form/div/div[4]/div/div[2]"));
            return element.getText(); // return the text of the error if it is displayed
        } catch (NoSuchElementException ex) {
            return "";
        }
    }

    public String getConfirmPasswordError() {
        try {
            WebElement element = driver.findElement(By.xpath("//*[@id=\"container\"]/div/form/div/div[5]/div/div"));
            return element.getText(); // return the text of the error if it is displayed
        } catch (NoSuchElementException ex) {
            return "";
        }
    }

    public String getCompanyNameError() {
        try {
            WebElement element = driver.findElement(By.xpath("//*[@id=\"container\"]/div/form/div/div[6]/div/div"));
            return element.getText(); // return the text of the error if it is displayed
        } catch (NoSuchElementException ex) {
            return "";
        }
    }

    public String getUsernameError() {
        try {
            WebElement element = driver.findElement(By.xpath("//*[@id=\"container\"]/div/form/div/div[7]/div/div[2]"));
            return element.getText(); // return the text of the error if it is displayed
        } catch (NoSuchElementException ex) {
            return "";
        }
    }

    public String getPhoneNumberError() {
        try {
            WebElement element = driver.findElement(By.xpath("//*[@id=\"container\"]/div/form/div/div[8]/div/div"));
            return element.getText(); // return the text of the error if it is displayed
        } catch (NoSuchElementException ex) {
            return "";
        }
    }

    public String getVerificationError() {
        try {
            WebElement element = driver.findElement(By.xpath("//*[@id=\"container\"]/div/form/div/div[9]/div/div[2]"));
            return element.getText(); // return the text of the error if it is displayed
        } catch (NoSuchElementException ex) {
            return "";
        }
    }

    public String getAgreementError() {
        try {
            WebElement element = driver.findElement(By.xpath("//*[@id=\"container\"]/div/form/div/div[10]/div/div[2]"));
            return element.getText(); // return the text of the error if it is displayed
        } catch (NoSuchElementException ex) {
            return "";
        }
    }

}
