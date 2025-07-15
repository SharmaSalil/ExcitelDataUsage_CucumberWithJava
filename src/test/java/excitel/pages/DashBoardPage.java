package excitel.pages;

import excitel.genericFunctions.GenericFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashBoardPage extends GenericFunctions {

    public DashBoardPage(WebDriver driver) {
        super(driver);
    }

    private final static By session_btn = By.xpath("//span[contains(text(),'Sessions')]");

    public DashBoardPage loader_waitInvisibilityOfElementLocated() {
        new LoginPage(driver).loader_waitInvisibilityOfElementLocated();
        return this;

    }

    public DashBoardPage session_btn_waitVisibilityOfElementLocated() {
        waitVisibilityOfElementLocated(session_btn);
        return this;
    }

    public void session_btn_click() throws InterruptedException {
        if (tryClickSessionButton()) {
            return;
        }
        System.out.println("First-time user detected. Please enter mobile number and OTP. You have 45 seconds...");
        waitForOtpEntry(45000L);

        if (!tryClickSessionButton()) {
            throw new RuntimeException("You have failed to provide the OTP in time!");
        }
    }

    private boolean tryClickSessionButton() {
        try {
            loader_waitInvisibilityOfElementLocated()
                    .session_btn_waitVisibilityOfElementLocated()
                    .click(session_btn);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private void waitForOtpEntry(long millis) throws InterruptedException {
        Thread.sleep(millis);
    }

}
