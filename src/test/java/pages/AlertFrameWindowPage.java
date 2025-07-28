package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.logging.Logger;

public class AlertFrameWindowPage extends BasePage {

    public AlertFrameWindowPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Alerts']")
    public WebElement alertsSubMenu;
    @FindBy(xpath = "//span[text()='Frames']")
    public WebElement framesELement;
    @FindBy(xpath = "//span[text()='Browser Windows']")
    public WebElement browserWindowsSubMenu;

    public void interctWithAlertsSubMenu() {
        elementHelper.clickJSElement(alertsSubMenu);
        LoggerUtility.infoStep("The user clicks on Alerts sub menu");
    }

    public void interactWithFramesSubMenu() {
        elementHelper.clickJSElement(framesELement);
        LoggerUtility.infoStep("The user clicks on Frames menu");
    }

    public void interactWithWindowsSubMenu() {
        elementHelper.clickJSElement(browserWindowsSubMenu);
    }
}
