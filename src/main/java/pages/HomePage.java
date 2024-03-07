package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.List;

public class HomePage extends AbstractPage{
    private static final Logger LOGGER = LoggerFactory.getLogger(HomePage.class);
    @FindBy(xpath = "//a[@_sp='m570.l1524']")
    WebElement loginButton;
    @FindBy(className = "gh-tb")
    WebElement searchBox;
    @FindBy(id = "gh-btn")
    WebElement searchButton;
    @FindBy(css = "div#srp-river-results li")
    List<WebElement> searchedElements;
    @FindBy(id = "gh-cat")
    WebElement dropdownCategories;
    @FindBy(linkText = "Deportes")
    WebElement sportsCategory;
    @FindBy(xpath = "(//a[contains(text(), 'Moda')])[2]")
    WebElement fashionCategory;

    public HomePage(WebDriver driver, WebDriverWait wait, Logger logger) {
        super(driver, wait, logger);
        PageFactory.initElements(driver, this);
    }

    public LoginPage clickLoginButton(){
        click(loginButton);
        return new LoginPage(driver);
    }

    public void clickSearchBox(String elementToSearch){
        sendKeys(searchBox, elementToSearch);
    }

    public void clickSearchButton(){
        searchButton.click();
    }

    public void getNumberOfSearchedElements(){
        LOGGER.info(String.valueOf(searchedElements.size()));
    }

    public void hoverSportsLink(){
        Actions actions = new Actions(driver);
        actions.moveToElement(sportsCategory).perform();
    }
    public SportsPage clickSportsLink(){
        sportsCategory.click();
        return new SportsPage(driver, wait, logger);
    }

    public void hoverFashionLink(){
        Actions actions = new Actions(driver);
        actions.moveToElement(fashionCategory).perform();
    }

    public void clickCategoriesDropdown() throws InterruptedException {
        dropdownCategories.click();
        Thread.sleep(3000);
        Select selectDrop = new Select(dropdownCategories);
        selectDrop.selectByIndex(2);
        Thread.sleep(3000);
    }
}
