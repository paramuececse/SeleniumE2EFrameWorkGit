package TestMethods;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.Objects.LoginDemo;
import Com.DriverPackage.DriverClass;
public class LoginTest extends DriverClass{
WebDriver driver;
	//create LoginDemo class instance to access the methods
		LoginDemo LoginObjects;
	
	//access the driver class
	@BeforeTest
	public void AccessDriverClass() throws IOException {
		driver=beforeTest();
	}
@Test
	public void LoginPageDemoTest() throws InterruptedException {
		
		LoginObjects=new LoginDemo (driver);
		LoginObjects.LoginButton1();
		LoginObjects.LoginUserName("paramu");
		Thread.sleep(50000);
		LoginObjects.LoginPassword("param098");
		LoginObjects.LoginClickButton2();
		Thread.sleep(5000);
		//check login page is successfully open or not
		String UserName="paramu";
		String expected="Welcome "+UserName;
		String actual=driver.findElement(By.id("nameofuser")).getText();
		
		System.out.println(actual);
		Assert.assertEquals(actual, expected);
		Thread.sleep(5000);
	}
@AfterTest
public void afterTest() {
	 //driver.close();
}

}
