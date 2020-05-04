package tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.After;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public abstract class SampleTest {

    @Managed(driver = "chrome", uniqueSession = true)
    private WebDriver driver;

    @Steps
    public User user;

    @After
    public void tearDown() {
        driver.quit();
    }
}
