package tests;

import helperMethods.ElementHelper;
import helperMethods.TabHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import sharedData.SharedData;

import java.util.ArrayList;
import java.util.List;

public class WindowsTest extends SharedData {

    @Test
    public void testMethod(){

        ElementHelper elementHelper = new ElementHelper(driver);
        TabHelper tabHelper = new TabHelper(driver);

        WebElement alertFrameWindowMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        elementHelper.clickJSElement(alertFrameWindowMenu);

        WebElement browserWindowsSubMenu = driver.findElement(By.xpath("//span[text()='Browser Windows']"));
        elementHelper.clickJSElement(browserWindowsSubMenu);

        WebElement newTabElement = driver.findElement(By.id("tabButton"));
        elementHelper.clickElement(newTabElement);
        System.out.println(driver.getCurrentUrl());

        tabHelper.switchToSpecificTab(1);

        tabHelper.closeCurrentTab();

        tabHelper.switchToSpecificTab(0);

        //din cauza reclamei fortam site-ul sa acceseze un URL specific
        //diferenta dintre get si navigate -> get asteapta sa se incarce
        //driver.navigate().to("https://demoqa.com/browser-windows");

        WebElement newWindow = driver.findElement(By.id("windowButton"));
        elementHelper.clickElement(newWindow);
        System.out.println(driver.getCurrentUrl());

        tabHelper.switchToSpecificTab(1);
        tabHelper.closeCurrentTab();
        tabHelper.switchToSpecificTab(0);
    }
}
