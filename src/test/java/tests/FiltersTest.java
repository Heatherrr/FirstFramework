package tests;

import Helper.PropertiesHelper;
import org.junit.Test;

public class FiltersTest extends SampleTest {

    @Test
    public void filtersTest () {
        user.mainPage.openMainPage();
        user.mainPage.clickOnSignInButton();
        user.mainPage.fillInEmailAddressField(PropertiesHelper.INSTANCE.getProperties("email"));
        user.mainPage.fillInPasswordField(PropertiesHelper.INSTANCE.getProperties("psssword"));
        user.mainPage.clickOnSignInButton();
        user.mainPage.clickOnSubmitLoginButton();
        user.mainPage.clickOnWomenTab();
        user.mainPage.checkOrangeColorOnItems();
    }
}
