package ar.com.xeven;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //cartas es una lista de enteros que tiene las 52 cartas
        List<Integer> cartas = new ArrayList<>();
        for (int i=1;i<53;i++)
            cartas.add(i);

        //objetoAleatorio es nuestro generador de numeros aleatorios
        Random objetoAleatorio = new Random();

        //cantidad de jugadores
        Scanner sc = new Scanner(System.in);
        int cantidadJugadores;
        do {
            System.out.println("Ingrese cantidad de jugadores (2-5): ");
            cantidadJugadores = sc.nextInt();
            System.out.println("");
        } while (cantidadJugadores<2 || cantidadJugadores>6);

        List<int[]> cartasJugadores = new ArrayList<>();
        //cartasJugadores es una lista de arrays de enteros. Representa c/u de los jugadores que ingrese por teclado
        int cartaElegida;
        for (int i=0;i<cantidadJugadores;i++){
            int[] cartasJugador = new int[5]; //cartas de cada jugador
            for (int j=0;j<5;j++){
                cartaElegida = objetoAleatorio.nextInt(cartas.size());
                cartasJugador[j] = cartas.remove(cartaElegida);
            }
            cartasJugadores.add(cartasJugador);
        }

        //muestro las cartas
        int contador = 0;
        for (int[] lasCartas: cartasJugadores){
            contador++;
            System.out.println("Jugador: "+contador);
            for (int i=0;i<5;i++)
                System.out.println("Cartas: "+lasCartas[i]);
        }

    }
}
