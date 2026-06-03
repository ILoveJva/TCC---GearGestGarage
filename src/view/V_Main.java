package view;

import view.controller.ViewController;
import javax.swing.*;
import java.awt.*;

public class V_Main extends JFrame {

    private JPanel pnl_Main;
    private V_MenuLateral pnl_MenuLateral;
    private JPanel pnl_ConteudoDinamico;

    private ViewController viewController;

    public V_Main() {
        this.viewController = viewController;

        setTitle("Sistema de Gerenciamento - Gear Gest Garage");
        setSize(1024, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
        layoutComponents();
    }

    private void initComponents() {
        pnl_Main = new JPanel(new BorderLayout());

        // O menu lateral precisa do viewController para acionar os botões
        pnl_MenuLateral = new V_MenuLateral(this.viewController);

        pnl_ConteudoDinamico = new JPanel(new BorderLayout());
        pnl_ConteudoDinamico.setBackground(Color.WHITE);
    }

    private void layoutComponents() {
        pnl_Main.add(pnl_MenuLateral, BorderLayout.WEST);
        pnl_Main.add(pnl_ConteudoDinamico, BorderLayout.CENTER);
        add(pnl_Main);
    }

    // Apenas substitui visualmente o painel no centro
    public void atualizarConteudo(JPanel pnl_NovaPagina) {
        pnl_ConteudoDinamico.removeAll();
        pnl_ConteudoDinamico.add(pnl_NovaPagina, BorderLayout.CENTER);
        pnl_ConteudoDinamico.revalidate();
        pnl_ConteudoDinamico.repaint();
    }
}