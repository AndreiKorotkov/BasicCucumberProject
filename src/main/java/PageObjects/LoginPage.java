package PageObjects;

import DriverManager.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.Form;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

/**
 * created by Andrei_Korotkov 8/27/2019
 */
public class LoginPage extends AbstractPage{

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

    @FindBy (id = "mailbox:error")
    private HtmlElement logingErrorMessage;

    @FindBy(how= How.CSS,using = "div.slot")
    HtmlElement ads;


//    private String login = "dfjwgge82h43g3uriy53h";
//    private String password = "PlOkIjUHYGC";

    public LoginPage () {
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(DriverManager.getDriver())), this);
    }

    public LoginPage open () {
        driver.get("https://mail.ru//");
        return this;
    }

    public void enterLogin (String login) {

        loginInput.sendKeys(login);
    }

    public LoginPage chooseDomain(String domain) {
        new Select(domainSelector).selectByVisibleText(domain);
        return this;
    }

    public LoginPage pressEnterPasswordButton() {
        enterPasswordButton.click();
        return this;
    }

    public LoginPage enterPassword (String password) {
        waitForElementVisible(passwordInput.getWrappedElement());
        passwordInput.sendKeys(password);
        return this;
    }

    public LoginPage loginToMailBox () {
        loginForm.submit();
        return this;
    }

    public String getInboxUrl () {
        waitForElementVisible(ads.getWrappedElement());
        return DriverManager.getDriver().getCurrentUrl();
    }

}
