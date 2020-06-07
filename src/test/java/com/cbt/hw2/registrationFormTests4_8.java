package com.cbt.hw2;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class registrationFormTests4_8 {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        assert driver != null;
        driver.get("http://practice.cybertekschool.com");
        utils.wait(2);
        //click Registration Form link:
        driver.findElement(By.linkText("Registration Form")).click();
    }

    @Test(description = "Verify that warning message is displayed:\n" +
            "“first name can only consist of alphabetical letters”")
     public void test4() {
        //Enter 123 into first name input box:
        driver.findElement(By.xpath("//input[@placeholder='first name']")).sendKeys("123");
        //Verify the message" first name can only consist of alphabetical letters":
        WebElement actualMessage = driver.findElement(By.xpath("//div/small[3]"));
        Assert.assertEquals(actualMessage.getText(), "first name can only consist of alphabetical letters");
    }

    @Test(description = "Verify that warning message is displayed:\n" +
            "“The last name can only consist of alphabetical\n" + "letters and dash”")
    public void test5() {
        //enter 123 into the Last Name input box:
        driver.findElement(By.xpath("//input[@placeholder='last name']")).sendKeys("123");
        utils.wait(2);
        //Verify the message: The last name can only consist of alphabetical letters and dash
        WebElement actualMessage = driver.findElement(By.xpath("//small[contains(text(),'and dash')]"));
        utils.wait(2);
        Assert.assertEquals(actualMessage.getText(), "The last name can only consist of alphabetical letters and dash");
    }

    @Test(description = "Verify that warning message is displayed:\n" +
            "“The username must be more than 6 and less than\n" + "30 characters long”")
    public void test6() {
        //enter user into the username input box:
        driver.findElement(By.xpath("//input[@placeholder='username']")).sendKeys("user");
        //Verify the message: The username must be more than 6 and less than 30 characters long”
        WebElement actualMessage = driver.findElement(By.xpath("//small[contains(text(),'more than 6 and less than 30 characters')]"));
        utils.wait(2);
        Assert.assertEquals(actualMessage.getText(), "The username must be more than 6 and less than 30 characters long");
    }

    @Test(description = "Verify that warning message is displayed:“email address is not a valid\n" +
            "Email format is not correct”")
    public void test7() {
        //enter user into the email input box:
        driver.findElement(By.xpath("//input[@placeholder='email@email.com']")).sendKeys("testers@email");
        //Verify the message: email address is not a valid Email format is not correct
        WebElement actualMessage1 = driver.findElement(By.xpath("//small[contains(text(),'email address is not a valid')]"));
        WebElement actualMessage2 = driver.findElement(By.xpath("//small[contains(text(),'Email format is not correct')]"));
        Assert.assertEquals(actualMessage1.getText(), "email address is not a valid");
        Assert.assertEquals(actualMessage2.getText(), "Email format is not correct");
    }

    @Test(description = "Verify that warning message is displayed:\n" + "“Phone format is not correct”")
    public void test8() {
        //enter user into the phone number input box:
        driver.findElement(By.xpath("//input[@placeholder='571-000-0000']")).sendKeys("5711234354");
        //Verify the message: Phone format is not correct
        WebElement actualMessage = driver.findElement(By.xpath("//small[contains(text(),'Phone format is not correct')]"));
        utils.wait(2);
        Assert.assertEquals(actualMessage.getText(), "Phone format is not correct");
    }

    @Test(description = "Verify that warning message is displayed: The password must have at least 8 characters")
    public void test9() {
        //enter user into the password input box:
        driver.findElement(By.xpath("//input[@data-bv-field='password']")).sendKeys("1234");
        //Verify the message: The password must have at least 8 characters
        WebElement actualMessage = driver.findElement(By.xpath("//small[contains(text(),'at least 8')]"));
        utils.wait(2);
        Assert.assertEquals(actualMessage.getText(), "The password must have at least 8 characters");
    }

    @Test(description = "Select 'female' radio button and confirm it is selected")
    public void test10() {
        //select 'female' radio button
        WebElement radioButton = driver.findElement(By.xpath("//input[@value='female']"));
        radioButton.click();
        System.out.println(radioButton.getAttribute("value"));
    }

    @Test(description = "Enter 01012000 into 'Date of birth' input box and verify that the message: The date of birth is not valid")
    public void test11() {
        // driver.findElement(By.xpath("//input[@value='other']")).click();
        driver.findElement(By.xpath("//input[@placeholder='MM/DD/YYYY']")).sendKeys("01012000");
        //Verify the message: The date of birth is not valid
        WebElement actualMessage = driver.findElement(By.xpath("//small[contains(text(),'The date of birth is not valid')]"));
        Assert.assertEquals(actualMessage.getText(), "The date of birth is not valid");
    }

    @Test(description = "Select Tresurer's Office from Department / Office dropdown and verify that it is selected")
    public void test12() {
        //select the department/office from dropdown menu:
        Select department = new Select(driver.findElement(By.name("department")));
        utils.wait(2);
        department.selectByVisibleText("Tresurer's Office");
        System.out.println(department.getFirstSelectedOption().getAttribute("value"));//TRO
    }

    @Test(description = "Select Product Owner from Job Title dropdown and verify that it is selected")
    public void test13() {
        //select job title from dropdown menu:
        Select jobTitle = new Select(driver.findElement(By.name("job_title")));
        jobTitle.selectByVisibleText("Product Owner");
        System.out.println(jobTitle.getFirstSelectedOption().getAttribute("value"));
    }

    @Test(description = "Select Java, select all, print all checkboxes' values")
    public void test14() {
        //select language (Java):
        driver.findElement(By.xpath("//input[@value='java']")).click();
        utils.wait(2);

        //find all elements with type='checkbox':
        List<WebElement> languages = driver.findElements(By.xpath("//input[@type='checkbox']"));
        //click each of the elements ans print their values:
        for (WebElement language : languages){
            if (!language.isSelected()) {
                language.click();
                utils.wait(1);
            }
            System.out.println(language.getAttribute("value"));
        }
    }

    @Test(description = "Click Sign-up button")
    public void test15() {
        //click sign-up button:
        WebElement signUpButton = driver.findElement(By.xpath("//button[text()='Sign up']"));
        if (signUpButton.isEnabled()){
            signUpButton.click();
        }else {
            System.out.println("Sign-up button is disabled");
        }
    }

        @AfterMethod
        public void teardown(){
            driver.quit();
        }
    }
