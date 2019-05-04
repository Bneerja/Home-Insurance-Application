package automation.userSession;

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

public class UserSessionStepDef {

	static WebDriver driver;

	@Before
	public void setup() {

		System.setProperty("webdriver.chrome.driver",
				"D:\\selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@Given("^I want to navigate to the UserLogin page$")

	public void Step_One() {
		driver.get("http://localhost:8088/HomeInsurance_NeerjaBalasubramanian_DynamicWebProject/views/UserLogin.jsp");
		System.out.println("Opening the window ");

	}

	@And ("^Enter Username$")
	public void Step_two() throws InterruptedException {
	   	Actions action = new Actions(driver);
	      driver.findElement(By.name("username")).sendKeys("neerja2");
	}

	@And ("^Enter Password$")
	public void Step_three() throws InterruptedException {
	   	Actions action = new Actions(driver);
	      driver.findElement(By.name("userpass")).sendKeys("neerja234");

	}
	@And ("^Click on Login$")
	public void Step_four() throws InterruptedException {
	   	Actions action = new Actions(driver);
	      driver.findElement(By.name("login")).click();
	}
	@And ("^Click on get a Quote$")
	public void Step_five() throws InterruptedException {
	   	Actions action = new Actions(driver);
	      driver.findElement(By.xpath("/html/body/table/tbody/tr/td[2]/table/tbody/tr/td/a")).click();
	}
	@And ("^Choose residence type$")
	public void Step_six() throws InterruptedException {
		Select s = new Select(driver.findElement(By.name("residencetype")));
		s.selectByValue("Condo");
	   Thread.sleep(2000);
	}

	@And ("^Enter Address Line1$")
	public void Step_seven() throws InterruptedException {
		Actions action = new Actions(driver);
	  driver.findElement(By.name("addressline1")).sendKeys("122 hiddenrdg");
	}

	@And ("^Enter Address Line2$")
	public void Step_eight() throws InterruptedException {
		Actions action = new Actions(driver);
	  driver.findElement(By.name("addressline2")).sendKeys("apt 101");
	}
	@And ("^Enter City$")
	public void Step_ten() throws InterruptedException {
		Actions action = new Actions(driver);
	  driver.findElement(By.name("city")).sendKeys("irving");
	  }
	@And ("^Enter State$")
	public void Step_nine() throws InterruptedException {
		Actions action = new Actions(driver);
	  driver.findElement(By.name("state")).sendKeys("TX");
	}	
	@And ("^Enter Zip$")
	public void Step_eleven() throws InterruptedException {
		Actions action = new Actions(driver);
	  driver.findElement(By.name("zipcode")).sendKeys("75070");
	}
	@And ("^Choose Residence use$")
	public void Step_twelve() throws InterruptedException {
		Actions action = new Actions(driver);
	  driver.findElement(By.name("residenceuse")).sendKeys("Secondary");
	}
	@And ("^Click on Continue$")
	public void Step_thirteen() throws InterruptedException {
		Actions action = new Actions(driver);
	  driver.findElement(By.name("Continue")).click();
	}
	@And ("^Enter FirstName$")
	public void Step_fourteen() throws InterruptedException {
		Actions action = new Actions(driver);
	  driver.findElement(By.name("firstname")).sendKeys("Neerja2");
	}
	@And ("^Enter LastName$")
	public void Step_fifteen() throws InterruptedException {
		Actions action = new Actions(driver);
	  driver.findElement(By.name("lastname")).sendKeys("Bala2");
	}
	@And ("^Enter DateofBirth$")
	public void Step_sixteen() throws InterruptedException {
		Actions action = new Actions(driver);
	  driver.findElement(By.name("dateofbirth")).sendKeys("02/03/1984");
	}
	@And ("^Choose Are You Retired$")
	public void Step_seventeen() throws InterruptedException {
		Actions action = new Actions(driver);
	  driver.findElement(By.name("optradio")).click();
	}	
	@And ("^Enter SSN$")
	public void Step_Eighteen() throws InterruptedException {
		Actions action = new Actions(driver);
	  driver.findElement(By.name("ssn")).sendKeys("123457654");
	}
	@And ("^Enter Email Id$")
	public void Step_Nineteen() throws InterruptedException {
		Actions action = new Actions(driver);
	  driver.findElement(By.name("email")).sendKeys("neerja2@gmail.com");
	}
	@And ("^Click ContinueKey$")
	public void Step_Twenty() throws InterruptedException {
		Actions action = new Actions(driver);
	  driver.findElement(By.name("Continue")).click();
	}
	@And ("^Enter Market Value$")
	public void Step_TwentyOne() throws InterruptedException {
		Actions action = new Actions(driver);
	  driver.findElement(By.name("marketvalue")).sendKeys("300000");
	}
	@And ("^Enter Year Built$")
	public void Step_Twentytwo() throws InterruptedException {
		Actions action = new Actions(driver);
	  driver.findElement(By.name("year")).sendKeys("2000");
	}
	@And ("^Enter Square Feet$")
	public void Step_Twentythree() throws InterruptedException {
		Actions action = new Actions(driver);
	  driver.findElement(By.name("sqft")).sendKeys("2000");
	}
	@And ("^Choose Dwelling Style$")
	public void Step_Twentyfour() throws InterruptedException {
		Select s = new Select(driver.findElement(By.name("dwellingstyle")));
		s.selectByValue("1 Story");
	   Thread.sleep(2000);
	}
	@And ("^Choose Roof Material$")
	public void Step_Twentyfive() throws InterruptedException {
		Select s = new Select(driver.findElement(By.name("roofmaterial")));
		s.selectByValue("Clay");
	   Thread.sleep(2000);
	}
	@And ("^Choose Garage Type$")
	public void Step_Twentysix() throws InterruptedException {
		Select s = new Select(driver.findElement(By.name("garagetype")));
		s.selectByValue("Attached");
	   Thread.sleep(2000);
	}
	@And ("^Choose Number of FullBaths$")
	public void Step_Twentyseven() throws InterruptedException {
		Select s = new Select(driver.findElement(By.name("fullbath")));
		s.selectByValue("1");
	   Thread.sleep(2000);
	}
	@And ("^Choose Number of HalfBaths$")
	public void Step_Twentyeight() throws InterruptedException {
		Select s = new Select(driver.findElement(By.name("halfbath")));
		s.selectByValue("1");
	   Thread.sleep(2000);
	}
	@And ("^Has swimming pool$")
	public void Step_Twentynine() throws InterruptedException {
		Actions action = new Actions(driver);
		  driver.findElement(By.xpath("/html/body/form/table/tbody/tr[9]/td[2]/label[2]/input")).click();
	}	
	@And ("^Click Continue again$")
	public void Step_Thirty() throws InterruptedException {
		Actions action = new Actions(driver);
	  driver.findElement(By.name("Continue")).click();
	}
	@And ("^Click Procced to Buy$")
	public void Step_Thirtyone() throws InterruptedException {
		Actions action = new Actions(driver);
	  driver.findElement(By.name("proceed")).click();
	}
	@And ("^Click on Buy Quote$")
	public void Step_Thirtytwo() throws InterruptedException {
		Actions action = new Actions(driver);
	  driver.findElement(By.xpath("/html/body/center[2]/a")).click();
	}
	@And ("^Enter Policy Start Date$")
	public void Step_Thirtythree() throws InterruptedException {
		Actions action = new Actions(driver);
	  driver.findElement(By.name("policyStatedate")).sendKeys("03/03/2019");
	}
	@And ("^Check the terms and conditions$")
	public void Step_Thirtyfour() throws InterruptedException {
		Actions action = new Actions(driver);
		if ( !driver.findElement(By.id("1")).isSelected())
		{
		     driver.findElement(By.id("1")).click();
		}
	}
	@And ("^Click on Submit$")
	public void Step_Thirtyfive() throws InterruptedException {
		Actions action = new Actions(driver);
	  driver.findElement(By.xpath("/html/body/form/table/tbody/tr[6]/td/input")).click();
	}
	@And ("^Click Logout$")
	public void Step_Thirtysix() throws InterruptedException {
		Actions action = new Actions(driver);
	  driver.findElement(By.xpath("/html/body/form/section/a[5]")).click();
	}
}
