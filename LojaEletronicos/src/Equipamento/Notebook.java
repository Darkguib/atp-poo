package Equipamento;

public class Notebook extends Equipamento {
    private String memoriaRam;
    private String processador;
    private String polegadas;

    public Notebook(String marca, String modelo,String memoriaRam, String processador,String polegadas) {
        super( marca, modelo);
        this.tipo = "Notebook";
        this.memoriaRam = memoriaRam;
        this.processador = processador;
        this.polegadas = polegadas;

    }


    @Override
    public String tamanhoTela() {
        return polegadas+" polegadas";
    }

    @Override
    public String especificacoes() {
        String retorno = "";
        retorno+= "Memória RAM: "+this.memoriaRam+"\n";
        retorno+= "Processador: "+this.processador+"\n";
        return retorno;
    }
}
