package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Артем on 17.03.2017.
 */
public class ResultPage {
    private WebDriver driver;
    private List<WebElement> listOfResultElements;
    private String query;
    private String locatorListVacancies = "//div[@class='search-result']//a[@data-qa='vacancy-serp__vacancy-title'][contains(text(), '%s')]";

    public ResultPage(WebDriver webDriver, String query){
        driver = webDriver;
        this.query = query;
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
    }
    public int getCountOfSuitableOfResults(){
        listOfResultElements = driver.findElements(By.xpath(String.format(locatorListVacancies, query)));
        return listOfResultElements.size();
    }


}
