/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package criptografia;

/**
 *
 * @author MR.ADILSON
 */
public class Main {

    public static void main(String[] args) {
        int key = 5;
        Criptografia cr = new Criptografia(key);

        String encriptedText = cr.criptografar_public("MR.ADILSON");
        String decriptedText = cr.decriptografar(encriptedText, key);

        System.out.println(encriptedText);
        System.out.println(decriptedText);
    }
}
