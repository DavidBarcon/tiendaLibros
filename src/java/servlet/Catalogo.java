package servlet;



import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.Comparator;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Usuario
 */
public class Catalogo {
    private SortedSet<Libro> libros;

    public Catalogo() {
        this.libros = new TreeSet<Libro>(new Comparator<Libro>(){
            @Override
            public int compare(Libro l1, Libro l2){
                return l1.getName().compareTo(l2.getName());
            }
        });

        Set<Libro> librosAux = new HashSet<>();

        try {
            librosAux = bookLoader();
        } catch (Exception ex) {
            Logger.getLogger(Catalogo.class.getName()).log(Level.SEVERE, null, ex);
        }
        insertarLibros(librosAux);
    }

    private void insertarLibros(Set<Libro> libros) {
        this.libros.addAll(libros);
    }

    private Set<Libro> bookLoader() throws ParseException, org.json.simple.parser.ParseException {
        Set<Libro> librosAux = new HashSet<>();

        //temporal ----------------
        /*
        librosAux.add(new Libro("1","libro1","esto es un libro"));
        librosAux.add(new Libro("2","libro2","esto es un libro"));
        librosAux.add(new Libro("3","libro3","esto es un libro"));
        librosAux.add(new Libro("4","libro4","esto es un libro"));
        librosAux.add(new Libro("5","libro5","esto es un libro"));
        librosAux.add(new Libro("6","libro6","esto es un libro"));
        */
        //--------------------------

        try{

            JSONParser parser = new JSONParser();
            JSONArray a = (JSONArray) parser.parse(new FileReader("C:\\Users\\Usuario\\Documents\\NetBeansProjects\\TiendaLibros1\\src\\java\\books\\books.json"));
            
            for(Object o:a){
                JSONObject book = (JSONObject) o;

                String foto = (String) book.get("thumbnailUrl");
                String title = (String) book.get("title");
                String isbn = (String) book.get("isbn");
                String shortDescription = (String) book.get("shortDescription");
                if(shortDescription == null){
                    shortDescription = "sin descripcion";
                }

                librosAux.add(new Libro(isbn, title, shortDescription, foto));

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return librosAux;
    }

    public SortedSet<Libro> getLibros() {
        return libros;
    }

    public Libro getLibro(String name){
        for(Libro l:libros){
            if(l.getName().equals(name)){
                return l;
            }
        }
        return null;
    }







}
