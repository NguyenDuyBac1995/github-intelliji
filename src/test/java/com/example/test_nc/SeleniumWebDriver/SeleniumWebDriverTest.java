package com.example.test_nc.SeleniumWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeleniumWebDriverTest {
//    private WebDriver  webDriver;
//
//    @BeforeEach
//    public void setUp() {
//        WebDriverManager.chromedriver().setup();
//        webDriver = new ChromeDriver();
//    }
//
//    @Test
//    void testSteps() throws InterruptedException {
//        // 1. Mở trang chủ
//        webDriver.get("https://vitimex.com.vn/");
//        Thread.sleep(3000);
//        // 2. Click vào nút Đăng ký (hoặc Đăng nhập, tùy giao diện)
//        webDriver.findElement(By.xpath("/html/body/div[1]/header/div/div/div/div[3]/div/div[3]/a")).click();
//        Thread.sleep(3000);
//        webDriver.findElement(By.xpath("//*[@id=\"customer-login\"]/div[1]/h4[2]/a")).click();
//
//
//        // 3. Điền thông tin đăng ký
//
//        webDriver.findElement(By.xpath("//*[@id=\"last_name\"]")).sendKeys("Nguyen");
//        webDriver.findElement(By.xpath("//*[@id=\"first_name\"]")).sendKeys("Duy Bac");
//        webDriver.findElement(By.xpath("//*[@id=\"radio2\"]")).click();
//        webDriver.findElement(By.xpath("//*[@id=\"birthday\"]")).sendKeys("06/04/2025");
//        webDriver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("boykenxyn@gmail.com");
//        webDriver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("1234567");
//        Thread.sleep(3000);
//       webDriver.findElement(By.xpath("//*[@id=\"create_customer\"]/div[8]/div[1]/input")).click();
//        Thread.sleep(3000);
//        WebElement webElement = webDriver.findElement(By.xpath("//*[@id=\"nav-menu\"]/ul/li[6]/a/span"));
//        String actualFristCategory = webElement.getText();
//        String expectedFristCategory = "Cửa hàng";
//        assertEquals(expectedFristCategory, actualFristCategory);
//        webDriver.quit();
//    }
}
