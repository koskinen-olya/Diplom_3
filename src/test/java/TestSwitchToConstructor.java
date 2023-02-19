import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class TestSwitchToConstructor {
    WebDriver driver;
    private final String URL = "https://stellarburgers.nomoreparties.site/login";

    @Before
    public void openBrowser() {
        //При необходимости прохождения тестов в яндекс браузере раскомментировать следующую строку
        //System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\yandexdriver.exe");
        driver = new ChromeDriver();
        driver.get(URL);
    }

    @Test
    public void testSwitchToConstructor() {
        PersonalCabinetPage personalCabinetPage = new PersonalCabinetPage(driver);
        personalCabinetPage.clickConstructor();
        personalCabinetPage.waitButtonLogin();
        assertEquals("Войти в аккаунт", personalCabinetPage.getTextLogin());
    }

    @Test
    public void testSwitchToLogo() {
        PersonalCabinetPage personalCabinetPage = new PersonalCabinetPage(driver);
        personalCabinetPage.clickLogo();
        personalCabinetPage.waitButtonLogin();
        assertEquals("Войти в аккаунт", personalCabinetPage.getTextLogin());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
