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
public class Contagem_de_caracteres {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        
        String texto;
        
        System.err.println("Informe um texto: ");
        texto = scanner.nextLine();
        
        int contCaracteres = 0;
        for(int i = 0; i < texto.length(); i++){            
            if(texto.charAt(i) != ' '){                           
            contCaracteres++;
            }
        }
        
        System.err.println("O texto digitado possui " + contCaracteres + " letras");
    }
}
