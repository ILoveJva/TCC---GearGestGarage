package model;

public class Motor {
    private long id;
    private String nome;
    private Montadora montadora;
    private String detalhes;

    public Motor(long id, String nome, Montadora montadora, String detalhes) {
        this.id = id;
        this.nome = nome;
        this.montadora = montadora;
        this.detalhes = detalhes;
    }

    @Override
    public String toString() {
        return "Motor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", montadora=" + montadora +
                ", detalhes='" + detalhes + '\'' +
                '}';
    }
}
