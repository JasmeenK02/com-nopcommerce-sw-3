package computer;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TestSuite extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";
    @Before
    public void SetUp() {

        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphabeticalOrder() {
        //Click on Computer Menu.
        clickOnTheElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));

        //Click on Desktop
        //clickOnTheElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Desktops']"));
        clickOnTheElement(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]"));


        //Select Sort By position "Name: Z to A"
        visibleTextDropDown(By.xpath("//select[@id='products-orderby']"), "Name: Z to A");

        //define expected
        String expectedText = "Name: Z to A";
        //get actual text
        String actualText = getTextFromElement(By.xpath("//select[@id='products-orderby']/option[text()='Name: Z to A']"));
        //verify the ordering is priced high to low
        Assert.assertEquals("not sorted by Name: Z to A", expectedText, actualText);
    }


    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //Click on Computer Menu.
        Thread.sleep(1000);
        clickOnTheElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));

        //Click on Desktop
        Thread.sleep(1000);
        //clickOnTheElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Desktops']"));
        clickOnTheElement(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]"));

        //Select Sort By position "Name: A to Z"
       visibleTextDropDown(By.xpath("//select[@id='products-orderby']"), "Name: A to Z");

        //Click on "Add To Cart"
        Thread.sleep(1000);
        clickOnTheElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/button[1]"));

        //Verify the Text "Build your own computer"
        String expectedText = "Build your own computer";
        String actualText = getTextFromElement(By.xpath("//div[@class='product-name']/h1"));
        Assert.assertEquals("Not on Build your own computer page", expectedText, actualText);
        Thread.sleep(1000);

        //Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        visibleTextDropDown(By.xpath("//select[@name='product_attribute_1']"), "2.2 GHz Intel Pentium Dual-Core E2200");

        //Select "8GB [+$60.00]" using Select class.
        visibleTextDropDown(By.xpath("//select[@name='product_attribute_2']"), "8GB [+$60.00]");

        //Select HDD radio "400 GB [+$100.00]"
        Thread.sleep(1000);
        clickOnTheElement(By.xpath("//input[@id='product_attribute_3_7']"));

        //Select OS radio "Vista Premium [+$60.00]"
        Thread.sleep(1000);
        clickOnTheElement(By.xpath("//label[text()='Vista Premium [+$60.00]']"));

        //Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        Thread.sleep(1000);
        clickOnTheElement(By.xpath("//input[@id='product_attribute_5_12']"));

        // Verify the price "$1,475.00"
        String expectedPrice = "$1,475.00";
        String actualPrice = getTextFromElement(By.xpath("//span[text()='$1,475.00']"));
        Assert.assertEquals("not $1,475.00", expectedPrice, actualPrice);

        //Click on "ADD TO CARD" Button.
        Thread.sleep(1000);
        clickOnTheElement(By.xpath("//button[@id='add-to-cart-button-1'] "));

        //Verify the Message "The product has been added to your shopping cart" on Top green Bar
        String expectedMessage = "The product has been added to your shopping cart";
        String actualMessage = getTextFromElement(By.xpath("//div[@class='bar-notification success']/p"));
        Assert.assertEquals("Not added successfully", expectedMessage, actualMessage);

        //After that close the bar clicking on the cross button.
        Thread.sleep(1000);
        clickOnTheElement(By.xpath("//div[@class='bar-notification success']/span"));

        //Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHover(By.xpath("//span[contains(text(),'Shopping cart')]"));
        Thread.sleep(1000);
        clickOnTheElement(By.xpath("//button[contains(text(),'Go to cart')]"));

        //Verify the message "Shopping cart"
        String expectedTextShoppingCart = "Shopping cart";
        String actualTextShoppingCart = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals("Shopping cart text doesn't match", expectedTextShoppingCart, actualTextShoppingCart);
        Thread.sleep(1000);

        //Change the Qty to "2" and Click on "Update shopping cart"
        driver.findElement(By.xpath("//input[@class='qty-input']")).clear();
        sendTextToElement(By.xpath("//input[@class='qty-input']"), "2");
        clickOnTheElement(By.xpath("//button[@class='button-2 update-cart-button']"));

        //Verify the Total"$2,950.00"
        String expectedTotal = "$2,950.00";
        String actualTotal = getTextFromElement(By.xpath("//td[@class='subtotal']/span[text()='$2,950.00']"));
        Assert.assertEquals("Total not $2,950.00", expectedTotal, actualTotal);
        Thread.sleep(1000);

        //click on checkbox “I agree with the terms of service”
        Thread.sleep(1000);
        clickOnTheElement(By.xpath("//input[@name='termsofservice']"));

        //Click on “CHECKOUT”
        Thread.sleep(1000);
        clickOnTheElement(By.xpath("//button[@name='checkout']"));

        //Verify the Text “Welcome, Please Sign In!”
        String expectedWelcome = "Welcome, Please Sign In!";
        String actualWelcome = getTextFromElement(By.xpath("//div[@class='page-title']/h1"));
        Assert.assertEquals("Welcome Text doesn't match", expectedWelcome, actualWelcome);

        //Click on “CHECKOUT AS GUEST” Tab
        clickOnTheElement(By.xpath("//button[@class='button-1 checkout-as-guest-button']"));

        //Fill the all mandatory field
        sendTextToElement(By.id("BillingNewAddress_FirstName"), "Jasmeen");
        sendTextToElement(By.id("BillingNewAddress_LastName"), "Kaur");
        sendTextToElement(By.id("BillingNewAddress_Email"), "jasmeen144@gmail.com");
        visibleTextDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "United Kingdom");
        sendTextToElement(By.id("BillingNewAddress_City"), "Leicester");
        sendTextToElement(By.id("BillingNewAddress_Address1"), "64 Best Road");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "LE5 6AY");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "07848533216");

        //Click on “CONTINUE”
        Thread.sleep(1000);
        clickOnTheElement(By.xpath("//div[@id='billing-buttons-container']//button[@class='button-1 new-address-next-step-button']"));

        //Click on Radio Button “Next Day Air($0.00)”
        Thread.sleep(1000);
        clickOnTheElement(By.xpath("//input[@value='Next Day Air___Shipping.FixedByWeightByTotal']"));

        //Click on “CONTINUE”
        Thread.sleep(1000);
        clickOnTheElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));

        //Select Radio Button “Credit Card”
        Thread.sleep(1000);
        clickOnTheElement(By.xpath("//input[@id='paymentmethod_1']"));
        Thread.sleep(1000);
        clickOnTheElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));

        //Select “Master card” From Select credit card dropdown
        visibleTextDropDown(By.xpath("//select[@id='CreditCardType']"), "Master card");

        //Fill all the details
        sendTextToElement(By.id("CardholderName"), "Ms Jasmeen");
        sendTextToElement(By.id("CardNumber"), "3220 1931 4455 1732");
        visibleTextDropDown(By.xpath("//select[@id='ExpireMonth']"), "10");
        visibleTextDropDown(By.xpath("//select[@id='ExpireYear']"), "2026");
        sendTextToElement(By.xpath("//input[@id='CardCode']"), "378");

        //Click on “CONTINUE”
        Thread.sleep(1000);
        clickOnTheElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));

        //Verify “Payment Method” is “Credit Card”
     Thread.sleep(1000);
        String expectedPayMethod = "Credit Card";
        String actualPayMethod = getTextFromElement(By.xpath("//span[contains(text(),'Credit Card')]"));
        Thread.sleep(1000);
        Assert.assertEquals("no credit card", expectedPayMethod, actualPayMethod);

        //Verify “Shipping Method” is “Next Day Air”
        String expectedShippingMethod = "Next Day Air";
        String actualShippingMethod = getTextFromElement(By.xpath("//span[normalize-space() = 'Next Day Air']"));
        Thread.sleep(1000);
        Assert.assertEquals("Shipping Message not found", expectedShippingMethod, actualShippingMethod);

        //Verify Total is “$2,950.00”
        String expectedTotalAmount = "$2,950.00";
        String actualTotalAmount = getTextFromElement(By.xpath("//span[@class='product-subtotal']"));
        Assert.assertEquals("Total amount does not match.", expectedTotalAmount, actualTotalAmount);

        //Click on “CONFIRM”
        Thread.sleep(1000);
        clickOnTheElement(By.xpath("//button[@class='button-1 confirm-order-next-step-button']"));

        Thread.sleep(1000);
        //Verify the Text “Thank You”
        String expectedThankYou = "Thank you";
        String actualThankYou = getTextFromElement(By.xpath("//div[@class='page-title']/h1"));
        Assert.assertEquals("Thank you not being displayed", expectedThankYou, actualThankYou);

        //Verify the message “Your order has been successfully processed!”
        String expectedSuccessMessage = "Your order has been successfully processed!";
        String actualSuccessMessage = getTextFromElement(By.xpath("//div[@class='section order-completed']//div[@class='title']/strong"));
        Assert.assertEquals("Not processed", expectedSuccessMessage, actualSuccessMessage);

        //Click on “CONTINUE”
        clickOnTheElement(By.xpath("//button[@class='button-1 order-completed-continue-button']"));

        //Verify the text “Welcome to our store”
        Thread.sleep(1000);
        String expectedWelcomeMessage = "Welcome to our store";
        String actualWelcomeMessage = getTextFromElement(By.xpath("//div[@class='topic-block-title']/h2"));
        Assert.assertEquals("Not successfully processed", expectedWelcomeMessage, actualWelcomeMessage);
    }


}
