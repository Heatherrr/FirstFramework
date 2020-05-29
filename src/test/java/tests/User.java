package tests;

import net.thucydides.core.annotations.Steps;
import pages.ContactUsPage;
import steps.MainSteps;

public class User {

    @Steps
    public MainSteps mainPage;

    @Steps
    public ContactUsPage contactUsPage;
}
