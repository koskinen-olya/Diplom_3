import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalCabinetPage {
    private WebDriver driver;

    private By inputName = By.xpath(".//fieldset[1]/div/div/input");
    private By inputEmailInRegistration = By.xpath(".//fieldset[2]/div/div/input");
    private By inputPasswordInRegistration = By.xpath(".//fieldset[3]/div/div/input");
    private By inputEmailInLogin = By.xpath(".//fieldset[1]/div/div/input");
    private By inputPasswordInLogin = By.xpath(".//fieldset[2]/div/div/input");
    private By constructor = By.xpath(".//p[text()='Конструктор']");
    private By logo = By.xpath(".//div/a[@href=\"/\"]");
    private By buttonRegistr = By.xpath(".//button[text()='Зарегистрироваться']");
    private By buttonRegistrFromPC = By.xpath(".//a[text()='Зарегистрироваться']");
    private By buttonLogin = By.xpath(".//button[text()='Войти']");
    private By buttonLoginInPageRegistr = By.xpath(".//a[text()='Войти']");
    private By personalCabinet = By.xpath(".//p[text()='Личный Кабинет']");
    private By buttonLogout = By.xpath(".//button[text()='Выход']");
    private By loginMainPage = By.xpath(".//button[text()='Войти в аккаунт']");
    private By loginPC = By.xpath(".//h2[text()='Вход']");
    private By buttonCreateOrder = By.xpath(".//button[text()='Оформить заказ']");
    private By buttonRecovery = By.xpath(".//a[text()='Восстановить пароль']");
    private By buttonWrongPassword = By.xpath(".//p[text()='Некорректный пароль']");

    public PersonalCabinetPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLoginOnMainPage() {
        driver.findElement(loginMainPage).click();
    }

    public void clickLoginOnPC() {
        driver.findElement(personalCabinet).click();
    }

    public void clickLoginFromPC() {
        driver.findElement(buttonRegistrFromPC).click();
    }

    public void clickButtonRecovery() {
        driver.findElement(buttonRecovery).click();
    }

    public void clickButtonLoginInPageRegistr() {
        driver.findElement(buttonLoginInPageRegistr).click();
    }

    public void clickConstructor() {
        driver.findElement(constructor).click();
    }

    public void clickLogo() {
        driver.findElement(logo).click();
    }


    public String getTextButtonOrder() {
        String text = driver.findElement(buttonCreateOrder).getText();
        return text;
    }

    public String getTextButtonLogin() {
        String text = driver.findElement(loginPC).getText();
        return text;
    }

    public String getTextWrongPassword() {
        String text = driver.findElement(buttonWrongPassword).getText();
        return text;
    }

    public String getTextLogin() {
        String text = driver.findElement(loginMainPage).getText();
        return text;
    }

    public void waitButtonLoginPC() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(loginPC));
    }

    public void waitButtonLogin() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(loginMainPage));
    }

    public void waitWrongPassword() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(buttonWrongPassword));
    }

    public void registr(String name, String email, String password) {
        driver.findElement(inputName).sendKeys(name);
        driver.findElement(inputEmailInRegistration).sendKeys(email);
        driver.findElement(inputPasswordInRegistration).sendKeys(password);
        driver.findElement(buttonRegistr).click();
    }

    public void login(String email, String password) {
        driver.findElement(inputEmailInLogin).sendKeys(email);
        driver.findElement(inputPasswordInLogin).sendKeys(password);
        driver.findElement(buttonLogin).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(buttonCreateOrder));
    }

    public void logout(String email, String password) {
        clickLoginOnMainPage();
        login(email, password);
        driver.findElement(personalCabinet).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(buttonLogout));
        driver.findElement(buttonLogout).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(loginPC));
    }
}
