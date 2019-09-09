package PageObjects;

import DriverManager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

/**
 * created by Andrei_Korotkov 8/27/2019
 */
public class AbstractPage {
    protected WebDriver driver= DriverManager.getDriver();
    private static final int WAIT_FOR_ELEMENT_TIMEOUT_SECONDS = 10;

    public AbstractPage () {
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(DriverManager.getDriver())), this);
    }

    protected void waitForElementVisible(WebElement element) {
        new WebDriverWait(driver, WAIT_FOR_ELEMENT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitForElementClickable(WebElement element) {
        new WebDriverWait(driver, WAIT_FOR_ELEMENT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitForElementNotVisible (WebElement element) {
        new WebDriverWait(driver, WAIT_FOR_ELEMENT_TIMEOUT_SECONDS).until(ExpectedConditions.invisibilityOf(element));
    }

    protected void waitForElementHasAttribute (WebElement element, String attribute) {
        new WebDriverWait(driver, WAIT_FOR_ELEMENT_TIMEOUT_SECONDS).until(ExpectedConditions.attributeToBeNotEmpty(element,attribute));
    }
}
