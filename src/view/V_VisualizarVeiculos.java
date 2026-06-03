package view;

import controller.OficinaController;
import model.Cliente;
import model.Veiculo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

/**
 * Painel de Conteúdo para a Listagem de Veículos.
 * Removido o menu dropdown superior e adicionado o mapa de navegação (Breadcrumb).
 */
public class V_VisualizarVeiculos extends JPanel {

    // ==========================================
    // DECLARAÇÃO DOS COMPONENTES (Padrão Prefixo)
    // ==========================================
    private JPanel pnl_CardCentral;
    private JLabel lbl_MapaNavegacao; // "Mapa" de onde o usuário se encontra

    // Componentes de Tabela
    private JTable tbl_Veiculos;
    private DefaultTableModel mdl_Veiculos;
    private JScrollPane scp_ScrollVeiculos;

    // Referência do Controller
    private OficinaController controller;

    /**
     * Construtor recebe o Controller unificado do sistema.
     */
    public V_VisualizarVeiculos() {
        this.controller = controller;

        // Alinhamento centralizado idêntico ao painel de cadastros
        setLayout(new GridBagLayout());
        setBackground(Color.WHITE);

        initComponents();
        layoutComponents();
        carregarDadosVeiculos();
    }

    private void initComponents() {
        // Card Central de Contenção (Mesmas proporções das telas de cadastro)
        pnl_CardCentral = new JPanel(new BorderLayout(0, 15));
        pnl_CardCentral.setBackground(Color.WHITE);
        pnl_CardCentral.setPreferredSize(new Dimension(680, 560));

        // "Mapa" de Navegação Superior (Substituindo o antigo menu suspenso)
        lbl_MapaNavegacao = new JLabel("Página Inicia > Consultar Veículos");
        lbl_MapaNavegacao.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lbl_MapaNavegacao.setForeground(Color.decode("#4D4D4D"));

        // Estrutura de colunas baseada estritamente nos atributos de Veiculo.java
        String[] colunas = {"Cód. Veículo","Veiculo","Ano", "Proprietário"};
        mdl_Veiculos = new DefaultTableModel(colunas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) { return false; }
        };

        tbl_Veiculos = new JTable(mdl_Veiculos);
        tbl_Veiculos.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        tbl_Veiculos.setRowHeight(30);
        tbl_Veiculos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Customização do Cabeçalho da Tabela
        tbl_Veiculos.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
        tbl_Veiculos.getTableHeader().setReorderingAllowed(false);
        tbl_Veiculos.getTableHeader().setPreferredSize(new Dimension(0, 35));

        scp_ScrollVeiculos = new JScrollPane(tbl_Veiculos);
        scp_ScrollVeiculos.setBorder(BorderFactory.createLineBorder(Color.decode("#CCCCCC")));
    }

    private void layoutComponents() {
        // Adiciona o mapa de navegação no topo do card
        pnl_CardCentral.add(lbl_MapaNavegacao, BorderLayout.NORTH);

        // Adiciona a tabela ocupando o resto do espaço útil
        pnl_CardCentral.add(scp_ScrollVeiculos, BorderLayout.CENTER);

        // Injeta o card central usando o GridBagLayout para manter centralizado na tela
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.CENTER;
        add(pnl_CardCentral, gbc);
    }

    /**
     * Carrega a tabela varrendo os clientes reais obtidos do Controller.
     */
    private void carregarDadosVeiculos() {
        mdl_Veiculos.setRowCount(0);
        if (controller == null) return;

        List<Cliente> todosClientes = controller.getTodosClientes();
        if (todosClientes == null) return;

        for (Cliente cliente : todosClientes) {
            if (cliente.getVeiculos() != null) {
                for (Veiculo veiculo : cliente.getVeiculos()) {
                    mdl_Veiculos.addRow(new Object[]{
                            String.format("%04d", veiculo.getIdVeiculo()),
                            veiculo.getModelo() != null ? veiculo.getTipo() : "Não Informado",
                            veiculo.getAno(),
                            cliente.getNome()
                    });
                }
            }
        }
    }

    // Exposição da tabela caso necessite vincular listeners externos no futuro
    public JTable getTbl_Veiculos() {
        return tbl_Veiculos;
    }
}