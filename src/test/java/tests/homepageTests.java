package tests;

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
import pages.basePage;
import pages.homePage;
import org.testng.reporters.*;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class homepageTests extends basePage {


    WebDriver driver;

    @BeforeTest
    public void setup() throws Exception {


        configProperties cp = new configProperties();

        driver = cp.setupBrowser();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

        homePage.goToHome(driver);
    }


    @Test
    public void verifyAcceptanceCriteria_1() throws Exception {


        //Verify homePage Logo is displayed
        homePage.homePageLogo(driver).isDisplayed();


    }


    @Test
    public void verifyAcceptanceCriteria_2() {


        //clear the searchbox in the Home page
        homePage.homePageSearch(driver).clear();
        //search the given word
        homePage.homePageSearch(driver).sendKeys("super");

        //wait until all elements are visible
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#search_form_homepage > div.search__autocomplete > div.acp-wrap.js-acp-wrap")));

        List<WebElement> list = driver.findElements(By.className("acp"));

        System.out.println("Number of search suggestions showed in Auto Suggest List ::" + list.size());
        Assert.assertEquals(list.size(), 10);
        driver.navigate().refresh();

    }

    @Test
    public void verifyAcceptanceCriteria_3() {


        //clear the searchbox in the Home page
        homePage.homePageSearch(driver).clear();
        //search the given word
        homePage.homePageSearch(driver).sendKeys("supercalafragalistic");

        //wait until all elements are visible
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@id='search_form_homepage']/div[2]/div/div/span")));
        String actual = driver.findElement(By.xpath("//form[@id='search_form_homepage']/div[2]/div/div/span")).getText();

        System.out.println("The Actual Search Suggestion is :" + actual);
        String expectedSearchSuggestion = "supercalafragalisticexpialadoshus";

        //verify the expected search suggestion is shown in actual results
        Assert.assertEquals(actual, expectedSearchSuggestion);


    }


    @Test
    public void verifyAcceptanceCriteria_4() {

        //click on hambuger menu
        homePage.menu(driver).click();

        //verify themes link is shown
        homePage.theme(driver).isDisplayed();
        driver.navigate().refresh();

    }


    @Test
    public void verifyAcceptanceCriteria_5() {
        //get the current background color of the page
        String bckgclr1 = homePage.pageBackground(driver).getCssValue("background-color");
        System.out.println("old background colour is :" + bckgclr1);


        //click on hamburger menu
        homePage.menu(driver).click();

        //click on themes link
        homePage.theme(driver).click();

        //select and click on dark mode to change the background color to dark mode
        homePage.darkBackgroundColor(driver).click();

        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

        //get the current background color of the page
        String bckgclr2 = homePage.background(driver).getCssValue("background-color");
        System.out.println("new background colour is:" + bckgclr2);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);


        //verify click on the themes link then click on the dark mode theme button Then the page background should change colour
        Assert.assertNotEquals(bckgclr1, bckgclr2);
        driver.navigate().refresh();
    }


    //AC6
    //Given I am on the homepage When I go to the homepage and type then click the maginifying glass Then I should get 10 results on the results page

    @Test
    public void verifyAcceptanceCriteria_6() {
        String[] strKeywords = new String[]{"Back to the future", "BMX Bandits", "Rocky IV", "Short Circuit", "The Terminator", "Ferries Bueller's Day off"};
        int []expectedResultsCount=new int[]{10,10,10,10,10,10};
        int []actualResultsCount=new int[6];
        for (int i = 0; i < strKeywords.length; i++) {


            //clear the searchbox in the Home page
            homePage.homePageSearch(driver).clear();
            //search the given word
            homePage.homePageSearch(driver).sendKeys(strKeywords[i]);
            driver.findElement(By.xpath("//INPUT[@id='search_button_homepage']")).click();


            //wait until all elements are visible
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"web_content_wrapper\"]/div[3]")));

            List<WebElement> list = driver.findElements(By.xpath("//*[@id=\"web_content_wrapper\"]/div[3]"));
            actualResultsCount[i]= list.size();
            System.out.println("Number of search results for " + strKeywords[i] + " is :" + list.size());

            homePage.goToHome(driver);


        }


        Assert.assertEquals(actualResultsCount,expectedResultsCount);

    }


}