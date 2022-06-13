package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.Keys;
import ultilities.Log;

import java.util.List;


public class WebUI {

    public WebDriver driver;
    public WebDriverWait wait;
    public int timeoutWaitForPageLoaded = 30;

    public void navigateToURL(String url) {

        Log.info("Truy cap trang: " + url);
        wait = new WebDriverWait(driver, 10);
        driver.get(url);
        waitForPageLoaded();
    }

    public void selectOptionByText(By element, String text) {

        Log.info("[SelectOption] " + element.toString() + " by text " + text);
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        Select select = new Select(driver.findElement(element));
        select.selectByVisibleText(text);
        waitForPageLoaded();
    }

    public void clearText(By element) {

        try {
            Log.info("[Clear text] của " + element.toString());
            wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
            driver.findElement(element).clear();
        } catch (Exception e) {
            Log.error(e.getMessage());
        }

    }

    public void setText(By element, String value) {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        clearText(element);
        Log.info("[Set text] của " + element.toString());
        driver.findElement(element).sendKeys(value);
    }

    public void setTextThenEnter(By element, String value) {

        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        driver.findElement(element).clear();
        Log.info("Set text của " + element.toString() + " roi Enter");
        driver.findElement(element).sendKeys(value);
        driver.findElement(element).sendKeys(Keys.ENTER);
        waitForPageLoaded();
    }

    public void type(By element, String value) {
        try {
            Log.info("[Type] của " + element.toString());
            wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
            driver.findElement(element).sendKeys(value);
            waitForPageLoaded();
        } catch (Exception e) {
            Log.error(e.getMessage());
        }
    }

    public void clickElement(By element) {
        Log.info("[Click] vào " + element.toString());
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        driver.findElement(element).click();
        waitForPageLoaded();
    }

    public boolean verifyUrl(String url) {
        System.out.println(driver.getCurrentUrl());
        System.out.println(url);

        return driver.getCurrentUrl().contains(url); //True/False
    }

    public void verifyElementText(By element, String textValue) {
        Log.info("[Verify Element text] của: " + element.toString() + " với value: " + textValue);
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        String elementText = driver.findElement(element).getText(); //True/False
        Assert.assertEquals(elementText, textValue, "Không bằng nhau");
    }

    public boolean verifyElementExist(By element) {
        //Tạo list lưu tất cả đối tượng WebElement
        List<WebElement> listElement = driver.findElements(element);

        int total = listElement.size();

        if (total > 0) {
            return true;
        }

        return false;
    }

    public boolean verifyPageLoaded(String pageLoadedText) {
        waitForPageLoaded();
        Boolean res = false;

        List<WebElement> elementList = driver.findElements(By.xpath("//*[contains(text(),'" + pageLoadedText + "')]"));
        if (elementList.size() > 0) {
            res = true;
            System.out.println("Page loaded (" + res + "): " + pageLoadedText);
        } else {
            res = false;
            System.out.println("Page loaded (" + res + "): " + pageLoadedText);
        }
        return res;
    }

    // Wait

    public void waitForPageLoaded() {
        // wait for jQuery to loaded
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
                } catch (Exception e) {
                    return true;
                }
            }
        };

        // wait for Javascript to loaded
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState")
                        .toString().equals("complete");
            }
        };

        try {
            wait = new WebDriverWait(driver, timeoutWaitForPageLoaded);
            wait.until(jQueryLoad);
            wait.until(jsLoad);
        } catch (Throwable error) {
            Assert.fail("Quá thời gian load trang.");
        }

    }

}
