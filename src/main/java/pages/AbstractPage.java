package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public abstract class AbstractPage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Logger logger;

    public AbstractPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        this.logger = LoggerFactory.getLogger(getClass());
    }

    protected void click(WebElement element) {
        logger.info("Clicking on element: {}", element);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
    protected void sendKeys(WebElement element, String text) {
        logger.info("Sending keys '{}' to element: {}", text, element.getAccessibleName());
        element.sendKeys(text);
    }
    protected void selectDropdownElementByIndex(WebElement dropdown, int index){
        Select drop = new Select(dropdown);
        drop.selectByIndex(index);
    }
}
