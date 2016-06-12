package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;  
import org.openqa.selenium.WebDriver;  
import org.openqa.selenium.interactions.HasInputDevices;
import org.testng.annotations.Test;
import BaseMethod.Page;
  
public class test12306 {  
  
    WebDriver wd;  
      
    @Test  
    public void test() throws InterruptedException{  
        //设置firefox浏览器  
    	Page page = new Page("common", "chrome"); 
          
        //打开12306主页  
    	page.driver.get("http://www.12306.cn/");
          
        //点击购票/预约按钮  
        Thread.sleep(1000);  
        page.driver.findElement(By.className("k2")).click();  
          
        //输入用户名、密码，等待手工输入验证码  
        Thread.sleep(1000);  
        page.driver.findElement(By.xpath("//a[contains(@href, '/login/init')]")).click();
        page.driver.findElement(By.id("UserName")).sendKeys("username");  
        page.driver.findElement(By.id("password")).sendKeys("password");  
        Thread.sleep(10000);  
          
        page.driver.findElement(By.id("loginSub")).click();  
          
        //进入订票界面，点击车票预定按钮  
        Thread.sleep(2000);  
        page.driver.findElement(By.id("selectYuding")).click();  
          
        //输入出发地和目的地  
        //出发地无法直接输入，需要借助键盘的上下键和回车键  
        Thread.sleep(1000);  
        page.driver.findElement(By.id("fromStationText")).clear();  
        page.driver.findElement(By.id("fromStationText")).sendKeys("北京"); 
        ((HasInputDevices) page).getKeyboard().sendKeys(Keys.RETURN);  
        page.driver.findElement(By.id("toStationText")).clear();  
        page.driver.findElement(By.id("toStationText")).sendKeys("上海");  
        ((HasInputDevices) page).getKeyboard().sendKeys(Keys.RETURN);  
          
        //输入出发日期  
        //现在这个地方不可以直接输入了，可以通过js来输入  
        String str = "document.getElementById(\"startdatepicker\").readonly=false";  
        String strDate = "document.getElementById(\"startdatepicker\").value=\"2013-08-02\"";  
        ((JavascriptExecutor)wd).executeScript(str);  
        ((JavascriptExecutor)wd).executeScript(strDate);      
        page.driver.findElement(By.id("submitQuery")).click();  
          
          
        //关闭浏览器  
        page.driver.close(); 
    }  
}
