package objectRepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {//Rule1: Create separate POM class
	//Rule2: Identify all web elements using annotations
	@FindBy(id="user-name")
	private WebElement usernameEdit;
	
	@FindBy (id="password")
	private WebElement passwordEdit;
	//Auto Healing Process- if first locator is not able to identify the web element 
	// Automatically then @findAll will shift to another locator for identifying the webelement
//	@FindAll ({@FindBy(id="password"),@FindBy(name="password")})//Single Web Element with multiple locator- OR operater
//	private WebElement passwordEdit1;
	
//	@FindBys ({@FindBy(id="password"),@FindBy(name="password")})//Single Web Element with multiple locator- AND operater
//	private WebElement passwordEdit1;

	
	@FindBy (id="login-button")
	private WebElement loginButton;
	//Rule3: Create a constructor to initialize WebElements
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
// Rule4: Provide getters to access the web elements

	public WebElement getUsernameEdit() {
		return usernameEdit;
	}

	public WebElement getPasswordEdit() {
		return passwordEdit;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	/**
	 * This method perporforms login operation
	 * @param username
	 * @param password
	 */

	public void loginApp(String username, String password)
	{
	usernameEdit.sendKeys(username);
	passwordEdit.sendKeys(password);
	loginButton.click();
	}
}
