/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exemplos_vetor;

/**
 *
 * @author jose.5989
 */
public class ordenar_lista_vetor {
   public static void main(String[] args) {
        int[] elementos = new int [5];
        int indiceMenor;
        
        elementos[0] = 11;
        elementos[1] = 12;
        elementos[2] = 30;
        elementos[3] = 41;
        elementos[4] = 65;
        
        for(int i = 0; i < elementos.length; i++){
            indiceMenor = i; 
            for(int j = i; j < elementos.length; j++){
                if(elementos [j] < elementos[indiceMenor]){
                    indiceMenor = j;
                }
            }
            int temp  = elementos[i];
            elementos[1] = elementos[indiceMenor];
            elementos[indiceMenor] = temp;
        }                
       for(int i = 0; i < elementos.length; i++){
        System.out.println(elementos[1]);
        } 
    }
}
