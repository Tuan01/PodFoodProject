package pageUIs;

public class CartPageUI {
    public static final String ELEMENT_IN_CART_PAGE = "//span[text()='Pod Express Items']";
    public static final String TEXT_IN_EXPRESS_SESSION_CART_PAGE = "//p[contains(text(),'These items will be consolidated')]";
    public static final String BRAND_NAME_IN_EXPRESS_SESSION_CART_PAGE = "//div[@class='cart-items-grid']//div[text()='exam brand1']";
    public static final String PRODUCT_NAME_IN_EXPRESS_SESSION_CART_PAGE = "//div[@class='cart-items-grid']//a[text()='Product exam1']";
    public static final String SKU_NAME_IN_EXPRESS_SESSION_CART_PAGE = "//div[@class='cart-items-grid']//div[text()='Sku1 exam1']";
    public static final String UNIT_UPC_IN_EXPRESS_SESSION_CART_PAGE = "//div[@class='variant unit-upc']";
    public static final String UNIT_CASE_AND_PRICE_IN_EXPRESS_SESSION_CART_PAGE = "//div[@class='%s-price']";
    public static final String ID_IN_EXPRESS_SESSION_CART_PAGE = "//div[@class='variant unit-upc']//span";
    public static final String QUANTITY_IN_EXPRESS_SESSION_CART_PAGE = "//input[@type='text']";
    public static final String TOTAL_PRICE_IN_EXPRESS_SESSION_CART_PAGE = "//div[@class='text-right']//div[@class='total']";
    public static final String NAME_SHIPPING_ADDRESS = "//div[text()='exam store']";
    public static final String INFO_SHIPPING_ADDRESS = "//span[@class='address-%s']";
    public static final String MESSAGE_IN_SUMMARY_CHECKOUT = "//div[@class='message']";
    public static final String TOOLTIP_IN_ITEM_SUBTOTAL = "//td[string()='+ Small Order Surcharge']//i";
}
