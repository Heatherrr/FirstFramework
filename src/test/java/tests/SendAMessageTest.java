package tests;

import Helper.PropertiesHelper;
import org.junit.Test;

public class SendAMessageTest extends SampleTest {

    //Тест-кейс
    //1. Open main page (http://automationpractice.com/index.php)
    //2. Click "Contact Us Button"
    //3. Click "Subject heading" drop-down menu and choose "Webmaster" point
    //4. Check for text "For any question about a product, an order"
    //5. Check for the icon near the text

    //6. Click "Subject heading" drop-down menu and choose "Customer Service" point
    //7. Check for text "If a technical problem occurs on this website"
    //8. Check for the icon near the text

    //9. Check text "Please enter" in email field
    //10. Fill in email address field
    //11. Click "Choose file" button and attach file
    //12. Check text "Please enter" in "Message" field
    //13. Type text in "Message" field
    //14. Click "Send" button

    @Test
    public void sendAMessageTest () {
        user.mainPage.openMainPage();
        user.contactUsPage.clickOnContactUsButton();
        user.contactUsPage.clickOnSubjectHeadingDropdownAndChooseWebmaster();
        user.contactUsPage.checkTextUnderWebmasterField();
        user.contactUsPage.checkIconUnderWebmasterField();
        user.mainPage.fillInEmailAddressField(PropertiesHelper.INSTANCE.getProperties("email"));
        user.contactUsPage.clickOnAttachFileButton();
        user.contactUsPage.typeTextInMessageField(PropertiesHelper.INSTANCE.getProperties("text")); //в методе сделать ссылку на текст, который будет в PropertiesHelper
        user.contactUsPage.clickOnSendButton();
    }
}
