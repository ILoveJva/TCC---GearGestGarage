package model;

import java.util.ArrayList;
import java.util.Date;

public class ItemServico {

    public enum StatusItem {
        PENDENTE,
        EM_EXECUCAO,
        CONCLUIDO
    }

    private long idItemServico;
    private ArrayList<Peca> listaPecas;
    private StatusItem status;
    private Date dataRealizacao;
    private String descricao;


    public ItemServico(long idItemServico, String descricao) {
        this.idItemServico = idItemServico;
        this.descricao = descricao;
        this.listaPecas = new ArrayList<>();
        this.status = StatusItem.PENDENTE;
    }

    public void atualizarStatus(StatusItem novoStatus) {
        this.status = novoStatus;
        if (novoStatus == StatusItem.CONCLUIDO) {
            this.dataRealizacao = new Date();
        }
    }

    // Getters e Setters
    public long getIdItemServico() { return idItemServico; }
    public void setIdItemServico(long idItemServico) { this.idItemServico = idItemServico; }

    public ArrayList<Peca> getListaPecas() { return listaPecas; }
    public void setListaPecas(ArrayList<Peca> listaPecas) { this.listaPecas = listaPecas; }

    public StatusItem getStatus() { return status; }
    public void setStatus(StatusItem status) { this.status = status; }

    public Date getDataRealizacao() { return dataRealizacao; }
    public void setDataRealizacao(Date dataRealizacao) { this.dataRealizacao = dataRealizacao; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public void adicionarPeca(Peca peca) {
        this.listaPecas.add(peca);
    }

    @Override
    public String toString() {
        return "ItemServico{" +
                "idItemServico=" + idItemServico +
                ", listaPecas=" + listaPecas +
                ", status=" + status +
                ", dataRealizacao=" + dataRealizacao +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
