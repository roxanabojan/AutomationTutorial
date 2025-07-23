package tests;

import org.testng.annotations.Test;
import pages.AlertFrameWindowPage;
import pages.FramesPage;
import pages.IndexPage;
import sharedData.SharedData;

public class FrameTest extends SharedData {

    @Test
    public void testMethod() {
        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.interactWithAlertsFrameWindowMenu();

        AlertFrameWindowPage alertFrameWindowPage = new AlertFrameWindowPage(getDriver());
        alertFrameWindowPage.interactWithFramesSubMenu();

        FramesPage framesPage = new FramesPage(getDriver());
        framesPage.dealWithBigIFrame();
        framesPage.dealWithLittleIFrame();
    }
}
