package servlet;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Usuario
 */
public class ShoppingCart {
    private Set<String> libros;

    public ShoppingCart() {
        this.libros = new HashSet<String>();
    }

    public void insertarLibro(String libro) {
        this.libros.add(libro);
    }

    public void removerLibro(String libro){
        this.libros.remove(libro);
    }  

    public void limpiar(){  
        this.libros.clear();
    }  

    public Set<String> getLibros() {
        return libros;
    }
}
