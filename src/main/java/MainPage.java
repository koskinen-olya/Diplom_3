import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;
    private By filling = By.xpath(".//span[text()='Начинки']");
    private By bun = By.xpath(".//span[text()='Булки']");
    private By souse = By.xpath(".//span[text()='Соусы']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSouse() {
        driver.findElement(souse).click();
    }

    public void clickBun() {
        driver.findElement(bun).click();
    }

    public void clickFilling() {
        driver.findElement(filling).click();
    }

    public String getText() {
        String text = driver.findElement(By.xpath("//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[@class='text text_type_main-default']")).getText();
        return text;
    }
}
