package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;

public class HomePage extends AbstractPage{
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

    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    public LoginPage clickLoginButton(){
        click(loginButton);
        return new LoginPage(driver, wait);
    }

    public void clickSearchBox(String elementToSearch){
        sendKeys(searchBox, elementToSearch);
    }

    public void clickSearchButton(){
        click(searchButton);
    }

    public int getNumberOfSearchedElements(){
        logger.info(String.valueOf(searchedElements.size()));
        return searchedElements.size();
    }

    public void hoverSportsLink(){
        Actions actions = new Actions(driver);
        actions.moveToElement(sportsCategory).perform();
    }
    public SportsPage clickSportsLink(){
        click(sportsCategory);
        return new SportsPage(driver, wait);
    }

    public void hoverFashionLink(){
        Actions actions = new Actions(driver);
        actions.moveToElement(fashionCategory).perform();
    }

    public void clickCategoriesDropdown() throws InterruptedException {
        selectDropdownElementByIndex(dropdownCategories, 2);
        Thread.sleep(3000);
    }
}
