import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait = new  WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            driver.get("file:///C:/Users/User/vscode-projects/test2/index.html"); //тут должна быть нормальная ссылка, а не путь к файлу, но ладно
            Thread.sleep(5000);
            String title = driver.getTitle();
            Assert.assertEquals(title, "Document"); //проверка соответствия актуального результата ожидаемому
            LoginPage lp = new LoginPage();
            lp.login("admin", "123");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
