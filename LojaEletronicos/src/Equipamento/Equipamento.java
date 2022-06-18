package Equipamento;

import java.io.Serializable;

public abstract class Equipamento implements Serializable {
    private static final long serialVersionUID = 1L;
    protected String tipo;
    private String marca;
    private String modelo;

    public Equipamento(String marca,String modelo){
        this.marca = marca;
        this.modelo = modelo;
    }

    public String toString() {
        String retorno = "";
        retorno+= "Aparelho: "+this.tipo +"\n";
        retorno+= "Marca: "+this.marca +"\n";
        retorno+= "Modelo: "+this.modelo +"\n";
        retorno+= "Tamanho da tela: "+this.tamanhoTela() +"\n";
        return retorno;
    }
    public abstract String tamanhoTela();
}
