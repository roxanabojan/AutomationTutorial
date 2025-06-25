package sharedData;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class SharedData {

    public WebDriver driver;

    @BeforeMethod
    public void prepareEnvironment (){
        //Deschidem o instanta de Chrome.
        driver = new ChromeDriver();

        //Accesam o pagina specifica.
        driver.get("https://demoqa.com");

        //Facem browserul sa fie in modul maximize.
        driver.manage().window().maximize();

        //wait implicit
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void clearEnvironment(){
        driver.quit();
    }
}
