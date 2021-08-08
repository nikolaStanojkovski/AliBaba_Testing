package pptech.skitproject.alibabatesting.ui_selenium.product;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import pptech.skitproject.alibabatesting.ui_selenium.BasePage;
import pptech.skitproject.alibabatesting.ui_selenium.user.LoginPage;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ProductSpecificPage extends BasePage {

    public ProductSpecificPage(WebDriver driver) {
        super(driver);
    }

    public void open() throws InterruptedException {
        Thread.sleep(5000);
        driver.get("https://www.alibaba.com/product-detail/Original-Ernie-Ball-Electric-Guitar-Strings_62442120002.html?spm=a2700.galleryofferlist.normal_offer.d_image.73232c2aBtlmKB");
        // using the "Original Ernie Ball Electric Guitar Strings" product from the page, for testing purposes
    }

    public boolean isLoaded() throws InterruptedException {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("block-layoutstd"))).isDisplayed();
    }

    public boolean getProductAppearance() {
        try {
            driver.manage().window().maximize();
            Thread.sleep(1500); // wait until elements are loaded

            Thread.sleep(2000);
            WebElement productSection = driver.findElement(By.id("block-mainscreen-level2")); // section with the product in it

            return productSection != null && productSection.isDisplayed();
            // if the section is not empty or null, then the product exists along with its information on the page
        } catch (Exception ignored) {
            return false;
        }
    }


    public boolean getProductImage() {
        try {
            driver.manage().window().maximize();
            Thread.sleep(1500); // wait until elements are loaded

            Thread.sleep(2000);
            WebElement productImage = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div/div/img")); // section with the product in it
            String imageSRC = productImage.getAttribute("src");

            return productImage.isDisplayed() && imageSRC.equals("https://sc04.alicdn.com/kf/Hec9ed7badfea4fe995f0f201ffb3e5c0V.jpg");
            // check if the image is displayed and it has its particular source attribute
        } catch (Exception ignored) {
            return false;
        }
    }

    public boolean getProductImageList() {
        try {
            WebElement imageListSection = driver.findElement(By.className("main-image-thumb-ul")); // section with the product in it
            List<WebElement> imageListItems = driver.findElements(By.className("main-image-thumb-item")); // particular image items

            return imageListSection != null && imageListSection.isDisplayed() &&
                    imageListItems != null && imageListItems.size() > 0;
            // check if the list of images is existent and the amount of images in the section is above 0
        } catch (Exception ignored) {
            return false;
        }
    }

    public boolean getProductTitle() {
        try {
            Thread.sleep(2000);

            WebElement productTitle = driver.findElement(By.xpath("//*[@id=\"module_title\"]/div/h1")); // the element with the title
            String title = productTitle.getText();

            return productTitle.isDisplayed() && title != null && title.equals("Original Ernie Ball Electric Guitar Strings 2220 2221 2222 2223 Nickel Wound 6 Strings 009 010 011");
            // check if the title of the product is existent and is correct
        } catch (Exception ignored) {
            return false;
        }
    }

    public boolean getProductTags() {
        try {
            driver.manage().window().maximize();
            Thread.sleep(1500); // wait until elements are loaded

            Thread.sleep(4000);
            WebElement tagsSection = driver.findElement(By.className("ready-to-ship-icon"));
            List<WebElement> tagsList = tagsSection.findElements(By.tagName("div"));
            for (WebElement element : tagsList) {
                String text = element.getText();
                if(!text.contains("Ready to Ship") &&
                        !text.contains("In Stock") &&
                        !text.contains("Fast Dispatch"))
                    return false;
            }

            return true;
            // check if the tags section exists and the tags in it contain the information needed
        } catch (Exception ignored) {
            return false;
        }
    }

    public boolean getProductOverallReview() {
        try {
            driver.manage().window().maximize();
            Thread.sleep(1500); // wait until elements are loaded

            Thread.sleep(2000);
            WebElement reviewSection = driver.findElement(By.className("next-rating-overlay"));
            List<WebElement> stars = reviewSection.findElements(By.className("next-rating-icon"));
            WebElement reviewCount = driver.findElement(By.xpath("//*[@id=\"module_title\"]/div/div[3]/div/div/span[2]"));

            return reviewSection.isDisplayed() && stars != null && stars.size() == 5
                    && reviewCount.isDisplayed() && reviewCount.getText().equals("3 Reviews");
            // check if the review section of the product is displayed and if there 5 stars that represent the average review along with the number of reviews
        } catch (Exception ignored) {
            return false;
        }
    }

    public boolean getProductQuantitySold() {
        try {
            driver.manage().window().maximize();
            Thread.sleep(1500); // wait until elements are loaded

            Thread.sleep(2000);
            WebElement productQuantitySoldElement = driver.findElement(By.className("quantity-sold"));

            return productQuantitySoldElement != null && productQuantitySoldElement.isDisplayed()
                    && productQuantitySoldElement.getText().equals("12 buyers");
            // check if the product quantity section of the page is displayed and it has the correct information (has 12 buyers)
        } catch (Exception ignored) {
            return false;
        }
    }

    public boolean getProductPrice() {
        try {
            driver.manage().window().maximize();
            Thread.sleep(1500); // wait until elements are loaded

            WebElement priceElement = driver.findElement(By.xpath("//*[@id=\"module_price\"]/div/div/div/span[1]/span"));

            return priceElement != null && priceElement.isDisplayed() &&
                    priceElement.getText().equals("$4.50");
            // check if the product price section of the page is displayed and it has the correct information ($4.50 per piece)
        } catch (Exception ignored) {
            return false;
        }
    }

    public boolean getProductMOQ() {
        try {
            Thread.sleep(2000);

            WebElement sectionTitle = driver.findElement(By.xpath("//*[@id=\"module_price\"]/div/div/div/span[4]"));
            WebElement moq = driver.findElement(By.xpath("//*[@id=\"module_price\"]/div/div/div/span[3]"));

            return sectionTitle.isDisplayed() && sectionTitle.getText().equals("(Min. Order)")
                    && moq.isDisplayed() && moq.getText().equals("20 Pieces");
            // check if the MOQ title exists (therefore the MOQ section) and check if there is info about the particular MOQ
        } catch (Exception ignored) {
            return false;
        }
    }

    public boolean getProductQuantity() {
        try {
            Thread.sleep(2000);
            WebElement quantitySection = driver.findElement(By.className("quantity-value"));
            WebElement sectionTitle = driver.findElement(By.xpath("//*[@id=\"skuWrap\"]/dl/dt"));

            WebElement buttonQuantityDown = driver.findElement(By.className("quantity-down"));
            WebElement buttonQuantityUp = driver.findElement(By.className("quantity-up"));
            WebElement inputQuantity = driver.findElement(By.xpath("//*[@id=\"skuWrap\"]/dl/dd/div/input"));

            return quantitySection != null && quantitySection.isDisplayed()
                    && sectionTitle.isDisplayed() && sectionTitle.getText().equals("Quantity:")
                    && buttonQuantityDown != null && buttonQuantityDown.isDisplayed()
                    && buttonQuantityUp != null && buttonQuantityUp.isDisplayed()
                    && inputQuantity != null && inputQuantity.isDisplayed();
            // Check if the quantity choice section is displayed, the correct title and elements are in it
        } catch (Exception ignored) {
            return false;
        }
    }

    public boolean getProductAssurance() {
        try {
            Thread.sleep(2000);
            WebElement productAssuranceSection = driver.findElement(By.xpath("//*[@id=\"module_market_action\"]/div/div[2]/div[1]/a"));
            WebElement productAssuranceTitle = driver.findElement(By.xpath("//*[@id=\"module_market_action\"]/div/div[2]/div[1]/a/span[1]"));

            return productAssuranceSection != null && productAssuranceSection.isDisplayed()
                    && productAssuranceTitle != null && productAssuranceTitle.isDisplayed()
                    && productAssuranceTitle.getText().equals("Trade Assurance");
            // Check if the product assurance section is existent and the title of it is correct (therefore the product assurance is displayed)
        } catch (Exception ignored) {
            return false;
        }
    }

    public boolean getProductPayments() {
        try {
            Thread.sleep(2000);
            WebElement productPaymentsSection = driver.findElement(By.className("assurance-payment"));
            WebElement productPaymentsTitle = driver.findElement(By.xpath("//*[@id=\"module_market_action\"]/div/div[2]/div[2]/span[1]/span"));
            List<WebElement> paymentMethods = driver.findElements(By.className("payment-item"));

            return productPaymentsSection != null && productPaymentsSection.isDisplayed()
                    && productPaymentsTitle != null && productPaymentsTitle.isDisplayed()
                    && productPaymentsTitle.getText().equals("Payments:")
                    && paymentMethods != null && paymentMethods.size() > 0;
            // Check if the product payments section is existent and the title of it is correct, as well as there are more than 0 elements in it
        } catch (Exception ignored) {
            return false;
        }
    }

    public boolean getProductDescription() {
        try {
            WebElement productDescriptionSection = driver.findElement(By.xpath("//*[@id=\"ali-anchor-AliPostDhMb-6dwpq\"]"));
            WebElement productDescriptionTitle = driver.findElement(By.xpath("//*[@id=\"ali-title-AliPostDhMb-6dwpq\"]/span"));
            WebElement productDescriptionTable = driver.findElement(By.xpath("//*[@id=\"ali-anchor-AliPostDhMb-6dwpq\"]/div[2]/div/div/table"));
            List<WebElement> descriptionData = productDescriptionTable.findElements(By.tagName("tr"));

            return productDescriptionSection != null && productDescriptionSection.isDisplayed()
                    && productDescriptionTitle != null && productDescriptionTitle.isDisplayed() && productDescriptionTitle.getText().equals("Product Description")
                    && productDescriptionTable.isDisplayed() && descriptionData != null  && descriptionData.size() > 0;
            // Check if the product description section exists, the adequate title for it is displayed and the table with the appropriate contents
        } catch (Exception ignored) {
            return false;
        }
    }

    public boolean getCompanyProfile() {
        try {
            WebElement companyProfileTabLink = driver.findElement(By.xpath("//*[@id=\"module_tabs\"]/div/div[2]/div/div[1]/div/div/div/ul/li[2]"));
            companyProfileTabLink.click();
            Thread.sleep(2000); // wait for the tab to load

            WebElement companyProfileSection = driver.findElement(By.xpath("//*[@id=\"module_ali_site\"]/div/div[1]/div"));
            WebElement companyProfileTitle = driver.findElement(By.xpath("//*[@id=\"module_ali_site\"]/div/div[1]/div/div/div/div[1]/h3"));

            return companyProfileSection != null && companyProfileSection.isDisplayed()
                    && companyProfileTitle != null && companyProfileTitle.isDisplayed()
                    && companyProfileTitle.getText().equals("COMPANY OVERVIEW");
            // Check if the company profile section exists and the adequate title for it is displayed (therefore meaning there is information about the company)
        } catch (Exception ignored) {
            return false;
        }
    }
    
    public boolean getProductReviews() {
        try {
            WebElement buyerReviewsTabLink = driver.findElement(By.xpath("//*[@id=\"module_tabs\"]/div/div[2]/div/div[1]/div/div/div/ul/li[3]"));
            buyerReviewsTabLink.click();
            Thread.sleep(2000); // wait for the tab to load

            WebElement reviewsSection = driver.findElement(By.id("module_detail_discuss"));
            WebElement reviewsSectionTitle = driver.findElement(By.xpath("//*[@id=\"reviewSubHeader\"]/h2"));
            WebElement overallReviewSection = driver.findElement(By.className("product-detail-review-overview"));
            List<WebElement> reviewsList = driver.findElements(By.className("review-item"));

            return reviewsSection != null && reviewsSection.isDisplayed() &&
                    reviewsSectionTitle != null && reviewsSectionTitle.isDisplayed() &&
                    reviewsSectionTitle.getText().equals("Product Quality") && overallReviewSection != null &&
                    overallReviewSection.isDisplayed() && overallReviewSection.isDisplayed() &&
                    reviewsList != null && reviewsList.size() > 0;
            // Check if the section with reviews is existent and the appropriate information is attached to it, along with the given reviews
        } catch (Exception ignored) {
            return false;
        }
    }


    public boolean getFeedbackForm() {
        try {
            WebElement formSection = driver.findElement(By.id("module_feedback"));
            WebElement formSectionTitle = driver.findElement(By.xpath("//*[@id=\"J-ls-feedback\"]/h3"));

            return formSection != null && formSection.isDisplayed()
                    && formSectionTitle != null && formSectionTitle.isDisplayed()
                    && formSectionTitle.getText().equals("Send your message to this supplier");
            // Check if the form is existent and the adequate title is given to it
        } catch (Exception ignored) {
            return false;
        }
    }

    public boolean getFeedbackFormElements() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            driver.manage().window().maximize();
            js.executeScript("window.scrollBy(0,2500)"); // scroll down to the section first, because it is not loaded at first

            WebElement toSection = driver.findElement(By.xpath("//*[@id=\"fastFeedbackContent\"]/div/form/div[2]"));
            WebElement supplierName = driver.findElement(By.xpath("//*[@id=\"fastFeedbackContent\"]/div/form/div[2]/div/span"));

            WebElement messageSection = driver.findElement(By.xpath("//*[@id=\"fastFeedbackContent\"]/div/form/div[3]/div/div[1]"));
            WebElement messageTitle = driver.findElement(By.xpath("//*[@id=\"fastFeedbackContent\"]/div/form/div[3]/label"));
            WebElement messageAreaInput = driver.findElement(By.xpath("//*[@id=\"fastFeedbackContent\"]/div/form/div[3]/div/div[1]/textarea"));

            WebElement quantitySection = driver.findElement(By.xpath("//*[@id=\"fastFeedbackContent\"]/div/form/div[4]"));
            WebElement quantityTitle = driver.findElement(By.xpath("//*[@id=\"fastFeedbackContent\"]/div/form/div[4]/label"));
            WebElement quantityInput = driver.findElement(By.xpath("//*[@id=\"fastFeedbackContent\"]/div/form/div[4]/div/input"));
            WebElement quantityMeasurementUnit = driver.findElement(By.xpath("//*[@id=\"fastFeedbackContent\"]/div/form/div[4]/div/select"));

            WebElement rfqCheckbox = driver.findElement(By.xpath("//*[@id=\"fastFeedbackContent\"]/div/form/div[6]/div/input"));
            WebElement businessCardCheckbox = driver.findElement(By.xpath("//*[@id=\"fastFeedbackContent\"]/div/form/div[7]/div/input"));

            WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"fastFeedbackContent\"]/div/form/div[9]/div/input"));

            return toSection != null && toSection.isDisplayed()
                    && supplierName != null && supplierName.isDisplayed() && supplierName.getText().contains("Jianyu Peng")
                    && messageSection != null && messageSection.isDisplayed()
                    && messageTitle != null && messageTitle.isDisplayed() && messageTitle.getText().contains("Message:")
                    && messageAreaInput != null && messageAreaInput.isDisplayed()
                    && quantitySection != null && quantitySection.isDisplayed()
                    && quantityTitle != null && quantityTitle.isDisplayed() && quantityTitle.getText().contains("Quantity:")
                    && quantityInput != null && quantityInput.isDisplayed()
                    && quantityMeasurementUnit != null && quantityMeasurementUnit.isDisplayed()
                    && rfqCheckbox != null && rfqCheckbox.isDisplayed()
                    && businessCardCheckbox != null && businessCardCheckbox.isDisplayed()
                    && submitButton != null && submitButton.isDisplayed();
            // checking if all needed elements are present in the review form
        } catch (Exception ignored) {
            return false;
        }
    }

    public boolean getFeedbackFormFunctionality() {
        try {
            driver.manage().window().maximize();
            Thread.sleep(1500);

            WebElement messageAreaInput = driver.findElement(By.xpath("//*[@id=\"fastFeedbackContent\"]/div/form/div[3]/div/div[1]/textarea"));
            WebElement quantityInput = driver.findElement(By.xpath("//*[@id=\"fastFeedbackContent\"]/div/form/div[4]/div/input"));
            WebElement quantityMeasurementUnitSelect = driver.findElement(By.xpath("//*[@id=\"fastFeedbackContent\"]/div/form/div[4]/div/select"));
            WebElement rfqCheckbox = driver.findElement(By.xpath("//*[@id=\"fastFeedbackContent\"]/div/form/div[6]/div/input"));
            WebElement businessCardCheckbox = driver.findElement(By.xpath("//*[@id=\"fastFeedbackContent\"]/div/form/div[7]/div/input"));
            // already should be checked, but existent on the page
            WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"fastFeedbackContent\"]/div/form/div[9]/div/input"));

            // test queries for purpose of testing the functionality
            messageAreaInput.sendKeys("Test message with more than 20 characters");
            quantityInput.sendKeys("40");
            Select dropdown = new Select(quantityMeasurementUnitSelect);
            dropdown.selectByIndex(2);
            rfqCheckbox.click();

            Thread.sleep(2500); // wait for everything to be input
            // submit information
            submitButton.submit();

            Thread.sleep(5000);
            // wait for website to submit information

            WebElement signInWindow = driver.findElement(By.xpath("/html/body/div[9]/div/div[1]"));

            return signInWindow != null && signInWindow.isDisplayed();
            // if the window for login is shown, that means the information is successfully input and will be submitted after login
        } catch (Exception ignored) {
            return false;
        }
    }


    public boolean getTotalProductPrice() {
        try {
            WebElement totalPriceSection = driver.findElement(By.xpath("//*[@id=\"module_actions\"]/div/div/ul/li[1]"));
            WebElement chosenQuantity = driver.findElement(By.xpath("//*[@id=\"module_actions\"]/div/div/ul/li[1]/span[1]/span"));
            WebElement totalPrice = driver.findElement(By.xpath("//*[@id=\"module_actions\"]/div/div/ul/li[1]/span[2]/span/span/span"));

            return totalPriceSection != null && totalPriceSection.isDisplayed()
                    && chosenQuantity != null && chosenQuantity.isDisplayed() && chosenQuantity.getText().equals("20 Pieces")
                    && totalPrice != null && totalPrice.isDisplayed() && totalPrice.getText().equals("$90.00");
            // check if the section with the chosen quantity and total price is displayed along with the appropriate information
        } catch (Exception ignored) {
            return false;
        }
    }

    public boolean getShippingPrice() {
        try {
            WebElement shippingInformationSection = driver.findElement(By.xpath("//*[@id=\"module_actions\"]/div/div/ul/li[2]"));
            WebElement shippingLocation = driver.findElement(By.xpath("//*[@id=\"wholesale-tansport-selector\"]/div"));
            WebElement shippingPrice = driver.findElement(By.xpath("//*[@id=\"module_actions\"]/div/div/ul/li[2]/span[2]/span/span/span"));

            return shippingInformationSection != null && shippingInformationSection.isDisplayed()
                    && shippingLocation != null && shippingLocation.isDisplayed() && shippingLocation.getText().equals("Ship to Macedonia by FedEx via JYC")
                    && shippingPrice != null && shippingPrice.isDisplayed() && shippingPrice.getText().equals("$28.34");
            // check if the section with the appropriate shipping location and fee along with the appropriate information is shown
        } catch (Exception ignored) {
            return false;
        }
    }

    public boolean getShippingInformation() {
        try {
            WebElement processingTime = driver.findElement(By.xpath("//*[@id=\"module_actions\"]/div/div/ul/li[3]/span"));
            WebElement shippingTime = driver.findElement(By.xpath("//*[@id=\"module_actions\"]/div/div/ul/li[4]/span"));

            return processingTime != null && processingTime.isDisplayed() && processingTime.getText().contains("Processing Time 15 days  ")
                    && shippingTime != null && shippingTime.isDisplayed() && shippingTime.getText().equals("Shipping time 6-10 days  ");
            // check if the section with the appropriate shipping location and fee along with the appropriate information is shown
        } catch (Exception ignored) {
            return false;
        }
    }

    public boolean getTotalPrice() {
        try {
            WebElement totalPriceSection = driver.findElement(By.xpath("//*[@id=\"module_actions\"]/div/div/div[1]"));
            WebElement totalPriceTitle = driver.findElement(By.xpath("//*[@id=\"module_actions\"]/div/div/div[1]/span[2]"));
            WebElement totalPrice = driver.findElement(By.xpath("//*[@id=\"module_actions\"]/div/div/div[1]/span[3]/span/span/span"));

            return totalPriceSection != null && totalPriceSection.isDisplayed()
                    && totalPriceTitle != null && totalPriceTitle.isDisplayed() && totalPriceTitle.getText().equals("Total")
                    && totalPrice != null && totalPrice.isDisplayed() && totalPrice.getText().equals("$118.34");
            // check if the section is displayed with the appropriate information attached to it
        } catch (Exception ignored) {
            return false;
        }
    }


    public boolean getOrderButton() {
        try {
            driver.manage().window().maximize();
            Thread.sleep(2500);

            WebElement orderButton = driver.findElement(By.xpath("//*[@id=\"J-action-start-order\"]"));
            orderButton.click(); // click the order button, therefore checking if it is existent on the page
            Thread.sleep(2500);
            // wait until the modal window for login is shown

            WebElement signInWindow = driver.findElement(By.xpath("/html/body/div[9]/div/div[1]"));
            return signInWindow != null && signInWindow.isDisplayed();
            // if the sign in modal window is shown, that means that the order will be successfully processed after login because it passed all the checks
        } catch (Exception ignored) {
            return false;
        }
    }

    public boolean getContactButton() {
        try {
            WebElement contactSupplierButton = driver.findElement(By.xpath("//*[@id=\"J-action-cs\"]"));
            contactSupplierButton.click();
            Thread.sleep(2500);
            // wait until the modal window for login is shown

            WebElement signInWindow = driver.findElement(By.xpath("/html/body/div[9]/div/div[1]"));
            return signInWindow != null && signInWindow.isDisplayed();
            // if the login modal window is shown, that means that the contact form will be successfully shown after login because it passed all the checks
        } catch (Exception ignored) {
            return false;
        }
    }

    public boolean getCallUsButton() {
        try {
            WebElement callUsButton = driver.findElement(By.xpath("//*[@id=\"module_actions\"]/div/div/button[2]"));
            callUsButton.click();
            Thread.sleep(2500);
            // wait until the modal window for login is shown

            WebElement signInWindow = driver.findElement(By.xpath("/html/body/div[9]/div/div[1]"));
            return signInWindow != null && signInWindow.isDisplayed();
            // if the login modal window is shown, that means that the contact information will be successfully shown after login
        } catch (Exception ignored) {
            return false;
        }
    }

    public boolean getAddToCartButton() {
        try {
            WebElement addToCartButton = driver.findElement(By.xpath("//*[@id=\"module_actions\"]/div/div/button[3]"));
            addToCartButton.click();
            Thread.sleep(2500);
            // wait until the modal window for login is shown

            WebElement signInWindow = driver.findElement(By.xpath("/html/body/div[9]/div/div[1]"));
            return signInWindow != null && signInWindow.isDisplayed();
            // if the login modal window is shown, that means that the order will be successfully processed after login because it passed all the checks
        } catch (Exception ignored) {
            return false;
        }
    }

    public boolean getFavouriteButton() {
        try {
            driver.manage().window().maximize();
            Thread.sleep(2500);

            WebElement addToFavouriteIcon = driver.findElement(By.xpath("//*[@id=\"detail-favorite-mark\"]/div"));
            addToFavouriteIcon.click();
            Thread.sleep(3000);
            // wait until the product is added into the favourites list

            WebElement successMessageSection = driver.findElement(By.xpath("/html/body/div[8]/div/div"));
            WebElement successMessageFirstPart = driver.findElement(By.xpath("/html/body/div[8]/div/div/div"));
            WebElement successMessageLink = driver.findElement(By.xpath("/html/body/div[8]/div/div/a"));
            WebElement successMessageSecondPart = driver.findElement(By.xpath("/html/body/div[8]/div/div"));

            return successMessageSection != null && successMessageSection.isDisplayed()
                    && successMessageFirstPart != null && successMessageFirstPart.isDisplayed() && successMessageFirstPart.getText().equals("Nicely done!")
                    && successMessageLink != null && successMessageLink.isDisplayed() && successMessageLink.getText().equals("My Favorites")
                    && successMessageSecondPart != null && successMessageSecondPart.isDisplayed()
                    && successMessageSecondPart.getText().contains("Nicely done!\n" +
                    "Visit My Favorites to manage your favorites.");
            // check if the success messages are adequately deployed in the appropriate section
        } catch (Exception ignored) {
            return false;
        }
    }


    public boolean getRecommendationsSection() {
        try {
            WebElement recommendationsSection = driver.findElement(By.id("module_recommandproducts_you_may_like"));
            List<WebElement> recommendationsSectionItems = driver.findElements(By.className("recommend-card"));

            return recommendationsSection != null && recommendationsSection.isDisplayed()
                    && recommendationsSectionItems != null && recommendationsSectionItems.size() > 0;
            // check if the section is existent and there are more than 0 products in it
        } catch (Exception ignored) {
            return false;
        }
    }

    public boolean getRecommendationsItems() {
        try {
            List<WebElement> recommendationsSectionItems = driver.findElements(By.className("recommend-card")); // get all recommended products
            WebElement firstRecommendedProduct = recommendationsSectionItems.get(0);
            // For testing purposes, get the first recommended product

            WebElement productImage = firstRecommendedProduct.findElement(By.className("recommend-card-img"));
            WebElement productTitle = firstRecommendedProduct.findElement(By.className("recommend-card-title"));
            WebElement productPrice = firstRecommendedProduct.findElement(By.className("recommend-price"));
            WebElement productMOQ = firstRecommendedProduct.findElement(By.className("recommend-moq"));
            // get all information about the product

            return productImage != null && productImage.isDisplayed()
                    && productTitle != null && productTitle.isDisplayed() && productTitle.getText().contains("Boss TR-2 Tremolo Guitar Effect Pedal for Guitar and Bass")
                    && productPrice != null && productPrice.isDisplayed() && productPrice.getText().contains("$78.88")
                    && productMOQ != null && productMOQ.isDisplayed() && productMOQ.getText().contains("1 Piece");
            // check if the adequate necessary information is accompanied with the product therefore meaning the recommended products have the appropriate form
        } catch (Exception ignored) {
            return false;
        }
    }


    public boolean getRegionalSettings() {
        try {
            driver.manage().window().maximize();
            Thread.sleep(1500); // wait until elements are loaded

            Actions action = new Actions(driver);
            WebElement languageCurrencySection = driver.findElement(By.xpath("/html/body/div[1]/div[1]/header/div[4]/div/div[4]/div[3]/div/div"));
            action.moveToElement(languageCurrencySection).build().perform();
            // hover over the section to make the form to appear

            WebElement regionalSettingsTitle = driver.findElement(By.xpath("/html/body/div[1]/div[1]/header/div[4]/div/div[4]/div[3]/div/div/div[2]/div[1]/b"));

            Thread.sleep(2000);
            if(regionalSettingsTitle.getText().contains("Regional Settings")) {
                WebElement languageDropdownList = driver.findElement(By.xpath("/html/body/div[1]/div[1]/header/div[4]/div/div[4]/div[3]/div/div/div[2]/div[2]/div/div"));
                WebElement currencyDropdownList = driver.findElement(By.xpath("/html/body/div[1]/div[1]/header/div[4]/div/div[4]/div[3]/div/div/div[2]/div[3]/div/div"));

                Thread.sleep(2000);
                action.moveToElement(languageDropdownList).click().build().perform();
                Thread.sleep(2000); // wait for select to show up
                driver.findElement(By.xpath("/html/body/div[1]/div[1]/header/div[4]/div/div[4]/div[3]/div/div/div[2]/div[2]/div/div/div[2]/ul/li/ul/li[3]")).click();
                Thread.sleep(2000);
                // wait for language to be saved

                Thread.sleep(2000);
                action.moveToElement(currencyDropdownList).click().build().perform();
                Thread.sleep(2000);
                driver.findElement(By.xpath("/html/body/div[1]/div[1]/header/div[4]/div/div[4]/div[3]/div/div/div[2]/div[3]/div/div/div[2]/ul/li[1]/ul/li[2]")).click();
                Thread.sleep(1500);
                // wait for currency to be saved

                WebElement submitButton = driver.findElement(By.xpath("/html/body/div[1]/div[1]/header/div[4]/div/div[4]/div[3]/div/div/div[2]/div[5]/button"));

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
        if(!englishElementsLanguage.get(0).equals("You may also like") ||
                !deutschElementsLanguage.get(0).equals("Dies könnte Ihnen auch gefallen"))
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
            WebElement youMayLike = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div[3]/div/div[1]"));
            WebElement categoriesTitle = driver.findElement(By.xpath("/html/body/div[1]/div[1]/header/div[4]/div/div[1]/div/div/h3/span]"));
            WebElement searchInputPlaceholder = driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/div[3]/div/div/form/div[2]/input"));

            return List.of(youMayLike.getText(), categoriesTitle.getText(), searchInputPlaceholder.getAttribute("placeholder"));
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
