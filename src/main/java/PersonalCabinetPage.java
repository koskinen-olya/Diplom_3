import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalCabinetPage {
    private WebDriver driver;

    //локатор для поля "Имя"
    private By inputName = By.xpath(".//fieldset[1]/div/div/input");
    //локатор для поля "Email" на форме регистрации
    private By inputEmailInRegistration = By.xpath(".//fieldset[2]/div/div/input");
    //локатор для поля "Пароль" на форме регистрации
    private By inputPasswordInRegistration = By.xpath(".//fieldset[3]/div/div/input");
    //локатор для поля "Email" на форме входа
    private By inputEmailInLogin = By.xpath(".//fieldset[1]/div/div/input");
    //локатор для поля "Пароль" на форме входа
    private By inputPasswordInLogin = By.xpath(".//fieldset[2]/div/div/input");
    //локатор для кнопки "Зарегистрироваться"
    private By buttonRegistr = By.xpath(".//button[text()='Зарегистрироваться']");
    //локатор для кнопки "Войти"
    private By buttonLogin = By.xpath(".//button[text()='Войти']");
    //локатор для кнопки "Личный кабинет"
    private By personalCabinet = By.xpath(".//p[text()='Личный Кабинет']");
    //локатор для кнопки "Выход"
    private By buttonLogout = By.xpath(".//button[text()='Выход']");

    public PersonalCabinetPage(WebDriver driver) {
        this.driver = driver;
    }

    public void registr(String name, String email, String password) {
        driver.findElement(inputName).sendKeys(name);
        driver.findElement(inputEmailInRegistration).sendKeys(email);
        driver.findElement(inputPasswordInRegistration).sendKeys(password);
        driver.findElement(buttonRegistr).click();
    }

    public void login(String lokator, String email, String password) {
        driver.findElement(By.xpath(lokator)).click();
        driver.findElement(inputEmailInLogin).sendKeys(email);
        driver.findElement(inputPasswordInLogin).sendKeys(password);
        driver.findElement(buttonLogin).click();
    }

    public void logout(String lokator, String email, String password) {
        login(lokator, email, password);
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(personalCabinet));
        driver.findElement(personalCabinet).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(buttonLogout));
        driver.findElement(buttonLogout).click();
    }
}
