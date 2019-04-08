/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales;

/**
 *Nodo perteneciente a la lista enlazada, en este caso lista enlazada circular.
 * @author Liam
 */
public class Nodo<T> {
    Nodo siguiente;
    T contenido;
    
    public Nodo(T contenido){
        this.contenido=contenido;
    }
    
    public Nodo(T contenido,Nodo siguiente){
        this(contenido);
        this.siguiente=siguiente;
    }
    

}
