package pptech.skitproject.alibabatesting.ui_selenium.user;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import pptech.skitproject.alibabatesting.models.TradeRole;
import pptech.skitproject.alibabatesting.ui_selenium.BasePage;

import java.util.List;

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


    public boolean getRegionalSettings() {
        try {
            driver.manage().window().maximize();
            Thread.sleep(2000);
            // wait for all elements to load

            WebElement languageSelectList = driver.findElement(By.id("language-switch"));
            Select selectList = new Select(languageSelectList);

            List<String> englishElements = getSomeWebElements();
            // before choosing another language, get some elements from the current for later comparison

            selectList.selectByIndex(1);
            // For the purpose of testing, choosing 'Chinese' as a primary language
            Thread.sleep(5000);
            // wait for new page to laod

            List<String> chineseElements = getSomeWebElements();

            return checkWebElementsLanguage(englishElements, chineseElements);
            // checking if the chosen web elements are different and have the appropriate language after the change
        } catch (Exception ignored) {
            return false;
        }
    }

    private boolean checkWebElementsLanguage(List<String> englishElements, List<String> chineseElements) {
        try {
            if(!englishElements.get(0).equals("Please select trade role:")
                    && !chineseElements.get(0).equals("请选择贸易类型:"))
                return false;
            if(!englishElements.get(1).equals("Email Address:")
                    && !chineseElements.get(1).equals("电子邮箱:"))
                return false;
            if(!englishElements.get(2).equals("Please set the email as the login name")
                    && !chineseElements.get(2).equals("请设置邮箱作为登录名"))
                return false;
            if(!englishElements.get(3).equals("Please set the login password")
                    && !chineseElements.get(3).equals("请设置登录密码"))
                return false;

            return true;
            // if everything is as it should be, the check returns true
        } catch (Exception ignored) {
            return false;
        }
    }

    private List<String> getSomeWebElements() {
        try {
            String tradeRoleLabel = driver.findElement(By.xpath("/html/body/div[2]/div/form/div/div[2]/label")).getText();
            String emailLabel = driver.findElement(By.xpath("/html/body/div[2]/div/form/div/div[3]/label")).getText();
            String emailPlaceHolder = driver.findElement(By.id("email")).getAttribute("placeholder");
            String passwordPlaceholder = driver.findElement(By.id("password")).getAttribute("placeholder");

            return List.of(tradeRoleLabel, emailLabel, emailPlaceHolder, passwordPlaceholder);
        } catch (Exception ignored) {
            return null;
        }
    }
}
