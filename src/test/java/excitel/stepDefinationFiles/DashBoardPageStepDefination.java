package excitel.stepDefinationFiles;

import excitel.context.TestContext;
import excitel.pages.DashBoardPage;
import excitel.pages.PageFactoryManager;
import io.cucumber.java.en.When;

public class DashBoardPageStepDefination {

    private final DashBoardPage dashBoardPage;

    public DashBoardPageStepDefination(TestContext testContext){
        dashBoardPage = PageFactoryManager.getDashBoardPage(testContext.driver);
    }

    @When("I navigate to the session usage page")
    public void iNavigateToTheSessionUsagePage() throws InterruptedException {
        dashBoardPage.session_btn_click();
    }
}
