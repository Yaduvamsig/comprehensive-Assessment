package reusablecomponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReadPropertyFile {

	public static WebDriver driver;
	public Properties p;

	public WebDriver DriverInitialisation() throws IOException {
		// TODO Auto-generated method stub
		p = new Properties();
		FileInputStream fis = new FileInputStream(
				"D:\\Selenium\\Cucumber\\BDD\\testdata\\configure.properties");
		p.load(fis);
		String browserName = p.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"D:\\Selenium\\Cucumber\\BDD\\drivers\\chromedriver2.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"D:\\Selenium\\Cucumber\\BDD\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver",
					"D:\\Selenium\\Cucumber\\BDD\\drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		return driver;
	}

}