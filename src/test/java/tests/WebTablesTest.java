package tests;

import helperMethods.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import sharedData.SharedData;

import java.time.Duration;
import java.util.List;

public class WebTablesTest extends SharedData {

    @Test
    public void TestMethod (){

        ElementHelper elementHelper = new ElementHelper(driver);

        WebElement elementsMenu = driver.findElement(By.xpath("//h5[text()='Elements']"));
        elementHelper.clickJSElement(elementsMenu);

        WebElement webTablesSubMenu = driver.findElement(By.xpath("//span[text()='Web Tables']"));
        elementHelper.clickJSElement(webTablesSubMenu);

        List<WebElement> tableList = driver.findElements(By.xpath("//div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        int tableSize = 3;
        elementHelper.validateListSize(tableList, tableSize);

        //Identificam un element.
        WebElement addElement = driver.findElement(By.id("addNewRecordButton"));
        elementHelper.clickElement(addElement);

        WebElement firstnameElement = driver.findElement(By.id("firstName"));
        String firstnameValue = "Roxana";
        elementHelper.fillElement(firstnameElement, firstnameValue);

        WebElement lastnameElement = driver.findElement(By.id("lastName"));
        String lastnameValue = "Bojan";
        elementHelper.fillElement(lastnameElement,lastnameValue);

        WebElement emailElement = driver.findElement(By.id("userEmail"));
        String emailValue = "test@test.com";
        elementHelper.fillElement(emailElement, emailValue);

        WebElement ageElement = driver.findElement(By.id("age"));
        String ageValue = "30";
        elementHelper.fillElement(ageElement, ageValue);

        WebElement salaryElement = driver.findElement(By.id("salary"));
        String salaryValue = "3000";
        elementHelper.fillElement(salaryElement, salaryValue);

        WebElement departmentElement = driver.findElement(By.id("department"));
        String departmentValue = "contabilitate";
        elementHelper.fillElement(departmentElement, departmentValue);

        WebElement submitElement = driver.findElement(By.id("submit"));
        elementHelper.clickJSElement(submitElement);
        //acest cod de javascript ajuta cand nu merge comanda normala de click (forteaza cumva sa treaca de orice
        // si sa faca click pe buton)

        tableList = driver.findElements(By.xpath("//div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        elementHelper.validateListSize(tableList,tableSize + 1);

//        tableList = driver.findElements(By.xpath("//div[@class='rt-tr -even' or @class='rt-tr -odd']"));
//        elementHelper.validateListSize(tableList, tableSize + 1);

        elementHelper.validateElementContainsText(tableList.get(tableSize), firstnameValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize), lastnameValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize), emailValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize), ageValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize),salaryValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize), departmentValue);

        //Edit functionlity
        WebElement editElement = driver.findElement(By.id("edit-record-4"));
        elementHelper.clickJSElement(editElement);

        WebElement editFirstNameEelement = driver.findElement(By.id("firstName"));
        String editFirstNameValue = "ada";
        elementHelper.clearFillElement(editFirstNameEelement, editFirstNameValue);

        WebElement editLastNameElement = driver.findElement(By.id("lastName"));
        String editLastNameValue = "pop";
        editLastNameElement.clear();
        elementHelper.fillElement(editLastNameElement, editLastNameValue);

        WebElement editEmailEelement = driver.findElement(By.id("userEmail"));
        String editEmailValue = "test1@testest.com";
        editEmailEelement.clear();
        elementHelper.fillElement(editEmailEelement, editEmailValue);

        WebElement editAgeEelement = driver.findElement(By.id("age"));
        String editAgeValue = "40";
        editAgeEelement.clear();
        elementHelper.fillElement(editAgeEelement, editAgeValue);

        WebElement editSalaryEelement = driver.findElement(By.id("salary"));
        String editSalaryValue = "40";
        editSalaryEelement.clear();
        elementHelper.fillElement(editSalaryEelement, editSalaryValue);

        WebElement editDepartmentEelement = driver.findElement(By.id("department"));
        String editDepartmentValue = "Finante";
        editDepartmentEelement.clear();
        elementHelper.fillElement(editDepartmentEelement, editDepartmentValue);

        WebElement editLine = driver.findElement(By.id("submit"));
        elementHelper.clickJSElement(editLine);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='rt-tr -even' or @class='rt-tr -odd']")));

        tableList = driver.findElements(By.xpath("//div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        elementHelper.validateListSize(tableList, tableSize + 1);

       elementHelper.validateElementContainsText(tableList.get(tableSize), editFirstNameValue);
       elementHelper.validateElementContainsText(tableList.get(tableSize), editLastNameValue);
       elementHelper.validateElementContainsText(tableList.get(tableSize), editEmailValue);
       elementHelper.validateElementContainsText(tableList.get(tableSize), editAgeValue);
       elementHelper.validateElementContainsText(tableList.get(tableSize), editSalaryValue);
       elementHelper.validateElementContainsText(tableList.get(tableSize), editDepartmentValue);

        //Delete element
        WebElement deleteElement = driver.findElement(By.id("delete-record-4"));
        elementHelper.clickJSElement(deleteElement);

        tableList = driver.findElements(By.xpath("//div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        elementHelper.validateListSize(tableList, tableSize);
    }
}
