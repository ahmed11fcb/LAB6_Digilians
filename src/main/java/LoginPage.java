import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    public final By username = By.id("user-name");

    public LoginPage(WebDriver driver)
    {
        this.driver=driver;
    }

    public void Enter_Username(String user)
    {
        driver.findElement(username).sendKeys(user);
    }
    public void MyName (){
        System.out.println("Roaa");
    }

}
