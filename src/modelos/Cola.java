/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *Interfaz cola; hace que un programa pueda usar distintas implemetaciones de cola.
 * @author Liam
 */
public interface Cola<T> {
    
    /***
     * Desencola un elemento de la cola y lo debuelve.
     * @return Elemento desencolado
     */
    T desencolar();
    
    /***
     * Debuelve una referencia al primer elemento de la cola sin desencolarlo.
     * @return Primer elemento de la cola o cabeza.
     */
    T primero();
    
    /***
     * Comprueba si la cola esta vacia.
     * @return true si es vacia, false en caso contracio.
     */
    boolean esVacia();
    
    /***
     * Añade un elemento a la cola.
     * @param contenido: Elemento a encolar.
     */
    void encolar(T contenido);
}
