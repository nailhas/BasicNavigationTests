package com.cbt.hw2_1;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase9_12 {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver= BrowserFactory.getDriver("chrome");
        assert driver != null;
        driver.get("https://practice-cybertekschool.herokuapp.com");

        //click on “Status Codes” link:
        driver.findElement(By.linkText("Status Codes")).click();
    }

    @Test(description = "Verify the message displayed - This page returned a 301 status code.")
    public void StatusCodeMessage301(){
        WebElement code301 = driver.findElement(By.linkText("301"));
        code301.click();

        WebElement codeMessage = driver.findElement(By.xpath("//br/parent::p"));
        System.out.println(codeMessage.getText());
    }

    @Test(description = "Verify the message displayed - This page returned a 200 status code.")
    public void StatusCodeMessage200(){
        WebElement code200 = driver.findElement(By.linkText("200"));
        code200.click();

        WebElement codeMessage = driver.findElement(By.xpath("//br/parent::p"));
        System.out.println(codeMessage.getText());
    }

    @Test(description = "Verify the message displayed - This page returned a 404 status code.")
    public void StatusCodeMessage404(){
        WebElement code404 = driver.findElement(By.linkText("404"));
        code404.click();

        WebElement codeMessage = driver.findElement(By.xpath("//br/parent::p"));
        System.out.println(codeMessage.getText());
    }

    @Test(description = "Verify the message displayed - This page returned a 500 status code.")
    public void StatusCodeMessage500(){
        WebElement code500 = driver.findElement(By.linkText("500"));
        code500.click();

        WebElement codeMessage = driver.findElement(By.xpath("//br/parent::p"));
        System.out.println(codeMessage.getText());
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
