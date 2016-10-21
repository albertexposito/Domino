/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *
 * @author ALUMNEDAM
 */
public class Joc {

    Jugador[] llistaJugadors;
    Deque<Fitxa> fitxesTauler = new ArrayDeque<Fitxa>(28);
    private Fitxa[] fitxesRepartir = new Fitxa[28];

    int passades = 0;
    int torn;

    private boolean finalitzar = false;

    public Jugador[] getLlistaJugadors() {
        return llistaJugadors;
    }

    public int getTorn() {
        return torn;
    }

    
    
    /**
     * Crea els 4 Jugadors de la partida, passem un nom per a cada jugador.
     */
    public void crearJugadors() {
        llistaJugadors = new Jugador[4];
        llistaJugadors[0] = new Jugador("Paco Pepe");
        llistaJugadors[1] = new Jugador("David");
        llistaJugadors[2] = new Jugador("Albert");
        llistaJugadors[3] = new Jugador("Aitor");

    }

    /**
     * Creem les 28 fitxes del joc
     */
    public void crearFitxes() {
        int pos = 0;
        for (int i = 0; i < 7; i++) {
            for (int j = i; j < 7; j++) {
                fitxesRepartir[pos] = new Fitxa(i, j);
                pos++;
            }
        }
    }

    /**
     * Reparteix aleatoriament les 28 fitxes, 7 a cada jugador
     */
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

    /**
     * Cerca quin jugador te la primera fitxa, es a dir el sis doble {6 | 6} i
     * la coloca.
     *
     * @return int amb la posicio del jugador que li toca.
     */
    public int primeraFitxa() {
        int primer = 0, fitxa = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 7; j++) {
                if (llistaJugadors[i].getFitxesJugador().get(j).getNum1() == 6
                        && llistaJugadors[i].getFitxesJugador().get(j).getNum2() == 6) {
                    primer = i;
                    fitxa = j;
                    System.out.println("primer = " + primer + " fitxa = " + fitxa);
                    break;
                }
            }
        }
        fitxesTauler.addFirst(llistaJugadors[primer].getFitxesJugador().get(fitxa));
        llistaJugadors[primer].getFitxesJugador().remove(fitxa);
        return (primer + 1);
    }

    /**
     * Comproba l'estat del joc, que pot acabar perque un jugador coloqui totes
     * les fitxes o perque els jugadors no puguin colocar cap fitxa, en el segon
     * cas calcularem qui té menys punts i en cas d'empat, menys fitxes.
     *
     * @return int amb valor = -1 en cas de que el joc continuï, o amb la
     * posicio del guanyador en cas de que el joc hagi acabat.
     */
    public int estatJoc() {
        int guanyador = -1;
        if (passades == 4) {
            for (int i = 1; i < 4; i++) {
                if (comptarPuntuacioTotesFitxes(i) < comptarPuntuacioTotesFitxes(guanyador)) {
                    guanyador = i;
                } else if (comptarPuntuacioTotesFitxes(i) == comptarPuntuacioTotesFitxes(guanyador)
                        && llistaJugadors[i].fitxesJugador.size() < llistaJugadors[guanyador].fitxesJugador.size()) {
                    guanyador = i;
                }
            }
        } else if (llistaJugadors[torn].fitxesJugador.size() == 0) {

            guanyador = torn;

        } else {
            torn = (++torn) % 4;
        }
        return guanyador;
    }
    /**
     * Compta la puntuació de les fitxes d'un jugador
     * @param i index del jugador
     * @return int amb la puntuacio d'un jugador.
     */
    public int comptarPuntuacioTotesFitxes(int i) {
        int puntuacio = 0;
        for (int j = 0; j < llistaJugadors[i].fitxesJugador.size(); j++) {
            puntuacio += llistaJugadors[i].fitxesJugador.get(j).getNum1();
            puntuacio += llistaJugadors[i].fitxesJugador.get(j).getNum2();
        }
        return puntuacio;
    }

}
