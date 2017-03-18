package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Артем on 17.03.2017.
 */
public class ResultPage {
    private WebDriver driver;
    private List<WebElement> listOfResultElements;
    private String query;
    private String locatorListVacancies = "//div[@class='search-result']//a[@data-qa='vacancy-serp__vacancy-title'][contains(text(), '%s')]";
    private WebDriverWait wait;

    public ResultPage(WebDriver webDriver, String query){
        driver = webDriver;
        wait = new WebDriverWait(driver, 30);
        this.query = query;
    }
    public int getCountOfSuitableOfResults(){
        listOfResultElements = wait.until(ExpectedConditions.
                presenceOfAllElementsLocatedBy(By.xpath(String.format(locatorListVacancies, query))));
        return listOfResultElements.size();
    }

    public List<String> analyzeForOverlap() throws Exception {
        List<WebElement> listElems = wait.until(ExpectedConditions.
                presenceOfAllElementsLocatedBy(By.xpath("//div[@class='search-result-item__head']/a")));
        List<String> listSuitableVacancies = new ArrayList<String>();
        List<String> wordsOfQuery = Arrays.asList(query.split(" "));

        for(WebElement el : listElems){
            String vacancy = el.getText();
            boolean condition = false;
            for (String word : wordsOfQuery){
                if (vacancy.contains(word)){
                    condition = true;
                }
                else if (vacancy.contains(word.toLowerCase())){
                    condition = true;
                }
                else {
                    condition = false;
                    break;
                }
            }
            if (condition == true) {
                listSuitableVacancies.add(vacancy);
            }
        }
        return listSuitableVacancies;
    }
}