package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pages.HomePage;

import java.time.Duration;

public abstract class AbstractTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Logger logger;
    protected HomePage homePageEbay;


    public void selectDropdownElementByIndex(WebElement dropdown, int index){
        Select drop = new Select(dropdown);
        drop.selectByIndex(index);
    }

    @BeforeClass
    @Parameters("Browser")
    public void setUp() {
//        System.setProperty("webdriver.chrome.driver", "/Users/alexisvillamayor/Solvd/Dev/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        logger = LoggerFactory.getLogger(HomePage.class);
        driver.manage().window().maximize();
        homePageEbay = new HomePage(driver, wait, logger);
//        goHome();
    }

    @BeforeMethod
    public void goHome() {
        driver.get("https://www.ebay.com/");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}

