package servlet;



import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Usuario
 */
public class UnknownComand extends FrontCommand{
    public void process(){
        try {
            forward("/Unknown.jsp");
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(UnknownComand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
}
