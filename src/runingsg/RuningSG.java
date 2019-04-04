/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runingsg;

import java.util.Scanner;
import lineales.ArrayCola;
import modelos.Cola;

/**
 *
 * @author Liam
 */
public class RuningSG {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.println(sc.nextInt());
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
    
}
