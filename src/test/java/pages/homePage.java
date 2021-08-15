
/* This class will store all the locators and functions of Home Page */



package pages;
import config.configProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class homePage extends basePage
{


    //Data
    public static String homePageUrl="https://start.duckduckgo.com/";



    public static void goToHome(WebDriver driver)
    {
        driver.get(homePageUrl);

    }

   //Locators

  public static WebElement homePageLogo(WebDriver driver)

  {
       WebElement homePageLogo = driver.findElement(By.xpath("//A[@id='logo_homepage_link']"));
       return homePageLogo;


  }


    public static WebElement homePageSearch(WebDriver driver)

    {
        WebElement homePageSearch = driver.findElement(By.xpath("//INPUT[@id='search_form_input_homepage']"));
        return homePageSearch;


    }

    public static WebElement searchSuggestionList(WebDriver driver)

    {
        WebElement searchSuggestionList = driver.findElement(By.className("acp"));
        return searchSuggestionList;


    }

    public static WebElement menu(WebDriver driver)

    {
        WebElement menu= driver.findElement(By.linkText("⇶"));
        return menu;


    }

    public static WebElement theme(WebDriver driver)

    {
        WebElement theme= driver.findElement(By.linkText("Themes"));
        return theme;


    }


    public static WebElement pageBackground(WebDriver driver)

    {
        WebElement pageBackground= driver.findElement(By.xpath("//BODY[@id='pg-index']"));
        return pageBackground;


    }


    public static WebElement background(WebDriver driver)

    {
        WebElement background= driver.findElement(By.xpath("//BODY[@id='pg-settings']"));
        return background;


    }
    public static WebElement defaultBackgroundColor(WebDriver driver)

    {
        WebElement defaultBackgroundColor= driver.findElement(By.xpath("//LABEL[@class='set-theme__label'][text()='Default']"));
        return defaultBackgroundColor;


    }

    public static WebElement basicBackgroundColor(WebDriver driver)

    {
        WebElement basicBackgroundColor= driver.findElement(By.xpath("//LABEL[@class='set-theme__label'][text()='Basic']"));
        return basicBackgroundColor;


    }


    public static WebElement contrastBackgroundColor(WebDriver driver)

    {
        WebElement contrastBackgroundColor= driver.findElement(By.xpath("//LABEL[@class='set-theme__label'][text()='Contrast']"));
        return contrastBackgroundColor;


    }

    public static WebElement darkBackgroundColor(WebDriver driver)

    {
        WebElement darkBackgroundColor= driver.findElement(By.xpath("//LABEL[@class='set-theme__label'][text()='Dark']"));
        return darkBackgroundColor;


    }

    public static WebElement greyBackgroundColor(WebDriver driver)

    {
        WebElement greyBackgroundColor= driver.findElement(By.xpath("//LABEL[@class='set-theme__label'][text()='Gray']"));
        return greyBackgroundColor;


    }

    public static WebElement terminalBackgroundColor(WebDriver driver)

    {
        WebElement terminalBackgroundColor= driver.findElement(By.xpath("//LABEL[@class='set-theme__label'][text()='Terminal']"));
        return terminalBackgroundColor;


    }
}
