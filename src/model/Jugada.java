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
public class Jugada {

    public void primeraFitxa(Jugador[] jugador, int primer, String tauler) {
        for (int j = 0; j < jugador[primer].fitxesJugador.size(); j++) {
            if (jugador[primer].fitxesJugador.get(j).getNum1() == 6
                    && jugador[primer].fitxesJugador.get(j).getNum2() == 6) {
                tauler = "{6 | 6}";
                jugador[primer].getFitxesJugador().remove(j);
            }

        }
    }

    public boolean esPotContinuar(int numL, int numR, int torn, Jugador[] jugador) {
        boolean cont = true;
        for (int i = 0; i < jugador[torn].fitxesJugador.size(); i++) {
            if (jugador[torn].fitxesJugador.get(i).getNum1() == numL
                    || jugador[torn].fitxesJugador.get(i).getNum2() == numL
                    || jugador[torn].fitxesJugador.get(i).getNum1() == numR
                    || jugador[torn].fitxesJugador.get(i).getNum2() == numR) {
                break;
            } else {
                cont = false;
            }
        }
        return cont;
    }

}
