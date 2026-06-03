package controller;

import model.Funcionario;
import model.ItemServico;
import model.Orcamento;
import model.OrdemDeServico;
import model.Peca;
import model.Veiculo;

import java.util.ArrayList;

/**
 * Gerencia criação, aprovação e conversão de Orçamentos.
 */
public class OrcamentoController {

    private ArrayList<Orcamento> orcamentos;
    private OrdemDeServicoController osController;
    private long proximoId = 1;

    public OrcamentoController(OrdemDeServicoController osController) {
        this.orcamentos = new ArrayList<>();
        this.osController = osController;
    }

    /**
     * Cria um novo orçamento vinculado a um veículo e funcionário responsável.
     */
    public Orcamento criar(Veiculo veiculo, Funcionario funcionario) {
        Orcamento orcamento = new Orcamento(proximoId++, null, veiculo, funcionario, "");
        orcamentos.add(orcamento);
        return orcamento;
    }

    /**
     * Busca orçamento pelo ID.
     */
    public Orcamento buscarPorId(long idOrcamento) {
        return orcamentos.stream()
                .filter(o -> o.getIdOrcamento() == idOrcamento)
                .findFirst()
                .orElse(null);
    }

    /**
     * Adiciona uma peça ao orçamento.
     */
    public boolean adicionarPeca(long idOrcamento, Peca peca) {
        Orcamento orcamento = buscarPorId(idOrcamento);
        if (orcamento == null) return false;
        orcamento.adicionarPeca(peca);
        return true;
    }

    /**
     * Aprova o orçamento e gera uma Ordem de Serviço.
     */

    /**
     * Cancela um orçamento.
     */
    public boolean cancelar(long idOrcamento) {
        Orcamento orcamento = buscarPorId(idOrcamento);
        if (orcamento == null) return false;
        orcamento.setStatus(Orcamento.StatusOrcamento.CANCELADO);
        return true;
    }

    /**
     * Lista orçamentos de um cliente específico.
     */
    public ArrayList<Orcamento> listarPorCliente(long idCliente) {
        ArrayList<Orcamento> resultado = new ArrayList<>();
        for (Orcamento o : orcamentos) {
            if (o.getCliente() != null && o.getCliente().getIdUsuario() == idCliente) {
                resultado.add(o);
            }
        }
        return resultado;
    }

    public ArrayList<Orcamento> listarTodos() {
        return orcamentos;
    }
}
