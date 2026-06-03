package model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public abstract class OrdemDeServico {

    public enum StatusOS {
        ABERTA,
        EM_ANDAMENTO,
        AGUARDANDO_PECA,
        CONCLUIDA,
        CANCELADA
    }

    public enum TipoServico {
        MOTOR,
        TRANSMISSAO,
        SUSPENSAO
    }

    public final static String[] ETAPAS_OS = new String[] {"Reclame", "Troca de Peças", "Revisão Final"};

    protected long idOrdemDeServico;
    protected String titulo;
    protected Date dataCriacao;
    protected StatusOS status;
    protected TipoServico tipoServico;
    protected int prazo;
    protected Map<String, ItemServico> itensServico = new HashMap<>();
    protected Veiculo veiculo;
    protected Funcionario responsavel;

    public OrdemDeServico(long idOrdemDeServico,
                          String titulo,
                          int prazo,
                          Veiculo veiculo,
                          TipoServico tipoServico,
                          Funcionario responsavel) {
        this.idOrdemDeServico = idOrdemDeServico;
        this.prazo = prazo;
        this.veiculo = veiculo;
        this.tipoServico = tipoServico;
        this.responsavel = responsavel;
        this.dataCriacao = new Date();
        this.status = StatusOS.ABERTA;
    }

    public String atualizarStatus(StatusOS novoStatus) {
        this.status = novoStatus;
        return this.status.name();
    }

    // Getters e Setters
    public long getIdOrdemDeServico() { return idOrdemDeServico; }
    public void setIdOrdemDeServico(long idOrdemDeServico) { this.idOrdemDeServico = idOrdemDeServico; }

    public Date getDataCriacao() { return dataCriacao; }
    public void setDataCriacao(Date dataCriacao) { this.dataCriacao = dataCriacao; }

    public StatusOS getStatus() { return status; }
    public void setStatus(StatusOS status) { this.status = status; }

    public int getPrazo() { return prazo; }
    public void setPrazo(int prazo) { this.prazo = prazo; }


    public Veiculo getVeiculo() { return veiculo; }
    public void setVeiculo(Veiculo veiculo) { this.veiculo = veiculo; }

    public Funcionario getResponsavel() { return responsavel; }
    public void setResponsavel(Funcionario responsavel) { this.responsavel = responsavel; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
}
