package base;

import ebayTests.HomepageTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import utils.WebDriverFactory;

import java.time.Duration;

public abstract class AbstractTest {
    private ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    protected Logger logger = LoggerFactory.getLogger(getClass());
    protected WebDriverWait wait;

    protected WebDriver getDriver() {
        return driverThreadLocal.get();
    }
    @BeforeMethod(alwaysRun = true)
    public void setUp() {
//        System.setProperty("webdriver.chrome.driver", "/Users/alexisvillamayor/Solvd/Dev/chromedriver");
        WebDriverFactory webDriverFactory = new WebDriverFactory();
        WebDriver driver = webDriverFactory.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        driver.manage().window().maximize();
        driver.get("https://www.ebay.com/");
        driverThreadLocal.set(driver);
    }
    @AfterMethod
    public void tearDown(){
        driverThreadLocal.get().quit();
        }
    }

