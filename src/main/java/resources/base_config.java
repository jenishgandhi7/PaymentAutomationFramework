package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class base_config {
	public WebDriver driver;
	public Properties prop;
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	Date date = new Date();


	public WebDriver initalizerDriver() throws IOException {

		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");
		prop = new Properties();
		prop.load(file);
		// this for direct run from Console with giving
		// mvn test -Dbrowser=chrome
		// mvn test -Dbrowser=firefox
		// mvn test -Dbrowser=ie
		// mvn test -Dbrowser=edge

		String browserName = System.getProperty("browser");

		//String browserName = prop.getProperty("browser");
		System.out.println(browserName);
		if (browserName.contains("chrome")) {

			System.setProperty("webdriver.chrome.driver", "./resourse/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			// statment for browser run for headless mode condition
			// for run into Headless mode
			// mvn test -Dbrowser=chrome_headless
			if (browserName.contains("headless")) {
				options.addArguments("--headless");
			}

			driver = new ChromeDriver(options);

		} else if (browserName.equals("firefox")) {

			System.setProperty("webdriver.gecko.driver", "./resourse/geckodriver.exe");
			FirefoxOptions options = new FirefoxOptions();
			// statment for browser run for headless mode condition
			// for run into Headless mode
			// mvn test -Dbrowser=firefox_headless
			if (browserName.contains("headless")) {
				options.addArguments("--headless");
			}
			driver = new FirefoxDriver(options);

		} else if (browserName.equals("edge")) {
			System.setProperty("webdriver.ie.driver", "./resourse/MicrosoftWebDriver.exe");
			driver = new InternetExplorerDriver();
			
		} else if (browserName.equals("ie")) {
			System.setProperty("webdriver.ie.driver", "./resourse/MicrosoftWebDriver.exe");
			driver = new InternetExplorerDriver();
		} else {

		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;

	}

	public String getScreenshot(WebDriver driver, String testMethodName) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenshotFloder = System.getProperty("user.dir") + "\\screenshot\\"+formatter.format(date)+"\\" + testMethodName + ".png";
		FileUtils.copyFile(src, new File(screenshotFloder));

		return screenshotFloder;
	}
}
