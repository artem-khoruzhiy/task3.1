import Pages.MainTut;
import Pages.ResultPage;
import Pages.WorkPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

/**
 * Created by Артем on 17.03.2017.
 */
public class TestClass {
    private WebDriver driver;
    private MainTut mainTut;
    private WorkPage workPage;
    private ResultPage resultPage;

    @Parameters({"section", "query"})
    @BeforeClass
    public void localSetup(String section, String query) throws Exception{
        driver = new FirefoxDriver();
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

    @Test
    public void testForOverlapMoreThanZero() throws Exception{
        List<String> list = resultPage.analyzeForOverlap();
        assertTrue(list.size() > 0);
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }
}