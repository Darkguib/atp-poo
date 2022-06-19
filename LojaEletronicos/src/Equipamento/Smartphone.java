package Equipamento;

public class Smartphone extends Equipamento{
    private String chips;
    private String memoriaRam;
    private String polegadas;
    public Smartphone(String marca, String modelo, String chips, String memoriaRam, String polegadas) {
        super(marca, modelo);
        this.tipo = "Smartphone";
        this.chips = chips;
        this.memoriaRam = memoriaRam;
        this.polegadas = polegadas;
    }

    @Override
    public String tamanhoTela() {
        return polegadas+" polegadas";
    }

    @Override
    public String especificacoes() {
        String retorno = "";
        retorno+= "Memoria RAM: "+memoriaRam+"\n";
        retorno+= "Quantidade de chips: "+chips+"\n";
        return retorno;
    }
}
