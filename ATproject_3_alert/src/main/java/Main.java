import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

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
            WebElement element = driver.findElement(By.id("a"));
            WebElement element2 = driver.findElement(By.id("b"));
            WebElement element3 = driver.findElement(By.id("c"));
            element.click();
            //Alert alert = driver.switchTo().alert(); //переключение на алерт, может не сработать из-за отсутствия ожидания появления алерта
            Alert alert = wait.until(alertIsPresent());
            alert.accept();
            element2.click();
            Alert promt = wait.until(alertIsPresent());
            promt.sendKeys("Kal Kalbich");
            promt.accept();
            Alert alert2 = wait.until(alertIsPresent());
            Thread.sleep(2000);
            alert2.accept();
            element3.click();
            Alert alert3 = wait.until(alertIsPresent());
            alert.dismiss();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
