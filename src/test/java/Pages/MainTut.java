package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Артем on 17.03.2017.
 */
public class MainTut {
    private WebDriver driver;
    private String locForMenu = "//ul[@class='b-topbar-i']//a[text()='%s']";


    public MainTut(WebDriver webDriver){
        driver = webDriver;
    }

    public WorkPage navigateOnMenu(String name){
        WebElement element = driver.findElement(By.xpath(String.format(locForMenu, name)));
        element.click();
        return new WorkPage(driver);
    }
}
