package controller;

import model.Modelo;
import model.Peca;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Gerencia o catálogo de Peças.
 */
public class PecaController {

    private ArrayList<Peca> pecas;

    public PecaController() {
        this.pecas = new ArrayList<>();
    }

    /**
     * Cadastra uma nova peça.
     */
    public boolean cadastrar(Peca peca) {
        boolean existente = pecas.stream()
                .anyMatch(p -> p.getIdPeca() == peca.getIdPeca());
        if (existente) return false;
        pecas.add(peca);
        return true;
    }

    /**
     * Busca peça pelo ID.
     */
    public Peca buscarPorId(long idPeca) {
        return pecas.stream()
                .filter(p -> p.getIdPeca() == idPeca)
                .findFirst()
                .orElse(null);
    }

    /**
     * Busca peças pelo nome (busca parcial, case-insensitive).
     */
    public ArrayList<Peca> buscarPorNome(String nome) {
        return pecas.stream()
                .filter(p -> p.getNome().toLowerCase().contains(nome.toLowerCase()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * Busca peças por sistema (ex: "freios", "suspensão").
     */
    public ArrayList<Peca> buscarPorSistema(String sistema) {
        return pecas.stream()
                .filter(p -> p.getSistema().equalsIgnoreCase(sistema))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * Retorna modelos compatíveis com a peça.
     */
    public ArrayList<Modelo> mostrarAplicacoes(long idPeca) {
        Peca peca = buscarPorId(idPeca);
        if (peca == null) return new ArrayList<>();
        return peca.mostrarAplicacoes();
    }

    /**
     * Retorna previsão de próxima troca da peça.
     */
    public String mostrarProximaTroca(long idPeca) {
        Peca peca = buscarPorId(idPeca);
        if (peca == null) return "Peça não encontrada.";
        return peca.mostrarProximaTroca();
    }

    /**
     * Atualiza os dados de uma peça.
     */
    public boolean atualizar(Peca pecaAtualizada) {
        for (int i = 0; i < pecas.size(); i++) {
            if (pecas.get(i).getIdPeca() == pecaAtualizada.getIdPeca()) {
                pecas.set(i, pecaAtualizada);
                return true;
            }
        }
        return false;
    }

    /**
     * Remove uma peça pelo ID.
     */
    public boolean remover(long idPeca) {
        return pecas.removeIf(p -> p.getIdPeca() == idPeca);
    }

    public ArrayList<Peca> listarTodas() {
        return pecas;
    }
}
