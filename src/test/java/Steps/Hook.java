package Steps;

import Base.BaseUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.sql.Driver;

public class Hook extends BaseUtil {

    private BaseUtil base;

    public Hook(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void InitializeTest(){
        System.out.println("Opening the browser: Firefox");

        System.setProperty("webdriver.gecko.driver", "/usr/local/Cellar/geckodriver/0.23.0/bin/geckodriver");
        base.Driver = new FirefoxDriver();

        // Passing a dummy Webdriver instance
        // base.StepInfo = "Firefox Driver";


    }

    @After
    public void TearDownTest(Scenario scenario){

        if(scenario.isFailed()){

            // Take screenshot
            System.out.println(scenario.getName());
        }

        System.out.println("Closing the browser: MOCK");
    }
}
