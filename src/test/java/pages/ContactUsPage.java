package pages;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@DefaultUrl("http://automationpractice.com/index.php?controller=contact")

public class ContactUsPage extends BasePage {


    //ЗАДАНИЕ

    //локаторы

    @FindBy(id = "contact-link")
    private WebElement contactUsButton;

    @FindBy(css = "#uniform-id_contact")
    private WebElement dropDownMenuChoose;


    @FindBy(id = "uniform-id_contact")
    private WebElement subjectHeadingDropdown;

    @FindBy(id = "id_contact")
    private WebElement subject;

    @FindBy(id = "fileUpload")
    private WebElement attachFileButton;

    @FindBy(id = "desc_contact1")
    private WebElement textUnderWebmasterField;

    @FindBy(css = "css=#desc_contact1 > .icon-comment-alt")
    private WebElement iconUnderWebmasterField;

    /*@FindBy(id = "email")
    private WebElement emailAddressField;*/

    @FindBy(id = "message")
    private WebElement messageField;

    @FindBy(css = "#submitMessage > span")
    private WebElement sendButton;



    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    //методы

    public void clickOnContactUsButton() {element(contactUsButton).click(); }

    public void clickOnSubjectHeadingDropdownAndChooseWebmaster() {     //(String subjectValue)
        element(subjectHeadingDropdown).click();
        selectFromDropdown(subject, "Webmaster");
    }


    public void clickOnAttachFileButton (String pathToFile) {
        element(attachFileButton).click();
        getDriver().switchTo().activeElement().sendKeys(pathToFile);  //sendButton (\путь\к\файлу\)
    }

    public void checkTextUnderWebmasterField () {
        //объект - ?
        String text = element(textUnderWebmasterField).getText();
        System.out.println(text);
        Pattern pattern = Pattern.compile("(^If\\sa\\stechnical\\sproblem\\soccurs\\son\\sthis\\swebsite\\s)");
        Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            System.out.println("Нашел");
        } else {
            System.out.println("Не нашел");
        }
    }

    //метод, проверить, что есть иконка рядом с текстом под полем Webmaster
    public void checkIconUnderWebmasterField () {
        element(iconUnderWebmasterField).isDisplayed();
    }

    //метод message
    public void typeTextInMessageField(String text) {
        element(messageField).sendKeys(text);
    }

    //метод click send button
    public void clickOnSendButton () {element(sendButton).click();}
}



