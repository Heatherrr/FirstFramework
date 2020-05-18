package pages;

//библиотеки селениума?
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//serenity page object, стандартный адрес:
@DefaultUrl("http://automationpractice.com/index.php")
//наследуем BasePage
public class MainPage extends BasePage{

    //// Локаторы:

    // Аннтоация:
    // указываем локатор
    // в данном случае сss
    @FindBy(css = "a.login")
    // Указываем веб элемент и его название:
    private WebElement signInButton;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy (xpath = "//*[@id='create-account_form']/div/p")
    private WebElement createAnAccountText;

    @FindBy (id = "passwd")
    private WebElement passwordField;


    ////

    //inject the driver into the test, создается автоматом после наследования BasePage:
    public MainPage(WebDriver driver) {

        super(driver);
    }


    //Методы

    //метод, открыть главную страницу
    public void openMainPage() {
        open();
    }

    //метод, нажать кнопку Sign in
    public void clickOnSignInButton() {
        element(signInButton).click();
  }

    //метод, записи в поле email почты нашего аккаунта:
    public void fillInEmailAddress (String email) {
        element (emailField).sendKeys(email);
    }

    //метод, проверить, есть ли текст "Please enter" в поле
    public void checkText () {
        //объект - ?
        String text = element(signInButton).getText();
        System.out.println(text);
        Pattern pattern = Pattern.compile("(^Please\\senter\\s)");
        Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            System.out.println("Нашел");
        } else {
            System.out.println("Не нашел");
        }
    }

    //метод, заполнить поле email
    public void fillInEmailAddressField(String email) {
        WebElement emailAddressField;
        element(emailField).sendKeys(email);
    }

    //метод, заполнить поле password
    public void fillInPasswordField(String password) {
        element (passwordField).sendKeys(password);
    }
}


    //чтобы запершить тест "Логин" осталось только нажать кнопку Sign in

    //    //метод, нажать кнопку Sign in
//    public void clickOnSignInButton() {
//        element(signInButton).click();
//  }

//и сделать так, чтобы нажималась 2-ая на странице кнопка Sign in, а не первая