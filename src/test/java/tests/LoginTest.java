package tests;

import Helper.PropertiesHelper;
import org.junit.Test;

// Описываем тест, который будем выполнять:
public class LoginTest extends SampleTest {

    // Аннотация:
    // для выполнения теста:
    @Test
    public void loginTest() {
        user.mainPage.openMainPage();
        user.mainPage.clickOnSignInButton();
        //user.mainPage.fillInEmailAddress("automationstep@gmail.com");
        //TO DO
        user.mainPage.checkText ();
        user.mainPage.fillInEmailAddressField(PropertiesHelper.INSTANCE.getProperties("email"));
        user.mainPage.fillInPasswordField(PropertiesHelper.INSTANCE.getProperties("password"));
    }
}
