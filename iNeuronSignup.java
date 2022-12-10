package seleniumwebdriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class iNeuronSignup {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

        WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		//Navigate to Signup Page
		
		driver.get("https://ineuron-courses.vercel.app/signup");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.id("name")).sendKeys("Narendra");
		
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("narendra11@gmail.com");
		
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("narendra");
		
		driver.findElement(By.xpath("//label[text()='Testing']")).click();
		
		driver.findElement(By.xpath("//label[text()='Male']")).click();
		
		
		JavascriptExecutor je = (JavascriptExecutor) driver;

		//Identify the WebElement which will appear after scrolling down

		WebElement element = driver.findElement(By.xpath("//button[text()='Sign up']"));

		// now execute query which actually will scroll until that element is not appeared on page.

		je.executeScript("arguments[0].scrollIntoView(true);",element);
		
		//Verify Signup Button is disabled
		boolean signup = driver.findElement(By.xpath("//select[@id='state']")).isEnabled();
		if(signup) {
			System.out.println("Signup Button is  Enabled"+signup);
		}else {
			System.out.println("Signup Button is Disabled" +signup);
		}
		
		Thread.sleep(20000);
		
		
		Select sc = new Select(driver.findElement(By.xpath("//select[@id='state']")));
		
		sc.selectByVisibleText("Karnataka");
		
		
		
		
		//Thread.sleep(20000);
		
		element.click();
		
		driver.quit();
		
	}

}
