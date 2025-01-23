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

    @FindBy(xpath = "//input[@name='username']") WebElement email;
    @FindBy(xpath = "//input[@name='password']") WebElement passWord;
    @FindBy(xpath = "//button[@type='submit']") WebElement loginBtn;
    @FindBy(xpath = "(//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message'])[1]")
    WebElement requiredErrMsg1;

    @FindBy(xpath = "(//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message'])[2]")
    WebElement requiredErrMsg2;

    @FindBy(xpath = "//p[.='Invalid credentials']") WebElement invalidMessage;

    public void enterLoginDetails()
    {
        waitForElementTobeEnterText(email,getProperty("username"));
        assertElementDisplayed(email,"Element not Displaying");
        waitForElementTobeEnterText(passWord,getProperty("password"));
        assertElementDisplayed(passWord,"Element not Displaying");

    }
    public void validateErrorMessage(){
        assertEqualsText(requiredErrMsg1,"Required");
        assertEqualsText(requiredErrMsg2,"Required");

    }

    public void enterInvalidLoginDetails()
    {
        waitForElementTobeEnterText(email,getProperty("invalidUsername"));
        assertElementDisplayed(email,"Element not Displaying");
        waitForElementTobeEnterText(passWord,getProperty("invalidPassword"));
        assertElementDisplayed(passWord,"Element not Displaying");

    }
    public void validateInvalidLogin(String expected){
        assertEqualsText(invalidMessage,expected);

    }

    public void clickOnLoginBtn()
    {
        waitForElementTobeClick(loginBtn);

    }

    public  void validateLoginPage(){
       String actual= getDriver().getTitle();
       String expected="OrangeHRM";
       assertEqualsTitles(actual,expected);

    }


}
