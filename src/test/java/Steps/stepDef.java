package Steps;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class stepDef {

    WebDriver driver;

    @Given("i am on the login page")
    public void i_am_on_the_login_page() {

        driver = new ChromeDriver();
        driver.get("https://ndosisimplifiedautomation.vercel.app/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("/html/body/div/div/nav/div[1]/div[3]/button")).click();
    }
    @And("i enter my email (.*)$")
    public void i_enter_my_email(String email) {
        driver.findElement(By.id("login-email")).sendKeys(email);
    }
    @And("i enter my password (.*)$")
    public void i_enter_my_password(String password) {
        driver.findElement(By.id("login-password")).sendKeys(password);
    }
    @When("i click on the login button")
    public void i_click_on_the_login_button() {
        driver.findElement(By.id("login-submit")).click();
    }
    @Then("i should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        assert driver.findElement(By.xpath("//*[@id=\"app-root\"]/nav/div[1]/div[2]/div[4]/button/span[2]")).isDisplayed();
    }
    @And("i click on mobile automation")
    public void iClickOnMobileAutomation() {
        //fffffff
    }
    
    @After
    public void closeBrowser(){
        driver.quit();
    }


}
