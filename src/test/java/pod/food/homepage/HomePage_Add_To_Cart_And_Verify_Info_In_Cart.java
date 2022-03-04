package pod.food.homepage;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.CartPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.PageGeneratorManager;
import testdata.UserData;

public class HomePage_Add_To_Cart_And_Verify_Info_In_Cart extends BaseTest {
    WebDriver driver;
    LoginPageObject loginPage;
    HomePageObject homePage;
    CartPageObject  cartPage;

    // INFORMATION OF PRODUCT
    int quantity = Integer.parseInt(UserData.ProductName.QUANTITY_OF_PRODUCT);
    int priceProduct = 10;
    int smallOrderSurcharge = 30;
    int logisticsSurcharge = 20;
    int totalPriceOfProduct = quantity * priceProduct;
    int totalPriceLast = totalPriceOfProduct + smallOrderSurcharge + logisticsSurcharge;

    // PARSE PRICE TO STRING
    String priceToString = Integer.toString(priceProduct);
    String priceOfProduct = "$" + priceToString.concat(".00");

    // SHIPPING ADDRESS
    String name = "exam store";
    String street = "1250 Waters Place";
    String city = "Bronx County";
    String state = "NY";
    String postal = "10461";
    String phone = "1232123211";
    String actualShipping = name + "\n" + street.concat(",") + "\n" + city.concat(",") + state.concat(",") + postal + "\n" + phone;


    @Parameters({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName, String urlValue){
        driver = getBrowserDriver(browserName,urlValue);
        loginPage = PageGeneratorManager.getLoginPage(driver);

        log.info("Pre-Condition - Step 01: Click to Sign Up button");
        loginPage.clickToLoginButtonAtHeader();

        log.info("Pre-Condition - Step 02: Enter to Email textbox");
        loginPage.enterToEmailTextbox(UserData.Login.EMAIL);

        log.info("Pre-Condition - Step 03: Enter to Password textbox");
        loginPage.enterToPasswordTextbox(UserData.Login.PASSWORD);

        log.info("Pre-Condition - Step 04: Select I am a Buyer value");
        loginPage.clickToUserRoleIconAtLoginForm("buyer");

        log.info("Pre-Condition - Step 05: Click to Login button");
        homePage = loginPage.clickToLoginButton();

        log.info("Pre-Condition - Step 06: Verify the Pop popup is displayed");
        verifyTrue(homePage.isPodPopupDisplayed());

        log.info("Pre-Condition - Step 07: Click on X button to close popup");
        homePage.clickXIconInPopupDialog();
    }

    @Test
    public void HomePage_01_Check_correctness_of_searching_product(){
        log.info("Home Page - Step 01: Enter product named '" + UserData.ProductName.NAME_PRODUCT_SEARCH + "' into search textbox");
        homePage.enterToSearchTextbox(UserData.ProductName.NAME_PRODUCT_SEARCH);

        log.info("Home Page - Step 02: Click on search icon");
        homePage.clickToSearchIcon();

        log.info("Home Page - Step 03: Verify the results search is displayed");
        verifyEquals(homePage.getNameProductOfResultsSearch("Product exam1"), UserData.ProductName.NAME_PRODUCT_SEARCH);

        log.info("Home Page - Step 04: Click on Add to cart icon");
        homePage.clickOnAddToCartIcon();

        log.info("Home Page - Step 05: Verify the add to cart popup is displayed");
        verifyTrue(homePage.isPopupAddToCartDisplayed());

        log.info("Home Page - Step 06: Enter quantity");
        homePage.enterQuantityInAddToCartModalDialog(UserData.ProductName.QUANTITY_OF_PRODUCT);

        log.info("Home Page - Step 07: Click on Add to Cart in Modal Dialog");
        homePage.clickToAddToCartInModalDialog();

        log.info("Home Page - Step 08: Verify the notification of adding to cart successfully");
        verifyTrue(homePage.areNotificationAddToCartSuccessDisplayed());

        log.info("Home Page - Step 09: Click on X icon");
        homePage.clickToCloseInAddToCartSuccessNotification();
    }

    @Test
    public void HomePage_02_Verify_information_of_product_in_cart_popper(){
        log.info("Home Page - Step 01: Hover to Cart icon");
        homePage.hoverToCartIconAtHeader();

        log.info("Home Page - Step 02: the cart popper is displayed normally");
        verifyTrue(homePage.isCartPopperDisplayed());

        log.info("Home Page - Step 03: Verify the quantity of product is displayed correctly");
        verifyEquals(homePage.getQuantityOfProduct("exam brand1"),UserData.ProductName.QUANTITY_OF_PRODUCT);

        log.info("Home Page - Step 04: Verify the price of product is displayed correctly");
        verifyEquals(homePage.getPriceOfProduct("exam brand1"),priceProduct);

        log.info("Home Page - Step 05: Verify the price total of product is displayed correctly");
        verifyEquals(homePage.getTotalPriceOfProductInCartPopper(),totalPriceOfProduct);

        log.info("Home Page - Step 06: Verify the order value is displayed correctly");
        verifyEquals(homePage.getItemsSubTotalInCartPopper("Order Value"),totalPriceOfProduct);

        log.info("Home Page - Step 07: Verify the items subtotal is displayed correctly");
        verifyEquals(homePage.getItemsSubTotalInCartPopper("Items Subtotal"),totalPriceOfProduct);

        log.info("Home Page - Step 08: Verify the small order surcharge is displayed correctly");
        verifyEquals(homePage.getSmallOrderInCartPopper("Small Order Surcharge"),smallOrderSurcharge);

        log.info("Home Page - Step 09: Verify the logistics surcharge is displayed correctly");
        verifyEquals(homePage.getSmallOrderInCartPopper("Logistics Surcharge"),logisticsSurcharge);

        log.info("Home Page - Step 10: Verify the last total price is displayed correctly");
        verifyEquals(homePage.calculateTotalPriceLastInCartPopper("Total"),totalPriceLast);
    }

    @Test
    public void HomePage_03_Verify_all_information_in_cart_page(){
        log.info("Home Page - Step 01: Click on Cart button");
        cartPage = homePage.clickToCartButton();

        log.info("Cart Page - Step 02: Verify the cart page is displayed");
        verifyTrue(cartPage.isCartPageDisplayed());

        log.info("Cart Page - Step 03: Verify the text in pod express items is displayed");
        verifyTrue(cartPage.isTextInPodExpressSessionDisplayedInCartPage());

        log.info("Cart Page - Step 04: Verify the brand name is displayed correctly");
        verifyTrue(cartPage.isBrandNameInPodExpressSessionDisplayed());

        log.info("Cart Page - Step 05: Verify the product name is displayed correctly");
        verifyTrue(cartPage.isProductNameInPodExpressSessionDisplayed());

        log.info("Cart Page - Step 06: Verify the sku name is displayed correctly");
        verifyTrue(cartPage.isSkuNameInPodExpressSessionDisplayed());

        log.info("Cart Page - Step 07: Verify the unit is displayed correctly");
        verifyTrue(cartPage.isUnitInPodExpressSessionDisplayed());

        log.info("Cart Page - Step 08: Verify the id is displayed correctly");
        verifyEquals(cartPage.getIdInPodExpressSession(),"28414");

        log.info("Cart Page - Step 09: Verify the unit is displayed correctly");
        verifyEquals(cartPage.getUnitAndPriceInPodExpressSession("item"), ""+ priceOfProduct +"/unit (1 units/case)");

        log.info("Cart Page - Step 10: Verify the price is displayed correctly");
        verifyEquals(cartPage.getCasePriceInPodExpressSession(), priceProduct);

        log.info("Cart Page - Step 11: Verify the quantity of product is displayed correctly");
        verifyEquals(cartPage.getQuantityInPodExpressSession("value"), UserData.ProductName.QUANTITY_OF_PRODUCT);

        log.info("Cart Page - Step 12: Verify the total price is displayed correctly");
        verifyEquals(cartPage.getTotalPriceInPodExpressSession(),totalPriceOfProduct);

        log.info("Cart Page - Step 13: Verify info of shipping address is displayed correctly");
        verifyEquals(cartPage.getShippingAddress(),actualShipping);

        log.info("Cart Page - Step 14: Verify the message in summary checkout is displayed correctly");
        verifyTrue(cartPage.isMessageDisplayedInSummaryCheckout());

        log.info("Cart Page - Step 15: Hover to tooltip in item subtotal");
        cartPage.hoverToTooltipInItemSubtotal();

        log.info("Cart Page - Step 16: Verify the text in tooltip is displayed correctly");
        verifyEquals(cartPage.getTextInTooltipInItemSubtotal("data-tip"),"Small order surcharge for orders less than $350");
    }

    @AfterClass
    public void  afterClass(){
        closeBrowserAndDriver(driver);
    }

}
