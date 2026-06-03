package model;

public class Modelo {

    private long idModelo;
    private String nome;
    private Montadora montadora;

    public Modelo() {}

    public Modelo(long idModelo, String nome, Montadora montadora) {
        this.idModelo = idModelo;
        this.nome = nome;
        this.montadora = montadora;
    }

    // Getters e Setters
    public long getIdModelo() { return idModelo; }
    public void setIdModelo(long idModelo) { this.idModelo = idModelo; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Montadora getMontadora() { return montadora; }
    public void setMontadora(Montadora montadora) { this.montadora = montadora; }
}
