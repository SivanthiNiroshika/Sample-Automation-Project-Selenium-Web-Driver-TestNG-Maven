package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class trafficPage
{

  public static String trafficPageUrl="https://start.duckduckgo.com/traffic";


    public static void goToTrafficPage(WebDriver driver)
    {
        driver.get(trafficPageUrl);

    }



    //Locators

    public static WebElement totalqueries2018(WebDriver driver)

    {
        WebElement totalqueries2018 = driver.findElement(By.xpath("(//H2)[74]"));
        return totalqueries2018;


    }

    public static WebElement trafficHistory2018(WebDriver driver)

    {
        WebElement trafficHistory2018 = driver.findElement(By.xpath("(//H2)[73]"));
        return trafficHistory2018;


    }

    public static WebElement trafficHistory2019(WebDriver driver)

    {
        WebElement trafficHistory2019 = driver.findElement(By.xpath("(//H2)[47]"));
        return trafficHistory2019;


    }

    public static WebElement trafficHistory2020(WebDriver driver)

    {
        WebElement trafficHistory2020 = driver.findElement(By.xpath("(//H2)[21]"));
        return trafficHistory2020;


    }


}
