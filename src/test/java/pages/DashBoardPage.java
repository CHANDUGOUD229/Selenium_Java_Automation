package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.GenericMethods;

import static org.testng.Assert.assertEquals;
import static utility.GenericMethods.globalDriver;

public class DashBoardPage extends GenericMethods {


    public DashBoardPage() {
        PageFactory.initElements(globalDriver(), this);
    }

    @FindBy(xpath = "//span[@class='oxd-topbar-header-breadcrumb']")  WebElement dashBoard;
    @FindBy(xpath = "//span[@class='oxd-userdropdown-tab']")  WebElement userDropDownTab;
    @FindBy(xpath = "//a[@href='/web/index.php/auth/logout']")  WebElement logoutLink;


    public void validateDashBoardPage(){
        assertEqualsText(dashBoard,"Dashboard");
    }

    public void clickOnLogout()
    {
        click(userDropDownTab);
        click(logoutLink);
    }


}
