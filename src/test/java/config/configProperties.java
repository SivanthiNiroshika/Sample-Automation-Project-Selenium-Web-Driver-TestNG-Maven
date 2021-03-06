package config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;


public class configProperties extends pages.basePage
{


    WebDriver driver;

    //Define the browser which is going to execute all tests
    //values can be set are : chrome or firefox or Edge
    public static String browser="chrome";

    @BeforeTest
    //Select the browser that you need to execute the testcases
    public WebDriver setupBrowser() throws Exception{
        //Check if parameter passed from TestNG is 'firefox'
        if(browser.equalsIgnoreCase("firefox")){
            //create firefox instance
            System.setProperty("webdriver.gecko.driver", "C:\\IE\\IE-Automation-Project\\driver\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
        //Check if parameter passed as 'chrome'
        else if(browser.equalsIgnoreCase("chrome")){
            //set path to chromedriver.exe
            System.setProperty("webdriver.chrome.driver", "C:\\IE\\IE-Automation-Project\\driver\\chromedriver.exe");
            //create chrome instance
            driver = new ChromeDriver();
        }
        //Check if parameter passed as 'Edge'
        else if(browser.equalsIgnoreCase("Edge")){
            //set path to Edge.exe
            System.setProperty("webdriver.edge.driver","C:\\IE\\IE-Automation-Project\\driver\\msedgedriver.exe");
            //create Edge instance
            driver = new EdgeDriver();
        }
        else{
            //If no browser passed throw exception
            throw new Exception("Browser is not correct");
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

}
