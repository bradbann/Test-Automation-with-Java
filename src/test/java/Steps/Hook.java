package Steps;

import Base.BaseUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by whaque on 27.11.17.
 */
public class Hook extends BaseUtil {
    private BaseUtil base;

    public Hook(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void InitializeTest()
    {
        System.out.println("Opening the browser: Firefox" + "\n");
        System.setProperty("webdriver.firefox.marionette", "/bin/");
        base.Driver = new FirefoxDriver();

        //Chrome driver
        //System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        //base.Driver = new ChromeDriver();
    }

    @After
    public void TearDownTest(Scenario scenario)
    {
        if (scenario.isFailed()) {
            //Take screenshot
            System.out.println(scenario.getName());
        }
        System.out.println("Closing the browser: Firefox" + "\n");
    }
}
