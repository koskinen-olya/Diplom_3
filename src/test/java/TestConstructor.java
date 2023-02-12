import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestConstructor {
    WebDriver driver;

    @Before
    public void openBrowser() {
        //При необходимости прохождения тестов в яндекс браузере раскомментировать следующую строку
        //System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\yandexdriver.exe");
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
    }

    @Test
    public void testSouse() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSouse();
    }
    @Test
    public void testBun() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickBun();
    }
    @Test
    public void testFilling() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickFilling();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
