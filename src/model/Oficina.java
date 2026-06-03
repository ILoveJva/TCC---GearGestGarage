package model;

import java.util.ArrayList;

public class Oficina {

    private long idOficina;
    private String nome;
    private String cnpj;
    private String endereco;
    private ArrayList<Funcionario> funcionarios;
    private ArrayList<Estoque> estoques;

    public Oficina() {
        this.funcionarios = new ArrayList<>();
        this.estoques = new ArrayList<>();
    }

    public Oficina(long idOficina, String nome, String cnpj, String endereco) {
        this.idOficina = idOficina;
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.funcionarios = new ArrayList<>();
        this.estoques = new ArrayList<>();
    }

    // Getters e Setters
    public long getIdOficina() { return idOficina; }
    public void setIdOficina(long idOficina) { this.idOficina = idOficina; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCnpj() { return cnpj; }
    public void setCnpj(String cnpj) { this.cnpj = cnpj; }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    public ArrayList<Funcionario> getFuncionarios() { return funcionarios; }
    public void setFuncionarios(ArrayList<Funcionario> funcionarios) { this.funcionarios = funcionarios; }

    public ArrayList<Estoque> getEstoques() { return estoques; }
    public void setEstoques(ArrayList<Estoque> estoques) { this.estoques = estoques; }

    public void adicionarFuncionario(Funcionario funcionario) {
        this.funcionarios.add(funcionario);
    }

    public void adicionarEstoque(Estoque estoque) {
        this.estoques.add(estoque);
    }
}
