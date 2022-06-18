package Equipamento;

public class Smartphone extends Equipamento{
    private String chips;
    private String memoriaRam;
    public Smartphone(String marca, String modelo, String chips, String memoriaRam) {
        super(marca, modelo);
        this.tipo = "Smartphone";
        this.chips = chips;
        this.memoriaRam = memoriaRam;
    }

    @Override
    public String tamanhoTela() {
        return "6 polegadas";
    }
}
