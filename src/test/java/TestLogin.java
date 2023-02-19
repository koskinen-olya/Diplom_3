import io.restassured.RestAssured;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class TestLogin {
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
        //Открытие браузера
        //При необходимости прохождения тестов в яндекс браузере раскомментировать следующую строку
        //System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\yandexdriver.exe");
        driver = new ChromeDriver();
        driver.get(URL);
        //Создание пользователя
        RestAssured.baseURI = URL;
        apiClient.createUser(email, password, name);
    }

    @Test
    public void testLoginFromMainPage() {
        PersonalCabinetPage personalCabinetPage = new PersonalCabinetPage(driver);
        personalCabinetPage.clickLoginOnMainPage();
        personalCabinetPage.login(email, password);
        assertEquals("Оформить заказ", personalCabinetPage.getTextButtonOrder());
    }

    @Test
    public void testLoginFromPersonalCabinet() {
        PersonalCabinetPage personalCabinetPage = new PersonalCabinetPage(driver);
        personalCabinetPage.clickLoginOnPC();
        personalCabinetPage.login(email, password);
        assertEquals("Оформить заказ", personalCabinetPage.getTextButtonOrder());
    }

    @Test
    public void testLoginFromRegistr() {
        PersonalCabinetPage personalCabinetPage = new PersonalCabinetPage(driver);
        personalCabinetPage.clickLoginOnPC();
        personalCabinetPage.clickLoginFromPC();
        personalCabinetPage.clickButtonLoginInPageRegistr();
        personalCabinetPage.login(email, password);
        assertEquals("Оформить заказ", personalCabinetPage.getTextButtonOrder());
    }

    @Test
    public void testLoginFromRecovery() {
        PersonalCabinetPage personalCabinetPage = new PersonalCabinetPage(driver);
        personalCabinetPage.clickLoginOnPC();
        personalCabinetPage.clickButtonRecovery();
        personalCabinetPage.clickButtonLoginInPageRegistr();
        personalCabinetPage.login(email, password);
        assertEquals("Оформить заказ", personalCabinetPage.getTextButtonOrder());
    }

    @After
    public void tearDownAndDeleteUser() {
        //Закрытие браузера
        driver.quit();
        //Удаление пользователя
        apiClient.deleteUser(email, password);
    }
}
