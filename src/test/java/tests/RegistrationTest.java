package tests;

import Helper.PropertiesHelper;
import org.junit.Test;

public class RegistrationTest extends SampleTest {

    @Test
    public void registrationTest () {
        user.mainPage.openMainPage();
        user.mainPage.clickOnSignInButton();
        user.mainPage.checkText();
        user.mainPage.fillInEmailAddressField(PropertiesHelper.INSTANCE.getProperties("email"));
        user.mainPage.clickOnCreateAnAccountButton();
    }
}
