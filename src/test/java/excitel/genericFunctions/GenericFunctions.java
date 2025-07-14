package excitel.genericFunctions;

import excitel.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class GenericFunctions extends BasePage {

    public GenericFunctions(WebDriver driver) {
        super(driver);
    }

    public void load(String url) {
        driver.get(url);
    }

    public void clear(By locator) {
        driver.findElement(locator).clear();
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void waitVisibilityOfElementLocated(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void sendKeys(By locator, String value){
        driver.findElement(locator).sendKeys(value);
    }

    public void waitElementToBeClickable(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitInvisibilityOfElementLocated(By locator){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void selectByVisibleText(By locator, String value){
        Select select = new Select(driver.findElement(locator));
        select.selectByVisibleText(value);
    }

    public String makeFirstCharacterUpperCase(String value){
        return String.valueOf(value.charAt(0)).toUpperCase() + value.substring(1);
    }
}
