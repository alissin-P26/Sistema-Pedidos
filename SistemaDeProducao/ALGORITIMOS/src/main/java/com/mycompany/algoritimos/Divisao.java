/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.algoritimos;

import java.util.Scanner;

/**
 *
 * @author jose.5989
 */
public class Divisao {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int num1, num2, resultado;
        
        System.out.println("Informe o primeiro número");
        num1 = entrada.nextInt();
        
        System.out.println("Informe o segundo número:");
        num2 = entrada.nextInt();
        
         resultado = num1 / num2;
        System.out.println("O resultado da divisao entre " + num1 + " e " + num2 + " é: " + resultado); 
    }
       
}
