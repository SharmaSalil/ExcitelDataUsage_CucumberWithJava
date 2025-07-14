package excitel.stepDefinationFiles;

import excitel.context.TestContext;
import excitel.domainObjects.CalenderMonth;
import excitel.pages.PageFactoryManager;
import excitel.pages.SessionsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class SessionPageStepDefination {

    private final SessionsPage sessionsPage;

    public SessionPageStepDefination(TestContext testContext){
        sessionsPage = PageFactoryManager.getSessionsPage(testContext.driver);
    }

    @And("I select {month} to retrieve usage details")
    public void iSelectToRetrieveUsageDetails(CalenderMonth month) throws Throwable {
        sessionsPage.month_drpDwn_selectByVisibleText(sessionsPage.makeFirstCharacterUpperCase(month.getMonth()));
    }

    @Then("I should see the total internet usage calculated for that month")
    public void iShouldSeeTheTotalInternetUsageCalculatedForThatMonth() {
        sessionsPage.totalTimeAndUsage();
    }
}
