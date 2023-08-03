package com.Objects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class LoginDemo {
private WebDriver driver;
public LoginDemo(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
@FindBy(id="login2")
WebElement loginbutton1;
@FindBy(id="loginusername")
WebElement loginusername;
@FindBy(id="loginpassword")
WebElement loginpassword;
@FindBy(xpath="//button[normalize-space()='Log in']")
WebElement loginclickbutton2;

public void LoginButton1() {
	loginbutton1.click();
}
public void LoginUserName(String UserName) {
	loginusername.sendKeys(UserName);;
}
public void LoginPassword(String password) {
	loginpassword.sendKeys(password);
}
public void LoginClickButton2() {
	loginclickbutton2.click();
}
}