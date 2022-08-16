/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package criptografia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MR.ADILSON
 */
public class Arquivo {
    
    public static String abrir_arquivo(File arquivo) {
        String dados = "";
        try {
            FileReader leitura = new FileReader(arquivo);
            BufferedReader ler = new BufferedReader(leitura);
            while (ler.ready()) {
                dados += ler.readLine() + "\n";
            }
            return dados;
        } catch (Exception ex) {
            Logger.getLogger(Criptografia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void criar_arquivo(String nome, String dados) {
        try {
            String local = "C:\\Users\\" + System.getenv("USERNAME") + "\\Documents\\CODIFICADOS\\";
            File arquivo = new File(local);
            if (!arquivo.exists()) {
                arquivo.mkdir();
            }
            FileWriter escreve = new FileWriter(local + nome);
            BufferedWriter escrever = new BufferedWriter(escreve);
            escrever.write(dados);
            escrever.close();
            escreve.close();
        } catch (IOException ex) {
            Logger.getLogger(Criptografia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
