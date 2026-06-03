package controller;

import model.Estoque;
import model.Funcionario;
import model.Oficina;

import java.util.ArrayList;

/**
 * Gerencia Oficinas, seus Funcionários e Estoques.
 */
public class OficinaController {

    private ArrayList<Oficina> oficinas;

    public OficinaController() {
        this.oficinas = new ArrayList<>();
    }

    public boolean cadastrar(Oficina oficina) {
        boolean cnpjExistente = oficinas.stream()
                .anyMatch(o -> o.getCnpj().equals(oficina.getCnpj()));
        if (cnpjExistente) return false;
        oficinas.add(oficina);
        return true;
    }

    public Oficina buscarPorId(long idOficina) {
        return oficinas.stream()
                .filter(o -> o.getIdOficina() == idOficina)
                .findFirst()
                .orElse(null);
    }

    public boolean adicionarFuncionario(long idOficina, Funcionario funcionario) {
        Oficina oficina = buscarPorId(idOficina);
        if (oficina == null) return false;
        funcionario.setOficina(oficina);
        oficina.adicionarFuncionario(funcionario);
        return true;
    }

    public boolean adicionarEstoque(long idOficina, Estoque estoque) {
        Oficina oficina = buscarPorId(idOficina);
        if (oficina == null) return false;
        oficina.adicionarEstoque(estoque);
        return true;
    }

    public ArrayList<Funcionario> listarFuncionarios(long idOficina) {
        Oficina oficina = buscarPorId(idOficina);
        if (oficina == null) return new ArrayList<>();
        return oficina.getFuncionarios();
    }

    public ArrayList<Oficina> listarTodas() {
        return oficinas;
    }
}
