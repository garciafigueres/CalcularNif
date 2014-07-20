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
 * Este mismo algoritmo tambiénpuede utilizarse para el cálculo del NIE. En el caso que el NIE empiece por X se calcula
 * despreciando la X y utilizando los 7 dígitos, si el NIE empieza por Z, se sustituye la letra Z por el número 2 y se
 * realiza el mismo cálculo.
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
        CalcularNif obj = new CalcularNif();
        Scanner sc = new Scanner(System.in);
        System.out.println("Por favor introduce el DNI: ");
        String dni = sc.next();
        if (!obj.esEntero(dni)) {
            System.out.println("El DNI introducido debe ser un número entero.");
        }else{
            System.out.println("NIF: " + dni + obj.calculaLetra(Integer.parseInt(dni)));
        }
    }

    public char calculaLetra(int dni){
        char letras[] = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
        int resto = dni%23;
        return letras[resto];
    }

    public boolean esEntero(String cadena){
        try{
            Integer.parseInt(cadena);
            return true;
        }catch (Exception e) {
            return false;
        }
    }
}
