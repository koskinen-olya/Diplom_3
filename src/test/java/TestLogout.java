import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestLogout {
    WebDriver driver;

    @Before
    public void openBrowserAndCreateUser() {
        //При необходимости прохождения тестов в яндекс браузере раскомментировать следующую строку
        //System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\yandexdriver.exe");
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
        //Создание пользователя
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site";
        ApiClient apiClient = new ApiClient();
        apiClient.createUser("userTestLogin@mail.ru", "012345", "userTestLogin");
    }

    @Test
    public void testLogout() {
        PersonalCabinetPage personalCabinetPage = new PersonalCabinetPage(driver);
        personalCabinetPage.logout(".//p[text()='Личный Кабинет']", "userTestLogin@mail.ru", "012345");
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//h2[text()='Вход']")));
    }

    @After
    public void tearDownAndDeleteUser() {
        driver.quit();
        //Удаление пользователя
        ApiClient apiClient = new ApiClient();
        apiClient.deleteUser("userTestLogin@mail.ru", "012345");
    }
}
