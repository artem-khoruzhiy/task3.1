package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

/**
 * Created by Артем on 17.03.2017.
 */
public class WorkPage {
//    @FindBy(xpath = "//input[@data-qa='vacancy-serp__query']")
//    WebElement queryField;
//
//    @FindBy(xpath = "//button/span[text()='Найти']")
//    WebElement btnSearch;

    private String query;
    By queryFieldBy = By.xpath("//input[@data-qa='vacancy-serp__query']");
    By btnSearchBy = By.xpath("//button/span[text()='Найти']");

    private WebDriver driver;

    public WorkPage(WebDriver webDriver){
        driver = webDriver;
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public void setQuery(String query) throws Exception{
        this.query = query;
         driver.findElement(queryFieldBy).sendKeys(query);
    }

    public ResultPage clickSearchButton(){
        driver.findElement(btnSearchBy).click();
        return new ResultPage(driver, query);
    }
}
