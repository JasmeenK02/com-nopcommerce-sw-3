package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

/**
 * 1. create class "TopMenuTest"
 * 1.1 create method with name "selectMenu" it has one parameter name "menu" of type
 * string
 * 1.2 This method should click on the menu whatever name is passed as parameter.
 * 1.3. create the @Test method name verifyPageNavigation.use selectMenu method to
 * select the Menu and click on it and verify the page navigation.
 */

public class TopMenuTest extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    //  create method with name "selectMenu" it has one parameter name "menu" of type string
    public void selectMenu(String menu){
        // This method should click on the menu whatever name is passed as parameter.
        clickOnTheElement(By.linkText(menu));
    }
    //create the @Test method name verifyPageNavigation.use selectMenu method to select the Menu and
    // click on it and verify the page navigation.
    @Test
    public void verifyPageNavigation(){

        selectMenu("Books");
        String expectedText = "Books";
        String actualText = getTextFromElement(By.xpath("//a[contains(text(),'Books')]"));
        Assert.assertEquals("Unable to verify text",expectedText,actualText);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }




}
