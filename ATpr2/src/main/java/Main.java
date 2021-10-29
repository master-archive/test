import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        /*driver.get("https://google.com");
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //Метод устарел, но его можно использовать
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement element = (new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.id("123"))));//В element запишется элемент с id = "123", и время его ожидания будет равно 10 секундам
        WebElement input = driver.findElement(By.xpath("//input[@aria-label='Найти']"));
        input.click();*/
        //driver.get("https://www.avito.ru/rossiya/avtomobili");
        driver.get("https://dev.by");
        WebElement element = driver.findElement(By.xpath("//a[text()='Вход']"));
        String par = element.getCssValue("display");
        System.out.println(par);

    }
}
