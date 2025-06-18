package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertsTest {
    public WebDriver driver;

    @Test
    public void testMethod() {
        //Deschidem o instanta de Chrome.
        driver = new ChromeDriver();

        //Accesam o pagina specifica.
        driver.get("https://demoqa.com");

        //Facem browserul sa fie in modul maximize.
        driver.manage().window().maximize();

        //wait implicit
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement alertFrameWindowMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", alertFrameWindowMenu);

        WebElement browserWindowsSubMenu = driver.findElement(By.xpath("//span[text()='Alerts']"));
        executor.executeScript("arguments[0].click();", browserWindowsSubMenu);

        WebElement alerOkButtonElement = driver.findElement(By.id("alertButton"));
        alerOkButtonElement.click();

        Alert alertOK = driver.switchTo().alert();
        alertOK.accept();

        WebElement alertWaitButtonElement = driver.findElement(By.id("timerAlertButton"));
        alertWaitButtonElement.click();

        //wait explicit pentru alerta
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alertWait = driver.switchTo().alert();
        alertOK.accept();

        //!!!! adauga parte de scroll
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)", "");

        WebElement alertOkCancelElement = driver.findElement(By.id("confirmButton"));
        alertOkCancelElement.click();

        Alert alertOKCancelElement = driver.switchTo().alert();
        alertOK.dismiss();

        WebElement alertPromptElement = driver.findElement(By.id("promtButton"));
        alertPromptElement.click();

        Alert alertPrompt = driver.switchTo().alert();
        alertPrompt.sendKeys("Formula1");
        alertOK.accept();

        driver.quit();

    }
}
