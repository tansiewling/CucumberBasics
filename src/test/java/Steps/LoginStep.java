package Steps;

import Base.BaseUtil;
import Transformation.EmailTransform;
import Transformation.SalaryCountTransformer;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.Transform;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import java.util.ArrayList;
import java.util.List;

public class LoginStep extends BaseUtil {

    private BaseUtil base;

    public LoginStep(BaseUtil base) {
        this.base = base;
    }

    @Given("^I navigate to the login page$")
    public void iNavigateToTheLoginPage() throws Throwable {

        System.out.println("Navigate to the login page");
        base.Driver.navigate().to("http://executeautomation.com/demosite/Login.html");
    }

    @And("^I enter the following for Login$")
    public void iEnterTheFollowingForLogin(DataTable table) throws Throwable {

        /* List<List<String>> data = table.raw();

        System.out.println("The value is : " + data.get(0).get(0).toString()); // 1st row 1st column
        System.out.println("The value is : " + data.get(0).get(1).toString()); // 1st row 2nd column */

        // Create an ArrayList
        List<User> users = new ArrayList<User>();

        // Store all the users
        users = table.asList(User.class);

        for (User user: users){
            System.out.println ("The UserName is " + user.username);
            System.out.println ("The Password is " + user.password);
        }
    }

    @And("^I click login button$")
    public void iClickLoginButton() throws Throwable {

        System.out.println("Click Login button");
    }

    @Then("^I should see the userform page$")
    public void iShouldSeeTheUserformPage() throws Throwable {

        System.out.println("Should see userform");

        // System.out.println("The driver is " + base.StepInfo);
    }

    @And("^I enter ([^\"]*) and ([^\"]*)$")
    public void iEnterUsernameAndPassword(String username, String password) throws Throwable {

        System.out.println ("The UserName is " + username);
        System.out.println ("The Password is " + password);
    }

    @And("^I enter the users email address as Email:([^\"]*)$")
    public void iEnterTheUsersEmailAddressAsEmailAdmin(@Transform(EmailTransform.class)String email) throws Throwable {

        System.out.println("The email address is " + email);
    }

    @And("^I will verify the count of my salary digits for Rs (\\d+)$")
    public void iWillVerifyTheCountOfMySalaryDigitsForRs(@Transform(SalaryCountTransformer.class) int salary) throws Throwable {

        System.out.println("My salary digits is " + salary);
    }


    public class User{
        public String username;
        public String password;

        public User(String userName, String passWord){
            username = userName;
            password = passWord;
        }
    }

}
