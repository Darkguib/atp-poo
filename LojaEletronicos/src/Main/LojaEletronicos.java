package Main;

import Equipamento.*;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class LojaEletronicos {
    private ArrayList <Equipamento> equipamentos;

    public LojaEletronicos(){
        this.equipamentos = new ArrayList<Equipamento>();
    }

    public String[] valores (String [] dadosIn){
        String [] dadosOut = new String [dadosIn.length];

        for (int i = 0; i < dadosIn.length; i++)
            dadosOut[i] = JOptionPane.showInputDialog  ("Entre com " + dadosIn[i]+ ": ");

        return dadosOut;
    }

    public Notebook notebook(){
        String[] valor = new String[4];
        String [] nomeValor ={"Marca","Modelo","Memória RAM","Processador"};
        valor = valores(nomeValor);

        Notebook notebook = new Notebook(valor[0],valor[1],valor[2],valor[3]);
        return notebook;
    }
    public Smartphone celular(){
        String[] valor = new String[4];
        String [] nomeValor ={"Marca","Modelo","Quantidade de chips","Memoria Ram"};
        valor = valores(nomeValor);

        Smartphone smartphone = new Smartphone(valor[0],valor[1],valor[2],valor[3]);
        return smartphone;
    }
    public CameraDigital cameraDigital(){
        String[] valor = new String[4];
        String [] nomeValor ={"Marca","Modelo","MegaPixels","Zoom"};
        valor = valores(nomeValor);

        CameraDigital camera = new CameraDigital(valor[0],valor[1],valor[2],valor[3]);
        return camera;
    }

    public Smartwatch relogio(){
        String[] valor = new String[3];
        String [] nomeValor ={"Marca","Modelo","Tipo da pulseira"};
        valor = valores(nomeValor);

        Smartwatch smartwatch= new Smartwatch(valor[0],valor[1],valor[2]);
        return smartwatch;
    }

    public void salvaEquipamentos (ArrayList<Equipamento> equipamentos){//Método para salvar os dados dos equipamentos
        ObjectOutputStream outputStream = null;
        try {
            outputStream = new ObjectOutputStream
                    (new FileOutputStream("c:\\temp\\lojaEletronicos.dados"));
            for (int i=0; i < equipamentos.size(); i++)
                outputStream.writeObject(equipamentos.get(i));
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Impossível criar arquivo!");
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {  //Para fechar a OutputStream do método
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public ArrayList<Equipamento> recuperaEquipamentos (){ //Método para recuperar os dados dos equipamentos
        ArrayList<Equipamento> equipamentosTemp = new ArrayList<Equipamento>();

        ObjectInputStream inputStream = null;

        try {
            inputStream = new ObjectInputStream
                    (new FileInputStream("c:\\temp\\lojaEletronicos.dados"));
            Object obj = null;
            while ((obj = inputStream.readObject()) != null) {
                if (obj instanceof Equipamento) {
                    equipamentosTemp.add((Equipamento) obj);
                }
            }
        } catch (EOFException ex) { // when EOF is reached
            System.out.println("Fim de arquivo.");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Arquivo com os equipamentos NÃO existe!");
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {  //Fecha a InputStream do Método
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (final IOException ex) {
                ex.printStackTrace();
            }
            return equipamentosTemp;
        }
    }
    public static void main(String[]args){

    }
}
