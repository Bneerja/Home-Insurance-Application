package automation.AdminUserSession;

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

public class AdminUserSessionStepDef {

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

	@And ("^Enter admin Username$")
	public void Step_two() throws InterruptedException {
	   	Actions action = new Actions(driver);
	      driver.findElement(By.name("username")).sendKeys("Sindhu");
	}

	@And ("^Enter admin Password$")
	public void Step_three() throws InterruptedException {
	   	Actions action = new Actions(driver);
	      driver.findElement(By.name("userpass")).sendKeys("harshu");
	}
	@And ("^Click on AdminLogin$")
	public void Step_four() throws InterruptedException {
	   	Actions action = new Actions(driver);
	     driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td[2]/table/tbody/tr/td/form/a/span")).click();
	}
	@And ("^Enter  User name$")
	public void Step_five() throws InterruptedException {
	   	Actions action = new Actions(driver);
	      driver.findElement(By.name("username")).sendKeys("kanna1");
	}
	@And ("^Click on submit$")
	public void Step_six() throws InterruptedException {
	   	Actions action = new Actions(driver);
	     driver.findElement(By.name("search")).click();	
	}	
	@And ("^Click Logout$")
	public void Step_eleven() throws InterruptedException {
		Actions action = new Actions(driver);
	  driver.findElement(By.xpath("/html/body/section/a[2]")).click();
	}
}