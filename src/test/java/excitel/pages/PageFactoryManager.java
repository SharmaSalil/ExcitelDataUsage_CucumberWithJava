package excitel.pages;

import org.openqa.selenium.WebDriver;

public class PageFactoryManager {

    private static LoginPage loginPage;
    private static DashBoardPage dashBoardPage;
    private static SessionsPage sessionsPage;

    public static LoginPage getLoginPage(WebDriver driver){
        return loginPage == null ? new LoginPage(driver) : loginPage;
    }

    public static DashBoardPage getDashBoardPage(WebDriver driver){
        return dashBoardPage == null ? new DashBoardPage(driver) : dashBoardPage;
    }

    public static SessionsPage getSessionsPage(WebDriver driver){
        return sessionsPage == null ? new SessionsPage(driver) : sessionsPage;
    }

}

