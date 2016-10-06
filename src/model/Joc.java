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
    Fitxa[] fitxes = new Fitxa[28];

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
                fitxes[pos] = new Fitxa(i, j);
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
                System.out.println(fitxes[numFitxa].getNum1() + " | " + fitxes[numFitxa].getNum2());
                escollides[numFitxa] = true;
                repartides++;

                if (repartides <= 7) {
                    llistaJugadors[0].fitxesJugador.add(fitxes[numFitxa]);
                } else if (repartides > 7 && repartides <= 14) {
                    llistaJugadors[1].fitxesJugador.add(fitxes[numFitxa]);
                } else if (repartides > 14 && repartides <= 21) {
                    llistaJugadors[2].fitxesJugador.add(fitxes[numFitxa]);
                } else {
                    llistaJugadors[3].fitxesJugador.add(fitxes[numFitxa]);
                }

            }
        }
    }

    public int comprovarSisDoble() {
        int jugInici = 0;

        return jugInici;
    }

}
