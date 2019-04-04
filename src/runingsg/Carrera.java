/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runingsg;

import java.util.Date;
import java.util.Scanner;
import lineales.ArrayCola;
import lineales.LECola;
import modelos.Cola;

/**
 *
 * @author Liam
 */
public class Carrera {
    //Listas en las cuales se almacenaran los corredores de la carrera.
    private Cola<Corredor> listas;
    private String circuito;
    private String poblacion;
    private Date fecha;
    private float distancia;
     
    public Carrera(boolean statico){
        if(statico)
            listas = new ArrayCola();
        else
            listas = new LECola();
    }
    
    public void setInfoCarrera(){
        
        Scanner sc = new Scanner(System.in);
        int dia,mes,anno;
        
        System.out.print("Circuito: ");
        circuito = sc.nextLine();
        System.out.print("Poblacion: ");
        poblacion = sc.nextLine();
        System.out.print("--Fecha--\n Dia: ");
        dia = sc.nextInt();
        System.out.print("Mes: ");
        mes = sc.nextInt();
        System.out.print("Anno: ");
        anno = sc.nextInt();
        fecha = new Date(anno,mes,dia);
        System.out.print("Distancia: ");
        distancia = sc.nextFloat();
    }
    
    public String toString(){
        return("Circuito: "+circuito+"\nPoblacion: "+poblacion+"\nFecha: "+fecha.toString()+"\nDistancia: "+Float.toString(distancia)+"\n\n_________________________________________________________________________________________________________\n");
    }
    
    public void introducirCorredor(){
        listas.encolar(new Corredor());
    }
}
