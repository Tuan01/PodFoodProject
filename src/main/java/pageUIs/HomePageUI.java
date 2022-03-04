    package pageUIs;

    public class HomePageUI {
        public static final String CLOSE_ICON_POPUP_DIALOG = "//div[@class='close-btn']";
        public static final String POD_POPUP = "//div[@class='banner-content']";
        public static final String SEARCH_TEXTBOX = "//input[@placeholder='search products...']";
        public static final String SEARCH_ICON = "//i[@class='fa fa-search']";
        public static final String NAME_PRODUCT_SEARCH = "//div[@class='product-card']//a[string()='%s']";
        public static final String ADD_TO_CART_ICON_IN_PRODUCT_CARD = "//span[@data-tip='Add to cart']";
        public static final String ADD_TO_CART_POPUP = "//div[@class='modal-content']";
        public static final String QUANTITY_TEXTBOX = "//input[@name='cart_items[0][quantity]']";
        public static final String ADD_TO_CART_BUTTON_IN_MODAL_DIALOG = "//button[string()='Add to cart']";
        public static final String ADD_TO_CART_NOTIFICATION_SUCCESS = "//div[@class='rb-notification']//p";
        public static final String CLOSE_ICON_IN_NOTIFICATION = "//div[@class='rb-notification']//span";
        public static final String CART_ICON_HEADER = "//div[@class='cart']";
        public static final String CART_POPPER_HOVER = "//div[@class='cart-popper']";
        public static final String VALUE_ITEMS_IN_CART_POPPER = "//td[text()='%s']/following-sibling::td";
        public static final String PRICE_PRODUCT_IN_CART_POPPER = "//div[text()='%s']/../following-sibling::div//span[@class='case-price']";
        public static final String QUANTITY_PRODUCT_IN_CART_POPPER = "//div[text()='%s']/../following-sibling::div//span[@class='quantity']";
    }
