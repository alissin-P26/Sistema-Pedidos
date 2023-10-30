/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exemplos_vetor;

/**
 *
 * @author jose.5989
 */
public class maior_menor_vetor {
    public static void main(String args[]){
        int [] vetor = { 5, 2, 9, 1, 5, 6};
        int maximo = vetor[0];
        int minimo = vetor[0];
        
        for (int i = 1; i < vetor.length; i++) {
            if (vetor[i] > maximo) {
                maximo = vetor[i];
            }else if (vetor[i] < minimo) {
                minimo = vetor[i];
            }
                
        }        
        System.out.println("Maior valor: " + maximo);
        System.out.println("Menor valor: " + minimo);
        
    }
}
