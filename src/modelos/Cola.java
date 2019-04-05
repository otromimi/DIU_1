/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author Liam
 */
public interface Cola<T> {
    
    T desencolar();
    T primero();
    boolean esVacia();
    void encolar(T contenido);
}
