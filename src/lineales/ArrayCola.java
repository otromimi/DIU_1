/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales;

import modelos.Cola;

/**
 *
 * @author Liam
 */
public class ArrayCola<E> implements Cola {
    private int primero, fin, talla;
    private static final int TAMANNO_DEFECTO = 8;
    private E arrayCola[];
    
    public ArrayCola(){
        primero=0;//cabeza de la cola
        fin=0;//referencia a la ultima casilla ocupada
        talla=0;//numero de elementos introducidos
        arrayCola = (E[]) new Object[TAMANNO_DEFECTO];
    }

    @Override
    public void encolar(Object contenido) {
        if(talla==arrayCola.length)
            redimensionar();
        arrayCola[fin+1]=(E)contenido;
        talla++;  
    }

    @Override
    public E desencolar() {
        if(talla>0){
            talla--;
            primero++;
            return arrayCola[primero-1];
        }else
            return null;
    }

    @Override
    public E primero() {
        return arrayCola[primero];
    }

    @Override
    public boolean esVacia() {
        return (talla==0);
    }
    
    private void redimensionar(){
        E aux[] = (E[])new Object[arrayCola.length*2];
        for(int j=0, i=primero;(i%arrayCola.length)!=fin;i++,j++){
            aux[j]=arrayCola[i%arrayCola.length];
        }
        arrayCola=aux;
        primero=0;
        fin=talla-1;
    }
    
}
