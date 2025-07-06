package tests;

import helperMethods.ElementHelper;
import helperMethods.PageHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import sharedData.SharedData;

import java.io.File;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class PracticeFormTest extends SharedData {

    @Test
    public void testMethod() {

        ElementHelper elementHelper = new ElementHelper(driver);
        PageHelper pageHelper = new PageHelper(driver);

        WebElement formsMenu = driver.findElement(By.xpath("//h5[text()='Forms']"));
        elementHelper.clickJSElement(formsMenu);

        WebElement practiceFormsSubMenu = driver.findElement(By.xpath("//span[text()='Practice Form']"));
        elementHelper.clickJSElement(practiceFormsSubMenu);

        WebElement firstNameElement = driver.findElement(By.cssSelector("input[placeholder='First Name']"));
        String firstNameValue = "Roxana";
        elementHelper.fillElement(firstNameElement, firstNameValue);

        WebElement lastNameElement = driver.findElement(By.cssSelector("input[placeholder='Last Name']"));
        String lastNameValue = "Bojan";
        elementHelper.fillElement(lastNameElement, lastNameValue);

        WebElement emailElement = driver.findElement(By.cssSelector("input[placeholder='name@example.com']"));
        String emailValue = "test@test.com";
        elementHelper.fillElement(emailElement, emailValue);

        WebElement mobileElement = driver.findElement(By.cssSelector("input[placeholder='Mobile Number']"));
        String mobileValue = "0744122133";
        elementHelper.fillElement(mobileElement, mobileValue);

        WebElement subjectsEelement = driver.findElement(By.id("subjectsInput"));
        List<String> subjectsValue = Arrays.asList("Maths", "Arts", "Accounting", "Social Studies");
        for(int index=0; index<subjectsValue.size(); index++){
            elementHelper.fillPressElement(subjectsEelement, subjectsValue.get(index), Keys.ENTER);
        }

        String genderValue = "Female";
        List<WebElement> genderElementList = driver.findElements(By.cssSelector("div[id='genterWrapper']>div>div>label[class='custom-control-label']"));
        switch (genderValue){
            case "Male":
                elementHelper.clickElement(genderElementList.get(0));
                break;
            case "Female":
                elementHelper.clickElement(genderElementList.get(1));
                break;
            case "Other":
                elementHelper.clickElement(genderElementList.get(2));
                break;
        }

        pageHelper.scrollPage(0,400);

        List<WebElement> hobbiesElementList = driver.findElements(By.cssSelector("div[id='hobbiesWrapper']>div>div>label[class='custom-control-label']"));
        List<String> hobbyValues = Arrays.asList("Sports", "Reading");
        for(int index=0; index<hobbiesElementList.size(); index++){
            if(hobbyValues.contains(hobbiesElementList.get(index).getText())){
                elementHelper.clickElement(hobbiesElementList.get(index));
            }
        }

        WebElement uploadElement = driver.findElement(By.id("uploadPicture"));
        String uploadValue = "src/test/resources/epix.jpg";
        File file = new File(uploadValue);
        elementHelper.fillElement(uploadElement, file.getAbsolutePath());

        WebElement currentAdressElement = driver.findElement(By.id("currentAddress"));
        String currentAddressValue = "str. Horea, nr.49";
        elementHelper.fillElement(currentAdressElement, currentAddressValue);

        WebElement stateElement = driver.findElement(By.id("stateCity-wrapper"));
        elementHelper.clickJSElement(stateElement);

        WebElement stateInputEelement = driver.findElement(By.id("react-select-3-input"));
        String stateValue = "NCR";
        elementHelper.fillPressElement(stateInputEelement, stateValue, Keys.ENTER);

        WebElement cityInputElement = driver.findElement(By.id("react-select-4-input"));
        String cityValue = "Delhi";
        elementHelper.fillPressElement(cityInputElement, cityValue, Keys.ENTER);

        WebElement submitElement = driver.findElement(By.id("submit"));
        elementHelper.clickJSElement(submitElement);

        List<WebElement> tableDescriptionList = driver.findElements(By.xpath("//table//td[1]"));
        List<WebElement> tableValueList = driver.findElements(By.xpath("//table//td[2]"));

        elementHelper.validateElementEqualsText(tableDescriptionList.get(0), "Student Name");
        elementHelper.validateElementContainsText(tableValueList.get(0), firstNameElement.getText());
        elementHelper.validateElementContainsText(tableValueList.get(0), lastNameElement.getText());

        elementHelper.validateElementEqualsText(tableDescriptionList.get(1), "Student Email");
        elementHelper.validateElementContainsText(tableValueList.get(1), emailValue);

        elementHelper.validateElementEqualsText(tableDescriptionList.get(2), "Gender");
        elementHelper.validateElementEqualsText(tableValueList.get(2), genderValue);

        elementHelper.validateElementEqualsText(tableDescriptionList.get(3), "Mobile");
        elementHelper.validateElementEqualsText(tableValueList.get(3), mobileValue);

        String allSubjects = String.join(", ", subjectsValue);
        elementHelper.validateElementEqualsText(tableDescriptionList.get(5), "Subjects");
        elementHelper.validateElementEqualsText(tableValueList.get(5), allSubjects);

        String allHobbies = String.join(", ", hobbyValues);
        elementHelper.validateElementEqualsText(tableDescriptionList.get(6), "Hobbies");
        elementHelper.validateElementEqualsText(tableValueList.get(6), allHobbies);

        String fileName = uploadValue.substring(19);
        elementHelper.validateElementEqualsText(tableDescriptionList.get(7), "Picture");
        elementHelper.validateElementEqualsText(tableValueList.get(7), fileName);

        elementHelper.validateElementEqualsText(tableDescriptionList.get(8), "Address");
        elementHelper.validateElementEqualsText(tableValueList.get(8), currentAddressValue);

        elementHelper.validateElementEqualsText(tableDescriptionList.get(9), "State and City");
        elementHelper.validateElementContainsText(tableValueList.get(9), stateValue);
        elementHelper.validateElementContainsText(tableValueList.get(9), cityValue);
    }
}
