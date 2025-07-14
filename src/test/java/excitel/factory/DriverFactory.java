package excitel.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    public static WebDriver driverInitialization() {
        WebDriver driver;
        driver = new ChromeDriver();
        return driver;
    }

}
