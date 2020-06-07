package com.cbt.hw2;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TestCase3_button1Message {
    public static void main(String[] args) {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        assert driver != null;
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com");
        utils.wait(3);

        //click Multiple Buttons:
        driver.findElement(By.xpath("//a[@href=\"/multiple_buttons\"]")).click();
        utils.wait(2);

        //click Button 1:
        driver.findElement(By.xpath("//button[@onclick='button1()']")).click();

        String expectedMessage="Clicked on button one!";
        String actualMessage = driver.findElement(By.cssSelector("#result")).getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Message is different");
        driver.quit();
    }
}
