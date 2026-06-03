package model;

import java.util.ArrayList;

public class Veiculo {

    private long idVeiculo;
    private Modelo modelo;
    private String tipo;
    private int ano;
    private String cor;
    private String placa;
    private String vin;
    private ArrayList<Peca> listaPecas;

    public Veiculo() {
        this.listaPecas = new ArrayList<>();
    }

    public Veiculo(long idVeiculo, Modelo modelo, String tipo, int ano,
                   String cor, String placa, String vin) {
        this.idVeiculo = idVeiculo;
        this.modelo = modelo;
        this.tipo = tipo;
        this.ano = ano;
        this.cor = cor;
        this.placa = placa;
        this.vin = vin;
        this.listaPecas = new ArrayList<>();
    }

    public ArrayList<OrdemDeServico> consultarHistorico() {
        // delegado ao controller
        return new ArrayList<>();
    }

    // Getters e Setters
    public long getIdVeiculo() { return idVeiculo; }
    public void setIdVeiculo(long idVeiculo) { this.idVeiculo = idVeiculo; }

    public Modelo getModelo() { return modelo; }
    public void setModelo(Modelo modelo) { this.modelo = modelo; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public int getAno() { return ano; }
    public void setAno(int ano) { this.ano = ano; }

    public String getCor() { return cor; }
    public void setCor(String cor) { this.cor = cor; }

    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }

    public String getVin() { return vin; }
    public void setVin(String vin) { this.vin = vin; }

    public ArrayList<Peca> getListaPecas() { return listaPecas; }
    public void setListaPecas(ArrayList<Peca> listaPecas) { this.listaPecas = listaPecas; }

    public void adicionarPeca(Peca peca) {
        this.listaPecas.add(peca);
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "idVeiculo=" + idVeiculo +
                ", modelo=" + modelo +
                ", tipo='" + tipo + '\'' +
                ", ano=" + ano +
                ", cor='" + cor + '\'' +
                ", placa='" + placa + '\'' +
                ", vin='" + vin + '\'' +
                ", listaPecas=" + listaPecas +
                '}';
    }
}
