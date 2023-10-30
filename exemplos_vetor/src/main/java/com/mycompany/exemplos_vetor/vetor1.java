/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exemplos_vetor;

/**
 *
 * @author jose.5989
 */
public class vetor1 {
     public static void main(String[] args) {
       int[] numeros = new int[5];
       int soma = 0;
       
       numeros[0] = 1;
       numeros[1] = 15;
       numeros[2] = 8;
       numeros[3] = 847;
       numeros[4] = 123;
       
       for(int i = 0; i < numeros.length; i++){
           soma = soma + numeros[i];
       }
       
       System.out.println("Resultado da soma: " + soma);
    }
}
