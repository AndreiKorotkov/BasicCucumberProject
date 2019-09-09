package StepDefinitions;

import DriverManager.DriverManager;
import PageObjects.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


/**
 * created by Andrei_Korotkov 9/9/2019
 */
public class MyStepdefs extends AbstractStepDefs{

    @Given("I open mailbox page")
    public void i_Open_MailBox_Page() {
        DriverManager.getDriver().get("https://mail.ru//");
    }

    @When("I input login as {string}")
    public void iInputLoginAs(String arg0) {
        onLoginPage().enterLogin(arg0);
    }

    @And("I choose domain as {string}")
    public void i_Choose_Domain(String arg0) {
        onLoginPage().chooseDomain(arg0);
    }

    @And("I click Input password button")
    public void i_Click_Input_password_Button() {
        onLoginPage().pressEnterPasswordButton();
    }

    @And("input password as {string}")
    public void input_Password(String arg0) {
        onLoginPage().enterPassword(arg0);
    }

    @And("I click login button")
    public void i_Click_Login_Button() {
        onLoginPage().loginToMailBox();
    }

    @Then("I am on my inbox page")
    public void i_Am_On_My_Inbox_Page() {
        Assert.assertEquals("https://e.mail.ru/inbox/?back=1&afterReload=1", onLoginPage().getInboxUrl());
    }


    @Then("Wrong login message is visible")
    public void wrongLoginMessageIsVisible() {
        onLoginPage().isLoginErrorMessageVisible();
    }

    @Given("I login to mailbox")
    public void iLoginToMailbox() {
        onLoginPage().loginToMail();
    }


}
