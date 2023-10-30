/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exemplos_vetor;
/**
 *
 * @author jose.5989
 */
public class filtragem_valores_pares_vetor {
    public static void main(String[]args) {
        int [] numeros = {1,2,3,4,5,6,7,8,9,10};
        
        int conPares = 0;
        for(int i = 0; i < numeros.length; i++){
            if(numeros [i] % 2 == 0){
                conPares++;
            }
        }
        int[] pares = new int[conPares];
        int contParesPos = 0;
        for(int i = 0; i < numeros.length; i++){
            if(numeros[i] % 2 == 0){
                pares[contParesPos] = numeros[i];
                contParesPos++;
            }
        }
        for(int i = 0; i < pares.length; i++){
            System.out.println(pares[i]);
        }
    }       
}
