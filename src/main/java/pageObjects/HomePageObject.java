package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage {
    WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isPodPopupDisplayed() {
        waitForElementVisible(driver,HomePageUI.POD_POPUP);
        return isElementDisplayed(driver,HomePageUI.POD_POPUP);
    }

    public void clickXIconInPopupDialog(){
        waitForElementClickable(driver,HomePageUI.CLOSE_ICON_POPUP_DIALOG);
        clickToElement(driver,HomePageUI.CLOSE_ICON_POPUP_DIALOG);
    }

    public void enterToSearchTextbox(String valueSearch){
        waitForElementVisible(driver, HomePageUI.SEARCH_TEXTBOX);
        sendkeyToElement(driver, HomePageUI.SEARCH_TEXTBOX, valueSearch);
    }

    public void clickToSearchIcon(){
        waitForElementClickable(driver,HomePageUI.SEARCH_ICON);
        clickToElement(driver,HomePageUI.SEARCH_ICON);
    }

    public String getNameProductOfResultsSearch(String nameValue) {
        waitForElementVisible(driver, HomePageUI.NAME_PRODUCT_SEARCH, nameValue);
        return getElementText(driver, HomePageUI.NAME_PRODUCT_SEARCH, nameValue).trim();
    }

    public void clickOnAddToCartIcon(){
        waitForElementClickable(driver,HomePageUI.ADD_TO_CART_ICON_IN_PRODUCT_CARD);
        clickToElement(driver,HomePageUI.ADD_TO_CART_ICON_IN_PRODUCT_CARD);
    }

    public boolean isPopupAddToCartDisplayed() {
        waitForElementVisible(driver,HomePageUI.ADD_TO_CART_POPUP);
        return isElementDisplayed(driver,HomePageUI.ADD_TO_CART_POPUP);
    }

    public void enterQuantityInAddToCartModalDialog(String quantityValue){
        waitForElementVisible(driver, HomePageUI.QUANTITY_TEXTBOX);
        sendkeyToElement(driver, HomePageUI.QUANTITY_TEXTBOX, quantityValue);
    }

    public void clickToAddToCartInModalDialog(){
        waitForElementClickable(driver,HomePageUI.ADD_TO_CART_BUTTON_IN_MODAL_DIALOG);
        clickToElement(driver,HomePageUI.ADD_TO_CART_BUTTON_IN_MODAL_DIALOG);
    }

    public boolean areNotificationAddToCartSuccessDisplayed(){
        boolean status = false;
        waitForElementVisible(driver, HomePageUI.ADD_TO_CART_NOTIFICATION_SUCCESS);
        if(isElementDisplayed(driver, HomePageUI.ADD_TO_CART_NOTIFICATION_SUCCESS)){
            status = true;
        } else{
            return status;
        }
        return status;
    }

    public void clickToCloseInAddToCartSuccessNotification(){
        waitForElementClickable(driver,HomePageUI.CLOSE_ICON_IN_NOTIFICATION);
        clickToElement(driver,HomePageUI.CLOSE_ICON_IN_NOTIFICATION);
    }

    public void hoverToCartIconAtHeader(){
        waitForElementVisible(driver,HomePageUI.CART_ICON_HEADER );
        hoverToElement(driver, HomePageUI.CART_ICON_HEADER);
    }

    public CartPageObject clickToCartButton() {
        waitForElementClickable(driver, HomePageUI.CART_ICON_HEADER);
        clickToElement(driver,HomePageUI.CART_ICON_HEADER);
        return PageGeneratorManager.getCartPage(driver);
    }

    public boolean isCartPopperDisplayed(){
        waitForElementVisible(driver,HomePageUI.CART_POPPER_HOVER);
        return isElementDisplayed(driver,HomePageUI.CART_POPPER_HOVER);
    }

    public String getItemValueInCartPopper(String label){
        waitForElementVisible(driver, HomePageUI.VALUE_ITEMS_IN_CART_POPPER,label);
        return getElementText(driver, HomePageUI.VALUE_ITEMS_IN_CART_POPPER,label).trim();
    }

    public int getPriceOfProduct(String nameProduct){
        waitForElementVisible(driver,HomePageUI.PRICE_PRODUCT_IN_CART_POPPER, nameProduct);
        String price = getElementText(driver,HomePageUI.PRICE_PRODUCT_IN_CART_POPPER, nameProduct).trim();
        price = price.replace("$","");
        price = price.replace(".00","");
        int priceProduct = Integer.parseInt(price);
        return priceProduct;
    }

    public String getQuantityOfProduct(String nameProduct){
        waitForElementVisible(driver,HomePageUI.QUANTITY_PRODUCT_IN_CART_POPPER, nameProduct);
        return getElementText(driver,HomePageUI.QUANTITY_PRODUCT_IN_CART_POPPER, nameProduct).trim();
    }

    public int getTotalPriceOfProductInCartPopper(){
        int price = getPriceOfProduct("Product exam1");
        String qua = getQuantityOfProduct("Product exam1");
        int quantity = Integer.parseInt(qua);
        int priceTotal = price * quantity;
        return priceTotal;
    }

    public int getItemsSubTotalInCartPopper(String label){
        waitForElementVisible(driver, HomePageUI.VALUE_ITEMS_IN_CART_POPPER,label);
        int c = getTotalPriceOfProductInCartPopper();
        int itemSubTotal = c;
        return itemSubTotal;
    }

    public int getSmallOrderInCartPopper(String label){
        waitForElementVisible(driver, HomePageUI.VALUE_ITEMS_IN_CART_POPPER,label);
        String smallSurcharge =  getElementText(driver, HomePageUI.VALUE_ITEMS_IN_CART_POPPER,label).trim();
        smallSurcharge = smallSurcharge.replace("$","");
        smallSurcharge = smallSurcharge.replace(".00","");
        int smallOrder = Integer.parseInt(smallSurcharge);
        return smallOrder;
    }

    public int getLogisticsInCartPopper(String label){
        waitForElementVisible(driver, HomePageUI.VALUE_ITEMS_IN_CART_POPPER,label);
        String logic =  getElementText(driver, HomePageUI.VALUE_ITEMS_IN_CART_POPPER,label).trim();
        logic = logic.replace("$","");
        logic = logic.replace(".00","");
        int logicsSurcharge  = Integer.parseInt(logic);
        return logicsSurcharge;
    }

    public int calculateTotalPriceLastInCartPopper(String label){
        waitForElementVisible(driver, HomePageUI.VALUE_ITEMS_IN_CART_POPPER,label);
        int itemSubtotal = getItemsSubTotalInCartPopper("Items Subtotal");
        int smallOrder = getSmallOrderInCartPopper("Small Order Surcharge");
        int logistics = getLogisticsInCartPopper("Logistics Surcharge");
        int totalPriceLast = itemSubtotal + smallOrder + logistics;
        return totalPriceLast;
    }

}
