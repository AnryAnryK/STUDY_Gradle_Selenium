package GitHub;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static com.codeborne.selenide.impl.Html.text;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeleniumContributorTabnineTest {

    WebDriver driver;

    @Test
    void FindBestSeleniumContributorTabnineTest() {
        System.setProperty("webdriver.chrome.driver", "D:\\ANDREY\\GoogleChromeDrivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe"); // Replace with your actual chromedriver path
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 1 - Open the website: https://github.com/ - УСПЕШНО
        driver.get("https://github.com/");

        // 2 - Enter "Selenide" in the search bar - УСПЕШНО
        driver.findElement(By.xpath("//*[@data-target='qbsearch-input.inputButtonText']")).click();
        driver.findElement(By.xpath(".//*[@style='width: 300px;']")).sendKeys("Selenide");
            driver.findElement(By.xpath(".//*[@style='width: 300px;']")).sendKeys(Keys.ENTER);

        //подождать 7000 милисекунд  - УСПЕШНО
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(7000));

        // 3 - Click on the first repository in the search results - УСПЕШНО (хотя тест может работать через раз)
        driver.findElement(By.xpath(".//span[@class='Text-sc-17v1xeu-0 qaOIC search-match' and contains(text(),'selenide/')]")).click();


        //подождать 7000 милисекунд  - УСПЕШНО
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(7000));

        // 4 - Find Andrei Solntsev's profile page in the Contributors section - УСПЕШНО (хотя тест может работать через раз)
        driver.findElement(By.xpath(".//*[@src='https://avatars.githubusercontent.com/u/279773?s=64&v=4']")).click();

        //подождать 7000 милисекунд  - УСПЕШНО
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(7000));

        // 5 - Verify Andrei Solntsev's name on the profile page  -  НЕ УСПЕШНО !! почему-то ошибка, хотя Локатор верный
        //driver.findElement(By.xpath(".//*[@itemprop='name']")); //я так переписал код
//assertEquals(text,"Andrei Solntsev"); //я так переписал код
        assertEquals("Andrei Solntsev", driver.findElement(By.xpath(".//*[@itemprop='name']")).getText().contains("Andrei Solntsev"));  //этот код мне предложил Табнин

        //подождать 7000 милисекунд  - УСПЕШНО
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(7000));

        driver.quit();
    }
}