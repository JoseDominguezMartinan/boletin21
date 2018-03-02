/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletin21;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



/**
 *
 * @author jose
 */
public class Metodos {
    Palabras[] listaPalabras=new Palabras[5];
    public void insertarPalabras(){
        for(int i=0;i<listaPalabras.length;i++){
            listaPalabras[i]=new Palabras(JOptionPane.showInputDialog("inserte una palabra"));
        }
    }
    public void ordear(){
       
     for(int i=0;i<(listaPalabras.length-1);i++){
         for(int j=i+1;j<listaPalabras.length;j++){
             if(listaPalabras[i].getContenido().compareToIgnoreCase(listaPalabras[j].getContenido())>0){
                 Palabras palabraAuxiliar=listaPalabras[i];
                 listaPalabras[i]=listaPalabras[j];
                 listaPalabras[j]=palabraAuxiliar;
                 
             }
         }
         
     }
    }
    public void escribir(){
        FileWriter escribir=null;
         try {

            File ficheiro = new File("palabras.txt");
           escribir=new FileWriter(ficheiro);
           for(int i=0;i<listaPalabras.length;i++){
               escribir.write((i+1)+": "+listaPalabras[i]+"\n");
             
           }

        } catch (FileNotFoundException ex) {

            System.out.println("Error de escritura" + ex);

        } catch (IOException ex) {

            System.out.println("Error de escritura" + ex);

        } finally {

            try {
                escribir.close();
            } catch (IOException ex) {
                Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
    
}
