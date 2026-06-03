package controller;

import model.FabricantePeca;
import model.Peca;

import java.util.ArrayList;

/**
 * Gerencia Fabricantes de Peças.
 */
public class FabricantePecaController {

    private ArrayList<FabricantePeca> fabricantes;

    public FabricantePecaController() {
        this.fabricantes = new ArrayList<>();
    }

    public boolean cadastrar(FabricantePeca fabricante) {
        fabricantes.add(fabricante);
        return true;
    }

    public FabricantePeca buscarPorId(long idFabricante) {
        return fabricantes.stream()
                .filter(f -> f.getIdFabricantePeca() == idFabricante)
                .findFirst()
                .orElse(null);
    }

    public boolean adicionarPeca(long idFabricante, Peca peca) {
        FabricantePeca fabricante = buscarPorId(idFabricante);
        if (fabricante == null) return false;
        peca.setFabricantePeca(fabricante);
        fabricante.adicionarPeca(peca);
        return true;
    }

    public ArrayList<Peca> listarPecas(long idFabricante) {
        FabricantePeca fabricante = buscarPorId(idFabricante);
        if (fabricante == null) return new ArrayList<>();
        return fabricante.listarPecas();
    }

    public ArrayList<FabricantePeca> listarTodos() {
        return fabricantes;
    }
}
