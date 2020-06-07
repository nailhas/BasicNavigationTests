package com.cbt.hw2;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class TestCase2_examplesNumber {
    public static void main(String[] args) {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        assert driver != null;
        driver.manage().window().maximize();
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        utils.wait(3);

        List<WebElement> examples = driver.findElements(By.xpath("//a"));
        for(WebElement webElement : examples){
        }
        int actualExamples=examples.size();
        System.out.println(actualExamples);
        int expectedExamples=48;

        Assert.assertEquals(actualExamples, expectedExamples, "Example number is not as expected");
        // java.lang.AssertionError: Example number is not as expected expected [48] but found [50]
        driver.quit();
    }
}
