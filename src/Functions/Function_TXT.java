/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Functions;

import EDD.Grafo;
import EDD.Grafo_LA;
import EDD.Nodo_Grafo;
import EDD.Nodo_List;
import EDD.Simple_List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author gabri
 */
public class Function_TXT {
     public void readTxt(Grafo_LA grafo){
        
        Simple_List users = new Simple_List();
        Simple_List relations = new Simple_List();
        

        try {
            BufferedReader reader = new BufferedReader(new FileReader("test//archivo.txt"));
            String line;
            String currentSection = null;

            while ((line = reader.readLine()) != null) {
                if (line.equals("usuarios")) {
                    currentSection = "usuarios";
                } else if (line.equals("relaciones")) {
                    currentSection = "relaciones";
                } else {
                    if (currentSection != null) {
                        if (currentSection.equals("usuarios")) {
                            users.insertFinal(line);
                                Nodo_List n= new Nodo_List(line);
                                grafo.insertar(n);
//                               System.out.println(line);
                                    
                        } else if (currentSection.equals("relaciones")) {
                            String[] arista = line.split(", ");
                            System.out.println("---------------------------");
                            System.out.println(line);
                            System.out.println(arista[0]);
                            System.out.println(arista[1]);
                            System.out.println("---------------------------");
                            grafo.insertar_arista(arista[0], arista[1]);
                        }
                    }
                }
            }

            reader.close();
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        
        grafo.show_Graph();
        

       

    }
    
    
    
    public void cargar_Txt(){
        
    }
    
    public void escribir_Txt(){
        
    }
}
