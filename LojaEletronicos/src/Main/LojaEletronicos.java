package Main;

import Equipamento.*;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
//NOMES: Guilherme Ribeiro Demtrio / Luis Felipe da Costa
//EQUIPE 20
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
    private boolean validarInt(String s) {
        try {
            Integer.parseInt(s); // Método estático, que tenta tranformar uma string em inteiro
            return true;
        } catch (NumberFormatException e) { // Não conseguiu tranformar em inteiro e gera erro
            return false;
        }
    }
    public int retornaInteiro(String entrada) { // retorna um valor inteiro
        int numInt;

        //Enquanto não for possível converter o valor de entrada para inteiro, permanece no loop
        while (!this.validarInt(entrada)) {
            entrada = JOptionPane.showInputDialog(null, "Valor incorreto!\n\nDigite um número inteiro.");
        }
        return Integer.parseInt(entrada);
    }

    public Notebook notebook(){
        String[] valor = new String[5];
        String [] nomeValor ={"Marca","Modelo","Memória RAM","Processador", "Polegadas da tela"};
        valor = valores(nomeValor);

        Notebook notebook = new Notebook(valor[0],valor[1],valor[2],valor[3],valor[4]);
        return notebook;
    }
    public Smartphone celular(){
        String[] valor = new String[5];
        String [] nomeValor ={"Marca","Modelo","Quantidade de chips","Memoria Ram","Polegadas da tela"};
        valor = valores(nomeValor);

        Smartphone smartphone = new Smartphone(valor[0],valor[1],valor[2],valor[3],valor[4]);
        return smartphone;
    }
    public CameraDigital cameraDigital(){
        String[] valor = new String[5];
        String [] nomeValor ={"Marca","Modelo","MegaPixels","Zoom","Polegadas da tela"};
        valor = valores(nomeValor);

        CameraDigital camera = new CameraDigital(valor[0],valor[1],valor[2],valor[3],valor[4]);
        return camera;
    }

    public Smartwatch relogio(){
        String[] valor = new String[4];
        String [] nomeValor ={"Marca","Modelo","Tipo da pulseira","Polegadas da tela"};
        valor = valores(nomeValor);

        Smartwatch smartwatch= new Smartwatch(valor[0],valor[1],valor[2],valor[3]);
        return smartwatch;
    }
    public Televisao televisao(){
        String[] valor = new String[4];
        String [] nomeValor ={"Marca","Modelo","Polegadas da tv","Qualidade de imagem"};
        valor = valores(nomeValor);

        Televisao tv= new Televisao(valor[0],valor[1],valor[2],valor[3]);
        return tv;
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
    public void menuLoja(){
        String menu = "";
        String entrada;
        int op1, op2;
        do{
            menu = "Menu da Loja de Equipamentos\n" +
                    "Opções:\n" +
                    "1- Registrar Equipamento\n" +
                    "2- Exibir Equipamentos Registrados\n" +
                    "3- Limpar Equipamentos\n" +
                    "4- Gravar Equipamentos\n" +
                    "5- Recuperar Equipamentos\n" +
                    "9- Sair";

            entrada = JOptionPane.showInputDialog (menu + "\n\n");
            op1 = this.retornaInteiro(entrada);
            switch (op1){
                case 1: //ENTRADA DE DADOS
                    menu = "Registro de Equipamentos\n"+
                            "1- Notebook\n"+
                            "2- Smartphone\n"+
                            "3- Smartwatch\n"+
                            "4- Câmera Digital\n"+
                            "5- Televisão\n";
                    entrada = JOptionPane.showInputDialog (menu + "\n\n");
                    op2 = this.retornaInteiro(entrada);
                    switch (op2){
                        case 1: equipamentos.add((Equipamento)notebook());
                            break;
                        case 2: equipamentos.add((Equipamento)celular());
                            break;
                        case 3: equipamentos.add((Equipamento)relogio());
                            break;
                        case 4: equipamentos.add((Equipamento)cameraDigital());
                            break;
                        case 5: equipamentos.add((Equipamento)televisao());
                            break;
                        default:
                            JOptionPane.showMessageDialog(null,"Escolha um produto da lista!");
                            break;
                    }
                    break;
                case 2: //EXIBIR DADOS DOS EQUIPAMENTOS
                    if(equipamentos.size()==0){
                        JOptionPane.showMessageDialog(null,"Sem equipamentos registrados, registre algum equipamento!");
                        break;
                    }
                    String dados = "";
                    for (int i = 0; i < equipamentos.size(); i++){
                        dados += equipamentos.get(i).toString()+"-----------------\n";
                    }
                    JOptionPane.showMessageDialog(null,dados);
                    break;
                case 3://EXCLUIR DADOS
                    if(equipamentos.size() == 0){
                        JOptionPane.showMessageDialog(null,"Sem equipamentos registrados, registre algum equipamento!");
                        break;
                    }
                    equipamentos.clear();
                    JOptionPane.showMessageDialog(null,"Equipamentos EXCLUÍDOS com sucesso!");
                    break;
                case 4://SALVAR DADOS
                    if(equipamentos.size() == 0){
                        JOptionPane.showMessageDialog(null,"Sem equipamentos registrados, registre algum equipamento!");
                        break;
                    }
                    salvaEquipamentos(equipamentos);
                    JOptionPane.showMessageDialog(null,"Equipamentos salvos com sucesso!");
                    break;
                case 5://RECUPERAR DADOS
                  equipamentos = recuperaEquipamentos();
                    if(equipamentos.size() == 0){
                        JOptionPane.showMessageDialog(null,"Sem dados de equipamentos para serem recuperados!");
                        break;
                    }
                    JOptionPane.showMessageDialog(null,"Dados recuperados com sucesso!");
                    break;
                case 9://ENCERRAR APLICAÇÃO
                    JOptionPane.showMessageDialog(null,"FECHANDO APLICAÇÃO DA LOJA DE ELETRONICOS");
                    break;
            }

        }while(op1 != 9);
    }
    public static void main(String[]args){
        LojaEletronicos loja = new LojaEletronicos();
        loja.menuLoja();

    }
}
