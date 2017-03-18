package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    private WebDriver driver;
    private String query;
    private By queryFieldBy = By.xpath("//input[@data-qa='vacancy-serp__query']");
    private By btnSearchBy = By.xpath("//button/span[text()='Найти']");
    private WebDriverWait wait;


    public WorkPage(WebDriver webDriver){
        driver = webDriver;
        wait = new WebDriverWait(driver, 90);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    public void setQuery(String query) throws Exception{
        this.query = query;
        wait.until(ExpectedConditions.presenceOfElementLocated(queryFieldBy)).sendKeys(query);
//        driver.findElement(queryFieldBy).sendKeys(query);
    }

    public ResultPage clickSearchButton(){
        wait.until(ExpectedConditions.presenceOfElementLocated(btnSearchBy)).click();
//        driver.findElement(btnSearchBy).click();
        return new ResultPage(driver, query);
    }
}
