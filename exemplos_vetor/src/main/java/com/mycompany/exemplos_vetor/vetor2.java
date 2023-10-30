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
public class vetor2 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
       
        int qtdValores;
        
        System.out.println("Quantos valores deseja informar? ");
        qtdValores = scanner.nextInt();
        
        int[] valores = new int[qtdValores];
        System.out.println("-----------VALORES-----------");
        for(int i = 0; i < valores.length; i++){
            System.out.println("Informe o valor para a posição " + i + ": "); 
            valores[i] = scanner.nextInt();  
        }
         System.out.println("-----------VALORES INFORMADOS-----------");
        for(int i = 0; i < valores.length; i++){
            System.out.println("Valor na posição " + i + ": " + valores[i]);
        }
    }
        
}
