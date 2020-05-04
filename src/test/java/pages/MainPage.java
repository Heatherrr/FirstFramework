package pages;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("http://automationpractice.com/index.php")
public class MainPage extends BasePage{

    @FindBy(css = "a.login")
    private WebElement signInButton;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void openMainPage() {
        open();
    }

    public void clickOnSignInButton() {
        element(signInButton).click();
  }
}
