package testng;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest {

	WebDriver driver;
	@BeforeMethod(alwaysRun=true)
	public void Setup() throws InterruptedException {
		
		System.setProperty("webdriver.chorme.driver", "chromedriver.exe"); //register your web driver with set property method tell where it is
		//create an instance of web driver
		driver = new ChromeDriver();
		driver.get("https://www.simplilearn.com/");//launch url
		driver. manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		Thread.sleep(4000);
		
	}
	@Parameters({"param1","param2"})
	@Test(groups= {"Sanity"})
	public void LoginTestCase(String UserName, String Password) {
		WebElement LoginLink=driver.findElement(By.linkText("Log in"));//locator to get ur element
		LoginLink.click();//click the click
		WebElement Email=driver.findElement(By.name("user_login"));//locator to get ur element
		Email.sendKeys(UserName);//click the click
		WebElement password=driver.findElement(By.id("password"));//locator to get ur element
		password.sendKeys(Password);
		WebElement RememberMe=driver.findElement(By.className("rememberMe"));
		RememberMe.click();
		WebElement LoginButton=driver.findElement(By.name("btn_login"));//locator to get ur element
		LoginButton.click();
		WebElement errorMsg=driver.findElement(By.id("msg_box"));
		String ActMsg=errorMsg.getText();
		String ExpMsg="The email or password you have entered is invalid.";
	
		Assert.assertEquals(ActMsg, ExpMsg);
		List<WebElement> Links=driver.findElements(By.tagName("a"));//a number of tags stored inside a list
		System.out.println("Total number of links are " + Links.size());
		for(int i=0;i< Links.size();i++) {
			System.out.println("Href is " + Links.get(i).getAttribute("href"));
			
		}
		
	}
	@AfterMethod(alwaysRun=true)
	public void TearDown() {
		driver.close();
		
	}

}
