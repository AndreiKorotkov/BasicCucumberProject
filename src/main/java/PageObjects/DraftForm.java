package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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

    @FindBy(xpath = "//div[@class=\"focus-zone focus-zone_fluid\"]//button[@title=\"Закрыть\"]")
    private Button closeFocusedZoneButton;

    @FindBy(xpath = "//div[@class=\"focus-zone focus-zone_fluid\"]")
    private HtmlElement focusZone;

}