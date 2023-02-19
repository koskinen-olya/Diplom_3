import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class TestSwitchToPersonalCabinet {
    WebDriver driver;
    private final String URL = "https://stellarburgers.nomoreparties.site/";

    @Before
    public void openBrowser() {
        //При необходимости прохождения тестов в яндекс браузере раскомментировать следующую строку
        //System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\yandexdriver.exe");
        driver = new ChromeDriver();
        driver.get(URL);
    }

    @Test
    public void testSwitchToPersonalCabinet() {
        PersonalCabinetPage personalCabinetPage = new PersonalCabinetPage(driver);
        personalCabinetPage.clickLoginOnPC();
        personalCabinetPage.waitButtonLoginPC();
        assertEquals("Вход", personalCabinetPage.getTextButtonLogin());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
