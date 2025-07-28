package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.util.List;
import java.util.logging.Logger;

public class PracticeFormPage extends BasePage {

    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input[placeholder='First Name']")
    private WebElement firstNameElement;
    @FindBy(css = "input[placeholder='Last Name']")
    private WebElement lastNameElement;
    @FindBy(css = "input[placeholder='name@example.com']")
    private WebElement emailElement;
    @FindBy(css = "input[placeholder='Mobile Number']")
    private WebElement mobileElement;
    @FindBy(id = "subjectsInput")
    private WebElement subjectsEelement;
    @FindBy(css = "div[id='genterWrapper']>div>div>label[class='custom-control-label']")
    private List<WebElement> genderElementList;
    @FindBy(css = "div[id='hobbiesWrapper']>div>div>label[class='custom-control-label']")
    private List<WebElement> hobbiesElementList;
    @FindBy(id = "uploadPicture")
    private WebElement uploadElement;
    @FindBy(id = "currentAddress")
    private WebElement currentAdressElement;
    @FindBy(id = "stateCity-wrapper")
    private WebElement stateElement;
    @FindBy(id = "react-select-3-input")
    private WebElement stateInputEelement;
    @FindBy(id = "react-select-4-input")
    private WebElement cityInputElement;
    @FindBy(id = "submit")
    private WebElement submitElement;

    @FindBy(xpath = "//table//td[1]")
    public List<WebElement> tableDescriptionList;
    @FindBy(xpath = "//table//td[2]")
    public List<WebElement> tableValueList;

    public void fillEntireForm(String firstNameValue, String lastNameValue, String emailValue, String mobileValue,
                               List<String> subjectsValue, String genderValue, List<String> hobbyValues,
                               String uploadValue, String currentAddressValue, String stateValue, String cityValue) {

        elementHelper.fillElement(firstNameElement, firstNameValue);
        LoggerUtility.infoLog("The user fills first name field with: "+ firstNameValue);
        elementHelper.fillElement(lastNameElement, lastNameValue);
        LoggerUtility.infoLog("The user fills last name field with: "+ lastNameValue);

        elementHelper.fillElement(emailElement, emailValue);
        LoggerUtility.infoLog("The user fills email field with: "+ emailValue);

        elementHelper.fillElement(mobileElement, mobileValue);
        LoggerUtility.infoLog("The user fills mobile field with: "+ mobileValue);


        for (int index = 0; index < subjectsValue.size(); index++) {
            elementHelper.fillPressElement(subjectsEelement, subjectsValue.get(index), Keys.ENTER);
            LoggerUtility.infoLog("The user fills the subjects field with valur " + subjectsValue.get(index));
        }

        switch (genderValue) {
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
        LoggerUtility.infoLog("The user checks from gender field the value " + genderValue);

        pageHelper.scrollPage(0, 400);

        for (int index = 0; index < hobbiesElementList.size(); index++) {
            if (hobbyValues.contains(hobbiesElementList.get(index).getText())) {
                elementHelper.clickElement(hobbiesElementList.get(index));
                LoggerUtility.infoLog("The user fills the hobbies field with value " + hobbiesElementList.get(index).getText());

            }
        }

        File file = new File(uploadValue);
        elementHelper.fillElement(uploadElement, file.getAbsolutePath());
        LoggerUtility.infoLog("The user uploads the file "+ file.getAbsolutePath());
        elementHelper.fillElement(currentAdressElement, currentAddressValue);
        LoggerUtility.infoLog("The user fills the address with "+ currentAddressValue);
        elementHelper.clickJSElement(stateElement);
        LoggerUtility.infoLog("The user clicks on state element");
        elementHelper.fillPressElement(stateInputEelement, stateValue, Keys.ENTER);
        LoggerUtility.infoLog("The user fills the state with "+ stateValue);


        elementHelper.fillPressElement(cityInputElement, cityValue, Keys.ENTER);
        LoggerUtility.infoLog("The user fills the city with "+ cityValue);

        elementHelper.clickJSElement(submitElement);
        LoggerUtility.infoLog("The user clocks on submit button");

    }

    public void validateFormValues(String firstNameValue, String lastNameValue, String emailValue, String genderValue,
                                   String mobileValue, List<String> subjectsValue, List<String> hobbyValues,
                                   String uploadValue, String currentAddressValue, String stateValue, String cityValue) {

        elementHelper.validateElementEqualsText(tableDescriptionList.get(0), "Student Name");
        LoggerUtility.infoLog("The user validates the presence of value Student Name");
        elementHelper.validateElementContainsText(tableValueList.get(0), firstNameValue);
        LoggerUtility.infoLog("The user validates the presence of value " + firstNameValue);

        elementHelper.validateElementContainsText(tableValueList.get(0), lastNameValue);
        LoggerUtility.infoLog("The user validates the presence of value " + lastNameValue);


        elementHelper.validateElementEqualsText(tableDescriptionList.get(1), "Student Email");
        LoggerUtility.infoLog("The user validates the presence of value Student Email");

        elementHelper.validateElementContainsText(tableValueList.get(1), emailValue);
        LoggerUtility.infoLog("The user validates the presence of value " + emailValue);


        elementHelper.validateElementEqualsText(tableDescriptionList.get(2), "Gender");
        LoggerUtility.infoLog("The user validates the presence of value Gender");

        elementHelper.validateElementEqualsText(tableValueList.get(2), genderValue);
        LoggerUtility.infoLog("The user validates the presence of value " + genderValue);


        elementHelper.validateElementEqualsText(tableDescriptionList.get(3), "Mobile");
        LoggerUtility.infoLog("The user validates the presence of value Mobile");

        elementHelper.validateElementEqualsText(tableValueList.get(3), mobileValue);
        LoggerUtility.infoLog("The user validates the presence of value " + mobileValue);


        String allSubjects = String.join(", ", subjectsValue);
        elementHelper.validateElementEqualsText(tableDescriptionList.get(5), "Subjects");
        LoggerUtility.infoLog("The user validates the presence of value Subjects");

        elementHelper.validateElementEqualsText(tableValueList.get(5), allSubjects);

        String allHobbies = String.join(", ", hobbyValues);
        elementHelper.validateElementEqualsText(tableDescriptionList.get(6), "Hobbies");
        elementHelper.validateElementEqualsText(tableValueList.get(6), allHobbies);

        //String fileName = uploadValue.substring(19);
        File file = new File(uploadValue);
        elementHelper.validateElementEqualsText(tableDescriptionList.get(7), "Picture");
        elementHelper.validateElementEqualsText(tableValueList.get(7), file.getName());

        elementHelper.validateElementEqualsText(tableDescriptionList.get(8), "Address");
        elementHelper.validateElementEqualsText(tableValueList.get(8), currentAddressValue);

        elementHelper.validateElementEqualsText(tableDescriptionList.get(9), "State and City");
        elementHelper.validateElementContainsText(tableValueList.get(9), stateValue);
        elementHelper.validateElementContainsText(tableValueList.get(9), cityValue);
    }
}
