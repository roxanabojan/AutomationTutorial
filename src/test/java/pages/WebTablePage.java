package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.logging.Logger;

public class WebTablePage extends BasePage {

    public WebTablePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='rt-tr -even' or @class='rt-tr -odd']")
    private List<WebElement> tableList;
    @FindBy(id = "addNewRecordButton")
    private WebElement addElement;
    @FindBy(id = "firstName")
    private WebElement firstnameElement;
    @FindBy(id = "lastName")
    private WebElement lastnameElement;
    @FindBy(id = "userEmail")
    private WebElement emailElement;
    @FindBy(id = "age")
    private WebElement ageElement;
    @FindBy(id = "salary")
    private WebElement salaryElement;
    @FindBy(id = "department")
    private WebElement departmentElement;
    @FindBy(id = "submit")
    private WebElement submitElement;

    @FindBy(id = "edit-record-4")
    public WebElement editElement;
    @FindBy(id = "firstName")
    public WebElement editFirstNameEelement;
    @FindBy(id = "lastName")
    public WebElement editLastNameElement;
    @FindBy(id = "userEmail")
    public WebElement editEmailEelement;
    @FindBy(id = "age")
    public WebElement editAgeEelement;
    @FindBy(id = "salary")
    public WebElement editSalaryEelement;
    @FindBy(id = "department")
    public WebElement editDepartmentEelement;
    @FindBy(id = "delete-record-4")
    public WebElement deleteElement;

    public void addNewEntry(int tableSize, String firstnameValue, String lastnameValue, String emailValue,
                            String ageValue, String salaryValue, String departmentValue) {
        elementHelper.validateListSize(tableList, tableSize);
        LoggerUtility.infoLog("The user validates that the table has " + tableSize + " rows");

        clickAddButton();
        LoggerUtility.infoLog("The user clicks on add button");
        fillFirstName(firstnameValue);
        fillLastName(lastnameValue);
        fillEmail(emailValue);
        fillAge(ageValue);
        fillSalary(salaryValue);
        fillDepartment(departmentValue);
        clickSubmit();

        elementHelper.validateListSize(tableList, tableSize + 1);
        LoggerUtility.infoLog("The user validates that the table has " +tableSize +1 +" rows");

        elementHelper.validateElementContainsText(tableList.get(tableSize), firstnameValue);
        LoggerUtility.infoLog("The user validates that the table contains " + firstnameValue + " value");

        elementHelper.validateElementContainsText(tableList.get(tableSize), lastnameValue);
        LoggerUtility.infoLog("The user validates that the table contains " + lastnameValue + " value");

        elementHelper.validateElementContainsText(tableList.get(tableSize), emailValue);
        LoggerUtility.infoLog("The user validates that the table contains " + emailValue + " value");

        elementHelper.validateElementContainsText(tableList.get(tableSize), ageValue);
        LoggerUtility.infoLog("The user validates that the table contains " + ageValue + " value");

        elementHelper.validateElementContainsText(tableList.get(tableSize), salaryValue);
        LoggerUtility.infoLog("The user validates that the table contains " + salaryValue + " value");

        elementHelper.validateElementContainsText(tableList.get(tableSize), departmentValue);
        LoggerUtility.infoLog("The user validates that the table contains " + departmentValue + " value");

    }

    public void editNewEntry(int tableSize, String editFirstNameValue, String editLastNameValue, String editEmailValue,
                             String editAgeValue, String editSalaryValue, String editDepartmentValue) {

        clickEditButton();
        fillEditFirstName(editFirstNameValue);
        fillEditLastName(editLastNameValue);
        fillEditEmail(editEmailValue);
        fillEditAge(editAgeValue);
        fillEditSalary(editSalaryValue);
        fillEditDepartment(editDepartmentValue);
        clickSubmit();

        elementHelper.validateListSize(tableList, tableSize + 1);
        LoggerUtility.infoLog("The user validates that the table has " +tableSize+1 +" rows");
        elementHelper.validateElementContainsText(tableList.get(tableSize), editFirstNameValue);
        LoggerUtility.infoLog("The user validates that the table contains " + editFirstNameValue + " value");
        elementHelper.validateElementContainsText(tableList.get(tableSize), editLastNameValue);
        LoggerUtility.infoLog("The user validates that the table contains " + editLastNameValue + " value");

        elementHelper.validateElementContainsText(tableList.get(tableSize), editEmailValue);
        LoggerUtility.infoLog("The user validates that the table contains " + editEmailValue + " value");

        elementHelper.validateElementContainsText(tableList.get(tableSize), editAgeValue);
        LoggerUtility.infoLog("The user validates that the table contains " + editAgeValue + " value");

        elementHelper.validateElementContainsText(tableList.get(tableSize), editSalaryValue);
        LoggerUtility.infoLog("The user validates that the table contains " + editSalaryValue + " value");

        elementHelper.validateElementContainsText(tableList.get(tableSize), editDepartmentValue);
        LoggerUtility.infoLog("The user validates that the table contains " + editDepartmentValue + " value");

    }

    public void deleteNewEntry(int tableSize) {
        clickDeleteButton();

        elementHelper.validateListSize(tableList, tableSize);
    }

    public void clickAddButton() {
        elementHelper.clickElement(addElement);
    }

    public void fillFirstName(String firstnameValue) {
        elementHelper.fillElement(firstnameElement, firstnameValue);
        LoggerUtility.infoLog("The user fills first name field with value" + firstnameValue);
    }

    public void fillLastName(String lastnameValue) {
        elementHelper.fillElement(lastnameElement, lastnameValue);
        LoggerUtility.infoLog("The user fills last name field with value" + lastnameValue);

    }

    public void fillEmail(String emailValue) {
        elementHelper.fillElement(emailElement, emailValue);
        LoggerUtility.infoLog("The user fills email field with value" + emailValue);

    }

    public void fillAge(String ageValue) {
        elementHelper.fillElement(ageElement, ageValue);
        LoggerUtility.infoLog("The user fills age field with value" + ageValue);

    }

    public void fillSalary(String salaryValue) {
        elementHelper.fillElement(salaryElement, salaryValue);
        LoggerUtility.infoLog("The user fills salary field with value" + salaryValue);

    }

    public void fillDepartment(String departmentValue) {
        elementHelper.fillElement(departmentElement, departmentValue);
        LoggerUtility.infoLog("The user fills departement field with value" + departmentValue);

    }

    public void clickSubmit() {
        elementHelper.clickJSElement(submitElement);
        LoggerUtility.infoLog("The user clicks on submit button");
    }

    public void clickEditButton() {
        elementHelper.clickJSElement(editElement);
        LoggerUtility.infoLog("The user clicks on edit button");

    }

    public void fillEditFirstName(String firstnameValue) {
        elementHelper.clearFillElement(editFirstNameEelement, firstnameValue);
        LoggerUtility.infoLog("The user fills first name field with value" + firstnameValue);

    }

    public void fillEditLastName(String lastnameValue) {
        elementHelper.clearFillElement(editLastNameElement, lastnameValue);
        LoggerUtility.infoLog("The user fills last name field with value" + lastnameValue);


    }

    public void fillEditEmail(String emailValue) {
        elementHelper.clearFillElement(editEmailEelement, emailValue);
        LoggerUtility.infoLog("The user fills email field with value" + emailValue);

    }

    public void fillEditAge(String ageValue) {
        elementHelper.clearFillElement(editAgeEelement, ageValue);
        LoggerUtility.infoLog("The user fills age field with value" + ageValue);

    }

    public void fillEditSalary(String salaryValue) {
        elementHelper.clearFillElement(editSalaryEelement, salaryValue);
        LoggerUtility.infoLog("The user fills salary field with value" + salaryValue);

    }

    public void fillEditDepartment(String departmentValue) {
        elementHelper.clearFillElement(editDepartmentEelement, departmentValue);
        LoggerUtility.infoLog("The user fills department field with value" + departmentValue);

    }

    public void clickDeleteButton() {
        elementHelper.clickJSElement(deleteElement);
        LoggerUtility.infoLog("The user clicks on delete button");

    }

}
