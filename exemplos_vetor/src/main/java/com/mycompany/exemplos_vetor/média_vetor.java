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
public class média_vetor {
    public static void main(String args[]){
        Scanner entrada = new Scanner(System.in);
        int valor, resultado;
        float soma = 0;
        
        System.out.println("Informe a quantidade de numeros: ");
        valor = entrada.nextInt();
        
        float [] valoresuser = new float [valor];
        System.out.println("-----------VALOR-----------");
        
        for(int i = 0; i < valoresuser.length; i++){
        System.out.println("Informe o valor na posição " + i + " : ");
        valoresuser[i] = entrada.nextFloat(); 
        }
        for(int i = 0; i < valoresuser.length; i++){
           soma = ( + valoresuser[i])/valoresuser.length;
        }                   
        System.err.println("Resultado: " + soma);
    }
    
}
