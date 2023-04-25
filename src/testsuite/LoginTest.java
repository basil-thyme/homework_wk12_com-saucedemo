package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.ArrayList;
import java.util.List;

public class LoginTest extends Utility {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }

    By username = By.xpath("//input[@id='user-name']");
    By password = By.xpath("//input[@id='password']");
    By click = By.xpath("//input[@id='login-button']");
    By verifyText = By.xpath("//span[contains(text(),'Products')]");

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {

        sendTextToElement(username, "standard_user");
        sendTextToElement(password, "secret_sauce");
        clickOnElement(click);
        assertToVerify(verifyText,"Products");

    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        sendTextToElement(username, "standard_user");
        sendTextToElement(password, "secret_sauce");
        clickOnElement(click);

        List<WebElement> labelsListOfWebElements = driver.findElements(By.xpath("//div[@class='inventory_list']//div//div//div[@class='inventory_item_name']"));

        ArrayList<String> actualList = new ArrayList<>();
        for (WebElement element : labelsListOfWebElements) {
            actualList.add(element.getText());


        }
        int actual = actualList.size();
        String actualNumberOfItems = Integer.toString(actual);

        int expected = 6;
        String expectedNumberOfItems = Integer.toString(expected);
        Assert.assertEquals("Number of items are not matching", expectedNumberOfItems, actualNumberOfItems);

    }


}
