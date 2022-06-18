package Equipamento;

import Equipamento.Equipamento;

public class Notebook extends Equipamento {
    private String memoriaRam;
    private String processador;

    public Notebook(String marca, String modelo,String memoriaRam, String processador) {
        super( marca, modelo);
        this.tipo = "Notebook";
        this.memoriaRam = memoriaRam;
        this.processador = processador;

    }

    @Override
    public String tamanhoTela() {
        return "15.6 polegadas";
    }
}
