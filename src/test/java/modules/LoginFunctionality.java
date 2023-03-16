package modules;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginFunctionality {

	public static void main(String[] args) throws InterruptedException {
		LoginFunctionality login=new LoginFunctionality();
		login.actiLogin();
	}
		
		public WebDriver actiLogin() throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("start-maximized");
		WebDriver driver=new ChromeDriver(options);
		
		driver.get("http://localhost:90/login.do");
		driver.findElement(By.id("username")).sendKeys("Admin");
		driver.findElement(By.cssSelector(".textField.pwdfield")).sendKeys("manager");
		driver.findElement(By.id("keepLoggedInCheckBox")).click();
		driver.findElement(By.id("loginButton")).click();
		
		//Get verify dashboard title
		String title=driver.getTitle();
		Thread.sleep(20);
	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
//		wait.until(ExpectedConditions.titleContains(title));
//		System.out.println(title);
		if(title.equals("actiTIME - Enter Time-Track")) {
			System.out.println("Login Title verified");
		}else {
			System.out.println("Incorrect Login Title");
		}
		
		//Get verify dashboard URL
		String url=driver.getCurrentUrl();
		System.out.println(url);
		if(url.equals("http://localhost:90/user/submit_tt.do")) {
			System.out.println("Login URL verified");
		}else {
			System.out.println("Incorrect Login URL");
		}
		
		//Get verify dashboard AllTabs
		List<WebElement> allTabs=driver.findElements(By.cssSelector("#topnav td>a>div:first-child"));
		for(int i=0;i<allTabs.size();i++) {
			System.out.println(allTabs.get(i).getText());
		}
		
		//driver.findElement(By.id("logoutLink")).click();
		return driver;
		
	}
	}


