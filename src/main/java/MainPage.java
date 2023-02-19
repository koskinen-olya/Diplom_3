import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;
    private By filling = By.xpath(".//span[text()='Начинки']");
    private By bun = By.xpath(".//span[text()='Булки']");
    private By souse = By.xpath(".//span[text()='Соусы']");
    private By thisBun = By.xpath(".//p[text()='Флюоресцентная булка R2-D3']");
    private By thisSouse = By.xpath(".//p[text()='Соус традиционный галактический']");
    private By thisFulling = By.xpath(".//p[text()='Биокотлета из марсианской Магнолии']");

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
    public String getTextBun(){
        String text = driver.findElement(thisBun).getText();
        return text;
    }
    public String getTextSouse(){
        String text = driver.findElement(thisSouse).getText();
        return text;
    }
    public String getTextFilling(){
        String text = driver.findElement(thisFulling).getText();
        return text;
    }
}
