package model.Servicos;

import model.*;

public class S_TrocaOleo extends ServicoMotor {

    private final Motor motor = veiculo.getMotor();

    public S_TrocaOleo(long idOrdemDeServico, String titulo, int prazo, Veiculo veiculo, TipoServico tipoServico, Funcionario responsavel) {
        super(idOrdemDeServico, titulo, prazo, veiculo, tipoServico, responsavel);
        for (String a : OrdemDeServico.ETAPAS_OS) {
            int i = 0;
            itensServico.put(a, new ItemServico(123, ETAPAS_OS[i]));
            i++;
        }
    }


    @Override
    public String toString() {
        return "S_TrocaOleo{" +
                "\nidOrdemDeServico=" + idOrdemDeServico +
                ",\n titulo='" + titulo + '\'' +
                ",\n dataCriacao=" + dataCriacao +
                ",\n status=" + status +
                ",\n tipoServico=" + tipoServico +
                ",\n prazo=" + prazo +
                ",\n itensServico=" + itensServico +
                ",\n veiculo=" + veiculo +
                ",\n responsavel=" + responsavel +
                '}';
    }
}
