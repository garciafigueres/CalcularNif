/**
 * CALCULAR LETRA NIF
 * @author: Luis García Figueres
 *
 * ALGORITMO
 * La letra del NIF se obtiene a partir de un algoritmo conocido como módulo 23. El algoritmo consiste en aplicar la
 * operación aritmética de módulo 23 al número del DNI. El módulo 23 es el número entero obtenido como resto de la
 * división entera del número del DNI entre 23. El resultado es un número comprendido entre el 0 y el 22. En base a una
 * tabla conocida se asigna una letra. La combinación del DNI con esa letra es el NIF.
 *
 * TABLA DE ASIGNACIÓN
 * 0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22
 * T,R,W,A,G,M,Y,F,P,D,X,B,N,J,Z,S,Q,V,H,L,C,K,E
 *
 * No se utilizan las letras: I, Ñ, O, U
 *
 */

package com.garciafigueres;

import java.util.Scanner;

public class CalcularNif {

    public static void main(String[] args) {
        //Creamos un objeto de la clase CalcularNif para acceder a los métodos de la misma
        CalcularNif obj = new CalcularNif();
        //Creamos un objeto de la clase Scanner para recibir los datos introducidos por consola
        Scanner sc = new Scanner(System.in);
        System.out.print("Por favor introduce el DNI: ");
        //Recibimos los datos por consola y los asignamos a una variable
        String dni = sc.next();

        //Llamamos al método que comprueba que la cadena introducida es un entero y positivo
        if (!obj.esEnteroPositivo(dni)) {
            //Si el método nos devuelve false (no es entero positivo) mostramos un mensaje
            System.out.println("El DNI introducido debe ser un número entero positivo.");
        }else{
            //Si el método nos devuelve true (es entero positivo) mostramos el NIF completo,
            //llamando al método que calcula la letra del NIF, pasándole el dni como parámetro.
            //Date cuenta de que al pasar el dni debemos CONVERTIRLO a int.
            System.out.println("NIF: " + dni + obj.calculaLetra(Integer.parseInt(dni)));
        }
    }

    //Este método recibe un dni entero y positivo y calcula su letra correspondiente.
    public char calculaLetra(int dni){
        char letras[] = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
        int resto = dni%23;
        return letras[resto];
    }

    //Este método recibe una cadena y comprueba si puede convertirse a entero y positivo.
    public boolean esEnteroPositivo(String cadena){
        try{
            if(Integer.parseInt(cadena)>0) {
                return true;
            }else {
                return false;
            }
        }catch (Exception e) {
            return false;
        }
    }
}
