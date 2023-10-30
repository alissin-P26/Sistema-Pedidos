/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exemplos_vetor;

/**
 *
 * @author jose.5989
 */
public class inversao_lista_vetor {
    public static void main(String args[]){
        int[] vetor = {1, 2, 3, 4, 5};
        
        System.out.println("Vetor original: ");
        imprimirVetor(vetor);
       
        inverterVetor(vetor);
        
        System.out.println("Vetor invertido: ");
        imprimirVetor(vetor);
    }
    
    public static void inverterVetor(int[] vetor) {
        int tamanho = vetor.length;
        for (int i = 0; i < tamanho / 2; i++) {
            int temp = vetor[i];
            vetor[i] = vetor[tamanho - 1 - i];
            vetor[tamanho - 1 - i] = temp;
        }
    }
    
    public static void imprimirVetor(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + " ");
        }
        System.out.println();
    }
}
    
