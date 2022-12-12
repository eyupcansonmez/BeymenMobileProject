package org.beymen;

import com.thoughtworks.gauge.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.beymen.base.Constans;
import org.beymen.methods.Methods;
import org.openqa.selenium.By;

import static org.junit.Assert.assertTrue;

import static org.beymen.base.BaseTest.appiumDriver;


public class StepImplementation {

    Methods methods = new Methods();
    Logger logger = LogManager.getLogger(StepImplementation.class);


    @Step("Beymen sayfasi acilir navigasyon izni only this time secilir")
    public void navigationPermission() {

        try {
            methods.click(Constans.NAVIGATION_PERMISSION, "xpath");
        } catch (Exception e) {
        }
    }

    @Step("Arama butonuna tiklanir")
    public void searchButton() {

        methods.click(Constans.SEARCH_BUTTON, "xpath");
    }

    @Step("Arama butonuna pantolon yazilir ve enter yapilir")
    public void writeProduct() {

        methods.click(Constans.WRITE_PRODUCT, "id");
        methods.sendKeys(Constans.WRITE_PRODUCT, "pantolon", "id");
        methods.keyEnter();

    }

    @Step("Filtrele butonuna tıklanır")
    public void filterButton() {

        methods.click(Constans.FILTER_BUTTON, "id");
    }

    @Step("Ürün çeşidine tiklanir")
    public void productSort() {

        methods.click(Constans.PRODUCT_SORT, "xpath");
    }

    @Step("Pantolon seçilir")

    public void choosePants() {

        methods.click(Constans.CHOOSE_PANT, "xpath");
    }

    @Step("Ürünler listelenir")
    public void listProducts() {

        methods.click(Constans.LIST_PRODUCTS, "xpath");
    }

    @Step("Ürün seçilir")
    public void chooseProduct() {

        methods.click(Constans.CHOOSE_PRODUCT, "xpath");
    }

    @Step("Sepete ekle texti kontrol edilir")
    public void addBasket() {

        methods.waitToXpath(Constans.ADD_BASKET);
        String check = appiumDriver.findElement(By.xpath(Constans.ADD_BASKET)).getText();
        assertTrue("Sepete ekle texti kontrol ediliyor! ", check.contains("SEPETE EKLE"));
        logger.info("'SEPETE EKLE' yazisi kontrol edildi");

    }

    @Step("Favorilere tıklanılır")
    public void clickFavorites() {

        methods.click(Constans.CLICK_FAVORITES, "xpath");
    }

    @Step("Kullanıcı giriş ekranının geldiği kontrol edilir")
    public void loginScreenControl() {

        methods.waitToXpath(Constans.LOGIN_SCREEN_CONTROL);
        boolean loginScreen = methods.findElementBykey(Constans.LOGIN_SCREEN_CONTROL, "xpath").isDisplayed();
        if (loginScreen) {
            logger.info("Kullanıcı giriş ekranının geldiği doğrulandı");
        } else {
            logger.info("Kullanıcı giriş ekranı bulunamadı");
        }

    }
}












