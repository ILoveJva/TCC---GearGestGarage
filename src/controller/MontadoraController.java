package controller;

import model.Modelo;
import model.Montadora;

import java.util.ArrayList;

/**
 * Gerencia Montadoras e seus Modelos.
 */
public class MontadoraController {

    private ArrayList<Montadora> montadoras;

    public MontadoraController() {
        this.montadoras = new ArrayList<>();
    }

    public boolean cadastrar(Montadora montadora) {
        montadoras.add(montadora);
        return true;
    }

    public Montadora buscarPorId(long idMontadora) {
        return montadoras.stream()
                .filter(m -> m.getIdMontadora() == idMontadora)
                .findFirst()
                .orElse(null);
    }

    public boolean adicionarModelo(long idMontadora, Modelo modelo) {
        Montadora montadora = buscarPorId(idMontadora);
        if (montadora == null) return false;
        montadora.adicionarModelo(modelo);
        modelo.setMontadora(montadora);
        return true;
    }

    public ArrayList<Modelo> listarModelos(long idMontadora) {
        Montadora montadora = buscarPorId(idMontadora);
        if (montadora == null) return new ArrayList<>();
        return montadora.listarModelos();
    }

    public ArrayList<Montadora> listarTodas() {
        return montadoras;
    }
}
