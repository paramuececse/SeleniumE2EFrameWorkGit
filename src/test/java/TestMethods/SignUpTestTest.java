package TestMethods;

import org.testng.annotations.Test;

import com.Objects.LoginDemo;
import com.Objects.Signupdemo;

import Com.DriverPackage.DriverClass;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium. WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class SignUpTestTest extends DriverClass {
	WebDriver driver;
	//create signupdemo class instance to access the methods 
	Signupdemo signupobjects;
		
	@BeforeTest
	public void AccessDriverClass() throws IOException {
		driver=beforeTest();
		
	}

  @Test 
  public void SignUpDemoTest() throws InterruptedException {
    signupobjects=new Signupdemo(driver);
    signupobjects.signupbuttonMethod();
    signupobjects.SignupUsername("paramu");
    signupobjects.SignupPassword("param098");
    signupobjects.SignUpClickButton();
   Thread.sleep(3000);
    //close pop-up notification if when users is already exists
   
 String s=   driver.switchTo().alert().getText();
 System.out.println(s);
 String excpected="This user already exist.";
 Assert.assertEquals(s,excpected);
 driver.switchTo().alert().accept();;
    signupobjects.SignUpCloseButton();
 Thread.sleep(15000);
  }
  
@AfterTest
  public void afterTest() {
	 driver.close();
  }
}
