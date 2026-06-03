package view;

import view.controller.ViewController;
import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * Barra lateral de navegação (JPanel).
 * Totalmente isolada do Back-end. Foco exclusivo em navegação via ViewController.
 */
public class V_MenuLateral extends JPanel {

    // ==========================================
    // DECLARAÇÃO DOS COMPONENTES (Padrão Prefixo)
    // ==========================================
    private JLabel lbl_LogoOficina;
    private JButton btn_PaginaInicial;
    private JButton btn_Pesquisar;
    private JButton btn_Servicos;
    private JButton btn_Estoque;

    // Referência do Controlador do Front-end (View Controller)
    private ViewController viewController;

    /**
     * Construtor Refatorado: Recebe o controlador de navegação de telas.
     */
    public V_MenuLateral(ViewController viewController) {
        this.viewController = viewController;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.decode("#6E6968")); // Cor de fundo padrão
        setPreferredSize(new Dimension(190, 768));

        initComponents();
        vincularAcoesNavegacao();
    }

    private void initComponents() {
        Dimension dimBtn = new Dimension(170, 90);

        // 1. Configuração do Logotipo / Header do Menu
        ImageIcon icoLogo = carregarERedimensionarIcone("/assets/icons/logo_menu.png", 50, 50);
        if (icoLogo != null) {
            lbl_LogoOficina = new JLabel(icoLogo);
        } else {
            lbl_LogoOficina = new JLabel("GEAR GEST");
            lbl_LogoOficina.setFont(new Font("Arial", Font.BOLD, 16));
            lbl_LogoOficina.setForeground(Color.WHITE);
        }
        lbl_LogoOficina.setAlignmentX(Component.CENTER_ALIGNMENT);
        lbl_LogoOficina.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

        // 2. Inicialização e Estilização dos Botões de Navegação
        btn_PaginaInicial = new JButton("Página Inicial");
        estilizarBotaoMenu(btn_PaginaInicial, "/assets/icons/home.png", dimBtn, 32, 32);

        btn_Pesquisar = new JButton("Pesquisar");
        estilizarBotaoMenu(btn_Pesquisar, "/assets/icons/search_menu.png", dimBtn, 32, 32);

        btn_Servicos = new JButton("Serviços / O.S.");
        estilizarBotaoMenu(btn_Servicos, "/assets/icons/services_menu.png", dimBtn, 32, 32);

        btn_Estoque = new JButton("Estoque");
        estilizarBotaoMenu(btn_Estoque, "/assets/icons/stock.png", dimBtn, 32, 32);

        // 3. Organização dos Componentes no Painel Lateral
        add(lbl_LogoOficina);
        add(Box.createVerticalStrut(10));
        add(btn_PaginaInicial);
        add(Box.createVerticalStrut(15));
        add(btn_Pesquisar);
        add(Box.createVerticalStrut(15));
        add(btn_Servicos);
        add(Box.createVerticalStrut(15));
        add(btn_Estoque);
        add(Box.createVerticalGlue()); // Empurra tudo para cima, deixando o fundo livre
    }

    /**
     * Vincula as ações de clique delegando o comportamento ao ViewController.
     */
    private void vincularAcoesNavegacao() {
        // Retorna para o painel principal
        btn_PaginaInicial.addActionListener(e -> {
            viewController.navegarPara(new V_PaginaInicial(viewController));
        });

        // Eventos temporários para teste de navegação das outras páginas
        btn_Pesquisar.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Navegando para: Tela de Pesquisa Geral", "Navegação", JOptionPane.INFORMATION_MESSAGE);
            // Quando a view correspondente estiver pronta, substitua por:
            // viewController.navegarPara(new V_PesquisarGeral(viewController));
        });

        btn_Servicos.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Navegando para: Tela de Serviços / O.S.", "Navegação", JOptionPane.INFORMATION_MESSAGE);
            // Quando a view correspondente estiver pronta, substitua por:
            // viewController.navegarPara(new V_VisualizarServicos(viewController));
        });

        btn_Estoque.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Navegando para: Tela de Controle de Estoque", "Navegação", JOptionPane.INFORMATION_MESSAGE);
            // Quando a view correspondente estiver pronta, substitua por:
            // viewController.navegarPara(new V_VisualizarEstoque(viewController));
        });
    }

    /**
     * Aplica a identidade visual padrão aos botões do menu lateral (Flat Design Vertical).
     */
    private void estilizarBotaoMenu(JButton btn, String caminhoIcone, Dimension dimensaoBtn, int larguraIco, int alturaIco) {
        btn.setMaximumSize(dimensaoBtn);
        btn.setPreferredSize(dimensaoBtn);
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);

        btn.setForeground(Color.WHITE); // Texto branco para contrastar com o fundo escuro
        btn.setFont(new Font("Arial", Font.BOLD, 13));

        ImageIcon icoBotao = carregarERedimensionarIcone(caminhoIcone, larguraIco, alturaIco);
        if (icoBotao != null) {
            btn.setIcon(icoBotao);
        }

        btn.setVerticalTextPosition(SwingConstants.BOTTOM);
        btn.setHorizontalTextPosition(SwingConstants.CENTER);
        btn.setIconTextGap(8);

        btn.setBorderPainted(false);
        btn.setContentAreaFilled(false);
        btn.setFocusPainted(false);
        btn.setMargin(new Insets(5, 5, 5, 5));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Efeito simples de Hover ao passar o mouse
        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn.setForeground(Color.decode("#EBE6E3"));
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn.setForeground(Color.WHITE);
            }
        });
    }

    /**
     * Busca os recursos de imagem de forma segura dentro do Build da aplicação.
     */
    private ImageIcon carregarERedimensionarIcone(String caminho, int larguraAlvo, int alturaAlvo) {
        URL url = getClass().getResource(caminho);
        if (url == null) {
            String caminhoLimpo = caminho.startsWith("/") ? caminho.substring(1) : caminho;
            url = Thread.currentThread().getContextClassLoader().getResource(caminhoLimpo);
        }

        if (url != null) {
            ImageIcon imagemOriginal = new ImageIcon(url);
            Image imgEscalada = imagemOriginal.getImage().getScaledInstance(larguraAlvo, alturaAlvo, Image.SCALE_SMOOTH);
            return new ImageIcon(imgEscalada);
        }
        return null;
    }
}