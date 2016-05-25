package TestCases;

import org.testng.annotations.Test;
import BaseMethod.Page;
@Test//百度搜索
public class BaiduSearch {
	
	
	public void test() throws Exception {
		Page page = new Page("common","chrome");
		page.driver.get("http://www.baidu.com");
		
		Thread.sleep(1000);
		
		
		page.sendKeys(page.getElement("Search"), "selenium");
		Thread.sleep(1000);
		page.click(page.getElement("Button"));
		Thread.sleep(1000);
		Thread.sleep(3000);
		 page.quit();
	}
}
