package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestListener;
import org.testng.annotations.*;
import utils.CustomListener;
import utils.WebDriverFactory;

import java.time.Duration;

@Listeners(CustomListener.class)
public abstract class AbstractTest implements ITestListener {
    String pathFile = "/Users/alexisvillamayor/Solvd/WebAutomationTask2/src/test/screenshots";
    protected ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    protected Logger logger = LoggerFactory.getLogger(getClass());
    protected WebDriverWait wait;

    protected WebDriver getDriver() {
        return driverThreadLocal.get();
    }
    @BeforeMethod(alwaysRun = true)
    public void setUp() {
//        System.setProperty("webdriver.chrome.driver", "/Users/alexisvillamayor/Solvd/Dev/chromedriver");
//                THESE CONFIGURATIONS ARE NEEDED JUST IN CASE YOU WANT TO RUN YOUR TESTS IN REMOTE USING SELENIUM GRID
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/"), options);
//        FirefoxOptions firefoxOptions = new FirefoxOptions();
//        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/"), firefoxOptions);

        WebDriverFactory webDriverFactory = new WebDriverFactory();
        WebDriver driver = webDriverFactory.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.ebay.com/");
        driverThreadLocal.set(driver);
    }

    @AfterMethod
    public void tearDown(){
        driverThreadLocal.get().quit();
        }
    }

