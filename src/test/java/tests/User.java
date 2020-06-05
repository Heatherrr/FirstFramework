package tests;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.steps.ScenarioSteps;
import steps.MainSteps;
import steps.ContactUsSteps;

public class User extends ScenarioSteps {

    @Steps
    public MainSteps mainPage;

    @Steps
    public ContactUsSteps contactUsPage;
}
