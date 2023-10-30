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
public class Atenticacao_user {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        
        String nome, senha;
        Boolean autorizado = false;
        
        while(autorizado == false){
            System.out.println("Usuário: ");
            nome = scanner.nextLine();

            System.out.println("Senha: ");
            senha = scanner.nextLine();

            if(nome.equals( "cyberninja") && senha.equals("542365")){
               System.out.println("Autorização autenticada!");
               autorizado = true;
            }else{
               System.out.println("Usuário não encontrado!");
               System.out.println("Insira novamentes as informações.");
               autorizado = false;
            }
        }
        
        System.out.println("Você está logado no sistema. Faça o uso CORRETAMENTE do sistema! ESTAMOS DE OLHO!!!!");
    }
    
}
