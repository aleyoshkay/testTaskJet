import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class testTaskJetSu {
    WebDriver driver;
    String yandexSearchPage = "https://www.yandex.ru/";


    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void testWeather() {
        driver.get(yandexSearchPage);
        driver.findElement(By.xpath("//*[@id=\"text\"]")).sendKeys("пого");
        String var = driver.findElement(By.xpath("(//div[5]/ul/li)[1]")).getText();
        System.out.println(var);
        Assert.assertEquals("погода спб\n" +
                "+4 °C", var);
    }

    @Test
    public void testLipeck() {
        driver.get(yandexSearchPage);
        driver.findElement(By.xpath("//*[@id=\"text\"]")).sendKeys("Липецк");
        String var = driver.findElement(By.xpath("(//div[5]/ul/li)[1]")).getText();
        System.out.println(var);
        Assert.assertEquals("липецк", var);
    }


    @Test
    public void testLoto() {
        driver.get(yandexSearchPage);
        driver.findElement(By.xpath("//*[@id=\"text\"]")).sendKeys("Лото");
        String var = driver.findElement(By.xpath("(//div[5]/ul/li)[1]")).getText();
        System.out.println(var);
        Assert.assertEquals("лото", var);
    }

    @Test
    public void testGoPicture() {
        driver.get(yandexSearchPage);
        driver.findElement(By.xpath("//a[text()='Картинки']")).click();
        switchToTwoTab();
        String actualTitle = driver.getTitle();
        Assert.assertEquals("Яндекс.Картинки: поиск изображений в интернете, поиск по картинке", actualTitle);
    }

    public void switchToTwoTab() {
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "\t");
        driver.switchTo().defaultContent();
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}