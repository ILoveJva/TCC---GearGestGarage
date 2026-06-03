package controller;

import model.Estoque;
import model.ItemEstoque;
import model.Peca;

import java.util.ArrayList;

/**
 * Gerencia as operações de Estoque e seus itens.
 */
public class EstoqueController {

    private ArrayList<Estoque> estoques;

    public EstoqueController() {
        this.estoques = new ArrayList<>();
    }

    /**
     * Cadastra um novo estoque.
     */
    public boolean cadastrar(Estoque estoque) {
        estoques.add(estoque);
        return true;
    }

    /**
     * Busca estoque pelo ID.
     */
    public Estoque buscarPorId(long idEstoque) {
        return estoques.stream()
                .filter(e -> e.getIdEstoque() == idEstoque)
                .findFirst()
                .orElse(null);
    }

    /**
     * Lista todos os itens de um estoque.
     */
    public ArrayList<ItemEstoque> listarItens(long idEstoque) {
        Estoque estoque = buscarPorId(idEstoque);
        if (estoque == null) return new ArrayList<>();
        return estoque.listar();
    }

    /**
     * Adiciona ou incrementa uma peça no estoque.
     */
    public boolean adicionarPeca(long idEstoque, Peca peca, int quantidade) {
        Estoque estoque = buscarPorId(idEstoque);
        if (estoque == null) return false;

        for (ItemEstoque item : estoque.getItens()) {
            if (item.getPeca().getIdPeca() == peca.getIdPeca()) {
                item.setQuantidade(item.getQuantidade() + quantidade);
                return true;
            }
        }

        // Peça não encontrada no estoque; cria novo ItemEstoque
        ItemEstoque novoItem = new ItemEstoque(
                System.currentTimeMillis(), estoque, peca, quantidade);
        estoque.adicionarItem(novoItem);
        return true;
    }

    /**
     * Baixa quantidade de uma peça do estoque (uso em OS).
     */
    public boolean baixarPeca(long idEstoque, long idPeca, int quantidade) {
        Estoque estoque = buscarPorId(idEstoque);
        if (estoque == null) return false;

        for (ItemEstoque item : estoque.getItens()) {
            if (item.getPeca().getIdPeca() == idPeca) {
                if (!item.temEstoque(quantidade)) return false;
                item.setQuantidade(item.getQuantidade() - quantidade);
                return true;
            }
        }
        return false;
    }

    /**
     * Verifica disponibilidade de uma peça no estoque.
     */
    public boolean verificarDisponibilidade(long idEstoque, long idPeca, int quantidadeNecessaria) {
        Estoque estoque = buscarPorId(idEstoque);
        if (estoque == null) return false;

        return estoque.getItens().stream()
                .anyMatch(item -> item.getPeca().getIdPeca() == idPeca
                        && item.temEstoque(quantidadeNecessaria));
    }

    public ArrayList<Estoque> listarTodos() {
        return estoques;
    }
}
