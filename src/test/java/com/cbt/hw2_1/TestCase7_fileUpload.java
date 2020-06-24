package com.cbt.hw2_1;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TestCase7_fileUpload {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        assert driver != null;
        driver.get("https://practice-cybertekschool.herokuapp.com");

        //Click File Upload link:
        driver.findElement(By.linkText("File Upload")).click();

        //Upload a file from PC:
        driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\Nailia\\Desktop\\FileToUpload.txt");

        //Click Submit button:
        driver.findElement(By.cssSelector("#file-submit")).click();

        //Verify that the message is File Uploaded!
        System.out.println(driver.findElement(By.tagName("h3")).getText());//File Uploaded!

        //Verify that the name of the uploaded file is displayed:
        String actualMessage = driver.findElement(By.id("uploaded-files")).getText();
        System.out.println(actualMessage);
        String expectedMessage = "FileToUpload.txt";
        Assert.assertEquals(actualMessage,expectedMessage, "The message is wrong!");

        driver.quit();
    }
}
