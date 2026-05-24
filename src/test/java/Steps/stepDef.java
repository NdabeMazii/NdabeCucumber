package Steps;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.PendingException;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class stepDef extends Base {

    @Given("i am on the login page")
    public void i_am_on_the_login_page() {
        homePage.clickLoginButton();
        loginPage.verifyLoginPageIsDisplayed();
    }

    @And("i enter my email (.*)$")
    public void i_enter_my_email(String email) {
        loginPage.enterEmail(email);
    }

    @And("i enter my password (.*)$")
    public void i_enter_my_password(String password) {
        loginPage.enterPassword(password);
    }

    @When("i click on the login button")
    public void i_click_on_the_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("i should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        dashboardPage.verifyDashboardPageIsDisplayed();
    }

    @After
    public void closeBrowser() {
    }


    @And("I click on the logged user")
    public void iClickOnTheLoggedUser() {
        dashboardPage.clickUserMenuButton();
    }

    @And("I click on the admin panel")
    public void iClickOnTheAdminPanel() {
        dashboardPage.clickAdminPanelButton();
    }

    @And("I click on the groups button")
    public void iClickOnTheGroupsButton() {
    }

    @And("I click on the create new group button")
    public void iClickOnTheCreateNewGroupButton() {
    }

    @And("I enter group name (.*)$")
    public void iEnterGroupNameGroupName(String groupName) {
    }

    @And("I enter group description (.*)$")
    public void iEnterGroupDescriptionGroupDescription(String groupDescription) {
    }

    @And("I enter year (.*)$")
    public void iEnterYear(int year) {
    }

    @And("I enter max capacity (.*)$")
    public void iEnterMaxCapacityMaxCapacity(int maxCapacity) {
    }


    @And("I enter start date (.*)$")
    public void iEnterStartDateStartDate(String startDate) {
    }

    @And("I enter end date (.*)$")
    public void iEnterEndDateEndDate(String endDate) {
    }

    @When("I click on the create group button")
    public void iClickOnTheCreateGroupButton() {
    }

    @Then("i should see the group created successfully")
    public void iShouldSeeTheGroupCreatedSuccessfully() {
    }

    @AfterStep
    public void addScreenshot(Scenario scenario) {
//        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot");
//        }

    }
}
