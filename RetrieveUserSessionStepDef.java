package automation.retrieveUserSession;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class RetrieveUserSessionStepDef {

	static WebDriver driver;

	@Before
	public void setup() {

		System.setProperty("webdriver.chrome.driver",
				"D:\\selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@Given("^Navigate to the UserLogin page$")

	public void Step_One() {
		driver.get("http://localhost:8088/HomeInsurance_NeerjaBalasubramanian_DynamicWebProject/views/UserLogin.jsp");
		System.out.println("Opening the window ");

	}

	@And ("^Enter the Username$")
	public void Step_two() throws InterruptedException {
	   	Actions action = new Actions(driver);
	      driver.findElement(By.name("username")).sendKeys("kanna1");
	}

	@And ("^Enter the Password$")
	public void Step_three() throws InterruptedException {
	   	Actions action = new Actions(driver);
	      driver.findElement(By.name("userpass")).sendKeys("123kanna");

	}
	@And ("^Click on UserLogin$")
	public void Step_four() throws InterruptedException {
	   	Actions action = new Actions(driver);
	      driver.findElement(By.name("login")).click();
	}
	@And ("^Click on Retrieve a Quote$")
	public void Step_five() throws InterruptedException {
	   	Actions action = new Actions(driver);
	      driver.findElement(By.name("RetrieveQuote")).click();
	}
	@And ("^Click on Quote Summary$")
	public void Step_six() throws InterruptedException {
	   	Actions action = new Actions(driver);
	      driver.findElement(By.name("proceed")).click();
	}
	@And ("^Click on the Buy Quote$")
	public void Step_seven() throws InterruptedException {
		Actions action = new Actions(driver);
	  driver.findElement(By.xpath("/html/body/center[2]/a")).click();
	}
	@And ("^Enter the policy start date$")
	public void Step_eight() throws InterruptedException {
		Actions action = new Actions(driver);
		 driver.findElement(By.name("policyStatedate")).sendKeys("02/03/1984");
	}
	@And ("^Check the checkbox$")
	public void Step_nine() throws InterruptedException {
		Actions action = new Actions(driver);
		if ( !driver.findElement(By.id("1")).isSelected())
		{
		     driver.findElement(By.id("1")).click();
		}
	}
	@And ("^Click on the Submit$")
	public void Step_ten() throws InterruptedException {
		Actions action = new Actions(driver);
	  driver.findElement(By.xpath("/html/body/form/table/tbody/tr[6]/td/input")).click();
	}
	@And ("^Click on Logout$")
	public void Step_eleven() throws InterruptedException {
		Actions action = new Actions(driver);
	  driver.findElement(By.xpath("/html/body/form/section/a[5]")).click();
	}
	
}