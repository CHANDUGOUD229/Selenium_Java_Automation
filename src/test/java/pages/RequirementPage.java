package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.GenericMethods;

import static utility.GenericMethods.globalDriver;

public class RequirementPage extends GenericMethods {

    public RequirementPage() {
        PageFactory.initElements(globalDriver(), this);
    }

    @FindBy(xpath = "//aside[@class='oxd-sidepanel']//ul//li//a//span[.='Recruitment']")
    WebElement recruitmentLink;

    @FindBy(xpath = "//button[normalize-space()='Add']")
    WebElement addBtn;

    @FindBy(xpath = "//input[@name='firstName']")
    WebElement firstName;

    @FindBy(xpath = "//input[@name='middleName']")
    WebElement middleName;

    @FindBy(xpath = "//input[@name='lastName']")
    WebElement lastName;
    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active' and @placeholder='Type here'])[1]")
    WebElement email;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement saveBtn;


    public void clickOnRequirementLink() throws InterruptedException {
        click(recruitmentLink);
        mouseClickAction(addBtn);
    }

    public void addCandidate(String fName, String mName, String lName, String emailId) {
        enterText(firstName, fName);
        enterText(middleName, mName);
        enterText(lastName, lName);
        enterText(email, emailId);
        click(saveBtn);
        click(recruitmentLink);
    }


}
