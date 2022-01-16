package com.qa.base;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.qa.util.TestUtil;

public class TestBase 
{
	public static WebDriver driver;
	public static Properties prop;
	public WebDriverWait wait;  
	public static Select select;
	public JavascriptExecutor js;
	public static EventFiringWebDriver e_driver;
	public	Actions action;
	static	Logger log = Logger.getLogger(TestBase.class);

	public TestBase()
	{


		try 
		{
			prop = new Properties();

			FileInputStream ip;

			try {
					
					ip = new FileInputStream("C:\\Users\\swapnil.bhaskar\\eclipse-workspace\\EverythingFinancialTest\\src\\com\\qa\\config\\config.properties");
					prop.load(ip);
				}		
				catch(FileNotFoundException e)
				{
					e.printStackTrace();	 
				}

		}catch(IOException e)
		{
			e.printStackTrace();
		}

	}


	public static void initialization()
	{
		String broweserName = prop.getProperty("browser");

		if (broweserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\swapnil.bhaskar\\eclipse-workspace\\XciteAppTest\\src\\main\\java\\com\\xciteApp\\qa\\util\\chromedriver.exe");
		
			driver=new ChromeDriver();
			log.info("Chrome Browser Started");
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		}
		else
		{
			System.out.println("Browser did not identified");
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));

	}


}



