package com.Objects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class Signupdemo {
	WebDriver driver;
	public Signupdemo(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="signin2")
	WebElement signinbutton;
	
	@FindBy(id="sign-username")
	WebElement signupusername;
	
	@FindBy(id="sign-password")
	WebElement signuppassword;
	
	@FindBy(xpath="(//button[normalize-space()='Sign up'])")
	WebElement signupclickbutton;
	
	@FindBy(xpath="(//button[@class='btn btn-secondary'])[2]")
	WebElement signupclosebutton;
	
	public void signupbuttonMethod() {
		signinbutton.click();
	}
	public void SignupUsername(String username) {
		signupusername.sendKeys(username);
	}
	public void SignupPassword(String password) {
		signuppassword.sendKeys(password);
	}
	public void SignUpClickButton() {
		signupclickbutton.click();
	}
	public void SignUpCloseButton() {
		signupclosebutton.click();
	}
}
