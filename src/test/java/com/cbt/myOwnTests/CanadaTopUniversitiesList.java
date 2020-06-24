package com.cbt.myOwnTests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CanadaTopUniversitiesList {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        assert driver != null;
        driver.get("https://www.topuniversities.com/universities/country/canada/subject/medicine");
        List<WebElement> canadaUniversities = driver.findElements(By.xpath("//h2[contains(text(), 'Univer')]"));
        for (WebElement webElement : canadaUniversities) {
            utils.wait(2);
           if (!webElement.getText().isEmpty()) {
                System.out.println(webElement.getText());
            }
        }
        System.out.println("Number of top Canadian universities is: "+canadaUniversities.size());
        driver.quit();
    }
}
