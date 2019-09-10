package PageObjects;

import DriverManager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.Form;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

/**
 * created by Andrei_Korotkov 8/27/2019
 */
public class LoginPage extends Menu {

    @FindBy(css = "input[placeholder='Имя ящика']")
    private TextInput loginInput;

    @FindBy(id = "mailbox:password")
    private TextInput passwordInput;

    @FindBy(id = "mailbox:domain")
    private ru.yandex.qatools.htmlelements.element.Select domainSelector;

    @FindBy(css = "input.o-control")
    private Button enterPasswordButton;

    @FindBy(id = "auth")
    private Form loginForm;

    @FindBy(id = "mailbox:error")
    private HtmlElement logingErrorMessage;

    @FindBy(how = How.CSS, using = "div.slot")
    private HtmlElement ads;

    private WebDriver driver = DriverManager.getDriver();


    private static final String LOGIN = "dfjwgge82h43g3uriy53h";
    private static final String PASSWORD = "PlOkIjUHYGC";
    private static final String DOMAIN = "@bk.ru";


    public LoginPage open() {
        driver.get("https://mail.ru//");
        return this;
    }

    public void enterLogin(String login) {
        waitForElementVisible(loginInput.getWrappedElement());
        loginInput.sendKeys(login);
    }

    public LoginPage chooseDomain(String domain) {
        new Select(domainSelector).selectByVisibleText(domain);
        return this;
    }

    public void pressEnterPasswordButton() {
        enterPasswordButton.click();
    }

    public LoginPage enterPassword(String password) {
        waitForElementVisible(passwordInput.getWrappedElement());
        passwordInput.sendKeys(password);
        return this;
    }

    public LoginPage loginToMailBox() {
        loginForm.submit();
        return this;
    }

    public String getInboxUrl() {
        waitForElementVisible(ads.getWrappedElement());
        return DriverManager.getDriver().getCurrentUrl();
    }

    public boolean isLoginErrorMessageVisible() {
        return loginInput.isDisplayed();
    }

    public void loginToMail() {
        open();
        enterLogin(LOGIN);
        chooseDomain(DOMAIN);
        pressEnterPasswordButton();
        enterPassword(PASSWORD);
        loginToMailBox();
        waitForElementVisible(ads.getWrappedElement());
    }

    public void clearLoginInput() {
        loginInput.clear();
    }
}
