package br.com.alura.leilao.leiloes;

import org.openqa.selenium.WebDriver;

public class CadastroLeilaoPage {

    //Page object -> é uma classe que representa aquela página

    private WebDriver browser;

    public CadastroLeilaoPage(WebDriver browser) {
        this.browser = browser;
    }

    public void fechar() {
        this.browser.quit();
    }

}
