package Equipamento;

public class CameraDigital extends Equipamento{
    private String megaPixels;
    private String zoom;
    public CameraDigital(String marca, String modelo,String megaPixels, String zoom) {
        super(marca, modelo);
        this.tipo = "Câmera Digital";
        this.zoom = zoom;
        this. megaPixels = megaPixels;
    }

    @Override
    public String tamanhoTela() {
        return "2.5 polegadas";
    }
}
