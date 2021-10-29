import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //driver.get("https://crossbrowsertesting.github.io/drag-and-drop");
        //WebElement element = driver.findElement(By.xpath("(//input[contains(@class, 'udlite-text-input')]) [1]"));
        try {
            driver.get("https://crossbrowsertesting.github.io/drag-and-drop");
            Thread.sleep(2000);
            WebElement element = driver.findElement(By.id("draggable"));
            WebElement element2 = driver.findElement(By.id("droppable"));
            Actions actions = new Actions(driver);
            actions.moveToElement(element).clickAndHold().moveToElement(element2).release().build().perform();
            //actions.dragAndDrop(element, element2); //альтернативный вариант для получения того же самого результата

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            Thread.sleep(20000);
            driver.quit();
        }
        //element.sendKeys("Java", Keys.ENTER);
        //Actions actions = new Actions();
        /*actions.moveToElement() //навести курсор на элемент
                .keyDown()      //нажать клавишу
                .keyUp()        //отпустить клавишу
                .clickAndHold() //нажать и задержать левую кнопку мыши
                .release()      //отпустить кнопку мыши
                .build()        //собрать все дейсвтия
                .perform();     //применить все действия*/

    }
}
