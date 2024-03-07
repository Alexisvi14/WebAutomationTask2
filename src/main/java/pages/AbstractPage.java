package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;


public abstract class AbstractPage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Logger logger;

    public AbstractPage(WebDriver driver, WebDriverWait wait, Logger logger) {
        this.driver = driver;
        this.wait = wait;
        this.logger = logger;
    }

    protected void click(WebElement element) {
        logger.info("Clicking on element: {}", element);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
    protected void sendKeys(WebElement element, String text) {
        logger.info("Sending keys '{}' to element: {}", text, element.getAccessibleName());
        element.sendKeys(text);
    }
}
