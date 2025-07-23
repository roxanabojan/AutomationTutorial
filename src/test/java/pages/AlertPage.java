package pages;

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
        alertHelper.acceptAlert();
    }

    public void dealAlertTimer() {
        elementHelper.clickElement(alertWaitButtonElement);
        alertHelper.acceptAlert();
        pageHelper.scrollPage(0, 400);
    }

    public void dealAlertCancel() {
        elementHelper.clickElement(alertOkCancelElement);
        alertHelper.dismissAlert();
    }

    public void dealAlertPrompt(String value) {
        elementHelper.clickElement(alertPromptElement);
        alertHelper.fillAlert(value);
    }
}
