package controller;

import model.Funcionario;
import model.Orcamento;
import model.OrdemDeServico;
import model.Veiculo;

import java.util.ArrayList;

/**
 * Gerencia as operações específicas do Funcionário.
 */
public class FuncionarioController {

    private ArrayList<Funcionario> funcionarios;
    private OrcamentoController orcamentoController;
    private OrdemDeServicoController osController;

    public FuncionarioController(OrcamentoController orcamentoController,
                                 OrdemDeServicoController osController) {
        this.funcionarios = new ArrayList<>();
        this.orcamentoController = orcamentoController;
        this.osController = osController;
    }

    /**
     * Cadastra um novo funcionário.
     */
    public boolean cadastrar(Funcionario funcionario) {
        boolean existente = funcionarios.stream()
                .anyMatch(f -> f.getCpf().equals(funcionario.getCpf()));
        if (existente) return false;
        funcionarios.add(funcionario);
        return true;
    }

    /**
     * Busca funcionário pelo ID.
     */
    public Funcionario buscarPorId(long idFuncionario) {
        return funcionarios.stream()
                .filter(f -> f.getIdUsuario() == idFuncionario)
                .findFirst()
                .orElse(null);
    }

    /**
     * Lista todas as ordens de serviço associadas ao funcionário.
     */
    public ArrayList<OrdemDeServico> consultarOS(long idFuncionario) {
        Funcionario funcionario = buscarPorId(idFuncionario);
        if (funcionario == null) return new ArrayList<>();
        return osController.listarPorFuncionario(idFuncionario);
    }

    /**
     * Cria um orçamento para um veículo de um cliente.
     */
    public Orcamento criarOrcamento(long idFuncionario, Veiculo veiculo) {
        Funcionario funcionario = buscarPorId(idFuncionario);
        if (funcionario == null) return null;
        return orcamentoController.criar(veiculo, funcionario);
    }

    /**
     * Atualiza o status de uma OS gerenciada pelo funcionário.
     */
    public boolean gerenciarOS(long idOS, OrdemDeServico.StatusOS novoStatus) {
        OrdemDeServico os = osController.buscarPorId(idOS);
        if (os == null) return false;
        os.atualizarStatus(novoStatus);
        return true;
    }

    public ArrayList<Funcionario> listarTodos() {
        return funcionarios;
    }
}
