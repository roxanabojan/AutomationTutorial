package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WebTablesTest {
    public WebDriver driver;

    @Test
    public void TestMethod (){
        //Deschidem o instanta de Chrome.
        driver = new ChromeDriver();

        //Accesam o pagina specifica.
        driver.get("https://demoqa.com");

        //Facem browserul sa fie in modul maximize.
        driver.manage().window().maximize();

        WebElement elementsMenu = driver.findElement(By.xpath("//h5[text()='Elements']"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", elementsMenu);

        WebElement webTablesSubMenu = driver.findElement(By.xpath("//span[text()='Web Tables']"));
        executor.executeScript("arguments[0].click();", webTablesSubMenu);

        List<WebElement> tableList = driver.findElements(By.xpath("//div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        int tableSize = 3;
        Assert.assertEquals(tableList.size(), tableSize, "Expected table size: " + tableSize + " is not correct");

        //Identificam un element.
        WebElement addElement = driver.findElement(By.id("addNewRecordButton"));
        addElement.click();

        WebElement firstnameElement = driver.findElement(By.id("firstName"));
        String firstnameValue = "Roxana";
        firstnameElement.sendKeys(firstnameValue);

        WebElement lastnameElement = driver.findElement(By.id("lastName"));
        String lastnameValue = "Bojan";
        lastnameElement.sendKeys(lastnameValue);

        WebElement emailElement = driver.findElement(By.id("userEmail"));
        String emailValue = "test@test.com";
        emailElement.sendKeys(emailValue);

        WebElement ageElement = driver.findElement(By.id("age"));
        String ageValue = "30";
        ageElement.sendKeys(ageValue);

        WebElement salaryElement = driver.findElement(By.id("salary"));
        String salaryValue = "3000";
        salaryElement.sendKeys(salaryValue);

        WebElement departmentElement = driver.findElement(By.id("department"));
        String departmentValue = "contabilitate";
        departmentElement.sendKeys(departmentValue);

        WebElement submitElement = driver.findElement(By.id("submit"));
        executor.executeScript("arguments[0].click();", submitElement);
        //acest cod de javascript ajuta cand nu merge comanda normala de click (forteaza cumva sa treaca de orice
        // si sa faca click pe buton)

        tableList = driver.findElements(By.xpath("//div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        Assert.assertEquals(tableList.size(), tableSize +1);
        Assert.assertTrue(tableList.get(tableSize).getText().contains(firstnameValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(lastnameValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(emailValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(ageValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(salaryValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(departmentValue));

        //Edit functionlity
        WebElement editElement = driver.findElement(By.id("edit-record-4"));
        editElement.click();

        WebElement editFirstNameEelement = driver.findElement(By.id("firstName"));
        String editFirstNameValue = "ada";
        editFirstNameEelement.clear();
        editFirstNameEelement.sendKeys(editFirstNameValue);

        WebElement editLastNameEelement = driver.findElement(By.id("lastName"));
        String editLastNameValue = "pop";
        editLastNameEelement.clear();
        editLastNameEelement.sendKeys(editLastNameValue);

        WebElement editEmailEelement = driver.findElement(By.id("userEmail"));
        String editEmailValue = "test1@testest.com";
        editEmailEelement.clear();
        editEmailEelement.sendKeys(editEmailValue);

        WebElement editAgeEelement = driver.findElement(By.id("age"));
        String editAgeValue = "40";
        editAgeEelement.clear();
        editAgeEelement.sendKeys(editAgeValue);

        WebElement editSalaryEelement = driver.findElement(By.id("salary"));
        String editSalaryValue = "40";
        editSalaryEelement.clear();
        editSalaryEelement.sendKeys(editSalaryValue);

        WebElement editDepartmentEelement = driver.findElement(By.id("department"));
        String editDepartmentValue = "Finante";
        editDepartmentEelement.clear();
        editDepartmentEelement.sendKeys(editDepartmentValue);

        WebElement editLine = driver.findElement(By.id("submit"));
        executor.executeScript("arguments[0].click();", editLine);

        tableList = driver.findElements(By.xpath("//div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        Assert.assertEquals(tableList.size(), tableSize +1);
        Assert.assertTrue(tableList.get(tableSize).getText().contains(editFirstNameValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(editLastNameValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(editEmailValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(editAgeValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(editSalaryValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(editDepartmentValue));

        //Delete element
        WebElement deleteElement = driver.findElement(By.id("delete-record-4"));
        deleteElement.click();

        tableList = driver.findElements(By.xpath("//div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        Assert.assertEquals(tableList.size(), tableSize);

        driver.quit();
    }
}
