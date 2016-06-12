package TestCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import BaseMethod.Page;

@Test
public class TestSendMail {

	public void test() throws InterruptedException {
		// 设置chrome浏览器
		Page page = new Page("common", "chrome");

		// 打开QQ邮箱主页
		page.driver.get("https://mail.qq.com/");

		// 点击账号密码登录
		Thread.sleep(1000);
		page.switchToiframe(page.driver.findElement(By.id("login_frame")));
		page.driver.findElement(By.id("switcher_plogin")).click();

		// 输入用户名、密码，等待手工输入验证码
		page.driver.findElement(By.id("u")).sendKeys("528906825");
		page.driver.findElement(By.id("p")).sendKeys("haoba123");
		page.driver.findElement(By.id("login_button")).click();


		//点击写信
		page.switchToiframe(page.driver.findElement(By.id("actionFrame")));
		page.driver.findElement(By.id("composebtn_td")).click();
		// 关闭浏览器
		page.driver.close();
	}
}
