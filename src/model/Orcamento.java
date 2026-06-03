package model;

import java.util.ArrayList;
import java.util.Date;

public class Orcamento {

    public enum StatusOrcamento {
        PENDENTE,
        APROVADO,
        RECUSADO,
        CANCELADO
    }

    private long idOrcamento;
    private Cliente cliente;
    private Veiculo veiculo;
    private Funcionario funcionario;
    private ArrayList<Peca> listaDePecas;
    private Date dataCriacao;
    private String descricao;
    private StatusOrcamento status;

    public Orcamento() {
        this.listaDePecas = new ArrayList<>();
        this.dataCriacao = new Date();
        this.status = StatusOrcamento.PENDENTE;
    }

    public Orcamento(long idOrcamento, Cliente cliente, Veiculo veiculo,
                     Funcionario funcionario, String descricao) {
        this.idOrcamento = idOrcamento;
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.funcionario = funcionario;
        this.descricao = descricao;
        this.listaDePecas = new ArrayList<>();
        this.dataCriacao = new Date();
        this.status = StatusOrcamento.PENDENTE;
    }

    public OrdemDeServico criarOS() {
        // delegado ao controller
        return null;
    }

    public void cancelarOS(long idOs) {
        // delegado ao controller
    }

    public double calcularTotal() {
        return listaDePecas.stream().mapToDouble(Peca::getValor).sum();
    }

    // Getters e Setters
    public long getIdOrcamento() { return idOrcamento; }
    public void setIdOrcamento(long idOrcamento) { this.idOrcamento = idOrcamento; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public Veiculo getVeiculo() { return veiculo; }
    public void setVeiculo(Veiculo veiculo) { this.veiculo = veiculo; }

    public Funcionario getFuncionario() { return funcionario; }
    public void setFuncionario(Funcionario funcionario) { this.funcionario = funcionario; }

    public ArrayList<Peca> getListaDePecas() { return listaDePecas; }
    public void setListaDePecas(ArrayList<Peca> listaDePecas) { this.listaDePecas = listaDePecas; }

    public Date getDataCriacao() { return dataCriacao; }
    public void setDataCriacao(Date dataCriacao) { this.dataCriacao = dataCriacao; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public StatusOrcamento getStatus() { return status; }
    public void setStatus(StatusOrcamento status) { this.status = status; }

    public void adicionarPeca(Peca peca) {
        this.listaDePecas.add(peca);
    }
}
