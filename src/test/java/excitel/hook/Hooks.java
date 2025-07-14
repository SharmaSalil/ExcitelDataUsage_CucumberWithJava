package excitel.hook;

import excitel.context.TestContext;
import excitel.factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    private final TestContext testContext;

    public Hooks(TestContext testContext) {
        this.testContext = testContext;
    }

    @Before
    public void before() {
        testContext.driver = DriverFactory.driverInitialization();
        testContext.driver.manage().window().maximize();
    }

    @After
    public void after() {
            testContext.driver.quit();
    }
}
