package model;

public class ItemEstoque {

    private long idItemEstoque;
    private Estoque estoque;
    private Peca peca;
    private int quantidade;

    public ItemEstoque() {}

    public ItemEstoque(long idItemEstoque, Estoque estoque, Peca peca, int quantidade) {
        this.idItemEstoque = idItemEstoque;
        this.estoque = estoque;
        this.peca = peca;
        this.quantidade = quantidade;
    }

    public boolean temEstoque(int quantidadeNecessaria) {
        return this.quantidade >= quantidadeNecessaria;
    }

    // Getters e Setters
    public long getIdItemEstoque() { return idItemEstoque; }
    public void setIdItemEstoque(long idItemEstoque) { this.idItemEstoque = idItemEstoque; }

    public Estoque getEstoque() { return estoque; }
    public void setEstoque(Estoque estoque) { this.estoque = estoque; }

    public Peca getPeca() { return peca; }
    public void setPeca(Peca peca) { this.peca = peca; }

    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }
}
