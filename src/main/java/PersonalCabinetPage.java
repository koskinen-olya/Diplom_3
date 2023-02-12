import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationClient {
    private WebDriver driver;

    //локатор для поля "Имя"
    private By inputName = By.xpath(".//fieldset[1]/div/div/input");
    //локатор для поля "Email"
    private By inputEmail = By.xpath(".//fieldset[2]/div/div/input");
    //локатор для поля "Пароль"
    private By inputPassword = By.xpath(".//fieldset[3]/div/div/input");
    //локатор для кнопки "Зарегистрироваться"
    private By buttonRegistr = By.xpath(".//button[text()='Зарегистрироваться']");

    public RegistrationClient(WebDriver driver){
        this.driver = driver;
    }

    public void registr(String name, String email,String password){
        driver.findElement(inputName).sendKeys(name);
        driver.findElement(inputEmail).sendKeys(email);
        driver.findElement(inputPassword).sendKeys(password);
        driver.findElement(buttonRegistr).click();
    }

}
