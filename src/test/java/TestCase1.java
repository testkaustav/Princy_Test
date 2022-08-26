import java.io.File;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.failsafe.internal.util.Assert;

public class TestCase1 {

	static WebDriver driver;
	static String url;

	public static void main(String[] args) throws InterruptedException {
		String projectPath = System.getProperty("user.dir");
		System.out.println(projectPath);

		System.setProperty("webdriver.chrome.driver",
				"/Users/princygoel/Seleneium-demo/Selenium-Demo/src/test/resources/com/Drivers/chromedriver5");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		url = "https://www.youtube.com/";
		launchingBrowser(url, driver);
		
		//createAccount(driver);
		 signIn(driver);
		 
		 likeVideo(driver);
		 subscribeVideo(driver);

	}

	public static void launchingBrowser(String url, WebDriver driver) {
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// input[@id = 'firstName']

	}

	public static void clickSignIn(WebDriver driver) {
		driver.findElement(By.xpath("//*[@class = \"style-scope ytd-button-renderer style-suggestive size-small\"]"))
				.click();
		

	}
	public static void signIn(WebDriver driver) throws InterruptedException {
		String actualTitle = driver
				.findElement(By.xpath("//*[@class = 'style-scope ytd-button-renderer style-suggestive size-small']"))
				.getText();
		String expectedTitle = "SIGN IN";
		if (actualTitle.equalsIgnoreCase(expectedTitle)) {
			System.out.println("User is not logged in");
			driver.findElement(
					By.xpath("//*[@class = 'style-scope ytd-button-renderer style-suggestive size-small']")).click();
			driver.findElement(By.xpath("//input[@id = 'identifierId']")).sendKeys("selenium.princy@gmail.com");
			driver.findElement(By.xpath("(//span[@class = 'VfPpkd-vQzf8d'])[2]")).click();
			driver.findElement(By.xpath("//input[@name = 'password']")).sendKeys("P12345678g");
			WebElement nextButton = new WebDriverWait(driver, Duration.ofSeconds(20))
					.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class = 'VfPpkd-vQzf8d'])[2]")));
			nextButton.click();
			//driver.findElement(By.xpath("(//span[@class = 'VfPpkd-vQzf8d'])[1]")).click();
			System.out.println("User is logged in now");

			
		} else {

			System.out.println("User is logged in");

		}
		search(driver);

	}
	public static void createAccount(WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath(
				"//button[@class = 'VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-dgl2Hf ksBjEc lKxP2d qfvgSe FliLIb uRo0Xe TrZEUc t29vte']"))
				.click();
		driver.findElement(By.xpath("//ul/li[1]/span[@class = 'VfPpkd-StrnGf-rymPhb-b9t22c']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[contains(text(),'Create a new Gmail address instead')]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@id = 'firstName']")).sendKeys("Princy");
		driver.findElement(By.xpath("//input[@id = 'lastName']")).sendKeys("Goel");
		driver.findElement(By.xpath("//input[@id = 'username']")).sendKeys("seleniumprincy021");
		driver.findElement(By.xpath("//input[@name = 'Passwd']")).sendKeys("P12345678g");
		driver.findElement(By.xpath("//input[@name = 'ConfirmPasswd']")).sendKeys("P12345678g");
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		// Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id = 'phoneNumberId']")).sendKeys("7217595129");
		// WebElement nextButton = driver.findElement(By.xpath("(//span[@class =
		// 'VfPpkd-vQzf8d'])[1]"));

		WebElement nextButton = new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class = 'VfPpkd-vQzf8d'])[1]")));
		nextButton.click();
		Thread.sleep(2000);
		verifyPhone(driver);

	}

	public static void verifyPhone(WebDriver driver) throws InterruptedException {

		JFrame f;
		f = new JFrame();
		WebElement enterOTP = driver.findElement(By.xpath("//input[@id = 'code']"));
		String name = JOptionPane.showInputDialog(f, "Enter Name");
		System.out.println(name);
		enterOTP.sendKeys(name);

		WebElement verifyButton = new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class = 'VfPpkd-vQzf8d'])[2]")));
		verifyButton.click();
		personalDetails(driver);
		
	}
	
	public static void personalDetails(WebDriver driver) throws InterruptedException {
		// Sending day
		driver.findElement(By.xpath("//input[@id='day']")).sendKeys("10");
		
		// Selecting month
		WebElement month = driver.findElement(By.xpath("//select[@id = 'month']"));
		Select select = new Select(month);
	    List<WebElement> lst = select.getOptions();
	    for(WebElement options: lst) {
	    	System.out.println(options.getText());
	    	select.selectByVisibleText("February");

	    }
	    // Sending Year
	    
		driver.findElement(By.xpath("//input[@id='year']")).sendKeys("1997");
		
	    // Selecting gender
        Thread.sleep(1000);
		WebElement gender = driver.findElement(By.xpath("//select[@id='gender']"));
		Select select1 = new Select(gender);
	    List<WebElement> lst1 = select1.getOptions();
	    for(WebElement options: lst1) {
	    	System.out.println(options.getText());
	    	select.selectByVisibleText("Male");
	    }
	    // Click Next button
	    driver.findElement(By.xpath("(//span[@class='VfPpkd-vQzf8d'])[1]")).click();
		
	}
	

	

	public static void search(WebDriver driver) throws InterruptedException {
		WebElement title = driver.findElement(By.xpath("//input[@id = 'search']"));
		title.sendKeys("Raat lambiya");
		title.sendKeys(Keys.RETURN);
		driver.findElement(By.xpath("//*[@id='video-title']/yt-formatted-string")).click();
		pauseVideo(driver);
		checkAd(driver);

		
	}

	public static void checkAd(WebDriver driver)  {
		try {
		WebElement adElement = driver.findElement(By.xpath("(//*[@class=\"ytp-ad-text\"])[1]"));
		System.out.println(adElement.getText());
		String adText = adElement.getText();
		WebElement skipAd = driver.findElement(By.xpath("//*[@id=\'ad-text:6\']"));
		String skipText	= skipAd.getText();
		System.out.println(skipText);
		
		
		if(adText.contains("Ad")) {
			if(skipText == "Skip Ads") {
				skipAd.click();
				System.out.println("Skipped Ad");
			}
			else {
				System.out.println("Waiting ad to be finished");
				Thread.sleep(10000);
				System.out.println("Ad Finished");
			}
		}
		else {
			System.out.println("No ad");
		}

	
	}
	catch(Exception e) {
		System.out.println(e);
	}
		
	}

	public static void scrollBy(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// Scroll the webpage
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		
	}

	public static void pauseVideo(WebDriver driver) {
		
		
		// Pausing the video
		driver.findElement(By.xpath("//button[@class = 'ytp-play-button ytp-button']")).click();
		System.out.println("Pause done");

	}

	public static void likeVideo(WebDriver driver) {

		// Scroll to see the like icon
		scrollBy(driver);
		// Click on like icon
		driver.findElement(By.xpath("//*[@id=\"segmented-like-button\"]/ytd-toggle-button-renderer/yt-button-shape/button/yt-touch-feedback-shape/div")).click();
		System.out.println("Liked");
		screenshot(driver);
		playingVideo(driver);
		
	}
	
	public static void screenshot(WebDriver driver) {
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		try {
        File DestFile=new File("./Screenshot/Image.png");
        FileUtils.copyFile(SrcFile, DestFile);
		}
		 catch (IOException e) {
	            System.out.println(e.getMessage());
	        }
	}

	public static void playingVideo(WebDriver driver) {
		// Playing the video
		driver.findElement(By.xpath("//button[@class = 'ytp-play-button ytp-button']")).click();
		System.out.println("Playing");

	}

	public static void subscribeVideo(WebDriver driver) throws InterruptedException {
		System.out.println("subscribing soon");
		pauseVideo(driver);
		// Subscribe Video
		driver.findElement(By.xpath("//ytd-subscribe-button-renderer/tp-yt-paper-button/yt-formatted-string[@class='style-scope ytd-subscribe-button-renderer']")).click();
		System.out.println("Subscribed");
		screenshot(driver);
		// Playing Video again
		playingVideo(driver);

	}

}
