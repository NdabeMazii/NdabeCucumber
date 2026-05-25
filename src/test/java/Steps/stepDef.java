package Steps;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.PendingException;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


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
        dashboardPage.clickGroupsButton();
    }

    @And("I click on the create new group button")
    public void iClickOnTheCreateNewGroupButton() {
        dashboardPage.clickCreateNewGroupButton();
    }

    @And("I enter group name (.*)$")
    public void iEnterGroupNameGroupName(String groupName) {
        dashboardPage.enterGroupName(groupName);
    }

    @And("I enter group description (.*)$")
    public void iEnterGroupDescriptionGroupDescription(String groupDescription) {
        dashboardPage.enterGroupDescription(groupDescription);
    }

    @And("I enter year (.*)$")
    public void iEnterYear(String groupYear) {
        dashboardPage.enterGroupYear(String.valueOf(groupYear));
    }

    @And("I enter max capacity (.*)$")
    public void iEnterMaxCapacityMaxCapacity(String maxCapacity) {
        dashboardPage.enterMaximumCapacity(String.valueOf(maxCapacity));
    }


    @And("I enter start date (.*)$")
    public void iEnterStartDateStartDate(String startDate) {
        String formatted;
        try {
            LocalDate d = LocalDate.parse(startDate); // expects yyyy-MM-dd
            formatted = d.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        } catch (Exception e) {
            formatted = startDate;
        }
        dashboardPage.enterStartDate(formatted);
    }

    @And("I enter end date (.*)$")
    public void iEnterEndDateEndDate(String endDate) {
        String formatted;
        try {
            LocalDate d = LocalDate.parse(endDate); // expects yyyy-MM-dd
            formatted = d.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        } catch (Exception e) {
            formatted = endDate;
        }
        dashboardPage.enterEndDate(formatted);
    }

    @When("I click on the create group button")
    public void iClickOnTheCreateGroupButton() {
        dashboardPage.clickCreateGroupButton();
    }

    @Then("i should see the group creation success message")
    public void iShouldSeeTheGroupCreationSuccessMessage() {
        dashboardPage.verifyGroupCreationSuccess();
    }

    @AfterStep
    public void addScreenshot(Scenario scenario) {
//        if (scenario.isFailed()) {
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", "screenshot");
//        }

    }
}
