package controller;

import model.ItemServico;
import model.Peca;

import java.util.ArrayList;

/**
 * Gerencia os Itens de Serviço dentro de uma OS.
 */
public class ItemServicoController {

    private ArrayList<ItemServico> itens;

    public ItemServicoController() {
        this.itens = new ArrayList<>();
    }

    public ItemServico criar(String descricao) {
        long id = System.currentTimeMillis();
        ItemServico item = new ItemServico(id, descricao);
        itens.add(item);
        return item;
    }

    public ItemServico buscarPorId(long idItem) {
        return itens.stream()
                .filter(i -> i.getIdItemServico() == idItem)
                .findFirst()
                .orElse(null);
    }

    public boolean adicionarPeca(long idItem, Peca peca) {
        ItemServico item = buscarPorId(idItem);
        if (item == null) return false;
        item.adicionarPeca(peca);
        return true;
    }

    public boolean atualizarStatus(long idItem, ItemServico.StatusItem novoStatus) {
        ItemServico item = buscarPorId(idItem);
        if (item == null) return false;
        item.atualizarStatus(novoStatus);
        return true;
    }

    public ArrayList<ItemServico> listarTodos() {
        return itens;
    }
}
