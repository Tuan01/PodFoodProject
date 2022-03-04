package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.CartPageUI;

public class CartPageObject extends BasePage {
    WebDriver driver;

    public CartPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isCartPageDisplayed(){
        waitForElementVisible(driver, CartPageUI.ELEMENT_IN_CART_PAGE);
        return isElementDisplayed(driver,CartPageUI.ELEMENT_IN_CART_PAGE);
    }

    public boolean isTextInPodExpressSessionDisplayedInCartPage(){
        waitForElementVisible(driver, CartPageUI.TEXT_IN_EXPRESS_SESSION_CART_PAGE);
        return isElementDisplayed(driver,CartPageUI.TEXT_IN_EXPRESS_SESSION_CART_PAGE);
    }

    public boolean isBrandNameInPodExpressSessionDisplayed(){
        waitForElementVisible(driver, CartPageUI.BRAND_NAME_IN_EXPRESS_SESSION_CART_PAGE);
        return isElementDisplayed(driver,CartPageUI.BRAND_NAME_IN_EXPRESS_SESSION_CART_PAGE);
    }

    public boolean isProductNameInPodExpressSessionDisplayed(){
        waitForElementVisible(driver, CartPageUI.PRODUCT_NAME_IN_EXPRESS_SESSION_CART_PAGE);
        return isElementDisplayed(driver,CartPageUI.PRODUCT_NAME_IN_EXPRESS_SESSION_CART_PAGE);
    }

    public boolean isSkuNameInPodExpressSessionDisplayed(){
        waitForElementVisible(driver, CartPageUI.SKU_NAME_IN_EXPRESS_SESSION_CART_PAGE);
        return isElementDisplayed(driver,CartPageUI.SKU_NAME_IN_EXPRESS_SESSION_CART_PAGE);
    }

    public boolean isUnitInPodExpressSessionDisplayed(){
        waitForElementVisible(driver, CartPageUI.UNIT_UPC_IN_EXPRESS_SESSION_CART_PAGE);
        return isElementDisplayed(driver,CartPageUI.UNIT_UPC_IN_EXPRESS_SESSION_CART_PAGE);
    }

    public String getIdInPodExpressSession(){
        waitForElementVisible(driver, CartPageUI.ID_IN_EXPRESS_SESSION_CART_PAGE);
        return getElementText(driver,CartPageUI.ID_IN_EXPRESS_SESSION_CART_PAGE).trim();
    }

    public String getUnitAndPriceInPodExpressSession(String attValue){
        waitForElementVisible(driver,CartPageUI.UNIT_CASE_AND_PRICE_IN_EXPRESS_SESSION_CART_PAGE, attValue);
        return getElementText(driver, CartPageUI.UNIT_CASE_AND_PRICE_IN_EXPRESS_SESSION_CART_PAGE, attValue).trim();
    }

    public int getCasePriceInPodExpressSession(){
        String price = getUnitAndPriceInPodExpressSession("case");
        price = price.replace("$","");
        price = price.replace(".00","");
        int casePrice = Integer.parseInt(price);
        return casePrice;
    }
    public String getQuantityInPodExpressSession(String value){
        waitForElementVisible(driver, CartPageUI.QUANTITY_IN_EXPRESS_SESSION_CART_PAGE);
        return getAttributeValue(driver,CartPageUI.QUANTITY_IN_EXPRESS_SESSION_CART_PAGE,value);
    }

    public int getTotalPriceInPodExpressSession(){
        waitForElementVisible(driver, CartPageUI.TOTAL_PRICE_IN_EXPRESS_SESSION_CART_PAGE);
        String price = getElementText(driver, CartPageUI.TOTAL_PRICE_IN_EXPRESS_SESSION_CART_PAGE).trim();
        price = price.replace("$","");
        price = price.replace(".00","");
        int priceTotal = Integer.parseInt(price);
        return priceTotal;
    }


    public String getNameShippingAddress(){
        waitForElementVisible(driver, CartPageUI.NAME_SHIPPING_ADDRESS);
        return getElementText(driver, CartPageUI.NAME_SHIPPING_ADDRESS).trim();
    }
    public String getInfoOfShippingAddress(String infoValue){
       waitForElementVisible(driver,CartPageUI.INFO_SHIPPING_ADDRESS,infoValue);
       return getElementText(driver,CartPageUI.INFO_SHIPPING_ADDRESS,infoValue);
    }

    public String getShippingAddress(){
        String name = getNameShippingAddress();
        String street = getInfoOfShippingAddress("street1");
        String city = getInfoOfShippingAddress("city");
        String state = getInfoOfShippingAddress("state");
        String postal = getInfoOfShippingAddress("zip");
        String phone = getInfoOfShippingAddress("phone_number");
        String shippingAddress =  name + "\n" + street + "\n" + city + state + postal + "\n" + phone;
        return  shippingAddress;
    }

    public boolean isMessageDisplayedInSummaryCheckout(){
        waitForElementVisible(driver,CartPageUI.MESSAGE_IN_SUMMARY_CHECKOUT);
        return isElementDisplayed(driver,CartPageUI.MESSAGE_IN_SUMMARY_CHECKOUT);
    }

    public void hoverToTooltipInItemSubtotal(){
        waitForElementVisible(driver, CartPageUI.TOOLTIP_IN_ITEM_SUBTOTAL);
        hoverToElement(driver, CartPageUI.TOOLTIP_IN_ITEM_SUBTOTAL);
    }

    public String getTextInTooltipInItemSubtotal(String value){
        waitForElementVisible(driver,CartPageUI.TOOLTIP_IN_ITEM_SUBTOTAL);
        return getAttributeValue(driver, CartPageUI.TOOLTIP_IN_ITEM_SUBTOTAL, value);
    }
}
