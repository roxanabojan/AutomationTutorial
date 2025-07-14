package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertFrameWindowPage extends BasePage{

    public AlertFrameWindowPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath ="//span[text()='Alerts']")
    public WebElement alertsSubMenu;
    @FindBy(xpath = "//span[text()='Frames']")
    public WebElement framesELement;
    @FindBy(xpath = "//span[text()='Browser Windows']")
    public WebElement browserWindowsSubMenu;

    public void interctWithAlertsSubMenu(){
        elementHelper.clickJSElement(alertsSubMenu);
    }

    public void interactWithFramesSubMenu(){
        elementHelper.clickJSElement(framesELement);
    }

    public void interactWithWindowsSubMenu(){
        elementHelper.clickJSElement(browserWindowsSubMenu);
    }
}
