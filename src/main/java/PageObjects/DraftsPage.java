package PageObjects;

import DriverManager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * created by Andrei_Korotkov 8/27/2019
 */
public class DraftsPage extends Menu {

    @FindBy(xpath = "//div[@class='subject__container--HWnat']//input")
    private WebElement subjectField;

    @FindBy(how= How.XPATH,using = "//a[contains (@class, 'js-letter-list-item')] [1]")
    private WebElement firstDraft;

    @FindBy(xpath = "//div[contains (@class, \"focus-zone\")]//span[contains(@class, \"text\")]")
    private WebElement focusZone;

    @FindBy(xpath = "//div[contains (@class, \"focus-zone\")]//span[contains(@class, \"text\")]")
    private WebElement adresseeField;

    @FindBy(css = "span[title=\"Отправить\"]")
    private WebElement sendLetterButton;

    @FindBy(xpath = "//div[@class=\"layer-sent-page\"]//span[@class=\"button2__ico\"]")
    private WebElement closeSentReportButton;

//    public DraftsPage(WebDriver driver) {
//        super(driver);
//    }

    private WebDriver driver= DriverManager.getDriver();

    public void clickFirstDraft() {
        waitForElementVisible(firstDraft);
        firstDraft.click();
    }

    public DraftsPage sendLetter() {
        sendLetterButton.click();
        return this;
    }

    public boolean checkDraftsArePresent () {
        return firstDraft.isDisplayed();
    }

    public DraftsPage closeReportLetterMessage() {
        waitForElementVisible(closeSentReportButton);
        closeSentReportButton.click();
        return this;
    }
}
