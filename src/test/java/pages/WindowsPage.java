package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WindowsPage extends BasePage {
    public WindowsPage(WebDriver driver){
        super(driver);
    }

    @FindBy(id = "tabButton")
    private WebElement newTabElement;
    @FindBy(id = "windowButton")
    private WebElement newWindow;

    public void dealWithNewTab(){
        elementHelper.clickElement(newTabElement);

        tabHelper.switchToSpecificTab(1);
        tabHelper.closeCurrentTab();
        tabHelper.switchToSpecificTab(0);
    }

    public void dealWithNewWindow(){
        elementHelper.clickJSElement(newWindow);

        tabHelper.switchToSpecificTab(1);
        tabHelper.closeCurrentTab();
        tabHelper.switchToSpecificTab(0);
    }
}
