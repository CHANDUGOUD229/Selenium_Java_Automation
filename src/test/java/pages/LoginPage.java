package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.DriverFactory;
import utility.GenericMethods;

public class LoginPage extends GenericMethods {

    public LoginPage() {
        PageFactory.initElements(globalDriver(), this);
    }

    @FindBy(id = "Email") WebElement email;
    @FindBy(id = "Password") WebElement passWord;
    @FindBy(xpath = "//button[normalize-space()='Log in']") WebElement loginBtn;

    public void enterLoginDetails()
    {
        waitForElementTobeEnterText(email,getProperty("username"));
        assertElementDisplayed(email,email+"Element not Displaying");
        waitForElementTobeEnterText(passWord,getProperty("password"));
        assertElementDisplayed(passWord,passWord+"Element not Displaying");

    }

    public void clickOnLoginBtn()
    {
        waitForElementTobeClick(loginBtn);
    }


}
