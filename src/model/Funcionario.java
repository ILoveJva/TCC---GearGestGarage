package model;

import java.util.ArrayList;

public class Funcionario extends Usuario {

    public enum Cargo {
        MECANICO,
        ELETRICISTA,
        FUNILEIRO,
        GERENTE,
        ATENDENTE
    }

    private double salario;
    private String dataAdmissao;
    private Cargo cargo;

    public Funcionario() {
        super();
    }

    public Funcionario(long idUsuario, String nome, String email, String senha,
                       String telefone, String cpf, String status, Oficina oficina,
                       double salario, String dataAdmissao, Cargo cargo) {
        super(idUsuario, nome, email, senha, telefone, cpf, status, oficina);
        this.salario = salario;
        this.dataAdmissao = dataAdmissao;
        this.cargo = cargo;
    }

    public ArrayList<OrdemDeServico> consultarOS() {
        // delegado ao controller
        return new ArrayList<>();
    }

    public void gerenciarOS(long idOS) {
        // delegado ao controller
    }

    public Orcamento criarOrcamento(Veiculo veiculo) {
        // delegado ao controller
        return null;
    }

    // Getters e Setters
    public double getSalario() { return salario; }
    public void setSalario(double salario) { this.salario = salario; }

    public String getDataAdmissao() { return dataAdmissao; }
    public void setDataAdmissao(String dataAdmissao) { this.dataAdmissao = dataAdmissao; }

    public Cargo getCargo() { return cargo; }
    public void setCargo(Cargo cargo) { this.cargo = cargo; }


    @Override
    public String toString() {
        return "Funcionario{" +
                "salario=" + salario +
                ", dataAdmissao='" + dataAdmissao + '\'' +
                ", cargo=" + cargo +
                '}';
    }
}
