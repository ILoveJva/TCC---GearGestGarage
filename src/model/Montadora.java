package model;

import java.util.ArrayList;

public class Montadora {

    private long idMontadora;
    private String nome;
    private String paisOrigem;
    private ArrayList<Modelo> modelos;

    public Montadora() {
        this.modelos = new ArrayList<>();
    }

    public Montadora(long idMontadora, String nome, String paisOrigem) {
        this.idMontadora = idMontadora;
        this.nome = nome;
        this.paisOrigem = paisOrigem;
        this.modelos = new ArrayList<>();
    }

    public ArrayList<Modelo> listarModelos() {
        return modelos;
    }

    // Getters e Setters
    public long getIdMontadora() { return idMontadora; }
    public void setIdMontadora(long idMontadora) { this.idMontadora = idMontadora; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getPaisOrigem() { return paisOrigem; }
    public void setPaisOrigem(String paisOrigem) { this.paisOrigem = paisOrigem; }

    public ArrayList<Modelo> getModelos() { return modelos; }
    public void setModelos(ArrayList<Modelo> modelos) { this.modelos = modelos; }

    public void adicionarModelo(Modelo modelo) {
        this.modelos.add(modelo);
    }
}
