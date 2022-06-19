package Equipamento;

public class CameraDigital extends Equipamento{
    private String megaPixels;
    private String zoom;
    private String polegadas;
    public CameraDigital(String marca, String modelo,String megaPixels, String zoom,String polegadas ) {
        super(marca, modelo);
        this.tipo = "Câmera Digital";
        this.zoom = zoom;
        this. megaPixels = megaPixels;
        this.polegadas = polegadas;
    }


    @Override
    public String tamanhoTela() {
        return polegadas+" polegadas";
    }

    @Override
    public String especificacoes() {
        String retorno = "";
        retorno+= "MegaPixels: "+megaPixels+"\n";
        retorno+= "Zoom: "+zoom+"\n";
        return retorno;
    }
}
