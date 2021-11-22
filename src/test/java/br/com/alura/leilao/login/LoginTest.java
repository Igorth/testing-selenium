package br.com.alura.leilao.login;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class LoginTest {

    @Test
    public void deveriaEfetuarLoginComDadosValidos() {
        System.setProperty("webdriver.chrome.driver", "/Users/igordias/IdeaProjects/testing-selenium/src/test/resources/chromedriver");

        WebDriver browser = new ChromeDriver();
        browser.navigate().to("http://localhost:8080/login");
        browser.findElement(By.id("username")).sendKeys("fulano");
        browser.findElement(By.id("password")).sendKeys("pass");
        browser.findElement(By.id("login-form")).submit();

        assertFalse(browser.getCurrentUrl().equals("http://localhost:8080/login"));
        assertEquals("fulano", browser.findElement(By.id("usuario-logado")).getText());

        browser.quit();
    }
}
