package helperMethods;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class TabHelper {
    public WebDriver driver;

    public TabHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToSpecificTab (int position){
        List<String> tabList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabList.get(position));
    }

    public void closeCurrentTab(){
        driver.close();
    }
}
