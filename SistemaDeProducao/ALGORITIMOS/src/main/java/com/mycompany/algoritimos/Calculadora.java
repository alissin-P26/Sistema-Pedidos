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
public class Calculadora {
    public static void main(String args[]){
        //Declaração da variável so tipo Scanner
        Scanner entrada = new Scanner(System.in);
        
        //Variável referente a calculadora
        int opcao;
        //Declaração das variáveis que receberão os números para serem calculados 
        float num1, num2, resultado =0;
        
        Boolean continuar = true;
        
        String opcaoEscolha;
        
        while(continuar){
            //Menu da calculadora
            System.out.println("------------------------------------------");
            System.out.println("Calculadora das quatros operaçãoes básicas");
            System.out.println("------------------------------------------");
            System.out.println("Selecione uma opção: ");
            System.out.println("1 - Soma");
            System.out.println("2 - Subtração");
            System.out.println("3 - Multiplicação");
            System.out.println("4 - Divisão");
            System.out.println("------------------------------------------");

            //Entrada da opção
            opcao = entrada.nextInt();

            //Entrada do primeiro valor a ser calculado
            System.out.println("Informe o primeiro número");
            num1 = entrada.nextFloat();

            //Entrada do segundo valor a ser calculado
            System.out.println("Informe o segundo número");
            num2 = entrada.nextFloat();

            //Condicionais referentes à opção selecionada
            if(opcao == 1){//soma 
                System.out.println("Informe o primeiro número");
                num1 = entrada.nextFloat();
                resultado = num1 + num2;
                
                System.out.println("Informe o segundo número");
                num2 = entrada.nextFloat();
                resultado = num1 + num2;
                
            }else if (opcao == 2){//subtração
                System.out.println("Informe o primeiro número");
                num1 = entrada.nextFloat();
                resultado = num1 - num2;
                
                System.out.println("Informe o segundo número");
                num2 = entrada.nextFloat();
                resultado = num1 - num2;
            }else if (opcao == 3){//multiplicação
                System.out.println("Informe o primeiro número");
                num1 = entrada.nextFloat();
                resultado = num1 * num2;
                
                System.out.println("Informe o segundo número");
                num2 = entrada.nextFloat();
                resultado = num1 + num2;
            }else if (opcao == 4){//divisão
                System.out.println("Informe o primeiro número");
                num1 = entrada.nextFloat();
                resultado = num1 / num2;
                
                System.out.println("Informe o segundo número");
                num2 = entrada.nextFloat();
                resultado = num1 + num2;

            }else{
                System.out.println("Opção inexistente!");
            }

            System.out.println("------------------------------------------");
            System.out.println("RESULTADO: ");
            System.out.println("------------------------------------------");
            System.out.println(resultado);
            
            System.out.println("------------------------------------------");
            System.out.println("Deseja continuar? (S/N)");
            opcaoEscolha = entrada.next();
            System.out.println("------------------------------------------");
            
            if(opcaoEscolha.equals("S") || opcaoEscolha.equals("s")) {
                continuar = true;
            }else{
                continuar = false;
            }
        }
    
    }
    
}