import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestSwitchToConstructor {
    WebDriver driver;

    @Before
    public void openBrowser() {
        //При необходимости прохождения тестов в яндекс браузере раскомментировать следующую строку
        //System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\yandexdriver.exe");
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/login");
    }

    @Test
    public void testSwitchToConstructor() {
        driver.findElement(By.xpath(".//p[text()='Конструктор']")).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[text()='Войти в аккаунт']")));
    }

    @Test
    public void testSwitchToLogo() {
        driver.findElement(By.xpath(".//div/a[@href=\"/\"]")).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[text()='Войти в аккаунт']")));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
