package demo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCases {
    ChromeDriver driver;

    /*
     * TODO: Write your tests here with testng @Test annotation. 
     * Follow `testCase01` `testCase02`... format or what is provided in instructions
     */

     
    /*
     * Do not change the provided methods unless necessary, they will help in automation and assessment
     */

    @BeforeTest
    public void startBrowser()
    {
        System.setProperty("java.util.logging.config.file", "logging.properties");

        // NOT NEEDED FOR SELENIUM MANAGER
        // WebDriverManager.chromedriver().timeout(30).setup();

        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);
        options.addArguments("--remote-allow-origins=*");

        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "build/chromedriver.log"); 

        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.manage().window().maximize();
    }

    
    
    @Test
    public void testCase01() throws InterruptedException {
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        Boolean status ;

        driver.get("https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform");

        WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(5));

        waits.until(ExpectedConditions.urlContains("forms"));

        Thread.sleep(5000);
        
        WebElement yourName = driver.findElement(By.xpath("//*[@id=\'mG61Hd\']/div[2]/div/div[2]/div[1]/div/div/div[2]/div/div[1]/div/div[1]/input"));

        yourName.sendKeys("Crio Learner");

        Thread.sleep(5000);

        WebElement WhyYouArePractingAutomation = driver.findElement(By.xpath("//textarea[@class='KHxj8b tL9Q4c']"));

        long epochLong = System.currentTimeMillis();

        String epoch = String.valueOf(epochLong);

        WhyYouArePractingAutomation.sendKeys("I want to be the best QA Engineer!"+epoch);

        System.out.println("The epoch is Time is : "+epoch);

        Thread.sleep(4000);


        WebElement radioButton  = driver.findElement(By.xpath("//*[@id=\'i22\']/div[3]/div"));

        radioButton.click();

        System.out.println("The Radio Button is selected by you");
        

        Thread.sleep(2000);


        WebElement JavaButton= driver.findElement(By.xpath("//*[@id=\"i34\"]"));

        WebElement  seleniumButton = driver.findElement(By.xpath("//*[@id=\"i37\"]/div[2]"));

        WebElement testngButton = driver.findElement(By.xpath("//*[@id=\"i43\"]/div[2]"));

        JavaButton.click();

        seleniumButton.click();

        testngButton.click();

        Thread.sleep(2000);


        WebElement address = driver.findElement(By.xpath("//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[5]/div/div/div[2]/div/div[1]/div[1]"));

        address.click();

        WebElement MrButton = driver.findElement(By.xpath("//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[5]/div/div/div[2]/div/div[2]/div[3]/span"));

        MrButton.click();

        Thread.sleep(3000);


        WebElement calendarButton = driver.findElement(By.xpath("//input[@type='date']"));

        LocalDateTime date = LocalDateTime.now();

        LocalDateTime updatedDated = date.minusDays(7);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String formattedDate = updatedDated.format(formatter);

        calendarButton.sendKeys(formattedDate);

        //calendarButton.click();

        Thread.sleep(3000);


        WebElement hours = driver.findElement(By.xpath("//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[7]/div/div/div[2]/div/div[1]/div[2]/div[1]/div/div[1]/input"));

        hours.sendKeys("07");

        WebElement mins = driver.findElement(By.xpath("//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[7]/div/div/div[2]/div/div[3]/div/div[1]/div/div[1]/input"));

        mins.sendKeys("30");

        Thread.sleep(3000);


        WebElement SubmitButton = driver.findElement(By.xpath("//*[@id=\"mG61Hd\"]/div[2]/div/div[3]/div[1]/div[1]/div/span"));

        SubmitButton.click();

        Thread.sleep(3000);

        WebElement SucessNote = driver.findElement(By.xpath("//div[text()='Thanks for your response, Automation Wizard!']"));

        String success = SucessNote.getText();

        System.out.println(success);

        Thread.sleep(2000);
    }


    @AfterTest
    public void endTest()
    {
        driver.close();
        driver.quit();

    }
}

