package StepDefinitions;

import PageObjects.DraftForm;
import PageObjects.DraftsPage;
import PageObjects.LoginPage;
import PageObjects.Menu;

/**
 * created by Andrei_Korotkov 9/9/2019
 */
public abstract class AbstractStepDefs {
    private LoginPage loginPage = new LoginPage();
    private Menu menu = new Menu();
    private DraftForm draftForm = new DraftForm();
    private DraftsPage draftsPage = new DraftsPage();

    public LoginPage onLoginPage() {
        return loginPage;
    }

    public Menu onMenu() {
        return menu;
    }

    public DraftForm onDraftForm() {
        return draftForm;
    }

    public DraftsPage onDraftsPage() {
        return draftsPage;
    }


}
