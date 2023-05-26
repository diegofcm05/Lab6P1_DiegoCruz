/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab6p1_diegocruz;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author dfcm9
 */
public class Lab6P1_DiegoCruz {

    static Scanner sc = new Scanner (System.in);
    static Scanner sc_st = new Scanner (System.in);
    static Random ran = new Random();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        boolean resp = true;
        while (resp){
            System.out.println("Menu Lab 6");
            System.out.println("1. Cuantos Primos?");
            System.out.println("2. Frecuencia de Letras");
            System.out.println("3. Salir");
            System.out.println("Ingrese una opcion: ");
            int opcion = sc.nextInt();
            switch (opcion){
                case 1:
                {
                    System.out.println("Ingrese el tamaño del arreglo a generar: ");
                    int tam = sc.nextInt();
                    while (tam<=1){
                        System.out.println("Ingrese un tamaño mayor a 1");
                        tam = sc.nextInt();
                    }
                    
                    System.out.println("Ingrese el límite inferior: ");
                    int limin = sc.nextInt();
                    
                    System.out.println("Ingrese el límite superior: ");
                    int limsu = sc.nextInt();
                        while (limsu<=limin){
                            System.out.println("El limite superior es igual o menor al inferior. Intente de nuevo");
                            limsu = sc.nextInt();
                        }
                    
                    int [] RanArray;
                    RanArray = getRandArray(tam, limin, limsu);
                    Imprimir(RanArray);
                    System.out.println("");
                    Imprimir(getTotalPrimeCount(RanArray));
                    System.out.println("");
                    break;
                    
                }
                case 2:
                    
                {
                    boolean wrong =false;
                    String palabra;
                    System.out.println("Ingrese una palabra:");
                    palabra = sc_st.next();
                    
                    for (int i = 0; i < palabra.length(); i++) {
                        int a =(int) palabra.charAt(i);
                        int a1 = a;
                        if ((a1 < 97) || (a1> 122) && (a1 !=65533)){
                            wrong = true;
                            break;
                            
                        }
                        
                    }
                    
                    Imprimir(extraerFrecuencias(palabra))  ;
                    System.out.println("");
                    break;
                }
                
                case 3:
                {
                    resp = false;
                    break;
                }
                default:
                    System.out.println("Opcion Invalida. Ingrese una opcion correcta.");
                    
            }
        }
    }
    
    public static void Imprimir(int [] arreglo){
        
        for (int i = 0; i<arreglo.length;i++){
            System.out.print("["+arreglo[i]+"]");
            
        }
    }
    
    public static int [] getRandArray (int a, int b, int c){

        int [] arreglo1 = new int [a];
        for (int i = 0; i < a ; i++) {

            arreglo1[i] = ran.nextInt(c-b)+b;

        }
        return arreglo1;

    }
    
    public static boolean isPrime(int numero){
        boolean primo = false;

        int contciclo = 1;
        int cont0 = 0;

        while (contciclo <= numero){
            if (numero % contciclo == 0){

            cont0 ++;
        }
            contciclo ++;
        }

        if (cont0 == 2){
            primo = true;
        }
        return primo;

    }
    
    public static int countPrimeFactors(int x){
        
        int cont = 0;
        for (int i = 1; i <=x; i++) {
            if (x % i == 0){
                if (isPrime(i)){
                    cont++;
                    
                }
            }
            
        }
        return cont;
    }
    
    public static int [] getTotalPrimeCount(int [] arregloent){
        
        int [] arretemp = new int [arregloent.length];
        
        for (int i = 0; i < arretemp.length; i++) {
            arretemp[i] = countPrimeFactors(arregloent[i]);
            
        }
        return arretemp;
        
    }
    
    public static int [] extraerFrecuencias(String pal){
        int [] arretemp2 = new int [27];
        for (int i = 0; i < pal.length(); i++) {
            char c = pal.charAt(i);
            int c1 = c;
            if ((c1 >= 97) && (c1 <=122)){
                arretemp2[c1-97] += 1;
            }
            else{
                arretemp2[26] += 1;
            }
            
            
        }
        return arretemp2;
    }
    
        
        
        
}
        
        
   
