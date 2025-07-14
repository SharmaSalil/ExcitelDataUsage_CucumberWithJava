package excitel.stepDefinationFiles;

import excitel.context.TestContext;
import excitel.domainObjects.Credentials;
import excitel.pages.LoginPage;
import excitel.pages.PageFactoryManager;
import excitel.applicationUrl.ApplicationUrls;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageStepDefination {

    private final LoginPage loginPage;

    public LoginPageStepDefination(TestContext testContext){
        loginPage = PageFactoryManager.getLoginPage(testContext.driver);
    }

    @Given("I log in to the Excitel portal with the following credentials")
    public void iLogInToTheExcitelPortalWithTheFollowingCredentials(Credentials credentials) {
        loginPage.load(new ApplicationUrls().getLoginPage());
        loginPage.loginUsingCredentials(credentials);
    }


}
