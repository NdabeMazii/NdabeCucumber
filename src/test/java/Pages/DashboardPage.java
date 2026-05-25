package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class DashboardPage {

    WebDriver driver;

    @FindBy(xpath = "//span[normalize-space()='Welcome']")
    WebElement dashboardHeading_xpath;

    @FindBy(xpath = "//button[contains(@class,'user-pill')]//span[contains(text(),'👤')]")
    WebElement userMenuButton_xpath;

    @FindBy(xpath = "//button[@class='nav-dropdown-item']//span[contains(text(),'Admin Panel')]")
    WebElement adminPanel_xpath;

    @FindBy(xpath = "//button[contains(.,'Groups')]")
    WebElement groupsButton_xpath;

    @FindBy(xpath = "//button[normalize-space()='+ Create New Group']")
    WebElement createNewGroup_xpath;

    @FindBy(xpath = "//input[@placeholder='e.g., 2nd Group 2026']")
    WebElement groupNameInput_xpath;

    @FindBy(xpath = "//textarea[@placeholder='Group description...']")
    WebElement groupDescriptionInput_xpath;

    @FindBy(xpath = "//input[@name='year']")
    WebElement groupYearInput_xpath;

    @FindBy(xpath = "//input[@placeholder='Unlimited']")
    WebElement maximumCapacityInput_xpath;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyDashboardPageIsDisplayed() {
        new WebDriverWait(driver, java.time.Duration.ofSeconds(15)).until(visibilityOf(dashboardHeading_xpath));
        dashboardHeading_xpath.click();
    }

    public void clickUserMenuButton() {
        new WebDriverWait(driver, java.time.Duration.ofSeconds(15)).until(visibilityOf(userMenuButton_xpath));
        userMenuButton_xpath.click();
    }

    public void clickAdminPanelButton() {
        adminPanel_xpath.click();
    }

    public void clickGroupsButton() {
        groupsButton_xpath.click();
    }

    public void clickCreateNewGroupButton() {
        createNewGroup_xpath.click();
    }

    public void enterGroupName(String groupName) {
        groupNameInput_xpath.sendKeys(groupName);
    }

    public void enterGroupDescription(String groupDescription) {
        groupDescriptionInput_xpath.sendKeys(groupDescription);
    }

    public void enterGroupYear(String groupYear) {
        groupYearInput_xpath.sendKeys(groupYear);
    }

    public void enterMaximumCapacity(String maximumCapacity) {
        maximumCapacityInput_xpath.sendKeys(maximumCapacity);
    }
}
