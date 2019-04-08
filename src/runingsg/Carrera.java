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
            listas = new ArrayCola<>();
        else
            listas = new LECola<>();
    }
    
    /***
     * Facilita la introduccion de la informacion del circuito al usuario.
     */
    public void setInfoCarrera(){
        
        Scanner sc = new Scanner(System.in);
        int dia,mes,anno;
        
        System.out.print("Circuito: ");
        circuito = sc.nextLine();
        System.out.print("Poblacion: ");
        poblacion = sc.nextLine();
        System.out.print("-Fecha-\n Dia: ");
        dia = sc.nextInt();
        System.out.print(" Mes: ");
        mes = sc.nextInt();
        System.out.print(" Anno: ");
        anno = sc.nextInt();
        fecha = new Date(anno,mes,dia);
        System.out.print("--------\nDistancia(Km): ");
        distancia = sc.nextFloat();
        
    }
    
    public String toString(){
        return("Circuito: "+circuito+"\nPoblacion: "+poblacion+"\nFecha: "+fecha.toString()+"\nDistancia: "+Float.toString(distancia)+" Km");
    }
    
    /**
     * Añade un corredor a las listas.
     */
    public void introducirCorredor(){
        listas.encolar(new Corredor());
    }
    
    public Cola getListas() {
        return listas;
    }
    
    /***
     * Coge y debuelve el mejor tiempo de la cola de corredores haciendo una copia de esta para no perderla.
     * @return float: corredor con el tiempo mas bajo.
     */
    private float getMejorTiempo(){
        float best=listas.primero().getTiempo();
        Cola<Corredor> clone;
        clone=(listas.getClass()==ArrayCola.class)?new ArrayCola<>(): new LECola<>();
        do{
            if(listas.primero().getTiempo()<best)
                best=listas.primero().getTiempo();
            clone.encolar(listas.desencolar());
        }while(!listas.esVacia());
        listas=clone;
        return best;
    }
    
    /**
     * Calcula las diferencias de tiempos respecto al corredor mas veloz.
     */
    public void deltaTime(){
        float best=getMejorTiempo();
        Cola<Corredor> actualizada;
        actualizada=(listas.getClass()==ArrayCola.class)?new ArrayCola<>(): new LECola<>();
        while(!listas.esVacia()){
            listas.primero().setDelta(listas.primero().getTiempo()-best);
            actualizada.encolar(listas.desencolar());
        }
        listas=actualizada;
    }
    
    /**
     * Ordena las listas de los corredores por diferencias de tiempos.
     * Para el algoritmo de ordenacion el metodo solo hace uso de colas.
     * @pre Necesita las diferencias de tiempo para poder ordenar.
     */
    public void ordenar(){
        Cola<Corredor> aux, tidy;
        aux=(listas.getClass()==ArrayCola.class)?new ArrayCola<>(): new LECola<>();
        tidy=(listas.getClass()==ArrayCola.class)?new ArrayCola<>(): new LECola<>();
        Corredor less;
        while((!listas.esVacia())||(!aux.esVacia())){
            less=listas.primero();
            while(!listas.esVacia()){
                if(listas.primero().getDelta()<less.getDelta()){
                    less=listas.primero();
                }
                aux.encolar(listas.desencolar());
            }
            tidy.encolar(less);
            while(!aux.esVacia()){
                if(aux.primero().equals(less))
                    aux.desencolar();
                else
                    listas.encolar(aux.desencolar());   
            }
        }
        listas=tidy;
    }
    
    /**
     * Imprime las listas de los corredores.
     * @param copy true si se quiere conservar la cola tras la impresion.
     */
    public void printListas(boolean copy){
        Cola<Corredor> aux=(listas.getClass()==ArrayCola.class)?new ArrayCola<>(): new LECola<>();
        while(!listas.esVacia()){
            System.out.print(listas.primero().toString());
            if(copy)
                aux.encolar(listas.desencolar());
            else
                listas.desencolar();
        }
        if(copy)
            listas=aux;
    }
}