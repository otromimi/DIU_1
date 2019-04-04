/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runingsg;

import java.util.Scanner;

/**
 *
 * @author Liam
 */
public class Corredor {
    
    private String corredor;
    private float tiempo;
    private float delta;
    
    public Corredor(){
        Scanner sc = new Scanner(System.in);
        
        System.out.print("---------------------------------\nNombre: ");
        corredor = sc.nextLine();
        System.out.print("Tiempo en segundos: ");
        tiempo = sc.nextFloat();
        System.out.print("Diferencia en segundos: ");
        delta = sc.nextFloat();
    }
    
    public Corredor(String name, float time, float diferencial){
        this.corredor=name;
        this.tiempo=time;
        this.delta=diferencial;
    }
    
    public String toString(){
        return (corredor+"\t"+Float.toString(tiempo)+"\t"+Float.toString(delta)+"\n");
    }
    
    public String getNombre() {
        return corredor;
    }

    public float getTiempo() {
        return tiempo;
    }

    public float getDelta() {
        return delta;
    }
}
