/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany;

import java.util.Scanner;

/**
 *
 * @author jose.5989
 */
public class Calculadora2 {
    public static void main(String args[]){
        Scanner entrada = new Scanner (System.in);
        
        int opcao; 
        
        float num1 = 0, num2 = 0, resultado = 0;
        
        Boolean continuar = true;
        
        String opcaoEscolha;
        
        while(continuar){
            System.out.println("------------------------------------------");
            System.out.println("Calculadora das quatros operaçãoes básicas");
            System.out.println("------------------------------------------");
            System.out.println("Selecione uma opção: ");
            System.out.println("1 - Soma");
            System.out.println("2 - Subtração");
            System.out.println("3 - Multiplicação");
            System.out.println("4 - Divisão");
            System.out.println("------------------------------------------");
            
            opcao = entrada.nextInt();
            
            if(opcao == 1){
                System.out.println("Informe o primeiro número: ");
                num1 = entrada.nextFloat();
                
                System.out.println("Informe o segundo número: ");
                num2 = entrada.nextFloat();
                
                resultado = num1 + num2;
                
                System.out.println("------------------------------------------");
                System.out.println("RESULTADO DA SOMA");
                System.out.println("------------------------------------------");
                System.out.println(resultado);
                System.out.println("------------------------------------------");
            }else if(opcao == 2){
                System.out.println("Informe o primeiro número: ");
                num1 = entrada.nextFloat();
                
                System.out.println("Informe o segundo número: ");
                num2 = entrada.nextFloat();
                
                resultado = num1 - num2;
                
                System.out.println("------------------------------------------");
                System.out.println("RESULTADO DA SUBTRAÇÃO");
                System.out.println("------------------------------------------");
                System.out.println(resultado);
                System.out.println("------------------------------------------");
            }else if(opcao == 3){
                System.out.println("Informe o primeiro número: ");
                num1 = entrada.nextFloat();
                
                System.out.println("Informe o segundo número: ");
                num2 = entrada.nextFloat();
                
                resultado = num1 * num2;
                
                System.out.println("------------------------------------------");
                System.out.println("RESULTADO MULTIPLICAÇÃO");
                System.out.println("------------------------------------------");
                System.out.println(resultado);
                System.out.println("------------------------------------------");
            }else if(opcao == 4){
                System.out.println("Informe o primeiro número: ");
                num1 = entrada.nextFloat();
                
                System.out.println("Informe o segundo número: ");
                num2 = entrada.nextFloat();
                
                resultado = num1 / num2;
                
                System.out.println("------------------------------------------");
                System.out.println("RESULTADO DA DIVISÃO");
                System.out.println("------------------------------------------");
                System.out.println(resultado);
                System.out.println("------------------------------------------");
            }else{
                System.err.println("OPÇÃO INEXISTENTE !!");
            }
            
            System.out.println("Deseja realizar mais alguma operação? (S/N)");
            opcaoEscolha = entrada.next();
            
            if(opcaoEscolha.equals("S")|| opcaoEscolha.equals("s")){
                continuar = true;
            }else{
                continuar = false;
            }
        }
    }
    
}
