import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class TestConstructor {
    private final String URL = "https://stellarburgers.nomoreparties.site/";
    WebDriver driver;

    @Before
    public void openBrowser() {
        //При необходимости прохождения тестов в яндекс браузере раскомментировать следующую строку
        //System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\yandexdriver.exe");
        driver = new ChromeDriver();
        driver.get(URL);
    }

    @Test
    public void testSouse() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSouse();
        assertEquals("Соусы", mainPage.getText());
    }

    @Test
    public void testBun() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickFilling();
        mainPage.clickBun();
        assertEquals("Булки", mainPage.getText());
    }

    @Test
    public void testFilling() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickFilling();
        assertEquals("Начинки", mainPage.getText());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
