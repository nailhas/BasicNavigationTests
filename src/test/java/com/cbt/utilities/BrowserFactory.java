package com.cbt.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
    public static WebDriver getDriver(String browser){
        if(browser.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }else if(browser.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }else if(browser.equals("safari")){
            return null;
        }else if(browser.equals("edge")){
            WebDriverManager.edgedriver().setup();
            return new EdgeDriver();
        }
        return null;
    }
}
