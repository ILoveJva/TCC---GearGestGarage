package controller;

import model.OrdemDeServico;
import model.Veiculo;

import java.util.ArrayList;

/**
 * Gerencia as operações sobre Veículos.
 */
public class VeiculoController {

    private ArrayList<Veiculo> veiculos;
    private OrdemDeServicoController osController;

    public VeiculoController(OrdemDeServicoController osController) {
        this.veiculos = new ArrayList<>();
        this.osController = osController;
    }

    /**
     * Cadastra um novo veículo.
     */
    public boolean cadastrar(Veiculo veiculo) {
        boolean placaExistente = veiculos.stream()
                .anyMatch(v -> v.getPlaca().equalsIgnoreCase(veiculo.getPlaca()));
        if (placaExistente) return false;
        veiculos.add(veiculo);
        return true;
    }

    /**
     * Busca veículo pelo ID.
     */
    public Veiculo buscarPorId(long idVeiculo) {
        return veiculos.stream()
                .filter(v -> v.getIdVeiculo() == idVeiculo)
                .findFirst()
                .orElse(null);
    }

    /**
     * Busca veículo pela placa.
     */
    public Veiculo buscarPorPlaca(String placa) {
        return veiculos.stream()
                .filter(v -> v.getPlaca().equalsIgnoreCase(placa))
                .findFirst()
                .orElse(null);
    }

    /**
     * Retorna o histórico de ordens de serviço de um veículo.
     */
    public ArrayList<OrdemDeServico> consultarHistorico(long idVeiculo) {
        return osController.listarPorVeiculo(idVeiculo);
    }

    /**
     * Atualiza dados do veículo.
     */
    public boolean atualizar(Veiculo veiculoAtualizado) {
        for (int i = 0; i < veiculos.size(); i++) {
            if (veiculos.get(i).getIdVeiculo() == veiculoAtualizado.getIdVeiculo()) {
                veiculos.set(i, veiculoAtualizado);
                return true;
            }
        }
        return false;
    }

    /**
     * Remove um veículo pelo ID.
     */
    public boolean remover(long idVeiculo) {
        return veiculos.removeIf(v -> v.getIdVeiculo() == idVeiculo);
    }

    public ArrayList<Veiculo> listarTodos() {
        return veiculos;
    }
}
