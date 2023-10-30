/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exemplos_vetor;

/**
 *
 * @author jose.5989
 */

public class mesclar_lista_vetor {
    public static void main(String[] args) {
        
        int [] elementos1 = new int [10];
        int [] elementos2 = new int [5];
        
        elementos1 [0] = 1;
        elementos1 [1] = 2;
        elementos1 [2] = 3;     
        elementos1 [3] = 4;   
        elementos1 [4] = 5;
        elementos1 [5] = 6;    
        elementos1 [6] = 7;
        elementos1 [7] = 8;     
        elementos1 [8] = 9;    
        elementos1 [9] = 10; 
        
        elementos2[0] = 11;
        elementos2[1] = 12;
        elementos2[2] = 13;
        elementos2[3] = 14;
        elementos2[4] = 15;
        
        int[] elementosMesc = new int[elementos1.length + elementos2.length];
        
        for(int i = 0; i < elementos1.length; i++){
            elementosMesc[i] = elementos1[i];
        }
        for(int i = 0; i < elementos2.length; i++){
            elementosMesc[elementos1.length + i ] = elementos2[i];
        }
        
        for(int i = 0; i < elementosMesc.length; i++){
            System.out.println(elementosMesc[i]);
        }
    }
    
    
        
     
}
