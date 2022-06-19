package Equipamento;

public class Televisao extends Equipamento{
    private String polegadas;
    private String qualidadeImagem;
    public Televisao(String marca, String modelo, String polegadas, String qualidadeImagem) {
        super(marca, modelo);
        this.tipo = "Televisão";
        this.qualidadeImagem = qualidadeImagem;
        this.polegadas = polegadas;
    }

    @Override
    public String tamanhoTela() {
        return polegadas+" polegadas";
    }

    @Override
    public String especificacoes() {
        String retorno = "";
        retorno+="Qualidade da imagem: "+qualidadeImagem+"\n";
        return retorno;
    }
}
