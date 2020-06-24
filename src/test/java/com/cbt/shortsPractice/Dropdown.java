package com.cbt.shortsPractice;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Dropdown {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
         driver = BrowserFactory.getDriver("chrome");
        assert driver != null;
         driver.get("http://practice.cybertekschool.com/dropdown");
         utils.wait(2);
    }

    @Test(description = "Select the first option from Simple dropdown")
    public void selectByText(){
        //create select object from Select class (comes from Selenium)
    Select select = new Select(driver.findElement(By.id("dropdown")));
    utils.wait(2);
    //The constructor, which requires webelement argument
        select.selectByVisibleText("Option 1");
    }

    @Test(description = "Select Colorado state by value")
    public void selectByValue(){
        Select select = new Select(driver.findElement(By.id("state")));
        select.selectByValue("CO");
        String expected = "Colorado";
        String actual = select.getFirstSelectedOption().getText();
        Assert.assertEquals(actual, expected, "The selected state is not Colorado");
        utils.wait(2);
    }

    @Test(description = "Select Alabama by index")
    public void selectByIndex(){
        Select select = new Select(driver.findElement(By.id("state")));
        select.selectByIndex(1);
        //index in html starts from 1
        //and since the first choice is disabled, probably, it does not count,
        //that is why Alabama got selected.
        String expected = "Alabama";
        String actual = select.getFirstSelectedOption().getText();
        System.out.println("Expected: "+expected);//Alabama
        System.out.println("Actual: "+actual);//Alabama

        //make sure that the value is AL:
        String expectedValue="AL";
        String actualValue=select.getFirstSelectedOption().getAttribute("value");
        System.out.println("Expected value: "+expectedValue);//AL
        System.out.println("Actual value: "+actualValue);//AL
    }

    @Test(description = "Select all options one by one and then deselect them")
    public void selectMultiple(){
        Select select = new Select(driver.findElement(By.name("Languages")));
        //select all options one by one:
        List<WebElement> options = select.getOptions();
        for(WebElement option:options){
            select.selectByVisibleText(option.getText());
            utils.wait(1);
        }

        //print all selectes options:'
        List<WebElement> selectedOptions = select.getAllSelectedOptions();
            for (WebElement option : selectedOptions){
                System.out.println(option.getText());
            }
        utils.wait(1);
        select.deselectByValue("js");//can deselect by index or visible text as well
        utils.wait(1);
        select.deselectAll();//deselects all selected options at once
    }

    @Test(description = "Select from non-select dropdown")
    public void nonSelectDropdown(){
        //non-select dropdown does not have select tag, so we cannot use Select class here

        //create webelement:
        WebElement dropdown = driver.findElement(By.id("dropdownMenuLink"));
        WebElement option = driver.findElement(By.xpath("//a[text()='Yahoo']"));

        //to access the options in non-select dropdown, first click the dropdownMenuLink,
        //otherwise it gives exception
        dropdown.click();
        utils.wait(1);

        //and then click desired option:
        option.click();
        utils.wait(3);
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
