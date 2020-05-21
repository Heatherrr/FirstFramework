package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.MainPage;

// Наследуем сценарии от билблиотеки серенити:
public class MainSteps extends ScenarioSteps {

    // Обьявляем MainPage:
    private MainPage onPage;

    // Описываем методы для серенити
    // чтобы серенити мог добавить шаги в репорт при его генерации:
    @Step
    public void clickOnSignInButton() {
        onPage.clickOnSignInButton();
    }

    @Step
    public void openMainPage() {
        onPage.openMainPage();
    }

    @Step
    public void fillInEmailAddress (String email) {
        onPage.fillInEmailAddress(email);
    }

    @Step
    public void checkText() {
        onPage.checkText ();
    }

    @Step
    public void fillInEmailAddressField(String email) {
        onPage.fillInEmailAddressField(email);
    }

    @Step
    public void fillInPasswordField(String password) {
        onPage.fillInPasswordField(password);
    }

    @Step
    public void clickOnSubmitLoginButton () {
        onPage.clickOnSubmitLoginButton ();
    }

    @Step
    public void clickOnWomenTab () {
        onPage.clickOnWomenTab();
    }

    @Step
    public void  checkOrangeColorOnItems () {
        onPage.checkOrangeColorsOnItems();
    }
}
