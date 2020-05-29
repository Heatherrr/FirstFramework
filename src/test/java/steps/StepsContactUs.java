package steps;

import Helper.PropertiesHelper;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.ContactUsPage;

public class StepsContactUs extends ScenarioSteps {

    private ContactUsPage onContactPage;

    //ЗАДАНИЕ

    @Step
    public void clickOnContactUsButton() {onContactPage.clickOnContactUsButton();}

    @Step
    public void clickOnSubjectHeadingDropdownAndChooseWebmaster () {onContactPage.clickOnSubjectHeadingDropdownAndChooseWebmaster();}

    @Step
    public void checkTextUnderWebmasterField() {onContactPage.checkTextUnderWebmasterField();}

    //нужен ли тут шаг для метода заполнить email, который на MainPage?

    @Step
    public void clickOnAttachFileButton() {onContactPage.clickOnAttachFileButton();}

    @Step
    public void typeTextInMessageField() {onContactPage.typeTextInMessageField(PropertiesHelper.INSTANCE.getProperties("text"));}
}
