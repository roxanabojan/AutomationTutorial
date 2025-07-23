package tests;

import org.testng.annotations.Test;
import pages.AlertFrameWindowPage;
import pages.AlertPage;
import pages.IndexPage;
import sharedData.SharedData;


public class AlertsTest extends SharedData {

    @Test
    public void testMethod() {

        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.interactWithAlertsFrameWindowMenu();

        AlertFrameWindowPage alertFrameWindowPage = new AlertFrameWindowPage(getDriver());
        alertFrameWindowPage.interctWithAlertsSubMenu();

        AlertPage alertPage = new AlertPage(getDriver());
        alertPage.dealAlertOk();
        alertPage.dealAlertTimer();
        alertPage.dealAlertCancel();
        alertPage.dealAlertPrompt("Formula 1");
    }
}
