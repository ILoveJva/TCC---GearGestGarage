package model;

import java.util.ArrayList;
import java.util.Date;

public class Peca {

    private long idPeca;
    private String nome;
    private String sistema;
    private double valor;
    private Date dataTroca;
    private int vidaUtilTempo;
    private int vidaUtilKm;
    private FabricantePeca fabricantePeca;

    public Peca() {}

    public Peca(long idPeca, String nome, String sistema, double valor,
                int vidaUtilTempo, int vidaUtilKm, FabricantePeca fabricantePeca) {
        this.idPeca = idPeca;
        this.nome = nome;
        this.sistema = sistema;
        this.valor = valor;
        this.vidaUtilTempo = vidaUtilTempo;
        this.vidaUtilKm = vidaUtilKm;
        this.fabricantePeca = fabricantePeca;
    }

    public ArrayList<Modelo> mostrarAplicacoes() {
        // delegado ao controller
        return new ArrayList<>();
    }

    public String mostrarProximaTroca() {
        if (dataTroca == null) return "Sem data de troca registrada.";
        long msUteis = (long) vidaUtilTempo * 30L * 24L * 60L * 60L * 1000L;
        Date proxima = new Date(dataTroca.getTime() + msUteis);
        return "Próxima troca prevista: " + proxima;
    }

    // Getters e Setters
    public long getIdPeca() { return idPeca; }
    public void setIdPeca(long idPeca) { this.idPeca = idPeca; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getSistema() { return sistema; }
    public void setSistema(String sistema) { this.sistema = sistema; }

    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }

    public Date getDataTroca() { return dataTroca; }
    public void setDataTroca(Date dataTroca) { this.dataTroca = dataTroca; }

    public int getVidaUtilTempo() { return vidaUtilTempo; }
    public void setVidaUtilTempo(int vidaUtilTempo) { this.vidaUtilTempo = vidaUtilTempo; }

    public int getVidaUtilKm() { return vidaUtilKm; }
    public void setVidaUtilKm(int vidaUtilKm) { this.vidaUtilKm = vidaUtilKm; }

    public FabricantePeca getFabricantePeca() { return fabricantePeca; }
    public void setFabricantePeca(FabricantePeca fabricantePeca) { this.fabricantePeca = fabricantePeca; }
}
