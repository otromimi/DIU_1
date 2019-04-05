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
public class RuningSG {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // lanza ambas implementaciones depende del usuario.
        Carrera runingSG;
        
        System.out.print("Si se introduce \"si\" se ejecutara en programa con la implementacion descrita en la practica 1A en memoria estatica; "
                + "de lo cantrario la implementacion sera la descrita en la practica 1B, con memoria dinamica.\n\n\tDesea correr la implementacion"
                + " en memoria estatica");
        runingSG= new Carrera(siNo());
        System.out.print("\n######################################################################\n\n\n");
        runingSG.setInfoCarrera();
        
        do{
            runingSG.introducirCorredor();
            System.out.print("Desea introducir otro corredor");
        }while(siNo());
        
        printInfo(runingSG,true);
        System.out.println();
        runingSG.ordenar();//Ordenacion de las desta del tiempo.
        pressToContinue();
        
        printInfo(runingSG,false);
        System.out.println();
        pressToContinue();
    }
    
    public static boolean siNo(){
        Scanner scan =new Scanner(System.in);
        String input=null;
        boolean redo, val=true;

        do{
            System.out.print(" S/n: ");
            input=scan.nextLine();
            switch (input) {
                case "":
                case "s":
                case "S":
                    redo=false;
                    val=true;
                    break;
                case "n":
                case "N":
                    redo=false;
                    val=false;
                    break;
                default:
                    System.out.print("\n Opcion erronea intentelo de nuevo ");
                    redo=true;
                    break;
            }
        }while(redo==true);
        return val;
    }
    
    /***
     * Imprime un mensaje por pantalla y espera a un intro para proseguir la ejecucion.
     */
    public static void pressToContinue(){
        Scanner scan =new Scanner(System.in);
        System.out.print("Presione intro para continuar...");
        scan.nextLine();
    }
    
    
    private static void printInfo(Carrera runingSG, boolean copy){
        runingSG.deltaTime();
        System.out.println("\n\n__________________________________________________");
        System.out.println(runingSG.toString());
        System.out.println("__________________________________________________\nNombre\t\tTiempo\t\tDiferencia");
        runingSG.printListas(copy);
    }
    
}
