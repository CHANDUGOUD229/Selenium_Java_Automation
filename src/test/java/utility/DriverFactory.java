package utility;


import io.cucumber.core.logging.LoggerFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.time.Duration;

public class DriverFactory extends PropertyFilesLoader {

    public static WebDriver driver;
    public final static Logger LOGGER = LogManager.getLogger(DriverFactory.class);
    //Logger log = LoggerHelper.getLogger(ServiceHooks.class);

    /**
     * This method will initiatingBrowser Based on your requirement,
     * Which browser you need based on your requirement you can update in testDat.Properties file
     *
     * @throws IOException
     */
    public static WebDriver initiatingBrowser() throws IOException {
        GenericMethods gm = new GenericMethods();
        try {
            String browser = GetProperty("browser");
            if (browser.equalsIgnoreCase("chrome")) {
                ChromeOptions options = new ChromeOptions();
//                options.addArguments("--headless");
                options.addArguments("--start-maximized");
                options.addArguments("--disable-extensions");
                options.addArguments("--disable-popup-blocking");
//                options.addArguments("--incognito");
                options.addArguments("disable-infobars");
                options.addArguments("--disable-gpu");
                driver = new ChromeDriver(options);
                gm.writeLoginfo("Chrome browser Launched successfully");
            } else if (browser.equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();
                gm.writeLoginfo("Firefox browser Launched successfully");
            } else if (browser.equalsIgnoreCase("edge")) {
                driver = new EdgeDriver();
                gm.writeLoginfo("Edge browser Launched successfully");
            } else {
                System.out.println("please enter right browser name");
            }
            driver.manage().window().maximize();
            gm.writeLoginfo("browser maximized successfully");
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            gm.writeLoginfo("implicitlyWait 30 sec added");
        } catch (IOException e) {
            System.err.println("Don't have compatibility");
            gm.writeLoginfo("browser not able to launch Launched");
        }

        return driver;

    }

    /**
     * This method will get the Current WebDriver instance
     *
     * @return driver
     */
    public static WebDriver getDriver() {
        return driver;
    }

}

