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
public interface Cola<E> {
    public void encolar(E contenido);
    public E desencolar();
    public E primero();
    public boolean esVacia();
}
