package cucumber;

import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.github.bonigarcia.wdm.WebDriverManager;
import ui.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Hooks {

    @BeforeAll
    public static void BeforeAll(){
        System.out.println("Before all tests");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        TestState.data.put("driver", driver);

    }

    @AfterAll
    public static void AfterAll(){
        System.out.println("after all tests");
        WebDriver driver = (WebDriver) TestState.data.get("driver");
        driver.quit();
    }

    @Before
    public void BeforeTest(){
        ChromeDriver driver = (ChromeDriver) TestState.data.get("driver");
        driver.get("https://todomvc.com/examples/vue/");
        driver.getLocalStorage().clear();
        driver.navigate().refresh();
        Page page = new Page(driver);
        TestState.data.put("page", page);
    }
}
