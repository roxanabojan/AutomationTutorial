package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class PracticeFormTest {
    public WebDriver driver;

    @Test
    public void testMethod() {
        //Deschidem o instanta de Chrome.
        driver = new ChromeDriver();

        //Accesam o pagina specifica.
        driver.get("https://demoqa.com");

        //Facem browserul sa fie in modul maximize.
        driver.manage().window().maximize();
        //Wait implicit - punem un timp maxim cat sa astepte, dar nu o sa astepte maximul, daca dupa 1 sec merge, el isi face treaba in continuare
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement formsMenu = driver.findElement(By.xpath("//h5[text()='Forms']"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", formsMenu);

        WebElement practiceFormsSubMenu = driver.findElement(By.xpath("//span[text()='Practice Form']"));
        executor.executeScript("arguments[0].click();", practiceFormsSubMenu);

        WebElement firstNameElement = driver.findElement(By.cssSelector("input[placeholder='First Name']"));
        String firstNameValue = "Roxana";
        firstNameElement.sendKeys(firstNameValue);

        WebElement lastNameElement = driver.findElement(By.cssSelector("input[placeholder='Last Name']"));
        String lastNameValue = "Bojan";
        lastNameElement.sendKeys(lastNameValue);

        WebElement emailElement = driver.findElement(By.cssSelector("input[placeholder='name@example.com']"));
        String emailValue = "test@test.com";
        emailElement.sendKeys(emailValue);

        WebElement mobileElement = driver.findElement(By.cssSelector("input[placeholder='Mobile Number']"));
        String mobileValue = "0744122133";
        mobileElement.sendKeys(mobileValue);

        WebElement subjectsEelement = driver.findElement(By.id("subjectsInput"));
        List<String> subjectsValue = Arrays.asList("Maths", "Arts", "Accounting", "Social Studies");
        for(int index=0; index<subjectsValue.size(); index++){
            subjectsEelement.sendKeys(subjectsValue.get(index));
            subjectsEelement.sendKeys(Keys.ENTER);
        }

        String genderValue = "Female";
        List<WebElement> genderElementList = driver.findElements(By.cssSelector("div[id='genterWrapper']>div>div>label[class='custom-control-label']"));
        switch (genderValue){
            case "Male":
                genderElementList.get(0).click();
                break;
            case "Female":
                genderElementList.get(1).click();
                break;
            case "Other":
                genderElementList.get(2).click();
                break;
        }

        //pentru a face scroll in jos
        //prima valoare X- face scroll stanga sau dreapta, a doua valoare y= face scroll sus jos
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)", "");
        List<WebElement> hobbiesElementList = driver.findElements(By.cssSelector("div[id='hobbiesWrapper']>div>div>label[class='custom-control-label']"));
        List<String> hobbyValues = Arrays.asList("Sports", "Reading");
        for(int index=0; index<hobbiesElementList.size(); index++){
            if(hobbyValues.contains(hobbiesElementList.get(index).getText())) {
                hobbiesElementList.get(index).click();
            }
        }

        WebElement uploadElement = driver.findElement(By.id("uploadPicture"));
        String uploadValue = "src/test/resources/epix.jpg";
        File file = new File(uploadValue);
        uploadElement.sendKeys(file.getAbsolutePath());

        WebElement currentAdressElement = driver.findElement(By.id("currentAddress"));
        String currentAddressValue = "str. Horea, nr.49";
        currentAdressElement.sendKeys(currentAddressValue);

        WebElement stateElement = driver.findElement(By.id("stateCity-wrapper"));
        js.executeScript("arguments[0].click();", stateElement);

        WebElement stateInputEelement = driver.findElement(By.id("react-select-3-input"));
        String stateValue = "NCR";
        stateInputEelement.sendKeys(stateValue);
        stateInputEelement.sendKeys(Keys.ENTER);

        WebElement cityInputElement = driver.findElement(By.id("react-select-4-input"));
        String cityValue = "Delhi";
        cityInputElement.sendKeys(cityValue);
        cityInputElement.sendKeys(Keys.ENTER);

        WebElement submitEelement = driver.findElement(By.id("submit"));
        submitEelement.click();

        //Wait explicit
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table//td[1]")));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table//td[2]")));

        List<WebElement> tableDescriptionList = driver.findElements(By.xpath("//table//td[1]"));
        List<WebElement> tableValueList = driver.findElements(By.xpath("//table//td[2]"));

        Assert.assertEquals(tableDescriptionList.get(0).getText(), "Student Name", "Student Name text is not displayed right in the table");
        Assert.assertTrue(tableValueList.get(0).getText().contains(firstNameValue), "First Name text is not displayed right in the table");
        Assert.assertTrue(tableValueList.get(0).getText().contains(lastNameValue), "Last Name text is not displayed right in the table");

        Assert.assertEquals(tableDescriptionList.get(1).getText(), "Student Email", "Student Email text is not displayed right in the table");
        Assert.assertEquals(tableValueList.get(1).getText(), emailValue, "Student Name text is not displayed right in the table");

        Assert.assertEquals(tableDescriptionList.get(2).getText(), "Gender", "Gender text is not displayed right in the table");
        Assert.assertEquals(tableValueList.get(2).getText(), genderValue, "Gender text is not displayed right in the table");

        //Tema de validat ce a mai ramas din tabel

        driver.quit();



//        String genderValue = "Female";
//        List<WebElement> genderElementList = driver.findElements(By.cssSelector("div[id='genterWrapper']>div>div>label[class='custom-control-label']"));
//        switch (genderValue){
//            case "Male":
//                genderElementList.get(0).click();
//                break;
//            case "Female":
//                genderElementList.get(1).click();
//                break;
//            case "Other":
//                genderElementList.get(2).click();
//                break;
//
//        }
//
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,400)", "");
//        List<WebElement> hobbiesElementList = driver.findElements(By.cssSelector("div[id='hobbiesWrapper']>div>div>label[class='custom-control-label']"));
//        List<String> hobbyValues = Arrays.asList("Reading");
//        for(int index=0; index<hobbiesElementList.size(); index++) {
//            if(hobbyValues.contains(hobbiesElementList.get(index).getText())) {
//                hobbiesElementList.get(index).click();
//            }
//        }
//
//        WebElement uploadElement = driver.findElement(By.id("uploadPicture"));
//        String uploadValue = "src/test/resources/epix.jpg";
//        File file = new File(uploadValue);
//        uploadElement.sendKeys(uploadValue);
    }
}
