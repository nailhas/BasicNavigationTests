package com.cbt.hw2_1;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class TestCase8_autocomplete {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        assert driver != null;
        driver.get("https://practice-cybertekschool.herokuapp.com");

        //Click Autocomplete link:
        driver.findElement(By.linkText("Autocomplete")).click();

        //Enter “United States of America” into the Country input box:
        driver.findElement(By.id("myCountry")).sendKeys("United States of America");

        //Click Submit button:
        driver.findElement(By.xpath("//input [@value='Submit']")).click();

        //Verify that following message is displayed: “You selected: United States of America”:
        WebElement actualMessage = driver.findElement(By.id("result"));
        String expectedMessage = "You selected: United States of America";
        Assert.assertEquals(actualMessage.getText(),expectedMessage, "The message is wrong!");

        driver.quit();
    }
}
