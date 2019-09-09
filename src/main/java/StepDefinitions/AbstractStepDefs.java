package StepDefinitions;

import DriverManager.DriverManager;
import PageObjects.LoginPage;
import PageObjects.Menu;

/**
 * created by Andrei_Korotkov 9/9/2019
 */
public abstract class AbstractStepDefs {
    private LoginPage loginPage = new LoginPage();
    private Menu menu = new Menu();

    public LoginPage onLoginPage () {
        return loginPage;
    }
    public Menu onMenu () {return menu;}

}
