package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertPage extends BasePage {

    public AlertPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "alertButton")
    private WebElement alerOkButtonElement;
    @FindBy(id = "timerAlertButton")
    private WebElement alertWaitButtonElement;
    @FindBy(id = "confirmButton")
    private WebElement alertOkCancelElement;
    @FindBy(id = "promtButton")
    private WebElement alertPromptElement;

    public void dealAlertOk() {
        elementHelper.clickElement(alerOkButtonElement);
        LoggerUtility.infoStep("The user clicks on alert Ok button.");
        alertHelper.acceptAlert();
        LoggerUtility.infoStep("The user deals with alert Ok presence");
    }

    public void dealAlertTimer() {
        elementHelper.clickElement(alertWaitButtonElement);
        LoggerUtility.infoStep("The user clicks on timer button.");
        alertHelper.acceptAlert();
        LoggerUtility.infoStep("The user deals with alert Ok presence");
        pageHelper.scrollPage(0, 400);
        LoggerUtility.infoStep("The user scrolls down the page");
    }

    public void dealAlertCancel() {
        elementHelper.clickElement(alertOkCancelElement);
        LoggerUtility.infoStep("The user clicks on alert Ok button.");
        alertHelper.dismissAlert();
        LoggerUtility.infoStep("The user cancels the alert.");

    }

    public void dealAlertPrompt(String value) {
        elementHelper.clickElement(alertPromptElement);
        LoggerUtility.infoStep("The user clicks on alert prompt.");
        alertHelper.fillAlert(value);
        LoggerUtility.infoStep("The user fills the alert with the value: " + value);
    }
}
