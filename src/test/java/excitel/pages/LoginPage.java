package excitel.pages;

import excitel.domainObjects.Credentials;
import excitel.genericFunctions.GenericFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends GenericFunctions {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private static final By loader = By.xpath("//div[contains(@class,'loader-container visible')]");
    private static final By username_txtFld = By.xpath("//input[@placeholder='Username']");
    private static final By password_txtFld = By.xpath("//input[@type='password']");
    private static final By submit_btn = By.xpath("//button[@class='btn']");

    public static By getLoader(){
        return loader;
    }

    public LoginPage username_txtFld_waitVisibilityOfElementLocated() {
        waitVisibilityOfElementLocated(username_txtFld);
        return this;
    }

    public LoginPage username_txtFld_clear() {
        username_txtFld_waitVisibilityOfElementLocated().clear(username_txtFld);
        return this;
    }

    public LoginPage username_txtFld_sendKeys(String username) {
        loader_waitInvisibilityOfElementLocated().
        username_txtFld_waitVisibilityOfElementLocated().
                username_txtFld_clear().
                sendKeys(username_txtFld, username);
        return this;
    }

    public LoginPage password_txtFld_waitVisibilityOfElementLocated() {
        waitVisibilityOfElementLocated(password_txtFld);
        return this;
    }

    public LoginPage password_txtFld_clear() {
        password_txtFld_waitVisibilityOfElementLocated().clear(password_txtFld);
        return this;
    }

    public LoginPage password_txtFld_sendKeys(String username) {
        password_txtFld_waitVisibilityOfElementLocated().
                password_txtFld_clear().
                sendKeys(password_txtFld, username);
        return this;
    }

    public LoginPage submit_btn_waitElementToBeClickable() {
        waitElementToBeClickable(submit_btn);
        return this;
    }

    public void submit_btn_click() {
        submit_btn_waitElementToBeClickable().
                click(submit_btn);
    }

    public LoginPage loader_waitInvisibilityOfElementLocated() {
        waitInvisibilityOfElementLocated(loader);
        return this;
    }

    public void loginUsingCredentials(Credentials credentials) {
                username_txtFld_sendKeys(credentials.getUsername()).
                password_txtFld_sendKeys(credentials.getPassword()).
                submit_btn_click();
    }
}
