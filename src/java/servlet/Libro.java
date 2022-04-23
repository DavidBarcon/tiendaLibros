package servlet;



import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Usuario
 */
public class Libro {
    private String isbn;
    private String name;
    private String description;
    private String foto;
    private int cost;

    public Libro(String isbn, String name, String description, String foto) {
        this.isbn = isbn;
        this.name = name;
        this.description = description;
        this.foto = foto;
        setCost();
    }

    public String getFoto() {
        return foto;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String toString(){
        return "[" + isbn + "] " +name + ": " + description;
    }

    private void setCost() {
        Random rand = new Random();
        this.cost = rand.nextInt(100);
    }

    public int getCost() {
        return cost;
    }



}
