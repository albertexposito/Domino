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
    private Deque<Fitxa> fitxesTauler = new ArrayDeque<Fitxa>(28);
    private Fitxa[] fitxesRepartir = new Fitxa[28];

    static int passades = 0;
    private int torn;

    private boolean finalitzar = false;

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

    public int estatJoc() {
        int guanyador = 0;
        if (passades == 4) {
            for (int i = 1; i < 4; i++) {
                if (comptarPuntuacioFitxes(i) > comptarPuntuacioFitxes(guanyador)) {
                    guanyador = i;
                } else if (comptarPuntuacioFitxes(i) == comptarPuntuacioFitxes(guanyador)
                        && llistaJugadors[i].fitxesJugador.size() > llistaJugadors[guanyador].fitxesJugador.size()) {
                    guanyador = i;
                }
            }
        }
        return guanyador;
    }

    public int comptarPuntuacioFitxes(int i) {
        int puntuacio = 0;
        for (int j = 0; j < llistaJugadors[i].fitxesJugador.size(); j++) {
            puntuacio += llistaJugadors[i].fitxesJugador.get(j).getNum1();
            puntuacio += llistaJugadors[i].fitxesJugador.get(j).getNum2();
        }
        return puntuacio;
    }

}
