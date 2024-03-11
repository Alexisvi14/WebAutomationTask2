package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;

public class LoginPage extends AbstractPage{
    private WebDriver driver;
    @FindBy(id = "userid")
    WebElement usernameBox;
    @FindBy(id = "pass")
    WebElement passwordBox;
    @FindBy(id = "signin-continue-btn")
    WebElement continueButton;
    @FindBy(css = "#signin-error-msg")
    WebElement errorMsg;

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    public void clickUsernameBox(String username){
        usernameBox.sendKeys(username);
    }
    public void clickPasswordBox(String password){
        passwordBox.sendKeys(password);
    }
    public void clickContinueButton(){
        continueButton.click();
    }
    public String getErrorMsg(){
        return errorMsg.getText();
    }
}
