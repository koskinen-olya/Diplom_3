import io.restassured.RestAssured;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import static org.junit.Assert.assertEquals;

public class TestLogout {
    WebDriver driver;
    ApiClient apiClient = new ApiClient();
    private final String URL = "https://stellarburgers.nomoreparties.site";
    //Создание рандомного email
    static String email = String.format("%s@mail.ru", RandomStringUtils.randomAlphabetic(5).toLowerCase());
    //Создание рандомного password
    static String password = String.format("%s", RandomStringUtils.randomNumeric(6).toLowerCase());
    //Создание рандомного name
    static String name = String.format("%s", RandomStringUtils.randomAlphabetic(5).toLowerCase());

    @Before
    public void openBrowserAndCreateUser() {
        //При необходимости прохождения тестов в яндекс браузере раскомментировать следующую строку
        //System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\yandexdriver.exe");
        driver = new ChromeDriver();
        driver.get(URL);
        //Создание пользователя
        RestAssured.baseURI = URL;
        apiClient.createUser(email, password, name);
    }

    @Test
    public void testLogout() {
        PersonalCabinetPage personalCabinetPage = new PersonalCabinetPage(driver);
        personalCabinetPage.logout(email, password);
        assertEquals("Вход", personalCabinetPage.getTextButtonLogin());

    }

    @After
    public void tearDownAndDeleteUser() {
        driver.quit();
        //Удаление пользователя
        apiClient.deleteUser(email, password);
    }
}
