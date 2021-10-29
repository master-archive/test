import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait = new  WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        try {
            driver.get("file:///C:/Users/User/vscode-projects/test2/index.html"); //тут должна быть нормальная ссылка, а не путь к файлу, но ладно
            Thread.sleep(5000);
            String window1 = driver.getWindowHandle(); //идентификатор (дескриптор) окна, с которым производися непосредственная работа
            js.executeScript("window.open()"); //открытие нового окна
            Set<String> currentWindows = driver.getWindowHandles(); //получение набора (сэта) строк с дескрипторами открытых на даанный момент окон
            String window2 = null;
            for (String window : currentWindows) {
                if (!window.equals(window1)) {
                    window2 = window;
                    break;
                }
            }
            driver.switchTo().window(window2);
            driver.get("https://ru.citaty.net/tsitaty-o-stradaniiakh/");
            driver.close();
            driver.switchTo().window(window1);

            js.executeScript("document.querySelector('#a').setAttribute('style', 'opacity:1')"); //выполняется скрипт, которой находит по css-селектору элемент и устанавливает атрибут со следующими значениями (это необходимо, чтобы скрытый input появился в поле видимости selenium)
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
