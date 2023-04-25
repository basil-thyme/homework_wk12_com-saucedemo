package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;

public class Utility extends BaseTest {

    public void clickOnElement(By by){
        driver.findElement(by).click();
    }

    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    public void assertToVerify(By by, String expected){
        String actual = driver.findElement(by).getText();
        Assert.assertEquals("Not matching", expected, actual);


    }





}
