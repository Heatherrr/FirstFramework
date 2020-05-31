package tests;

import Helper.PropertiesHelper;
import org.junit.Test;

public class FiltersTest extends SampleTest {

    @Test
    public void filtersTest () {
        user.mainPage.openMainPage();
        user.mainPage.clickOnSignInButton();
        user.mainPage.fillInEmailAddressField(PropertiesHelper.INSTANCE.getProperties("email"));
        user.mainPage.fillInPasswordField(PropertiesHelper.INSTANCE.getProperties("password"));
        user.mainPage.clickOnSubmitLoginButton();
        user.mainPage.clickOnWomenTab();      //тут мы на другой странице, нормально, что ссылка .mainPage?
        user.mainPage.checkOrangeColorOnItems();    //тут мы на другой странице, нормально, что ссылка .mainPage?
    }
}
