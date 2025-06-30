package helperMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrameHelper {
    public WebDriver driver;

    public FrameHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void switchFrameByElement(WebElement element) {
        driver.switchTo().frame(element);
    }

    public void switchFrameByString(String text) {
        driver.switchTo().frame(text);
    }

    public void switchToParent() {
        driver.switchTo().parentFrame();
    }
}
