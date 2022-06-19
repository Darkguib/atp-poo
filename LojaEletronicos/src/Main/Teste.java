package Main;

import Equipamento.*;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class Teste {
    private ArrayList<Equipamento> equipamentos;

    public Teste(){
        this.equipamentos = new ArrayList<Equipamento>();
    }

    public void adicionarEquipamento(Equipamento equip){
            this.equipamentos.add(equip);
    }

    public void excluirEquipamentos(){
        equipamentos.clear();
        System.out.println("Equipamentos excluídos com sucesso!");
    }

    public void salvaEquipamentos()  {
        ObjectOutputStream outputStream = null;
        try {
            outputStream = new ObjectOutputStream (new FileOutputStream("c:\\temp\\animais.dat"));
            for(Equipamento equip:equipamentos) {
                outputStream.writeObject(equip);
            }
        }catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }catch (IOException ex) {
            ex.printStackTrace();
        }finally{
            try {
                if (outputStream != null ) {
                    outputStream.flush();
                    outputStream.close();
                }
            }catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    public void listarEquipamentos(){
        for (Equipamento equip: equipamentos) {
            System.out.println(equip.toString());
        }
        System.out.println("Total = "+this.equipamentos.size()+" de equipamentos listados atualmente");
    }
    public void recuperarEquipamentos() {
        ObjectInputStream inputStream = null;
        try {
            inputStream	= new ObjectInputStream (new FileInputStream ("c:\\temp\\animais.dat"));
            Object obj = null;
            while((obj = inputStream.readObject ()) != null) {
                if (obj instanceof Equipamento)
                    this.equipamentos.add((Equipamento) obj);

            }
        }catch (EOFException ex) {     // when EOF is reached
            System.out.println ("End of file reached");
        }catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }catch (IOException ex) {
            ex.printStackTrace();
        }finally{
            try {
                if (inputStream != null ) {
                    inputStream.close();
                    System.out.println("Equipamentos restaurados com suecsso!\n");
                }
            }catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }
    public static void main(String[]args){
        Teste teste = new Teste();

        Notebook notebook = new Notebook("Acer","Aspire 5","8 GB", "I5","15.6");
        Smartphone smartphone = new Smartphone("Samsung","Note 9", "2","6 GB","6");
        Smartwatch smartwatch = new Smartwatch("Amazon","Amaz Fit", "Sintético","2");
        CameraDigital cameraDigital = new CameraDigital("Sony","DSC-W800","20.1","5x","2.5");

        teste.adicionarEquipamento(notebook);
        teste.adicionarEquipamento(smartphone);
        teste.adicionarEquipamento(smartwatch);
        teste.adicionarEquipamento(cameraDigital);
        teste.listarEquipamentos();
        teste.salvaEquipamentos();
        teste.equipamentos.remove(notebook);
        teste.listarEquipamentos();
        teste.excluirEquipamentos();
        teste.listarEquipamentos();
        teste.recuperarEquipamentos();
        teste.listarEquipamentos();


    }
}
