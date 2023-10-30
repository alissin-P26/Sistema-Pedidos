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
public class Vetor_soma {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int soma =0; 
        int valoresuser;
        System.out.println("Informe a quantidade de numeros desejados: ");
        valoresuser = scanner.nextInt();
        
        int [] valores = new int [valoresuser];
        System.out.println("-----------VALOR-----------");
        for(int i = 0; i < valores.length; i++){
        System.out.println("Informe o valor na posição " + i + " : ");
        valores[i] = scanner.nextInt();
        }
        for(int i = 0; i < valores.length; i++){
           soma = soma + valores[i];
       }
       
       System.out.println("Resultado da soma: " + soma); 
       System.out.println("-----------------------------");
         
    }
        
}
