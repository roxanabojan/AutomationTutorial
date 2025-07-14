package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WebTablePage extends BasePage{

    public WebTablePage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//div[@class='rt-tr -even' or @class='rt-tr -odd']")
    public List<WebElement> tableList;
    @FindBy(id = "addNewRecordButton")
    public WebElement addElement;
    @FindBy(id = "firstName")
    public WebElement firstnameElement;
    @FindBy(id = "lastName")
    public WebElement lastnameElement;
    @FindBy(id = "userEmail")
    public WebElement emailElement;
    @FindBy(id = "age")
    public WebElement ageElement;
    @FindBy(id = "salary")
    public WebElement salaryElement;
    @FindBy(id = "department")
    public WebElement departmentElement;
    @FindBy(id = "submit")
    public WebElement submitElement;

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
                            String ageValue, String salaryValue, String departmentValue){
        elementHelper.validateListSize(tableList, tableSize);

        clickAddButton();
        fillFirstName(firstnameValue);
        fillLastName(lastnameValue);
        fillEmail(emailValue);
        fillAge(ageValue);
        fillSalary(salaryValue);
        fillDepartment(departmentValue);
        clickSubmit();

        elementHelper.validateListSize(tableList,tableSize + 1);
        elementHelper.validateElementContainsText(tableList.get(tableSize), firstnameValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize), lastnameValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize), emailValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize), ageValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize),salaryValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize), departmentValue);
    }

    public void editNewEntry(int tableSize, String editFirstNameValue, String editLastNameValue, String editEmailValue,
                            String editAgeValue, String editSalaryValue, String editDepartmentValue){

        clickEditButton();
        fillEditFirstName(editFirstNameValue);
        fillEditLastName(editLastNameValue);
        fillEditEmail(editEmailValue);
        fillEditAge(editAgeValue);
        fillEditSalary(editSalaryValue);
        fillEditDepartment(editDepartmentValue);
        clickSubmit();

        elementHelper.validateListSize(tableList, tableSize + 1);

        elementHelper.validateElementContainsText(tableList.get(tableSize), editFirstNameValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize), editLastNameValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize), editEmailValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize), editAgeValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize), editSalaryValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize), editDepartmentValue);
    }

    public void deleteNewEntry(int tableSize){
        clickDeleteButton();

        elementHelper.validateListSize(tableList, tableSize);
    }

    public void clickAddButton(){
        elementHelper.clickElement(addElement);
    }

     public void fillFirstName(String firstnameValue){
        elementHelper.fillElement(firstnameElement, firstnameValue);
    }

    public void fillLastName (String lastnameValue){
        elementHelper.fillElement(lastnameElement,lastnameValue);
    }

    public void fillEmail(String emailValue){
        elementHelper.fillElement(emailElement, emailValue);
    }

    public void fillAge (String ageValue){
        elementHelper.fillElement(ageElement, ageValue);
    }

    public void fillSalary(String salaryValue){
        elementHelper.fillElement(salaryElement, salaryValue);
    }

    public void fillDepartment(String departmentValue){
        elementHelper.fillElement(departmentElement, departmentValue);
    }

    public void clickSubmit(){
        elementHelper.clickJSElement(submitElement);
    }

    public void clickEditButton(){
        elementHelper.clickJSElement(editElement);
    }

    public void fillEditFirstName(String firstnameValue){
        elementHelper.clearFillElement(editFirstNameEelement, firstnameValue);
    }

    public void fillEditLastName (String lastnameValue){
        elementHelper.clearFillElement(editLastNameElement,lastnameValue);
    }

    public void fillEditEmail(String emailValue){
        elementHelper.clearFillElement(editEmailEelement, emailValue);
    }

    public void fillEditAge (String ageValue){
        elementHelper.clearFillElement(editAgeEelement, ageValue);
    }

    public void fillEditSalary(String salaryValue){
        elementHelper.clearFillElement(editSalaryEelement, salaryValue);
    }

    public void fillEditDepartment(String departmentValue){
        elementHelper.clearFillElement(editDepartmentEelement, departmentValue);
    }

    public void clickDeleteButton(){
        elementHelper.clickJSElement(deleteElement);
    }
}
