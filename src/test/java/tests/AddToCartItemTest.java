package tests;

public class AddToCartItemTest extends SampleTest {
    public void addToCartItemTest () {
        user.mainPage.openMainPage();
        user.mainPage.clickOnWomenTab();
        user.mainPage.clickOnAddToCartButtonsItems(3);
    }
}
