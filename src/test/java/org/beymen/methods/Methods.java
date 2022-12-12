package org.beymen.methods;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.beymen.base.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import javax.annotation.Nullable;
import java.time.Duration;
import java.util.List;

public class Methods extends BaseTest {

    AppiumDriver driver;
    FluentWait<AppiumDriver> wait;
    Actions actions;
    Logger logger = LogManager.getLogger(Methods.class);

    public Methods() {

        driver = appiumDriver;
        wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NoSuchElementException.class);

        actions = new Actions(driver);
    }

    public MobileElement findElement(By by) {
        return (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public List<MobileElement> findElements(By by) {
        return wait.until(new ExpectedCondition<List<MobileElement>>() {
            @Nullable
            @Override
            public List<MobileElement> apply(@Nullable WebDriver driver) {
                List<MobileElement> elements = driver.findElements(by);
                return elements.size() > 0 ? elements : null;
            }
        });
    }

    public MobileElement findElementBykey(String key, String selector) {
        if (selector.equals("xpath")) {
            return findElement(By.xpath(key));
        } else {
            return findElement(By.id(key));
        }
    }

    public void click(String key, String selector) {

        findElementBykey(key, selector).click();
        logger.info(key + " Butonuna tiklandi");
    }

    public void sendKeys(String key, String text, String selector) {

        logger.info(key + " ya " + text + " yazildi");
        findElementBykey(key, selector).sendKeys(text);
    }

    public String getText(String key, String selector) {
        logger.info(key + " deki text alindi");
        return findElementBykey(key, selector).getText();
    }

    public void keyEnter() {
        actions.sendKeys(Keys.ENTER).build().perform();
    }


    public String getText(By element) {
        return findElement(element).getText();
    }

    public boolean isElementVisible(By by) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public Select getSelect(By by) {
        return new Select(findElement(by));
    }

    public void selectByText(By by, String text) {
        getSelect(by).selectByVisibleText(text);
    }


    public void waitToElementId(String key) {
        wait = new FluentWait(appiumDriver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofMillis(1050))
                .ignoring(NoSuchElementException.class)
                .ignoring(TimeoutException.class);
        wait.until(ExpectedConditions.elementToBeClickable
                (By.id(key)));
    }

    public void waitToXpath(String key) {
        wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath(key)));
    }
}