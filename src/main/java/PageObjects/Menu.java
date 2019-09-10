package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

/**
 * created by Andrei_Korotkov 8/27/2019
 */
public class Menu extends AbstractPage {

    @FindBy(css = "a[href=\"/drafts/\"]")
    private WebElement draftsButton;

    @FindBy(css = "a[href=\"/sent/\"]")
    private Button sentMessagesButton;

    @FindBy(css = "a[title=\"выход\"]")
    private Button exitButton;

    @FindBy(how = How.CSS, using = "span.compose-button")
    private Button writeLetterButton;

    @FindBy(how=How.CSS,using = "div.slot")
    private HtmlElement ads;

    @FindBy(css = "div.dimmer")
    private HtmlElement dimmer;

    @FindBy (id = "PH_user-email")
    private HtmlElement currentUsername;

    public String readNumberOfDrafts () {
        waitForElementHasAttribute(draftsButton, "title");
        return draftsButton.getAttribute("title");
    }

    public Menu goToDrafts (){
        waitForElementClickable(draftsButton);
        draftsButton.click();
        return this;
    }

    public void goToSentMessages() {
        waitForElementVisible(sentMessagesButton);
        sentMessagesButton.click();
    }

    public void clickWriteLetter () {
        waitForElementVisible(ads.getWrappedElement());
        writeLetterButton.click();
    }

    public Menu exitAccount () {
        waitForElementVisible(exitButton);
        exitButton.click();
        return this;
    }

    public String readCurrentUsername () {
        waitForElementVisible(ads.getWrappedElement());
        return currentUsername.getText();
    }
}
