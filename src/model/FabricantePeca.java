package model;

import java.util.ArrayList;

public class FabricantePeca {

    private long idFabricantePeca;
    private String nome;
    private String paisOrigem;
    private ArrayList<Peca> pecas;

    public FabricantePeca() {
        this.pecas = new ArrayList<>();
    }

    public FabricantePeca(long idFabricantePeca, String nome, String paisOrigem) {
        this.idFabricantePeca = idFabricantePeca;
        this.nome = nome;
        this.paisOrigem = paisOrigem;
        this.pecas = new ArrayList<>();
    }

    public ArrayList<Peca> listarPecas() {
        return pecas;
    }

    // Getters e Setters
    public long getIdFabricantePeca() { return idFabricantePeca; }
    public void setIdFabricantePeca(long idFabricantePeca) { this.idFabricantePeca = idFabricantePeca; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getPaisOrigem() { return paisOrigem; }
    public void setPaisOrigem(String paisOrigem) { this.paisOrigem = paisOrigem; }

    public ArrayList<Peca> getPecas() { return pecas; }
    public void setPecas(ArrayList<Peca> pecas) { this.pecas = pecas; }

    public void adicionarPeca(Peca peca) {
        this.pecas.add(peca);
    }
}
