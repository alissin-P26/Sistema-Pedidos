/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exemplos_vetor;

import java.util.Scanner;

/**
 *
 * @author jose.5989
 */
public class buscar_elemneto_em_lista_vetor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int valorBusca, posicao = 0;
        int [] elementos = new int [10];
        
        elementos [0] = 21;
        elementos [1] = 29;
        elementos [2] = 53;     
        elementos [3] = 14;   
        elementos [4] = 95;
        elementos [5] = 66;    
        elementos [6] = 87;
        elementos [7] = 78;     
        elementos [8] = 49;    
        elementos [9] = 100; 
        
        boolean encontrado = false;
        
        System.out.println("Qual valor deseja encontrar no vetor? ");
        valorBusca = scanner.nextInt();
        
        for(int i = 0; i < elementos.length; i++){
            if(elementos[i] == valorBusca){
                encontrado = true;
                posicao = i;
                break;
            }
        }
        if(encontrado) {
            System.out.println("O valor " + valorBusca + " existente no vetor e esta na posição " + posicao);
        }else{
            System.out.println("O valor " + valorBusca + " NÃO existente no vetor!");
        }
    }
}
