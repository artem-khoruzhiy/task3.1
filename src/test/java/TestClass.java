import Pages.MainTut;
import Pages.ResultPage;
import Pages.WorkPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import static org.testng.Assert.*;

/**
 * Created by Артем on 17.03.2017.
 */
public class TestClass {

    private WebDriver driver;
    private MainTut mainTut;
    private WorkPage workPage;
    private ResultPage resultPage;

    @BeforeClass
    public void settings(){
        driver = new FirefoxDriver();
    }

    @Parameters({"section", "query"})
    @BeforeMethod
    public void locatSetup(String section, String query) throws Exception{
        driver.get("http://www.tut.by");
        mainTut = new MainTut(driver);
        workPage = mainTut.navigateOnMenu(section);
        workPage.setQuery(query);
        resultPage = workPage.clickSearchButton();
    }

    @Test
    public void testIsMoreThanZero() throws Exception{
        assertTrue(resultPage.getCountOfSuitableOfResults() > 0);
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }
}
