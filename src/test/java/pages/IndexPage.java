package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndexPage extends BasePage {

    public IndexPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h5[text()='Alerts, Frame & Windows']")
    private WebElement alertFrameWindowMenu;
    @FindBy(xpath = "//h5[text()='Elements']")
    private WebElement elementsMenu;
    @FindBy(xpath = "//h5[text()='Forms']")
    private WebElement formsMenu;

    public void interactWithAlertsFrameWindowMenu() {
        elementHelper.clickJSElement(alertFrameWindowMenu);
        LoggerUtility.infoStep("The user clicks on Alert Window Frame Menu");
    }

    public void interactWithElementsMenu() {
        elementHelper.clickJSElement(elementsMenu);
        LoggerUtility.infoStep("The user clicks on Elements Menu");
    }

    public void interactWithFormsMenu() {
        elementHelper.clickJSElement(formsMenu);
        LoggerUtility.infoStep("The user clicks on Forms Menu");
    }
}
