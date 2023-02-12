import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestLogin {
    WebDriver driver;

    @Before
    public void openBrowserAndCreateUser() {
        //Открытие браузера
        //При необходимости прохождения тестов в яндекс браузере раскомментировать следующую строку
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\yandexdriver.exe");
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
        //Создание пользователя
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site";
        ApiClient apiClient = new ApiClient();
        apiClient.createUser("userTestLogin@mail.ru", "012345", "userTestLogin");
    }

    @Test
    public void testLoginFromMainPage() {
        PersonalCabinetPage personalCabinetPage = new PersonalCabinetPage(driver);
        personalCabinetPage.login(".//button[text()='Войти в аккаунт']", "userTestLogin@mail.ru", "012345");
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[text()='Оформить заказ']")));
    }

    @Test
    public void testLoginFromPersonalCabinet() {
        PersonalCabinetPage personalCabinetPage = new PersonalCabinetPage(driver);
        personalCabinetPage.login(".//p[text()='Личный Кабинет']", "userTestLogin@mail.ru", "012345");
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[text()='Оформить заказ']")));
    }

    @Test
    public void testLoginFromRegistr() {
        driver.findElement(By.xpath(".//p[text()='Личный Кабинет']")).click();
        driver.findElement(By.xpath(".//a[text()='Зарегистрироваться']")).click();
        PersonalCabinetPage personalCabinetPage = new PersonalCabinetPage(driver);
        personalCabinetPage.login(".//a[text()='Войти']", "userTestLogin@mail.ru", "012345");
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[text()='Оформить заказ']")));
    }

    @Test
    public void testLoginFromRecovery() {
        driver.findElement(By.xpath(".//p[text()='Личный Кабинет']")).click();
        driver.findElement(By.xpath(".//a[text()='Восстановить пароль']")).click();
        PersonalCabinetPage personalCabinetPage = new PersonalCabinetPage(driver);
        personalCabinetPage.login(".//a[text()='Войти']", "userTestLogin@mail.ru", "012345");
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[text()='Оформить заказ']")));
    }

    @After
    public void tearDownAndDeleteUser() {
        //Закрытие браузера
        driver.quit();
        //Удаление пользователя
        ApiClient apiClient = new ApiClient();
        apiClient.deleteUser("userTestLogin@mail.ru", "012345");
    }
}
