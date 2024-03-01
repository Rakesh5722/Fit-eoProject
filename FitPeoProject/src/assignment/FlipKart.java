package assignment;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FlipKart {

	public static void main(String[] args) throws InterruptedException {
       System.setProperty("webdriver.chrome.driver", "E:\\Rakesh\\FitPeoProject\\drivers\\chromedriver.exe");
       ChromeOptions options=new ChromeOptions();
       options.setBinary("D:\\Drivers\\chrome\\chrome-win64\\chrome-win64\\chrome.exe");
       WebDriver driver =new ChromeDriver(options);
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
       
       driver.get("https://www.flipkart.com");
       
       WebElement searchBox=driver.findElement(By.xpath("//*[@name='q']"));
       searchBox.sendKeys("ipad");
       searchBox.submit();
       
       Thread.sleep(2000);
       
      List<WebElement>  suggestions=(List<WebElement>) driver.findElement(By.xpath("//div[@class='TrendingSuggestions-trendingSuggestions']"));
       if(!suggestions.isEmpty()) {
    	   suggestions.get(0);
    	   
       }
       
       WebElement onlineFilter=driver.findElement(By.xpath("//div[text()='online']/preceeding-sibling::div"));
       onlineFilter.click();
       
       List<WebElement>productResults=driver.findElements(By.xpath("//div[@class='_1AtVbE']"));
       if(!productResults.isEmpty()) {
    	   
    	   productResults.get(0);
    	   
       }
       
       WebElement addToCart=driver.findElement(By.xpath("//*[@class='_2KpZ6l _2U9uOA _3v1-ww']"));
       addToCart.click();
       
       Thread.sleep(2000);
       
       WebElement placeOrder=driver.findElement(By.xpath("//*[@class='_2KpZ6l _2ObVJD _3AWRsL']"));
       placeOrder.click();
       
       String email ="test"+generateRandomNumber()+"@Example.com";
       String phoneNumber=generateRandomPhoneNumber();
       
       
       WebElement phoneField=driver.findElement(By.xpath("//*[@class='_2IX_2- _17N0em']"));
       phoneField.sendKeys( phoneNumber);
       
       WebElement emailField=driver.findElement(By.xpath("//*[@class='_2IX_2- _17N0em']"));
    	   emailField.sendKeys(email);
       
       driver.quit();
       
       
       
	}

	private static String generateRandomPhoneNumber() {
		Random random=new Random();
		StringBuilder  phoneNumber=new StringBuilder("+");
		for(int i=0; i<10; i++) {
			 phoneNumber.append(random.nextInt());
			 
			 
		}
		
		return  phoneNumber.toString();
	}

	private static int generateRandomNumber() {
		return (int)(Math.random()*1000);
	}

}  
