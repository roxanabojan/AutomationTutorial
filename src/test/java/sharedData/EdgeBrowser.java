package sharedData;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class EdgeBrowser implements Browser{

    private WebDriver driver;
    private FirefoxOptions firefoxOptions;

    @Override
    public void openBrowser() {
        configureBrowser();
        driver = new FirefoxDriver(firefoxOptions);

        //Accesam o pagina specifica.
        driver.get("https://demoqa.com");

        //wait implicit
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Override
    public void configureBrowser() {
        boolean cicd = Boolean.parseBoolean(System.getProperty("cicd"));
        firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("window-size=1680, 1050");
        firefoxOptions.addArguments("--disable-gpu");
        firefoxOptions.addArguments("--disable-infobars");
        firefoxOptions.addArguments("--disable-extensions");
        if(cicd){
            firefoxOptions.addArguments("--headless=new");
        }
        firefoxOptions.addArguments("--incognito");
    }

    public WebDriver getDriver() {
        return driver;
    }
}
