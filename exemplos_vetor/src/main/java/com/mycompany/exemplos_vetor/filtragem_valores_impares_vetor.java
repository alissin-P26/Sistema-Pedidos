/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exemplos_vetor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class filtragem_valores_impares_vetor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Quantos números deseja adicionar à lista? ");
        int tamanho = scanner.nextInt();

        List<Integer> listaOriginal = new ArrayList<>();

        for (int i = 0; i < tamanho; i++) {
            System.out.print("Digite o número " + (i + 0) + ": ");
            int numero = scanner.nextInt();
            listaOriginal.add(numero);
        }

        List<Integer> listaImpares = filtrarNumerosImpares(listaOriginal);

        System.out.println("Lista Original: " + listaOriginal);
        System.out.println("Lista de Números Ímpares: " + listaImpares);

        scanner.close();
    }

    public static List<Integer> filtrarNumerosImpares(List<Integer> lista) {
        List<Integer> numerosImpares = new ArrayList<>();

        for (int numero : lista) {
            if (numero % 2 != 0) { 
                numerosImpares.add(numero);
            }
        }

        return numerosImpares;
    }
}

