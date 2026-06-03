package view;

import view.controller.ViewController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

/**
 * Tela de Autenticação (Login) do Sistema.
 * Totalmente desacoplada do Back-end. Foco exclusivo em interface e navegação.
 */
public class V_Login extends JFrame {

    // ==========================================
    // DECLARAÇÃO DOS COMPONENTES (Padrão Prefixo)
    // ==========================================
    private JTextField txtEmail;
    private JPasswordField txtSenha;
    private JButton btnEntrar;
    private JLabel lblIrParaCadastro;

    // Referência do Controlador do Front-end
    private ViewController viewController;

    /**
     * Construtor Refatorado: Recebe o controlador de navegação de telas.
     */
    public V_Login(ViewController viewController) {
        this.viewController = viewController;

        setTitle("Gear Gest Garage - Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 520);
        setLocationRelativeTo(null);
        setResizable(false);

        // Painel Principal com fundo cinza escuro/médio (#7D7876)
        JPanel pnlPrincipal = getJPanel();
        setContentPane(pnlPrincipal);

        // --- Imagem da Logo ---
        JLabel lblLogoImagem = new JLabel();
        lblLogoImagem.setBounds(225, 20, 225, 225);
        lblLogoImagem.setHorizontalAlignment(SwingConstants.CENTER);

        try {
            ImageIcon iconeOriginal = new ImageIcon(getClass().getResource("/assets/images/logo.png"));
            Image imagemRedimensionada = iconeOriginal.getImage().getScaledInstance(225, 225, Image.SCALE_SMOOTH);
            lblLogoImagem.setIcon(new ImageIcon(imagemRedimensionada));
        } catch (Exception e) {
            lblLogoImagem.setText("GEAR GEST GARAGE");
            lblLogoImagem.setFont(new Font("Arial", Font.BOLD, 20));
            lblLogoImagem.setForeground(Color.WHITE);
        }
        pnlPrincipal.add(lblLogoImagem);

        // --- Campo de Texto: E-mail ---
        txtEmail = new JTextField("oficina@geargest.com"); // Texto padrão temporário para facilitar testes
        txtEmail.setBounds(200, 260, 300, 40);
        txtEmail.setFont(new Font("Arial", Font.PLAIN, 14));
        txtEmail.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.LIGHT_GRAY), "E-mail Corporativo"));
        pnlPrincipal.add(txtEmail);

        // --- Campo de Texto: Senha ---
        txtSenha = new JPasswordField("123456"); // Senha padrão temporária para facilitar testes
        txtSenha.setBounds(200, 315, 300, 40);
        txtSenha.setFont(new Font("Arial", Font.PLAIN, 14));
        txtSenha.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.LIGHT_GRAY), "Senha de Acesso"));
        pnlPrincipal.add(txtSenha);

        // --- Botão: Entrar ---
        btnEntrar = new JButton("Entrar") {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setColor(Color.BLACK);
                g2d.fill(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 12, 12));
                g2d.dispose();
                super.paintComponent(g);
            }
        };
        btnEntrar.setOpaque(false);
        btnEntrar.setContentAreaFilled(false);
        btnEntrar.setBorderPainted(false);
        btnEntrar.setForeground(Color.WHITE);
        btnEntrar.setFont(new Font("Arial", Font.BOLD, 14));
        btnEntrar.setBounds(200, 385, 300, 42);
        btnEntrar.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Vincula a ação de clique para disparar o método de login local
        btnEntrar.addActionListener(e -> efetuarLogin());
        pnlPrincipal.add(btnEntrar);

        // --- Link: Criar Conta ---
        lblIrParaCadastro = new JLabel("Não possui conta? Cadastre sua Oficina aqui");
        lblIrParaCadastro.setBounds(200, 440, 300, 20);
        lblIrParaCadastro.setFont(new Font("Arial", Font.PLAIN, 12));
        lblIrParaCadastro.setForeground(Color.LIGHT_GRAY);
        lblIrParaCadastro.setHorizontalAlignment(SwingConstants.CENTER);
        lblIrParaCadastro.setCursor(new Cursor(Cursor.HAND_CURSOR));

        lblIrParaCadastro.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                irParaCadastro();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                lblIrParaCadastro.setForeground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lblIrParaCadastro.setForeground(Color.LIGHT_GRAY);
            }
        });
        pnlPrincipal.add(lblIrParaCadastro);
    }

    /**
     * Cria o painel de fundo customizado.
     */
    private JPanel getJPanel() {
        JPanel pnlPrincipal = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                GradientPaint gp = new GradientPaint(0, 0, Color.decode("#7D7876"), 0, getHeight(), Color.decode("#4E4A49"));
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        pnlPrincipal.setLayout(null);
        return pnlPrincipal;
    }

    /**
     * Executa a validação visual do login e delega a transição para o ViewController.
     */
    private void efetuarLogin() {
        String email = txtEmail.getText().trim();
        String senha = new String(txtSenha.getPassword());

        // Validação simples de preenchimento (Front-end)
        if (email.isEmpty() || senha.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Por favor, preencha todos os campos para continuar.",
                    "Campos Vazios",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Foco em Navegação: Simula uma autenticação bem-sucedida sem depender do banco.
        // A integração real com o Back-end será adicionada aqui futuramente.
        JOptionPane.showMessageDialog(this,
                "Login (Modo de Navegação) efetuado com sucesso!",
                "Bem-vindo",
                JOptionPane.INFORMATION_MESSAGE);

        // Passa o comando de mudança de tela para o controlador central da View
        viewController.loginComSucesso();
    }

    /**
     * Gerencia a navegação para a tela de registro de nova oficina.
     */
    private void irParaCadastro() {
        // Quando criar o painel ou frame de cadastro, vincule-o aqui usando o viewController:
        // viewController.navegarParaCadastro();
        JOptionPane.showMessageDialog(this,
                "Navegando para: Tela de Cadastro de Oficina",
                "Navegação",
                JOptionPane.INFORMATION_MESSAGE);
    }
}