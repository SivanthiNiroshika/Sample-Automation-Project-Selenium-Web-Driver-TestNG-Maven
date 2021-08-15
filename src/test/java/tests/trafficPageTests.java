package tests;

import config.configProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.basePage;
import pages.trafficPage;

public class trafficPageTests extends basePage
{

    WebDriver driver;
    @BeforeTest
    public void setup() throws Exception {

        configProperties cp=new configProperties();
        driver=cp.setupBrowser();
        trafficPage.goToTrafficPage(driver);
    }



    @Test
    public void verifyAcceptanceCriteria_7()
    {

        //click on traffic history 2018 and expand all months
        trafficPage.trafficHistory2018(driver).click();

        //create an array to store all months values
        String []months = new String[12];

        //create an array and store all locator values as per the order shown in the web page
        String []locators=new String[12];

        locators[0] ="(//H3)[33]";
        locators[1] ="(//H3)[34]";
        locators[2] ="(//H3)[35]";
        locators[3]="(//H3)[36]";
        locators[4]="(//H3)[37]";
        locators[5]="(//H3)[38]";
        locators[6] ="(//H3)[39]";
        locators[7] ="(//H3)[40]";
        locators[8]="(//H3)[41]";
        locators[9]="(//H3)[42]";
        locators[10]="(//H3)[43]";
        locators[11]="(//H3)[44]";


        //store all month values in months array which are taken from the elements in locators array
        for (int i = 0; i < 12; i++)
        {

            months[i] = driver.findElement(By.xpath(locators[i])).getText();
            System.out.println(months[i]);

        }

        //create an array and store the expected order of months
        String[] expectedOrder= new String[] {"December 2018","November 2018","October 2018","September 2018","August 2018","July 2018","June 2018","May 2018","April 2018","March 2018","February 2018","January 2018"};

        //verify actual order of months is equal to the expected order of the months
        Assert.assertEquals(months,expectedOrder);
        System.out.println("Months are in expected Order");

        //get the value of total queries in year 2018
        String totalQueries=trafficPage.totalqueries2018(driver).getText().replaceAll(",","");
        long Total=Long.parseLong(totalQueries);
        //System.out.println(Total);

        //create an array to store the total directs recorded for each month
        String [] locatorsForTotalDirects=new String[12];
        locatorsForTotalDirects[0] ="(//H2)[76]";
        locatorsForTotalDirects[1] ="(//H2)[78]";
        locatorsForTotalDirects[2] ="(//H2)[80]";
        locatorsForTotalDirects[3]="(//H2)[82]";
        locatorsForTotalDirects[4]="(//H2)[84]";
        locatorsForTotalDirects[5]="(//H2)[86]";
        locatorsForTotalDirects[6] ="(//H2)[88]";
        locatorsForTotalDirects[7] ="(//H2)[90]";
        locatorsForTotalDirects[8]="(//H2)[92]";
        locatorsForTotalDirects[9]="(//H2)[94]";
        locatorsForTotalDirects[10]="(//H2)[96]";
        locatorsForTotalDirects[11]="(//H2)[98]";



        //create a variable to store sum of the all directs recorded in all months
        long sumOfValues=0;

        for(int i=0;i<12;i++)
        {
            String totalDirect=(driver.findElement(By.xpath(locatorsForTotalDirects[i])).getText()).replaceAll(",","");
            long value=Long.parseLong(totalDirect);
            sumOfValues=sumOfValues+value;

        }


        System.out.println("The Sum of all quesries reported in all all months is  "+sumOfValues);

        System.out.println("The value of total queries in year 2018:" +Total);

        //verify the traffic page shows the correct total value for queries
        Assert.assertEquals(sumOfValues,Total);

    }







}
