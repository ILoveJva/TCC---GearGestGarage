package model;

import java.util.ArrayList;

public class Cliente extends Usuario {

    private ArrayList<Veiculo> veiculos;

    public Cliente(long idUsuario, String nome, String email, String senha,
                   String telefone, String cpf, String status, Oficina oficina) {
        super(idUsuario, nome, email, senha, telefone, cpf, status, oficina);
        this.veiculos = new ArrayList<>();
    }

    public ArrayList<Veiculo> visualizarVeiculos() {
        return veiculos;
    }

    public boolean decidirOrcamento(long idOrcamento, boolean resposta) {
        // delegado ao controller
        return false;
    }

    // Getters e Setters
    public ArrayList<Veiculo> getVeiculos() { return veiculos; }
    public void setVeiculos(ArrayList<Veiculo> veiculos) { this.veiculos = veiculos; }

    public void adicionarVeiculo(Veiculo veiculo) {
        this.veiculos.add(veiculo);
    }
}
