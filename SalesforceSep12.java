package assessment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesforceSep12 {

		public static void main(String[] args) {
			WebDriverManager.chromedriver().setup();		
			ChromeOptions opt2 = new ChromeOptions();
			opt2.addArguments("disable-notifications");
			ChromeDriver driver = new ChromeDriver(opt2);
			driver.manage().window().maximize();
			driver.get("https://login.salesforce.com/");
		    driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		    driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		    driver.findElement(By.id("password")).sendKeys("India$321");
		    driver.findElement(By.name("Login")).click();
		    driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
			driver.findElement(By.xpath("//button[text()='View All']")).click();
		    WebElement Ind = driver.findElement(By.xpath("//p[text()='Individuals']"));
		    Actions click = new Actions(driver);
		    click.moveToElement(Ind).click(Ind).perform();
		    driver.findElement(By.xpath("//div[@class='slds-context-bar__label-action slds-p-left--none slds-p-right--x-small']/one-app-nav-bar-menu-button")).click();
		    WebElement newind = driver.findElement(By.xpath("(//span[text()='New Individual'])"));
		    driver.executeScript("arguments[0].click();", newind);
		    WebElement lname = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
		    lname.sendKeys("A");
			String lnameexp = lname.getAttribute("value");
		    System.out.println(lnameexp);
		    driver.findElement(By.xpath("//button[@title='Save']//span[1]")).click();
		    WebElement lnamea = driver.findElement(By.xpath("(//span[@class='uiOutputText'])[1]"));
			String lnameact = lnamea.getText();
			System.out.println(lnameact);
			Assert.assertEquals(lnameact, lnameexp);
	        driver.findElement(By.xpath("//div[@title='Edit']")).click();  
	        driver.findElement(By.xpath("//a[@class='select']")).click();
	        driver.findElement(By.xpath("//a[text()='Mr.']")).click();
	        WebElement fname = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
		    fname.sendKeys("Ajay");
			String fnameexp = fname.getAttribute("value");
		    System.out.println(fnameexp);
		    driver.findElement(By.xpath("//button[@title='Save']")).click();
		    
		    WebElement fnamea = driver.findElement(By.xpath("//span[contains(text(),'"+fnameexp+"')])"));
			String fnameact = fnamea.getText();
			System.out.println(fnameact);
			if(fnameact.contains(fnameexp)) {
			    System.out.println("Value contains the user provided firstname");
			} else {
			    System.out.println("Value doesnot contains the user provided firstname");
			}
	driver.close();
			

		    
		    
	        
	      
	        
	        
			
	}
}


