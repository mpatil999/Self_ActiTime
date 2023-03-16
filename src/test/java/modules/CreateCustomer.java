package modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateCustomer extends LoginFunctionality{
	public static void main(String[] args) throws InterruptedException {
		LoginFunctionality login=new LoginFunctionality();
		WebDriver driver = login.actiLogin();
		driver.navigate().to("http://localhost:90/tasks/tasklist.do");
		driver.findElement(By.className("addNewContainer")).click();
		WebElement custName=driver.findElement(By.cssSelector(".item.createNewCustomer.ellipsis"));
		custName.click();
		driver.findElement(By.cssSelector("input[placeholder='Enter Customer Name']")).sendKeys("Suraj");
		driver.findElement(By.id("customerLightBox_descriptionField")).sendKeys("Cricketer");
		
		driver.findElement(By.xpath("//div[@id='customerLightBox_commitBtn']/div")).click();
		driver.findElement(By.xpath("//span[text()=\"Customer '" + custName + "' has been created\"]"));
	}
	



}
