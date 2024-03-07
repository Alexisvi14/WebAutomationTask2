package ebayTests;

import base.AbstractTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomepageTests extends AbstractTest {
//    private final Logger logger = LoggerFactory.getLogger(HomepageTests.class);

    @Test(dataProvider="usernameData")
    public void loginButtonTest(String username) throws InterruptedException {
        var loginPage = homePageEbay.clickLoginButton();
        loginPage.clickUsernameBox(username);
        loginPage.clickContinueButton();
        Thread.sleep(3000);
        Assert.assertEquals(loginPage.getErrorMsg(),
                "No pudimos encontrar esta cuenta de eBay.", "El mensaje no fue el esperado");
        Assert.assertTrue(!loginPage.getErrorMsg().isEmpty());
    }
    @DataProvider
    public Object[][] usernameData(){
        Object[][] data = new Object[3][1];
        data[0][0] = "hellohellojajagmail";
        data[1][0] = "ahsdiusjndkasndujewkiu";
        data[2][0] = "iu32whuewhut21t21y";
        return data;
    }
    @Test()
    public void searchButtonTest() throws InterruptedException {
        homePageEbay.clickSearchBox("Iphone");
        homePageEbay.clickSearchButton();
        Thread.sleep(5000);
        homePageEbay.getNumberOfSearchedElements();
    }

    @Test()
    public void submenuElements() throws InterruptedException {
        homePageEbay.hoverFashionLink();
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement footwear = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Calzado")));
        footwear.click();
    }

    @Test()
    public void dropdownTest() throws InterruptedException {
        homePageEbay.clickCategoriesDropdown();
        homePageEbay.clickSearchButton();
        Thread.sleep(3000);
    }

    @Test()
    public void hoverSportsTest() throws InterruptedException {
        homePageEbay.hoverSportsLink();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement link = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Vende con eBay")));
        link.click();
        Thread.sleep(3000);
    }
    @Test()
    public void sportList() throws InterruptedException {
        var sportsPage = homePageEbay.clickSportsLink();
        sportsPage.iterateCategorySection("Equipo de Boxeo y MMA");
        Thread.sleep(3000);
    }
}
