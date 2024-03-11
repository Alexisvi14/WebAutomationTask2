package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;

import java.util.List;

public class SportsPage extends AbstractPage{

    @FindBy(xpath = "//li[@class='b-links-accordion']")
    List<WebElement> categoriesLinks;

    public SportsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }


    public void iterateCategorySection(String linkToSelect){
        for (WebElement link : categoriesLinks) {
            String dropdownText = link.getText();
            if (dropdownText.equalsIgnoreCase(linkToSelect)){
                link.click();
                break;
            }
        }
    }
}
