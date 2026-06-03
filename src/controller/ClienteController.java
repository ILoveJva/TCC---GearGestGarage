package controller;

import model.Cliente;
import model.Orcamento;
import model.OrdemDeServico;
import model.Veiculo;

import java.util.ArrayList;

/**
 * Gerencia as operações específicas do Cliente.
 */
public class ClienteController {

    private ArrayList<Cliente> clientes;
    private OrcamentoController orcamentoController;
    private OrdemDeServicoController osController;

    public ClienteController(OrcamentoController orcamentoController,
                             OrdemDeServicoController osController) {
        this.clientes = new ArrayList<>();
        this.orcamentoController = orcamentoController;
        this.osController = osController;
    }

    /**
     * Cadastra um novo cliente.
     */
    public boolean cadastrar(Cliente cliente) {
        boolean existente = clientes.stream()
                .anyMatch(c -> c.getCpf().equals(cliente.getCpf()));
        if (existente) return false;
        clientes.add(cliente);
        return true;
    }

    /**
     * Busca cliente pelo ID.
     */
    public Cliente buscarPorId(long idCliente) {
        return clientes.stream()
                .filter(c -> c.getIdUsuario() == idCliente)
                .findFirst()
                .orElse(null);
    }

    /**
     * Retorna o orçamento de um cliente pelo ID.
     */
    public Orcamento visualizarOrcamento(long idOrcamento) {
        return orcamentoController.buscarPorId(idOrcamento);
    }

    /**
     * Retorna uma OS pelo ID.
     */
    public OrdemDeServico visualizarOS(long idOS) {
        return osController.buscarPorId(idOS);
    }

    /**
     * Retorna os veículos de um cliente.
     */
    public ArrayList<Veiculo> visualizarVeiculos(long idCliente) {
        Cliente cliente = buscarPorId(idCliente);
        if (cliente == null) return new ArrayList<>();
        return cliente.getVeiculos();
    }

    /**
     * Aprova ou recusa um orçamento.
     */
    public boolean decidirOrcamento(long idOrcamento, boolean aprovado) {
        Orcamento orcamento = orcamentoController.buscarPorId(idOrcamento);
        if (orcamento == null) return false;

        if (aprovado) {
            orcamento.setStatus(Orcamento.StatusOrcamento.APROVADO);
        } else {
            orcamento.setStatus(Orcamento.StatusOrcamento.RECUSADO);
        }
        return true;
    }

    /**
     * Associa um veículo a um cliente.
     */
    public boolean adicionarVeiculo(long idCliente, Veiculo veiculo) {
        Cliente cliente = buscarPorId(idCliente);
        if (cliente == null) return false;
        cliente.adicionarVeiculo(veiculo);
        return true;
    }

    public ArrayList<Cliente> listarTodos() {
        return clientes;
    }
}
