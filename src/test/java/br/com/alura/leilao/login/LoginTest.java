package br.com.alura.leilao.login;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    private LoginPage paginaDeLogin;

    @BeforeEach
    public void beforeEach() {
        this.paginaDeLogin = new LoginPage();
    }

    @AfterEach
    public void afterEach() {
        this.paginaDeLogin.fechar();
    }

    @Test
    public void deveriaEfetuarLoginComDadosValidos() {
        this.paginaDeLogin.preencherFormularioDeLogin("fulano", "pass");
        this.paginaDeLogin.efetuaLogin();

        assertFalse(paginaDeLogin.isPaginaDeLogin());
        assertEquals("fulano", paginaDeLogin.getNomeUsuarioLogado());
    }

    @Test
    public void naoDeveriaLogarcomDadosInvalidos() {
        this.paginaDeLogin.preencherFormularioDeLogin("invalido", "123123");
        this.paginaDeLogin.efetuaLogin();

        assertTrue(paginaDeLogin.isPaginaDeLoginComDadosInvalidos());
        assertNull(paginaDeLogin.getNomeUsuarioLogado());
        assertTrue(paginaDeLogin.contemTexto("Usuário e senha inválidos."));
    }

    @Test
    public void naoDeveriaAcessarPaginaRestritaSemEstarLogado() {
        paginaDeLogin.navegaParaPaginaDeLances();

        assertTrue(paginaDeLogin.isPaginaDeLogin());
        assertFalse(paginaDeLogin.contemTexto("Dados do Leilão"));
    }
}
