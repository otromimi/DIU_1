/*
 * Lista enlazada circular
 */
package lineales;

import modelos.Cola;

/**
 *
 * @author Liam
 * @param <T>
 */
public class LECola<T> implements Cola<T>{
    
    private int talla;
    private Nodo ultimo;
    
    public LECola(){
        talla=0;
        ultimo=null;
    }
    
    public void encolar(T contenido) {
        
        Nodo aux;
        if(ultimo==null){
            ultimo=new Nodo(contenido);
            ultimo.siguiente=ultimo;
        }else{
            aux=new Nodo(contenido, ultimo.siguiente);
            ultimo.siguiente=aux;
            ultimo=aux;
        }
        talla++;
    }

 
    public T desencolar() {
        
        T aux;
        Nodo auxNodo;
        
        if(ultimo!=null){
            if(talla==1){
                aux=(T) ultimo.contenido;
                ultimo=null;
            }else{
                auxNodo=ultimo.siguiente;
                ultimo.siguiente=auxNodo.siguiente;
                aux=(T) auxNodo.contenido;
            }
            talla--;
            return aux;
        }else{
            return null;
        }
    }

    
    public T primero() {
        return (T) ultimo.siguiente.contenido;
    }

    
    public boolean esVacia() {
        return (talla==0);
    }
    
}
