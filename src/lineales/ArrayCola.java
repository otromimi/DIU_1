/*
 * Implementacion de la cola mediante arrays estaticos circulares
 */
package lineales;

import modelos.Cola;

/**
 *
 * @author Liam
 */
public class ArrayCola<T> implements Cola<T>, Cloneable {
    private int primero, fin, talla;
    private static final int TAMANNO_DEFECTO = 2;
    private T arrayCola[];
    
    public ArrayCola(){
        primero=0;//cabeza de la cola
        fin=0;//referencia a la primera csilla sin ocupar
        talla=0;//numero de elementos introducidos
        arrayCola = (T[]) new Object[TAMANNO_DEFECTO];
    }

    /**
     *
     * @param contenido
     */
    @Override
    public void encolar(T contenido) {
        if(talla==arrayCola.length){
            redimensionar();
        }
        arrayCola[fin]=contenido;
        talla++;  
        fin=(fin+1)%(arrayCola.length);
    }
    
    @Override
    public T desencolar() {
        T aux;
        if(talla>0){
            talla--;
            aux=arrayCola[primero];
            primero=(primero+1)%(arrayCola.length);
            return aux;
        }else
            return null;
    }

    @Override
    public T primero() {
        return arrayCola[primero];
    }

    @Override
    public boolean esVacia() {
        return (talla==0);
    }
    
    private void redimensionar(){
        T aux[] = (T[])new Object[arrayCola.length*2];
        int finAux;
        finAux=(fin==0)?arrayCola.length:fin-1;
        for(int j=0, i=primero;i!=(finAux);i=(i+1)%(arrayCola.length+1),j++){
            aux[j]=arrayCola[i];
        }
        arrayCola=aux;
        primero=0;
        fin=talla;
    }

}
