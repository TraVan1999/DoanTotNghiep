package testcases;

import common.BaseSetup;
import helpers.WebUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import ultilities.PropertiesFile;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseTest {

    protected WebDriver driver;
//allure serve
    @BeforeTest
    public void setup()
    {
        PropertiesFile.setPropertiesFile();
        Date date = new Date();
        String LogDate= new SimpleDateFormat("yyyy-MM-dd_HHmmss").format(date);
        System.setProperty("logFilename", LogDate);

    }
    @BeforeMethod
    public void beforeMethod(){
        driver = new BaseSetup().setupDriver(PropertiesFile.getPropValue("browser"));
        driver.get(PropertiesFile.getPropValue("url"));
    }
    @AfterMethod
    public void afterMethod(){
        driver.close();
    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
