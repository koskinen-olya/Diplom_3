import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestRegistration {
    WebDriver driver;

    @Before
    public void openBrowserAndDeleteUser() {
        //Открытие браузера
        //При необходимости прохождения тестов в яндекс браузере раскомментировать следующую строку
        //System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\yandexdriver.exe");
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/register");
        //Удаление пользователя
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site";
        ApiClient apiClient = new ApiClient();
        boolean user = apiClient.loginUser("newUser@mail.ru", "012345").then().extract().body().path("success");
        if (user)
            apiClient.deleteUser("newUser@mail.ru", "012345");
    }

    @Test
    public void testSuccessRegistration() {
        PersonalCabinetPage personalCabinetPage = new PersonalCabinetPage(driver);
        personalCabinetPage.registr("newUser", "newUser@mail.ru", "012345");
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//h2[text()='Вход']")));
    }

    @Test
    public void testWrongPassword() {
        PersonalCabinetPage personalCabinetPage = new PersonalCabinetPage(driver);
        personalCabinetPage.registr("user", "user@mail.ru", "123");
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//p[text()='Некорректный пароль']")));
    }

    @After
    public void tearDownAndDeleteUser() {
        //Закрытие браузера
        driver.quit();
        //Удаление пользователя
        ApiClient apiClient = new ApiClient();
        boolean user = apiClient.loginUser("newUser@mail.ru", "012345").then().extract().body().path("success");
        if (user)
            apiClient.deleteUser("newUser@mail.ru", "012345");
    }
}
