package tests;

import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.IndexPage;
import pages.WebTablePage;
import sharedData.SharedData;

public class WebTablesTest extends SharedData {

    @Test
    public void TestMethod() {

        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.interactWithElementsMenu();

        ElementsPage elementsPage = new ElementsPage(getDriver());
        elementsPage.interactWithWebTablesSubMenu();

        int tableSize = 3;
        String firstnameValue = "Roxana";
        String lastnameValue = "Bojan";
        String emailValue = "test@test.com";
        String ageValue = "30";
        String salaryValue = "3000";
        String departmentValue = "contabilitate";
        String editFirstNameValue = "ada";
        String editLastNameValue = "pop";
        String editEmailValue = "test1@testest.com";
        String editAgeValue = "40";
        String editSalaryValue = "40";
        String editDepartmentValue = "Finante";

        WebTablePage webTablePage = new WebTablePage(getDriver());
        webTablePage.addNewEntry(tableSize, firstnameValue, lastnameValue, emailValue, ageValue,
                salaryValue, departmentValue);
        webTablePage.editNewEntry(tableSize, editFirstNameValue, editLastNameValue, editEmailValue, editAgeValue,
                editSalaryValue, editDepartmentValue);

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='rt-tr -even' or @class='rt-tr -odd']")));

        webTablePage.deleteNewEntry(tableSize);
    }
}
