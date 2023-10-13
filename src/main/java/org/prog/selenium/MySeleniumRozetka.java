package org.prog.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class MySeleniumRozetka {

  public static void main(String[] args) {

      //Объявляем и инициализируем Chrome Driver и для примера другие драйвера, но они будут закоменториваны

      WebDriver driver = new ChromeDriver();
//      WebDriver ffDriver = new FirefoxDriver();
//      WebDriver edge = new EdgeDriver();

      //Далее указываю, что я вообще хочу сделать, например я хочу перейти на страницу "https://rozetka.com.ua/"

      driver.get("https://rozetka.com.ua/");

      //Нам нужно найти поле ввода нашего поискового запроса на исходной странице rozetka.com.ua как это сделать, об этом ниже:

      WebElement serchInput = driver.findElement(By.name("search"));

      //Введем в поле ввода, что-то для теста, например поищем "iphone 15 pro max 256"

      serchInput.sendKeys("iphone 15 pro max 256 blue");
      serchInput.click();
      //Найдем зеленую кнопку "Найти" справа и привяжемся к ее индексу, выявнили, что ее индекс всегда будет 5

      List<WebElement> buttons = driver.findElements(By.xpath("//button"));
      if (buttons.size() == 12) {
          //мы видим главную страницу rozetka.com.ua
          WebElement element = buttons.get(5);
          element.click();
      }

      WebElement searchInput = driver.findElements(By.xpath("//input[@type='checkbox']")).get(0);
          searchInput.click();
          driver.quit();

  }


}


