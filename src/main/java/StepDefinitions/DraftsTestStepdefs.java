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
public class DraftsTestStepdefs extends AbstractStepDefs{

    @Given("I login to mailbox")
    public void i_Login_To_Mailbox() {
        onLoginPage().loginToMail();
    }


    @When("I click Write a letter button on Menu")
    public void i_Click_Write_Letter_Button_on_Menu() {
        onMenu().clickWriteLetter();
    }


    @And("I enter (.*) and (.*) of the letter")
    public void i_Enter_Addressee_And_Body_Of_The_Letter(String addressee, String body) {
        onDraftForm().inputAddressee(addressee);
        onDraftForm().inputBodyOfTheLetter(body);
    }

    @And("I click Save a draft button on Drafts Form")
    public void i_Click_Save_A_Draft_Button_on_Drafts_Form() {
        onDraftForm().clickSaveDraft();
    }

    @And("I click Close button on Drafts Form")
    public void i_Click_Close_Button_on_Drafts_Form() {
        onDraftForm().closeDraftForm();
    }


    @And("I go to Drafts folder")
    public void i_Go_To_Drafts_Folder(){
        onMenu().goToDrafts();
    }


    @And("I click the first draft on Drafts Page")
    public void i_Click_The_First_Draft_on_Drafts_Page() {
        onDraftsPage().clickFirstDraft();
    }

    @Then("I check (.*) and (.*) of the letter")
    public void i_Check_Addressee_And_Body_Of_The_Letter(String addressee, String body) {
        Assert.assertTrue(onDraftForm().readAdresseeOfLetter().equals(addressee) && onDraftForm().readBodyOfLetter().equals(body));
        onDraftForm().closeDraftForm();
    }

    @Given("There is at least one draft")
    public void there_Is_At_Least_One_Draft() {
        if (onMenu().readNumberOfDrafts().equals("Нет писем")) {
           onMenu().clickWriteLetter();
           onDraftForm().inputAddressee("test@mail.ru");
           onDraftForm().inputBodyOfTheLetter("This is test letter");
           onDraftForm().clickSaveDraft();
           onDraftForm().closeDraftForm();
        }
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
        Assert.assertEquals( "Нет писем", onMenu().readNumberOfDrafts());
    }

    @Given("Cache is cleared")
    public void cache_Is_Cleared() {
        DriverManager.getDriver().get("chrome://settings/clearBrowserData");
    }

    @And("I exit account")
    public void i_Exit_Account() {
        onMenu().exitAccount();
    }

    @And("Login field is cleared")
    public void login_Field_Is_Cleared() {
        DriverManager.getDriver().get("https://mail.ru//");
        onLoginPage().clearLoginInput();
    }
}
