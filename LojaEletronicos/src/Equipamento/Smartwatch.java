package Equipamento;

public class Smartwatch extends Equipamento{
    private String tipoPulseira;
    private String polegadas;
    public Smartwatch(String marca, String modelo, String tipoPulseira, String polegadas) {
        super(marca, modelo);
        this.tipo = "Smartwatch";
        this.tipoPulseira = tipoPulseira;
        this.polegadas = polegadas;
    }

    @Override
    public String tamanhoTela() {
        return polegadas+" polegadas";
    }

    @Override
    public String especificacoes() {
        String retorno = "";
        retorno = "Tipo da pulseira: "+tipoPulseira+"\n";
        return retorno;
    }
}
