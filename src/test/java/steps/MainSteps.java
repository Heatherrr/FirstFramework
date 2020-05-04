package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.MainPage;

public class MainSteps extends ScenarioSteps {

    private MainPage onPage;

    @Step
    public void clickOnSignInButton() {
        onPage.clickOnSignInButton();
    }

    @Step
    public void openMainPage() {
        onPage.openMainPage();
    }
}
