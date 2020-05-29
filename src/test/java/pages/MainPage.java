package pages;

//библиотеки селениума?

import net.thucydides.core.annotations.DefaultUrl;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
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

    @FindBy(id = "SubmitLogin")
    private WebElement signInButtonOnLoginPage;

    @FindBy(css = "a[title='Women']")
    private WebElement womenTab;

    @FindBy(css = "a[style='background:#F39C11;']")
    private WebElement orangeBox;

    //локатор, будет вытягивать список товаров, где есть цвета (любые)
    @FindBy(css = "ul[class='color_to_pick_list clearfix']")
    private List<WebElement> colorBoxes;

    @FindBy (xpath = "//*[@id='center_column']/ul/li")
    private  List<WebElement> moveToItem;
    //"//*[@id='center_column']/ul/li"

    @FindBy (css = "a[title='Add to cart'][data-id-product]")
    private  List<WebElement> addToCartButtons;

    @FindBy (xpath = "//*[@id='layer_cart']/div[1]/div[2]/div[4]/span/span")
    private WebElement continueShoppingButton;



    //REGISTRATION TEST
    @FindBy(css = "button#SubmitCreate")
    // Указываем веб элемент и его название:
    private WebElement createAnAccountButton;


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

    //метод на click по кнопке submit на стр логина
    public void clickOnSubmitLoginButton () {
        element(signInButtonOnLoginPage).click();
    }

    //метод клик на women
    public void clickOnWomenTab() {
        element(womenTab).click();
    }

    //метод возвращает боксы с цветами
    private List<WebElement> getColorBoxes() {
        return colorBoxes;
    }

    //метод проверяем что у нас есть 3 оранжевых цвета (3 продукта), 1 продукт - один оранжевый цвет
    public void checkOrangeColorsOnItems () {
        int counter = 0;
        for (int i = 0; i < getColorBoxes().size(); i++) {
            if (getColorBoxes().get(i).findElements(By.cssSelector("a[style='background:#F39C11;']")).size() > 1) {
                counter++;
            }
        }
        Assert.assertEquals(3, counter);
    }

    private List<WebElement> getMoveToItemList () {
        return moveToItem;
    }

    private List<WebElement> getAddToCartButtons() {
        return addToCartButtons;
    }

    public void clickOnAddToCartButtonsOnItems(int count) {
        for (int i = 0; i < count; i++) {
            withAction().moveToElement(getMoveToItemList().get(i)).perform();
            getDriver().findElement(By.cssSelector("a[title='Add to cart'][data-id-product = '" + (i+1) + "']")).click();
            //waitForCondition().until(ExpectedConditions.visibilityOf(addToCartButtons.get(i))).click();
            //addToCartButtons.get(i).click();
            element (continueShoppingButton).click();  //ленивая инициализация
        }
    }


    //REGISTRATION TEST
    public void clickOnCreateAnAccountButton ()  {
        element(createAnAccountButton).click();
    }

}


    //чтобы запершить тест "Логин" осталось только нажать кнопку Sign in

    //    //метод, нажать кнопку Sign in
//    public void clickOnSignInButton() {
//        element(signInButton).click();
//  }

//и сделать так, чтобы нажималась 2-ая на странице кнопка Sign in, а не первая