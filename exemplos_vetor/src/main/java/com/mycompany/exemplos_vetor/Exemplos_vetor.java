/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.exemplos_vetor;

/**
 *
 * @author jose.5989
 */
public class Exemplos_vetor {
    public static void main(String[] args) {
       int[] numeros = new int[5];
       
       numeros[0] = 1;
       numeros[1] = 15;
       numeros[2] = 8;
       numeros[3] = 847;
       numeros[4] = 123;
       
       for(int i = 0; i < numeros.length; i++){
           System.out.println("O valor na posição " + i + " é: " + numeros[i]);
       }
    }
}
