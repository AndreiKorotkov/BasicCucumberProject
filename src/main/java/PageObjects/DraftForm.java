package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

/**
 * created by Andrei_Korotkov 9/9/2019
 */
public class DraftForm extends AbstractPage {

    @FindBy(xpath = "//div[@class='contactsContainer--3RMuQ']//input")
    private TextInput adresseeField;

    @FindBy(xpath = "//div[@class='subject__container--HWnat']//input")
    private TextInput subjectField;

    @FindBy(css = "div[role=textbox]")
    private TextInput letterBody;

    @FindBy(css = "span.button2_base:nth-child(2)")
    private Button saveDraftButton;

    @FindBy(xpath = "//div[@class='contactsContainer--3RMuQ']//span[contains(@class, 'text')]")
    private HtmlElement filledAdresseeField;

    @FindBy(xpath = "//div[contains(@id, \"BODY\")]/div/div/div")
    private TextInput letterBodyField;

    @FindBy(xpath = "//div[@class=\"focus-zone focus-zone_fluid\"]//button[@title=\"Закрыть\"]")
    private Button closeFocusedZoneButton;

    @FindBy(xpath = "//div[@class=\"focus-zone focus-zone_fluid\"]")
    private HtmlElement focusZone;

    @FindBy (id = "dimmer")
    private HtmlElement dimmer;

    @FindBy (css = "div.input--3slxg")
    private WebElement addresseeField;

    public void inputAddressee (String addressee) {
        waitForElementVisible(adresseeField.getWrappedElement());
        adresseeField.sendKeys(addressee);
    }

    public void inputBodyOfTheLetter (String body) {
        waitForElementVisible(letterBody.getWrappedElement());
        letterBody.sendKeys(body);
    }

    public String readAdresseeOfLetter() {
        waitForElementVisible(focusZone.getWrappedElement());
        return filledAdresseeField.getText();
    }


    public String readBodyOfLetter() {
        return letterBodyField.getWrappedElement().getText();
    }


    public void clickSaveDraft () {
        waitForElementClickable(saveDraftButton.getWrappedElement());
        saveDraftButton.click();
    }

    public void closeDraftForm () {
        closeFocusedZoneButton.click();
        waitForElementNotVisible(dimmer.getWrappedElement());
        new WebDriverWait(driver,10).until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector("div.input--3slxg"))));
    }
}
