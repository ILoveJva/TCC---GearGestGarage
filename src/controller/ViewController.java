package view.controller;

import view.*;
import javax.swing.*;

/**
 * Gerencia a navegação e o fluxo de telas do Front-end.
 * Totalmente isolado do Back-end (OficinaController) neste momento.
 */
public class ViewController {

    private V_Main telaPrincipal;
    private JFrame telaLogin;

    // 1. Inicia o fluxo visual pelo Login
    public void iniciarAplicacao() {
        telaLogin = new V_Login(this);
        telaLogin.setVisible(true);
    }

    // 2. Transição após Login bem-sucedido
    public void loginComSucesso() {
        if (telaLogin != null) {
            telaLogin.dispose();
        }

        telaPrincipal = new V_Main();
        telaPrincipal.setVisible(true);

        // Injeta a tela inicial no centro
        navegarPara(new V_PaginaInicial(this));
    }

    // 3. Método Central de Navegação
    public void navegarPara(JPanel novoPainel) {
        if (telaPrincipal != null) {
            telaPrincipal.atualizarConteudo(novoPainel);
        }
    }
}