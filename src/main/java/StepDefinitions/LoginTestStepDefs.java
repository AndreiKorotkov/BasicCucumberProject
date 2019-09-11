package StepDefinitions;

import DriverManager.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginTestStepDefs extends AbstractStepDefs {

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

    @And("I click Input password button on Login Page")
    public void i_Click_Input_password_Button_on_Login_Page() {
        onLoginPage().pressEnterPasswordButton();
    }

    @And("input password as {string}")
    public void input_Password(String arg0) {
        onLoginPage().enterPassword(arg0);
    }

    @And("I click login button on Login Page")
    public void i_Click_Login_Button_on_Login_Page() {
        onLoginPage().loginToMailBox();
    }

    @Then("I am on my inbox page")
    public void i_Am_On_My_Inbox_Page() {
        Assert.assertEquals("dfjwgge82h43g3uriy53h@bk.ru", onMenu().readCurrentUsername());
    }

    @Then("Wrong login message is visible")
    public void wrong_Login_Message_Is_Visible() {
        onLoginPage().isLoginErrorMessageVisible();
    }

}
