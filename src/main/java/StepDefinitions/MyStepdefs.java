package StepDefinitions;

import DriverManager.DriverManager;
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
        Assert.assertEquals("dfjwgge82h43g3uriy53h@bk.ru", onMenu().readCurrentUsername());
    }


    @Then("Wrong login message is visible")
    public void wrong_Login_Message_Is_Visible() {
        onLoginPage().isLoginErrorMessageVisible();
    }

    @Given("I login to mailbox")
    public void i_Login_To_Mailbox() {
        onLoginPage().loginToMail();
    }


    @When("I click Write a letter button")
    public void i_Click_Write_Letter_Button() {
        onMenu().clickWriteLetter();
    }


    @And("I enter (.*) and (.*) of the letter")
    public void i_Enter_Addressee_And_Body_Of_The_Letter(String addressee, String body) {
        onDraftForm().inputAddressee(addressee);
        onDraftForm().inputBodyOfTheLetter(body);
    }

    @And("I click Save a draft button")
    public void i_Click_Save_A_Draft_Button() {
        onDraftForm().clickSaveDraft();
    }

    @And("I click Close button")
    public void i_Click_Close_Button() {
        onDraftForm().closeDraftForm();
    }


    @And("I go to Drafts folder")
    public void i_Go_To_Drafts_Folder(){
        onMenu().goToDrafts();
    }


    @And("I click the first draft")
    public void i_Click_The_First_Draft() {
        onDraftsPage().clickFirstDraft();
    }

    @Then("I check (.*) and (.*) of the letter")
    public void i_Check_Addressee_And_Body_Of_The_Letter(String addressee, String body) {
        Assert.assertTrue(onDraftForm().readAdresseeOfLetter().equals(addressee) && onDraftForm().readBodyOfLetter().equals(body));
        onDraftForm().closeDraftForm();
    }

    @Given("There is at least one draft")
    public void there_Is_At_Least_One_Draft() {
        Assert.assertTrue(onDraftsPage().checkDraftsArePresent());
    }

    @When("I click Select all button")
    public void i_Click_Select_All_Button() {
        onMenu().selectAll();
    }

    @And("I click Delete")
    public void i_Click_Delete() {
        onMenu().clickDelete();
    }

    @Then("I check there is no drafts in the Drafts folder")
    public void i_Check_There_Is_No_Drafts_In_The_Drafts_Folder() {
        Assert.assertFalse(onDraftsPage().checkDraftsArePresent());
    }

    @Given("Cache is cleared")
    public void cacheIsCleared() {
        DriverManager.getDriver().get("chrome://settings/clearBrowserData");
    }

    @And("I exit account")
    public void i_Exit_Account() {
        onMenu().exitAccount();
    }
}
