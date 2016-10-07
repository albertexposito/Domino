/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ALUMNEDAM
 */
public class Joc {

    Jugador[] llistaJugadors;
    Fitxa[] fitxesRepartir = new Fitxa[28];
    Jugada jug = new Jugada();
    
    String tauler;
    int NumL = 6;
    int numR = 6;
    int passades = 0;
    int torn;
    
    boolean finalitzar = false;

    public Jugador[] getLlistaJugadors() {
        return llistaJugadors;
    }

    public void crearJugadors() {
        llistaJugadors = new Jugador[4];
        llistaJugadors[0] = new Jugador("Paco Pepe");
        llistaJugadors[1] = new Jugador("David");
        llistaJugadors[2] = new Jugador("Albert");
        llistaJugadors[3] = new Jugador("Aitor");

    }

    public void crearFitxes() {
        int pos = 0;
        for (int i = 0; i < 7; i++) {
            for (int j = i; j < 7; j++) {
                fitxesRepartir[pos] = new Fitxa(i, j);
                pos++;
            }
        }
    }

    public void repartirFitxes() {

        boolean[] escollides = new boolean[28];
        int repartides = 0;

        while (repartides <= 27) {
            int numFitxa = (int) (Math.random() * 28);
            System.out.println(numFitxa);

            if (escollides[numFitxa] == false) {
                System.out.println(fitxesRepartir[numFitxa].getNum1() + " | " + fitxesRepartir[numFitxa].getNum2());
                escollides[numFitxa] = true;
                repartides++;

                if (repartides <= 7) {
                    llistaJugadors[0].fitxesJugador.add(fitxesRepartir[numFitxa]);
                } else if (repartides > 7 && repartides <= 14) {
                    llistaJugadors[1].fitxesJugador.add(fitxesRepartir[numFitxa]);
                } else if (repartides > 14 && repartides <= 21) {
                    llistaJugadors[2].fitxesJugador.add(fitxesRepartir[numFitxa]);
                } else {
                    llistaJugadors[3].fitxesJugador.add(fitxesRepartir[numFitxa]);
                }

            }

        }
    }

    public void comprovarSisDoble() {
        int jugInici = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 7; j++) {
                if (llistaJugadors[i].getFitxesJugador().get(j).getNum1() == 6
                        && llistaJugadors[i].getFitxesJugador().get(j).getNum2() == 6) {
                        jugInici = i;
                        break;
                }
            }
        }
        torn = jugInici;
        System.out.println("El jugador que comença es: " + llistaJugadors[jugInici].nom);
        
    }
    
    public void iniciarJoc(){
        jug.primeraFitxa(llistaJugadors, torn, tauler);
        
        while(!finalitzar){
            
        }
    }

}
