package Runner;

import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;

import DriverManager.DriverManager;

/**
 * created by Andrei_Korotkov 9/9/2019
 */

@RunWith(Cucumber.class)
@CucumberOptions(plugin = "pretty",
        features = "src/main/resources",
        glue = "StepDefinitions",
        tags = "@DraftsTest, @LoginTest")

public class CucumberRunner {

    @AfterClass
    public static void finish () {
        DriverManager.getDriver().quit();
    }
}
