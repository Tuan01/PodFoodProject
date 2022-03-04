package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BasePage {
    WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToLoginButtonAtHeader() {
        waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON_HEADER);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON_HEADER);
    }

    public void enterToEmailTextbox(String username) {
        waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, username);
    }

    public void enterToPasswordTextbox(String password) {
        waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
    }

    public void clickToUserRoleIconAtLoginForm(String roleValue){
        waitForElementClickable(driver, LoginPageUI.USER_ROLE_RADIO_BUTTON, roleValue);
        clickToElement(driver, LoginPageUI.USER_ROLE_RADIO_BUTTON, roleValue);
    }

    public HomePageObject clickToLoginButton() {
        waitForElementClickable(driver,LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver,LoginPageUI.LOGIN_BUTTON);
        return PageGeneratorManager.getHomePage(driver);
    }
}
