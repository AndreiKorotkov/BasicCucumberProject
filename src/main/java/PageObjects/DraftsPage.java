package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

/**
 * created by Andrei_Korotkov 8/27/2019
 */
public class DraftsPage extends Menu {

    @FindBy(xpath = "//div[@class='subject__container--HWnat']//input")
    private WebElement subjectField;

    @FindBy(css = "a.llc_first")
    private HtmlElement firstDraft;

    @FindBy(xpath = "//div[contains (@class, \"focus-zone\")]//span[contains(@class, \"text\")]")
    private WebElement focusZone;

    @FindBy(xpath = "//div[contains (@class, \"focus-zone\")]//span[contains(@class, \"text\")]")
    private WebElement adresseeField;

    public void clickFirstDraft() {
        firstDraft.click();
    }

    public boolean checkDraftsArePresent () {
        return firstDraft.exists();
    }

}
