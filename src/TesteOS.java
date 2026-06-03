import model.Funcionario;
import model.OrdemDeServico;
import model.Servicos.S_TrocaOleo;
import model.Veiculo;

import java.util.Date;

public class TesteOS {
    public static void main(String[] args) {
        OrdemDeServico os = new S_TrocaOleo(1, "Troca de Oleo", 1, new Veiculo(), OrdemDeServico.TipoServico.MOTOR, new Funcionario());
        System.out.println(os);

    }
}
