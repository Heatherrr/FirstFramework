package tests;

import Helper.PropertieesHelper;
import org.junit.Test;

// Описываем тест, который будем выполнять:
public class LoginTest extends SampleTest {

    // Аннотация:
    // для выполнения теста:
    @Test
    public void loginTest() {
        user.mainPage.openMainPage();
        user.mainPage.clickOnSignInButton();
        user.mainPage.fillInEmailAddress("automationstep@gmail.com");
        //TO DO
        user.mainPage.checkText ();
        user.mainPage.fillInEmailAddressField(PropertieesHelper.INSTANCE.getProperty("email"));
        user.mainPage.fillInPasswordField(PropertieesHelper.INSTANCE.getProperty("password"));
    }
}
