import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;

    //локатор для вкладки "Начинки"
    private By filling = By.xpath(".//span[text()='Начинки']");
    //локатор для вкладки "Булки"
    private By bun = By.xpath(".//span[text()='Булки']");
    //локатор для вкладки "Соусы"
    private By souse = By.xpath(".//span[text()='Соусы']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickFilling() {
        driver.findElement(filling).click();
    }

    public void clickBun() {
        driver.findElement(filling).click();
        driver.findElement(bun).click();
    }

    public void clickSouse() {
        driver.findElement(souse).click();
    }
}
