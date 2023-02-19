import io.restassured.RestAssured;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class TestRegistration {
    WebDriver driver;
    ApiClient apiClient = new ApiClient();
    private final String URL = "https://stellarburgers.nomoreparties.site/register";
    private final String URL_API = "https://stellarburgers.nomoreparties.site";
    //Создание рандомного email
    static String email = String.format("%s@mail.ru", RandomStringUtils.randomAlphabetic(5).toLowerCase());
    //Создание рандомного password
    static String password = String.format("%s", RandomStringUtils.randomNumeric(6).toLowerCase());
    //Создание рандомного password
    static String wrongPassword = String.format("%s", RandomStringUtils.randomNumeric(3).toLowerCase());
    //Создание рандомного name
    static String name = String.format("%s", RandomStringUtils.randomAlphabetic(5).toLowerCase());

    @Before
    public void openBrowser() {
        //Открытие браузера
        //При необходимости прохождения тестов в яндекс браузере раскомментировать следующую строку
        //System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\yandexdriver.exe");
        driver = new ChromeDriver();
        driver.get(URL);
    }

    @Test
    public void testSuccessRegistration() {
        PersonalCabinetPage personalCabinetPage = new PersonalCabinetPage(driver);
        personalCabinetPage.registr(name, email, password);
        personalCabinetPage.waitButtonLoginPC();
        assertEquals("Вход", personalCabinetPage.getTextButtonLogin());
    }

    @Test
    public void testWrongPassword() {
        PersonalCabinetPage personalCabinetPage = new PersonalCabinetPage(driver);
        personalCabinetPage.registr(name, email, wrongPassword);
        personalCabinetPage.waitWrongPassword();
        assertEquals("Некорректный пароль", personalCabinetPage.getTextWrongPassword());
    }

    @After
    public void tearDownAndDeleteUser() {
        //Закрытие браузера
        driver.quit();
        //Удаление пользователя
        RestAssured.baseURI = URL_API;
        apiClient.deleteUser(email, password);
    }
}
