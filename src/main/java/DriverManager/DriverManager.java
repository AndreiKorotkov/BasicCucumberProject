package DriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * created by Andrei_Korotkov 9/9/2019
 */
public class DriverManager {

    public static WebDriver driver;

    public static WebDriver getDriver () {
        if (driver == null) {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver= new ChromeDriver(options);
        }
        return driver;
    }
}
