package model.Servicos;

import model.Funcionario;
import model.OrdemDeServico;
import model.Veiculo;

public class ServicoMotor extends OrdemDeServico {
    public ServicoMotor(long idOrdemDeServico, String titulo, int prazo, Veiculo veiculo, TipoServico tipoServico, Funcionario responsavel) {
        super(idOrdemDeServico, titulo, prazo, veiculo, tipoServico, responsavel);
    }

    @Override
    public String toString() {
        return "ServicoMotor{" +
                "idOrdemDeServico=" + idOrdemDeServico +
                ", titulo='" + titulo + '\'' +
                ", dataCriacao=" + dataCriacao +
                ", status=" + status +
                ", tipoServico=" + tipoServico +
                ", prazo=" + prazo +
                ", itensServico=" + itensServico +
                ", veiculo=" + veiculo +
                ", responsavel=" + responsavel +
                '}';
    }
}
