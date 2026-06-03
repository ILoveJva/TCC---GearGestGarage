package view;

import view.controller.ViewController;
import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * Painel de Conteúdo da Página Inicial.
 * Totalmente desacoplado do Back-end. Foco exclusivo em renderização e navegação.
 */
public class V_PaginaInicial extends JPanel {

    // ==========================================
    // DECLARAÇÃO DOS COMPONENTES (Padrão Prefixo)
    // ==========================================
    private JPanel pnl_Header;
    private JPanel pnl_BotoesAcao;
    private JPanel pnl_BotoesVisualizar;

    // Elementos do Cabeçalho
    private JLabel lbl_NomeGaragem;
    private JLabel lbl_CnpjGaragem;
    private JLabel lbl_Especialidade;
    private JButton btn_PesquisarHeader;

    // Botões de Ações Rápidas
    private JButton btn_AdicionarServico;
    private JButton btn_AdicionarCliente;
    private JButton btn_AdicionarVeiculo;

    // Botões de Visualização
    private JButton btn_VisServicos;
    private JButton btn_VisOrcamentos;
    private JButton btn_VisClientes;
    private JButton btn_VisVeiculos;

    // Referência do Controlador do Front-end
    private ViewController viewController;

    /**
     * Construtor Refatorado: Recebe o controlador de navegação de telas.
     */
    public V_PaginaInicial(ViewController viewController) {
        this.viewController = viewController;

        setBackground(Color.decode("#F5F5F5"));
        setLayout(new BorderLayout(20, 20));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        initComponents();
        carregarInformacoesEstaticas(); // Substitui a consulta ao Back-end antiga
        layoutComponents();
        vincularAcoesNavegacao();
    }

    private void initComponents() {
        // --- 1. Inicialização do Cabeçalho (Header) ---
        pnl_Header = new JPanel(new BorderLayout(15, 0));
        pnl_Header.setBackground(Color.decode("#EBE6E3"));
        pnl_Header.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));

        JPanel pnlTextoHeader = new JPanel();
        pnlTextoHeader.setLayout(new BoxLayout(pnlTextoHeader, BoxLayout.Y_AXIS));
        pnlTextoHeader.setOpaque(false);

        lbl_NomeGaragem = new JLabel();
        lbl_NomeGaragem.setFont(new Font("Arial", Font.BOLD, 22));
        lbl_NomeGaragem.setForeground(Color.decode("#2E2B2A"));

        lbl_CnpjGaragem = new JLabel();
        lbl_CnpjGaragem.setFont(new Font("Arial", Font.PLAIN, 13));
        lbl_CnpjGaragem.setForeground(Color.DARK_GRAY);

        lbl_Especialidade = new JLabel();
        lbl_Especialidade.setFont(new Font("Arial", Font.ITALIC, 13));
        lbl_Especialidade.setForeground(Color.DARK_GRAY);

        pnlTextoHeader.add(lbl_NomeGaragem);
        pnlTextoHeader.add(Box.createVerticalStrut(4));
        pnlTextoHeader.add(lbl_CnpjGaragem);
        pnlTextoHeader.add(Box.createVerticalStrut(2));
        pnlTextoHeader.add(lbl_Especialidade);

        btn_PesquisarHeader = new JButton("Pesquisa Geral");
        estilizarBotaoCard(btn_PesquisarHeader, "/assets/icons/search.png", new Dimension(160, 50), 20, 20);
        btn_PesquisarHeader.setFont(new Font("Arial", Font.BOLD, 12));

        pnl_Header.add(pnlTextoHeader, BorderLayout.WEST);
        pnl_Header.add(btn_PesquisarHeader, BorderLayout.EAST);

        // --- 2. Painel Inferior Dividido (Ações à esquerda, Visualizações à direita) ---
        Dimension dimCard = new Dimension(140, 120);

        // Seção: Ações Rápidas (Cadastros)
        pnl_BotoesAcao = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 15));
        pnl_BotoesAcao.setOpaque(false);
        pnl_BotoesAcao.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Ações Rápidas", 0, 0, new Font("Arial", Font.BOLD, 14), Color.DARK_GRAY));

        btn_AdicionarServico = new JButton("Nova O.S.");
        estilizarBotaoCard(btn_AdicionarServico, "/assets/icons/add_os.png", dimCard, 40, 40);

        btn_AdicionarCliente = new JButton("Novo Cliente");
        estilizarBotaoCard(btn_AdicionarCliente, "/assets/icons/add_client.png", dimCard, 40, 40);

        btn_AdicionarVeiculo = new JButton("Novo Veículo");
        estilizarBotaoCard(btn_AdicionarVeiculo, "/assets/icons/add_car.png", dimCard, 40, 40);

        pnl_BotoesAcao.add(btn_AdicionarServico);
        pnl_BotoesAcao.add(btn_AdicionarCliente);
        pnl_BotoesAcao.add(btn_AdicionarVeiculo);

        // Seção: Consultas / Visualizações
        pnl_BotoesVisualizar = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 15));
        pnl_BotoesVisualizar.setOpaque(false);
        pnl_BotoesVisualizar.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Consultar Registros", 0, 0, new Font("Arial", Font.BOLD, 14), Color.DARK_GRAY));

        btn_VisServicos = new JButton("Serviços");
        estilizarBotaoCard(btn_VisServicos, "/assets/icons/services.png", dimCard, 40, 40);

        btn_VisOrcamentos = new JButton("Orçamentos");
        estilizarBotaoCard(btn_VisOrcamentos, "/assets/icons/quotes.png", dimCard, 40, 40);

        btn_VisClientes = new JButton("Clientes");
        estilizarBotaoCard(btn_VisClientes, "/assets/icons/clients.png", dimCard, 40, 40);

        btn_VisVeiculos = new JButton("Veículos");
        estilizarBotaoCard(btn_VisVeiculos, "/assets/icons/cars.png", dimCard, 40, 40);

        pnl_BotoesVisualizar.add(btn_VisServicos);
        pnl_BotoesVisualizar.add(btn_VisOrcamentos);
        pnl_BotoesVisualizar.add(btn_VisClientes);
        pnl_BotoesVisualizar.add(btn_VisVeiculos);
    }

    /**
     * Preenche os dados visuais com mocks independentes do banco de dados.
     */
    private void carregarInformacoesEstaticas() {
        lbl_NomeGaragem.setText("Gear Gest Garage (Visualização Independente)");
        lbl_CnpjGaragem.setText("CNPJ: 00.000.000/0001-00");
        lbl_Especialidade.setText("Especialidade: Modo de Navegação Ativo");
    }

    private void layoutComponents() {
        add(pnl_Header, BorderLayout.NORTH);

        JPanel pnlCentroGeral = new JPanel(new GridLayout(2, 1, 0, 20));
        pnlCentroGeral.setOpaque(false);
        pnlCentroGeral.add(pnl_BotoesAcao);
        pnlCentroGeral.add(pnl_BotoesVisualizar);

        add(pnlCentroGeral, BorderLayout.CENTER);
    }

    /**
     * Centraliza o comportamento de cliques nos botões enviando os comandos
     * diretamente para o método 'navegarPara' do Controller da View.
     */
    private void vincularAcoesNavegacao() {
        // Exemplo de navegação para a tela de listagem de veículos
        btn_VisVeiculos.addActionListener(e -> {
            // Quando a classe V_VisualizarVeiculos for refatorada para aceitar o ViewController, descomente abaixo:
            // viewController.navegarPara(new V_VisualizarVeiculos(viewController));
            JOptionPane.showMessageDialog(this, "Navegando para: Tela de Veículos", "Navegação", JOptionPane.INFORMATION_MESSAGE);
        });

        // Vincule as demais ações conforme for ajustando as suas outras views
        btn_PesquisarHeader.addActionListener(e -> System.out.println("Navegar para Pesquisa"));
        btn_AdicionarServico.addActionListener(e -> System.out.println("Navegar para Nova OS"));
        btn_AdicionarCliente.addActionListener(e -> System.out.println("Navegar para Novo Cliente"));
        btn_AdicionarVeiculo.addActionListener(e -> System.out.println("Navegar para Novo Veículo"));
        btn_VisServicos.addActionListener(e -> System.out.println("Navegar para Serviços"));
        btn_VisOrcamentos.addActionListener(e -> System.out.println("Navegar para Orçamentos"));
        btn_VisClientes.addActionListener(e -> System.out.println("Navegar para Clientes"));
    }

    /**
     * Aplica os estilos visuais de botões em formato de "Card".
     */
    private void estilizarBotaoCard(JButton btn, String caminhoIcone, Dimension dimensao, int larguraIco, int alturaIco) {
        ImageIcon icoBotao = carregarERedimensionarIcone(caminhoIcone, larguraIco, alturaIco);
        if (icoBotao != null) {
            btn.setIcon(icoBotao);
        }

        btn.setVerticalTextPosition(SwingConstants.BOTTOM);
        btn.setHorizontalTextPosition(SwingConstants.CENTER);
        btn.setPreferredSize(dimensao);
        btn.setFont(new Font("Arial", Font.BOLD, 14));
        btn.setForeground(Color.DARK_GRAY);
        btn.setBackground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.setIconTextGap(10);
    }

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