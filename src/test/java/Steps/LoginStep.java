package Steps;

import Base.BaseUtil;
import Pages.LoginPage;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by whaque on 27.04.17.
 */
public class LoginStep extends BaseUtil {

    private BaseUtil base;

    public LoginStep(BaseUtil base) {
        this.base = base;
    }

    @Given("^I navigate to the login page$")
    public void iNavigateToTheLoginPage() throws Throwable {
        System.out.println("Navigate the login page" + "\n");
        String baseUrl = "http://executeautomation.com/demosite/Login.html";
        base.Driver.get(baseUrl);
    }

    @And("^I enter the following for login$")
    public void iEnterTheFollowingForLogin(DataTable table) throws Throwable {
        List<User> users;
        users = table.asList(User.class);

        LoginPage page = new LoginPage(base.Driver);

        for (User user : users) {
            page.Login(user.username, user.password);

        }
    }

    @And("^I click login button$")
    public void iClickLoginButton() throws Throwable {
        //base.Driver.findElement(By.name("Login")).submit();
        LoginPage page = new LoginPage(base.Driver);
        page.ClickLogin();
    }

    @Then("^I should see the userform page$")
    public void iShouldSeeTheUserformPage() throws Throwable {
        WebElement formElement = base.Driver.findElement(By.id("Initial"));
        Assert.assertEquals("It's not displayed!", formElement.isDisplayed(),true);
    }

    public class User {
        public String username;
        public String password;

        public User(String userName, String passWord) {
            username = userName;
            password = passWord;
        }
    }
}
