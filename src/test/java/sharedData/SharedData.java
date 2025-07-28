package sharedData;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class SharedData {

    private WebDriver driver;

    @BeforeMethod
    public void prepareEnvironment() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("window-size=1920, 1080");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-extensions");
        options.addArguments("--headless=new");
        options.addArguments("--incognito");

        //Deschidem o instanta de Chrome.
        driver = new ChromeDriver(options);

        //Accesam o pagina specifica.
        driver.get("https://demoqa.com");

        //Facem browserul sa fie in modul maximize.
        //driver.manage().window().maximize();

        //wait implicit
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        LoggerUtility.startTest(this.getClass().getSimpleName());
    }

    @AfterMethod
    public void clearEnvironment(ITestResult result) {
        if(result.getStatus()==ITestResult.FAILURE){
            LoggerUtility.errorLog(result.getThrowable().getMessage());
        }
        driver.quit();

        LoggerUtility.finishTest(this.getClass().getSimpleName());
    }

    public WebDriver getDriver() {
        return driver;
    }
}
