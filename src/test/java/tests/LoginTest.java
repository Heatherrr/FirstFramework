package tests;

import org.junit.Test;

public class LoginTest extends SampleTest {

    @Test
    public void loginTest() {
        user.mainPage.openMainPage();
        user.mainPage.clickOnSignInButton();
    }
}
