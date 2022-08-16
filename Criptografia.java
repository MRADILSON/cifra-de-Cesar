/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package criptografia;

import javax.swing.JOptionPane;

/**
 *
 * @author MR.ADILSON
 */
public class Criptografia {

    int key; // Chave para criptografar e decriptografar o texto

    private static final char[] abcedario = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
        'u', 'v', 'w', 'x', 'y', 'z', 'ç', 'á', 'à', 'é', 'è', 'í', 'ì', 'ó', 'ò', 'ú', 'ù', 'ê', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '-', '*', '_', '/',
        '\\', '%', ',', '.', ';', '?', '!', '\n', ' '};

    public Criptografia(int key) {
        this.key = key; //Atribuindo valor na chave
    }

    /**
     * Faz a criptográfia do texto com a chave introduzida no construtor e Retorna o texto
     * criptográfado
     *
     * @param texto String com texto puro
     * @return String com texto criptográfado
     */
    public String criptografar_public(String texto) {
        String dados = "";
        if (key > 0 && key < abcedario.length) { 
            texto = texto.toLowerCase();
            for (char percorre_text : texto.toCharArray()) {    //percorre cada letra do texto introduzido
                int posicao_letra_abc = 0;
                for (char percorre_abcedario : abcedario) {     //percorre o abcedario procurando a letra 
                    if (percorre_text == percorre_abcedario) {  
                        if (posicao_letra_abc + key < abcedario.length) {
                            dados += abcedario[(posicao_letra_abc + key) % abcedario.length];
                        } else {
                            dados += abcedario[(key - (abcedario.length - posicao_letra_abc)) % abcedario.length];
                        }
                        break;
                    }
                    posicao_letra_abc++;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Introduz uma chave no intervalo de 1 à " + (abcedario.length - 1), "CHAVE FORA DO INTERVALO", JOptionPane.ERROR_MESSAGE);
            dados = null;
        }
        return dados;
    }

    /**
     * Faz a decriptográfia do texto de acordo a chave introduzida e Retorna o
     * texto decriptográfado
     *
     * @param texto
     * @param chave
     * @return
     */
    public String decriptografar(String texto, int chave) {

        String dados = "";
        if (chave > 0 && chave < abcedario.length) {
            texto = texto.toLowerCase();
            for (char percorre_texto : texto.toCharArray()) {
                int posicao_letra_abc = 0;
                for (char percorre_abcedario : abcedario) {
                    if (percorre_texto == percorre_abcedario) {
                        if (posicao_letra_abc - chave >= 0) {
                            dados += abcedario[(posicao_letra_abc - chave) % abcedario.length];
                        } else {
                            dados += abcedario[(abcedario.length - (chave - posicao_letra_abc)) % abcedario.length];
                        }
                        break;
                    }
                    posicao_letra_abc++;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Introduz uma chave no intervalo de 1 à " + (abcedario.length - 1), "CHAVE FORA DO INTERVALO", JOptionPane.ERROR_MESSAGE);
            dados = null;
        }
        return dados;
    }

}
