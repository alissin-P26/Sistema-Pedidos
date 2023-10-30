/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.modelo;

import javax.swing.JFrame;

/**
 *
 * @author jose.5989
 */
public class ModMarca {
    private int id;
    private String nome;

    public ModMarca(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public ModMarca() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "ModMarca{" + "id=" + id + ", nome=" + nome + '}';
    }

    public String getDescricao() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
