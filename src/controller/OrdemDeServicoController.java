package controller;

import model.Funcionario;
import model.ItemServico;
import model.OrdemDeServico;
import model.Veiculo;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Gerencia o ciclo de vida das Ordens de Serviço.
 */
public class OrdemDeServicoController {

    private ArrayList<OrdemDeServico> ordensDeServico;
    private long proximoId = 1;

    public OrdemDeServicoController() {
        this.ordensDeServico = new ArrayList<>();
    }

    /**
     * Cria uma nova OS a partir de um veículo, funcionário responsável e item de serviço.
     */
    public OrdemDeServico criar(Veiculo veiculo, Funcionario responsavel, ItemServico itemServico) {
        return null;
    }

    /**
     * Busca uma OS pelo ID.
     */
    public OrdemDeServico buscarPorId(long idOS) {
        return ordensDeServico.stream()
                .filter(os -> os.getIdOrdemDeServico() == idOS)
                .findFirst()
                .orElse(null);
    }

    /**
     * Atualiza o status de uma OS.
     */
    public boolean atualizarStatus(long idOS, OrdemDeServico.StatusOS novoStatus) {
        OrdemDeServico os = buscarPorId(idOS);
        if (os == null) return false;
        os.atualizarStatus(novoStatus);
        return true;
    }

    /**
     * Lista OS de um funcionário específico.
     */
    public ArrayList<OrdemDeServico> listarPorFuncionario(long idFuncionario) {
        return ordensDeServico.stream()
                .filter(os -> os.getResponsavel() != null
                        && os.getResponsavel().getIdUsuario() == idFuncionario)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * Lista OS de um veículo específico (histórico).
     */
    public ArrayList<OrdemDeServico> listarPorVeiculo(long idVeiculo) {
        return ordensDeServico.stream()
                .filter(os -> os.getVeiculo() != null
                        && os.getVeiculo().getIdVeiculo() == idVeiculo)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * Lista OS por status.
     */
    public ArrayList<OrdemDeServico> listarPorStatus(OrdemDeServico.StatusOS status) {
        return ordensDeServico.stream()
                .filter(os -> os.getStatus() == status)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * Define o prazo (em dias) de uma OS.
     */
    public boolean definirPrazo(long idOS, int prazo) {
        OrdemDeServico os = buscarPorId(idOS);
        if (os == null || prazo < 0) return false;
        os.setPrazo(prazo);
        return true;
    }

    public ArrayList<OrdemDeServico> listarTodas() {
        return ordensDeServico;
    }
}
