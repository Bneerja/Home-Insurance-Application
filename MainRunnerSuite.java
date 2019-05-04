package automation.mainRunner;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import automation.AdminUserSession.AdminUserSessionRunner;
import automation.retrieveUserSession.RetrieveUserSessionRunner;
import automation.userSession.UserSessionRunner;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Suite.class)
@Suite.SuiteClasses({ RetrieveUserSessionRunner.class, UserSessionRunner.class, AdminUserSessionRunner.class

})

public class MainRunnerSuite {

}
