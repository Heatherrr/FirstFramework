package tests;

import Helper.PropertiesHelper;
import org.junit.Test;

public class BuyAnItemTest extends SampleTest {

    @Test
    public void buyAnItemTest () {

    /*1. Open My Store (http://automationpractice.com/index.php)
    2. Press "Add to cart" button of any item
    3. Press the "Proceed to checkout" button
    4. Press the "Proceed to checkout" button on Summary Page

    5. Fill in "Email Address" field
    6. Fill in "Password" field
    7. Click "Sign In" button

    8. Press the "Proceed to checkout" button on Address Page
    9. Press the check-box "I agree to the terms of service and will adhere to them unconditionally. (Read the Terms of Service)"
    10. Press the "Proceed to checkout" button on Shipping Page
    11. Press "Pay by bank wire" banner
    12. Press "I confirm my order" button
    13. Check the "Your order on "My Store is complete." message
    14. Check the for "Cart (empty)" title on the cart */

    user.mainPage.openMainPage();
    user.mainPage.clickOnAddToCartButtonsOnItems(1);
    user.mainPage.clickOnProceedToCheckOutButton();
    user.mainPage.clickOnProceedToCheckOutButtonOnSummaryPage();
    user.mainPage.fillInEmailAddressField(PropertiesHelper.INSTANCE.getProperties("email"));
    user.mainPage.fillInPasswordField(PropertiesHelper.INSTANCE.getProperties("password"));
    user.mainPage.clickOnSignInButton();
    user.mainPage.clickOnProceedToCheckOutButtonOnAddressPage();
    user.mainPage.tickTheCheckBoxIAgree();
    user.mainPage.clickOnProceedToCheckOutButtonOnShippingPage();
    user.mainPage.clickOnPayByBankWire();
    user.mainPage.clickOnIConfirmMyOrderButton();

    }
}
