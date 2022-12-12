package org.beymen.base;

public class Constans {


    // SETUP
    public static final boolean IS_LOCAL_ANDROID = true;

    public static final String DEVICE_NAME = "emulator-5554";

    public static final String START_APP_ACTIVITY = "com.mobisoft.beymen.activity.SplashActivity";

    public static final String APP_PACKAGE = "com.mobisoft.beymen";

    public static final String NEW_COMMAND_TIMEOUT = "3000";

    public static final String URL = "http://127.0.0.1:4723/wd/hub";

    // HOME PAGE
    public static final String NAVIGATION_PERMISSION = "//*[@resource-id='com.android.permissioncontroller:id/permission_allow_one_time_button']";

    public static final String SEARCH_BUTTON = "(//*[@resource-id='com.mobisoft.beymen:id/icon'])[2]";      // //*[@text='Arama']

    public static final String WRITE_PRODUCT = "com.mobisoft.beymen:id/search_bar_text";

    public static final String FILTER_BUTTON = "com.mobisoft.beymen:id/tv_filter";

    public static final String PRODUCT_SORT = "//*[@text='Ürün Çeşidi']";

    public static final String CHOOSE_PANT = "//*[@text='Jean Pantolon']";

    public static final String LIST_PRODUCTS = "//*[@resource-id='com.mobisoft.beymen:id/btn_apply_filter']";

    public static final String CHOOSE_PRODUCT = "(//*[@resource-id='com.mobisoft.beymen:id/productCategory'])[1]";

    // BASKET PAGE
    public static final String ADD_BASKET = "//*[@text='SEPETE EKLE']";

    public static final String CLICK_FAVORITES = "//*[@resource-id='com.mobisoft.beymen:id/addToFavoriteButton']";

    public static final String LOGIN_SCREEN_CONTROL = "//*[@text='Kullanıcı Girişi']";

}
