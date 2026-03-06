package api.test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dynamic_Tables {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://practice.expandtesting.com/dynamic-table");
		driver.manage().window().maximize();
	  List<WebElement> totalRow=driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr"));
	  System.out.print(totalRow.size());
	}

}
