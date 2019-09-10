package PageObjects;

import DriverManager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

    @FindBy(css = "span[title=\"Отправить\"]")
    private WebElement sendLetterButton;

    @FindBy(xpath = "//div[@class=\"layer-sent-page\"]//span[@class=\"button2__ico\"]")
    private WebElement closeSentReportButton;

    public void clickFirstDraft() {

        firstDraft.click();
    }

    public DraftsPage sendLetter() {
        sendLetterButton.click();
        return this;
    }

    public boolean checkDraftsArePresent () {
        return firstDraft.exists();
    }

    public HtmlElement getFirstDraft() {
        return firstDraft;
    }

    public DraftsPage closeReportLetterMessage() {
        waitForElementVisible(closeSentReportButton);
        closeSentReportButton.click();
        return this;
    }


}
