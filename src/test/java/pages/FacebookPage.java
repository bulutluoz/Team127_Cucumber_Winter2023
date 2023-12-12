package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FacebookPage {

    public FacebookPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//button[@title='Allow all cookies']")
    public WebElement cookiesKabulButonu;

    @FindBy(xpath = "//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")
    public WebElement yeniHesapOlusturButonu;

    @FindBy(name = "websubmit")
    public WebElement yeniKayitKaydolButonu;

}
