package model;

import java.util.ArrayList;

public class Estoque {

    private long idEstoque;
    private String tipo;
    private ArrayList<ItemEstoque> itens;

    public Estoque() {
        this.itens = new ArrayList<>();
    }

    public Estoque(long idEstoque, String tipo) {
        this.idEstoque = idEstoque;
        this.tipo = tipo;
        this.itens = new ArrayList<>();
    }

    public ArrayList<ItemEstoque> listar() {
        return itens;
    }

    // Getters e Setters
    public long getIdEstoque() { return idEstoque; }
    public void setIdEstoque(long idEstoque) { this.idEstoque = idEstoque; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public ArrayList<ItemEstoque> getItens() { return itens; }
    public void setItens(ArrayList<ItemEstoque> itens) { this.itens = itens; }

    public void adicionarItem(ItemEstoque item) {
        this.itens.add(item);
    }
}
