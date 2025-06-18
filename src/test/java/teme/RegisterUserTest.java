package teme;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class RegisterUserTest {
    public WebDriver driver;
    public WebDriverWait wait;
    String expectedUrl = "https://automationexercise.com/";

    @Test
    public void testMethod(){
        //deschid o instanta de Chrome
        driver = new ChromeDriver();

        //accesez pagina specifica
        driver.get("https://automationexercise.com/");

        //fac browserul sa fie in modul maximize
        driver.manage().window().maximize();

        // asteapta sa apara pop-up-ul si da click pe butonul de consent
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement consentButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".fc-choice-dialog .fc-primary-button")));
        consentButton.click();

        WebElement homeText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Full-Fledged practice website for Automation Engineers')]")));
        Assert.assertTrue(homeText.isDisplayed(), "Home Page is not visible!");

        WebElement signUpLoginButton = driver.findElement(By.xpath("//a[text()=' Signup / Login']"));
        signUpLoginButton.click();

        WebElement signupText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'New User Signup!')]")));
        Assert.assertTrue(signupText.isDisplayed(), "Signup / Login is not visible!");

        WebElement nameElement = driver.findElement(By.cssSelector("input[placeholder='Name']"));
        String nameValue = "Roxana Bojan";
        nameElement.sendKeys(nameValue);

        WebElement emailElement = driver.findElement(By.cssSelector("input[data-qa='signup-email']"));
        String emailValue = "testbr@test.com";
        emailElement.sendKeys(emailValue);

        WebElement signupButton = driver.findElement(By.cssSelector("button[data-qa='signup-button']"));
        signupButton.click();

//        List<WebElement> nameValueList = driver.findElements(By.id("name"));
//        List<WebElement> emailValueList = driver.findElements(By.id("email"));
//        Assert.assertTrue(nameValueList.get(0).getText().contains(nameValue), "Name text is not displayed correctly in the field!");
//        Assert.assertTrue(nameValueList.get(0).getText().contains(nameValue), "Email text is not displayed correctly in the field!");

        String titleValue = "Mrs";
        List<WebElement> titleElementList = driver.findElements(By.cssSelector("div[class='radio-inline']>label>div[data-qa='title']"));
        switch (titleValue){
            case "Mr":
                titleElementList.get(0).click();
                break;
            case "Mrs":
                titleElementList.get(1).click();
                break;
        }


    }

}
