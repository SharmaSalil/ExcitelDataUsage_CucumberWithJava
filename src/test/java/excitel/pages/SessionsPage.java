package excitel.pages;

import excitel.genericFunctions.GenericFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SessionsPage extends GenericFunctions {

    static double totalTime;
    static double totalInternet;

    public SessionsPage(WebDriver driver) {
        super(driver);
    }

    private final static String rowsForTimeAndNet = "(//td['_ngcontent-psk-45'])[";

    private final static By month_drpDwn = By.xpath("//select[@name='month']");
    private final static By rows_WE = By.xpath("//tr[@class='cpointer']");

    public SessionsPage loader_waitInvisibilityOfElementLocated() {
        new LoginPage(driver).loader_waitInvisibilityOfElementLocated();
        return this;
    }

    public SessionsPage month_drpDwn_waitVisibilityOfElementLocated() {
        waitVisibilityOfElementLocated(month_drpDwn);
        return this;
    }

    public void month_drpDwn_selectByVisibleText(String month) {
        try {
            month_drpDwn_waitVisibilityOfElementLocated().
                    loader_waitInvisibilityOfElementLocated().
                    selectByVisibleText(month_drpDwn, month);
        }catch (Exception e){
            throw new RuntimeException("Month or year is not visible in last 12 month list !!");
        }
    }

    public void calculateTimeAndUsage() {
        List<WebElement> rows = driver.findElements(rows_WE);
        int netIndex = 5, timeIndex = 4;

        for (int x = 0; x < rows.size(); x++) {
            String netXpath = String.format("%s%d]", rowsForTimeAndNet, netIndex);
            String timeXpath = String.format("%s%d]", rowsForTimeAndNet, timeIndex);

            double currentNet = Double.parseDouble(driver.findElement(By.xpath(netXpath)).getText());
            double currentTime = Double.parseDouble(driver.findElement(By.xpath(timeXpath)).getText());
            System.out.printf("totalInternet :: %s <--> totalTime :: %s%n", currentNet, currentTime);

            totalInternet += currentNet;
            totalTime += currentTime;
            netIndex += 6;
            timeIndex += 6;
        }
    }

    public void totalTimeAndUsage() {
        loader_waitInvisibilityOfElementLocated().
                calculateTimeAndUsage();

        System.out.println("Total Time :: " + (int) (totalTime / 60) + " hours and " + (int) (totalTime % 60) + " minutes");
        System.out.println("Total Data :: " + totalInternet + " MB, i.e " + (totalInternet / 1024) + " GB");
    }
}
