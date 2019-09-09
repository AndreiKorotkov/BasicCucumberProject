package StepDefinitions;

import DriverManager.DriverManager;
import PageObjects.LoginPage;

/**
 * created by Andrei_Korotkov 9/9/2019
 */
public abstract class AbstractStepDefs {
    private LoginPage loginPage = new LoginPage();

    public LoginPage onLoginPage () {
        return loginPage;
    }

}
