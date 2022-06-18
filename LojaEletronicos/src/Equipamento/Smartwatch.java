package Equipamento;

public class Smartwatch extends Equipamento{
    private String tipoPulseira;
    public Smartwatch(String marca, String modelo, String tipoPulseira) {
        super(marca, modelo);
        this.tipo = "Smartwatch";
        this.tipoPulseira = tipoPulseira;
    }

    @Override
    public String tamanhoTela() {
        return "2 polegadas";
    }
}
