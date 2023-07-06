package Electronics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class ElectronicsTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void SetUp() {
       openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() throws InterruptedException {

        //1.1 Mouse Hover on “Electronics” Tab
        mouseHover(By.xpath("//a[text()='Electronics ']"));
        //1.2 Mouse Hover on “Cell phones” and click
        mouseHover(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
        Thread.sleep(2000);
        clickOnTheElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));


        //1.3 Verify the text “Cell phones”
        String expectedText = "Cell phones";
        String actualText = getTextFromElement(By.xpath("//h1[contains(text(),'Cell phones')]"));
        Assert.assertEquals("Cell phones text doesn't match')]", expectedText, actualText);
    }
    @Test
    public void TestNameVerifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        //1.1 Mouse Hover on “Electronics” Tab
        mouseHover(By.xpath("//ul[@class='top-menu notmobile']/li/a[text()='Electronics ']"));
        //1.2 Mouse Hover on “Cell phones” and click
        mouseHover(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
        Thread.sleep(2000);
        clickOnTheElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
        Thread.sleep(2000);


        //1.3 Verify the text “Cell phones”
        String expectedText = "Cell phones";
        String actualText = getTextFromElement(By.xpath("//h1[contains(text(),'Cell phones')]"));
        Assert.assertEquals("Cell phones text doesn't match')]", expectedText, actualText);

        Thread.sleep(2000);
        //2.4 Click on List View Tab
        clickOnTheElement(By.xpath("//a[contains(text(),'List')]"));

        //2.5 Click on product name “Nokia Lumia 1020” link
        Thread.sleep(1000);
        clickOnTheElement(By.xpath("//a[contains(text(),'Nokia Lumia 1020')]"));

        //2.6 Verify the text “Nokia Lumia 1020”
        String expectedText1 = "Nokia Lumia 1020";
        String actualText1 = getTextFromElement(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/div[2]/div[1]/h1[1]"));
        Assert.assertEquals("'Nokia Lumia 1020'", expectedText1, actualText1);
        Thread.sleep(1000);

        //2.7 Verify the price “$349.00”
        String expectedPrice = "$349.00";
        String actualPrice = getTextFromElement(By.xpath("//span[contains(text(),'$349.00')]"));
        Assert.assertEquals("'$349.00' is not matching]", expectedPrice, actualPrice);

        //2.8 Change quantity to 2
        driver.findElement(By.xpath("//input[@id='product_enteredQuantity_20']")).clear();
        sendTextToElement(By.xpath("//input[@id='product_enteredQuantity_20']"), "2");

        //2.9 Click on “ADD TO CART” tab
        clickOnTheElement(By.xpath("//button[@class='button-1 add-to-cart-button']"));

        //2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        String expectedMessage = "The product has been added to your shopping cart";
        String actualMessage = getTextFromElement(By.xpath("//div[@class='bar-notification success']//p[@class='content']"));
        Assert.assertEquals("Error",expectedMessage,actualMessage);
        //After that close the bar clicking on the cross button.
        clickOnTheElement(By.xpath("//div[@class='bar-notification success']/span"));
        Thread.sleep(1000);

        //2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHover(By.xpath("//span[contains(text(),'Shopping cart')]"));
        Thread.sleep(1000);
        clickOnTheElement(By.xpath("//button[contains(text(),'Go to cart')]"));

        //2.12 Verify the message "Shopping cart"
        String expectedTextShoppingCart = "Shopping cart";
        String actualTextShoppingCart = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals("Error in Shopping cart", expectedTextShoppingCart, actualTextShoppingCart);

        Thread.sleep(1000);
        //2.13 Verify the quantity is 2
        String expectedQty = "2";
        String actualQty = driver.findElement(By.xpath("//input[@class='qty-input']")).getAttribute("value");
        Assert.assertEquals("Qty not equal", expectedQty, actualQty);

        //2.14 Verify the Total $698.00
        String expectedTotal = "$698.00";
        String actualTotal = driver.findElement(By.xpath("//span[@class='product-subtotal']")).getText();
        Assert.assertEquals("Error in total",expectedTotal, actualTotal);

        //2.15 click on checkbox “I agree with the terms of service”
        clickOnTheElement(By.xpath("//input[@id='termsofservice']"));

        //2.16 Click on “CHECKOUT”
        clickOnTheElement(By.xpath("//button[@id='checkout']"));

        //2.17 Verify the Text “Welcome, Please Sign In!”
        String expectedWelcomeText = "Welcome, Please Sign In!";
        String actualWelcomeText = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        Assert.assertEquals("Error in Welcome Text",expectedWelcomeText, actualWelcomeText);

        Thread.sleep(2000);

        //2.18 Click on “REGISTER” tab
       clickOnTheElement(By.xpath("//button[contains(text(),'Register')]"));

        //2.19 Verify the text “Register”
        String expectedRegister = "Register";
        String actualRegister = getTextFromElement(By.xpath("//h1[normalize-space()='Register']"));
        Assert.assertEquals("Error in Register Text",expectedRegister, actualRegister);
        Thread.sleep(2000);

        //2.20 Fill the mandatory fields
        sendTextToElement(By.id("FirstName"),"Jasmeen");
        sendTextToElement(By.id("LastName"), "Kaur");
        sendTextToElement(By.id("Email"), "jasmeen1441@gmail.com");
        sendTextToElement(By.id("Password"), "jask1234");
        sendTextToElement(By.id("ConfirmPassword"), "jask1234");

        //2.21 Click on “REGISTER” Button
        clickOnTheElement(By.id("register-button"));
        Thread.sleep(2000);

        //2.22 Verify the message “Your registration completed”
        String expectedRegistration = "Your registration completed";
        String actualRegistration = getTextFromElement(By.xpath("//div[contains(text(),'Your registration completed')]"));
        Assert.assertEquals("Error in Registration", expectedRegistration, actualRegistration);

        Thread.sleep(2000);

        //2.23 Click on “CONTINUE” tab
        clickOnTheElement(By.xpath("//a[contains(text(),'Continue')]"));

        //2.24 Verify the text “Shopping cart”
        String expectedShoppingCart = "Shopping cart";
        String actualShoppingCart = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals("Error in Shopping Cart", expectedTextShoppingCart, actualTextShoppingCart);
        Thread.sleep(1000);

        //2.25 click on checkbox “I agree with the terms of service”
        Thread.sleep(2000);
        clickOnTheElement(By.xpath("//input[@id='termsofservice']"));

        //2.26 Click on “CHECKOUT”
        Thread.sleep(2000);
        clickOnTheElement(By.id("checkout"));

        //2.27 Fill the Mandatory fields
        Thread.sleep(2000);
        visibleTextDropDown(By.id("BillingNewAddress_CountryId"), "United Kingdom");
        visibleTextDropDown(By.id("BillingNewAddress_City"), "Leicester");
        visibleTextDropDown(By.id("BillingNewAddress_Address1"), "64 Best Road");
        visibleTextDropDown(By.id("BillingNewAddress_ZipPostalCode"), "LE5 6AY");
        visibleTextDropDown(By.id("BillingNewAddress_PhoneNumber"), "07848533216");

        //2.28 Click on “CONTINUE”
        Thread.sleep(2000);
        clickOnTheElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/div[1]/button[4]"));

        //2.29 Click on Radio Button “2nd Day Air ($0.00)”
        Thread.sleep(2000);
        clickOnTheElement(By.id("shippingoption_2"));
//        2.30 Click on “CONTINUE”
        Thread.sleep(2000);
        clickOnTheElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[2]/button[1]"));

//        2.31 Select Radio Button “Credit Card”
        Thread.sleep(2000);
        clickOnTheElement(By.id("paymentmethod_1"));
        clickOnTheElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/div[1]/button[1]"));
//
//        2.32 Select “Visa” From Select credit card dropdown
          Thread.sleep(2000);
        visibleTextDropDown(By.id("CreditCardType"),"Visa");

//        2.33 Fill all the details
        Thread.sleep(2000);
        sendTextToElement(By.id("CardholderName"), "Jasmeen");
        sendTextToElement(By.id("CardNumber"),"3220193144551732");
        sendTextToElement(By.id("ExpireMonth"), "10");
        sendTextToElement(By.id("ExpireYear"), "2026");
        sendTextToElement(By.id("CardCode"), "378");

//        2.34 Click on “CONTINUE”
        Thread.sleep(2000);
        clickOnTheElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/button[1]"));

//        2.35 Verify “Payment Method” is “Credit Card”
        String expectedPayMethod = "Credit Card";
        String actualPayMethod = getTextFromElement(By.xpath("//span[contains(text(),'Credit Card')]"));
        Assert.assertEquals("Unable to verify payment method.", expectedPayMethod, actualPayMethod);

//        2.36 Verify “Shipping Method” is “2nd Day Air”
        Thread.sleep(2000);
        String expectedShippingMethod = "2nd Day Air";
        String actualShippingMethod = getTextFromElement(By.xpath("//li[@class = 'shipping-method']//span[@class = 'value']"));
        Assert.assertEquals("Shipping Method not verified", expectedShippingMethod, actualShippingMethod);

//        2.37 Verify Total is “$698.00”
        String expectedTotalAmount = "$698.00";
        String actualTotalAmount = getTextFromElement(By.xpath("//span[@class='product-subtotal']"));
        Assert.assertEquals("Total amount does not match.", expectedTotalAmount, actualTotalAmount);

//        2.38 Click on “CONFIRM”
        Thread.sleep(2000);
        clickOnTheElement(By.xpath("//button[contains(text(),'Confirm')]"));

//        2.39 Verify the Text “Thank You”
        String expectedThankYou = "Thank you";
        String actualThankYou = getTextFromElement(By.xpath("//h1[contains(text(),'Thank you')]"));
        Assert.assertEquals("Thank you not being displayed", expectedThankYou, actualThankYou);

//        2.40 Verify the message “Your order has been successfully processed!”
        String expectedSuccessMessage = "Your order has been successfully processed!";
        String actualSuccessMessage = getTextFromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        Assert.assertEquals("Not processed", expectedSuccessMessage, actualSuccessMessage);

//        2.41 Click on “CONTINUE”
        Thread.sleep(2000);
        clickOnTheElement(By.xpath("//button[contains(text(),'Continue')]"));

//        2.42 Verify the text “Welcome to our store”
        String expectedWelcomeMessage = "Welcome to our store";
        String actualWelcomeMessage = getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]"));
        Assert.assertEquals("Not successfully processed", expectedWelcomeMessage, actualWelcomeMessage);

//        2.43 Click on “Logout” link
        Thread.sleep(2000);
        clickOnTheElement(By.xpath("//a[contains(text(),'Log out')]"));

//        2.44 Verify the URL is “https://demo.nopcommerce.com/
        String expectedUrl = "https://demo.nopcommerce.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals("Unable to verify URl", expectedUrl, actualUrl);

    }
    @After
    public void tearDown(){
        closeBrowser();
    }
    }
