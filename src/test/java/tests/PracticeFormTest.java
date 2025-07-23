package tests;

import helperMethods.ElementHelper;
import helperMethods.PageHelper;
import org.testng.annotations.Test;
import pages.FormsPage;
import pages.IndexPage;
import pages.PracticeFormPage;
import sharedData.SharedData;

import java.util.Arrays;
import java.util.List;

public class PracticeFormTest extends SharedData {

    @Test
    public void testMethod() {

        ElementHelper elementHelper = new ElementHelper(getDriver());
        PageHelper pageHelper = new PageHelper(getDriver());

        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.interactWithFormsMenu();

        FormsPage formsPage = new FormsPage(getDriver());
        formsPage.interactPracticeFormSubMenu();

        String firstNameValue = "Roxana";
        String lastNameValue = "Bojan";
        String emailValue = "test@test.com";
        String mobileValue = "0744122133";
        List<String> subjectsValue = Arrays.asList("Maths", "Arts", "Accounting", "Social Studies");
        String genderValue = "Female";
        List<String> hobbyValues = Arrays.asList("Sports", "Reading");
        String uploadValue = "src/test/resources/epix.jpg";
        String currentAddressValue = "str. Horea, nr.49";
        String stateValue = "NCR";
        String cityValue = "Delhi";

        PracticeFormPage practiceFormPage = new PracticeFormPage(getDriver());
        practiceFormPage.fillEntireForm(firstNameValue, lastNameValue, emailValue, mobileValue, subjectsValue,
                genderValue, hobbyValues, uploadValue, currentAddressValue, stateValue, cityValue);

        practiceFormPage.validateFormValues(firstNameValue, lastNameValue, emailValue, genderValue, mobileValue,
                subjectsValue, hobbyValues, uploadValue, currentAddressValue, stateValue, cityValue);
    }
}