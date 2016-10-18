/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Deque;

/**
 *
 * @author ALUMNEDAM
 */
public class Jugada {

    private int torn;
    private Jugador[] jugador;

    public Jugada(int torn, Jugador[] jugador) {
        this.torn = torn;
        this.jugador = jugador;
    }

    public byte determinarTipusFitxa(Deque<Fitxa> fitxesTauler, int i) {
        byte cont = 0;
        if (jugador[torn].fitxesJugador.get(i).getNum1() == fitxesTauler.getFirst().num1
                || jugador[torn].fitxesJugador.get(i).getNum2() == fitxesTauler.getFirst().num1
                || jugador[torn].fitxesJugador.get(i).getNum1() == fitxesTauler.getLast().num2
                || jugador[torn].fitxesJugador.get(i).getNum2() == fitxesTauler.getLast().num2) {

            if (jugador[torn].fitxesJugador.get(i).getNum1() == jugador[torn].fitxesJugador.get(i).getNum2()) {
                cont = 2;
            } else {
                cont = 1;
            }
        } else {
            cont = 0;
            System.out.println("No es pot continuar");
        }
        return cont;
    }

    public byte[] possibleFitxa(Deque<Fitxa> fitxesTauler) {
        byte[] possibles = new byte[jugador[torn].fitxesJugador.size()];
        for (int i = 0; i < possibles.length; i++) {
            possibles[i] = determinarTipusFitxa(fitxesTauler, i);

        }
        return possibles;
    }

    //CAMBIAR TIRADA POSSIBLE
    public void colocarFitxa(Deque<Fitxa> fitxesTauler, int posicio, boolean[] possibles) {

        if (tiradaPossible == true) {
            Joc.passades = 0;
            if (possibles[posicio] == true) {

                //
                if ((jugador[torn].fitxesJugador.get(posicio).getNum1() == fitxesTauler.getFirst().num1)
                        || (jugador[torn].fitxesJugador.get(posicio).getNum2() == fitxesTauler.getLast().num2)) {

                    rotarFitxa(jugador[torn].fitxesJugador.get(posicio));
                    posicioEspecifica(fitxesTauler, posicio);
                } else if ((jugador[torn].fitxesJugador.get(posicio).getNum1() == fitxesTauler.getLast().num2)
                        || (jugador[torn].fitxesJugador.get(posicio).getNum2() == fitxesTauler.getFirst().num1)) {

                    posicioEspecifica(fitxesTauler, posicio);
                } else if (jugador[torn].fitxesJugador.get(posicio).getNum2() == fitxesTauler.getFirst().num1) {

                    fitxesTauler.addFirst(jugador[torn].fitxesJugador.get(posicio));
                    jugador[torn].fitxesJugador.remove(posicio);
                } else if (jugador[torn].fitxesJugador.get(posicio).getNum1() == fitxesTauler.getLast().num2) {

                    fitxesTauler.addLast(jugador[torn].fitxesJugador.get(posicio));
                    jugador[torn].fitxesJugador.remove(posicio);
                } else if (jugador[torn].fitxesJugador.get(posicio).getNum1() == fitxesTauler.getFirst().num1) {

                    rotarFitxa(jugador[torn].fitxesJugador.get(posicio));
                    fitxesTauler.addFirst(jugador[torn].fitxesJugador.get(posicio));
                    jugador[torn].fitxesJugador.remove(posicio);
                } else if (jugador[torn].fitxesJugador.get(posicio).getNum2() == fitxesTauler.getLast().num2) {

                    rotarFitxa(jugador[torn].fitxesJugador.get(posicio));
                    fitxesTauler.addLast(jugador[torn].fitxesJugador.get(posicio));
                    jugador[torn].fitxesJugador.remove(posicio);
                }
            }
        } else {
            Joc.passades++;
        }
    }

    public void rotarFitxa(Fitxa fitxa) {
        int aux = fitxa.getNum2();
        fitxa.setNum2(fitxa.getNum1());
        fitxa.setNum1(aux);
    }

    public void posicioEspecifica(Deque<Fitxa> fitxesTauler, int posicio) {
        char posFitxa = 'L';
        if (posFitxa == 'L') {
            fitxesTauler.addFirst(jugador[torn].fitxesJugador.get(posicio));
            jugador[torn].fitxesJugador.remove(posicio);
        } else if (posFitxa == 'R') {
            fitxesTauler.addLast(jugador[torn].fitxesJugador.get(posicio));
            jugador[torn].fitxesJugador.remove(posicio);
        }
    }

    public void colocarDobles(byte[] possibles, Deque<Fitxa> fitxesTauler) {
        int fitxa1 = -1;
        int fitxa2 = -1;

        for (int i = 0; i < possibles.length; i++) {
            if (possibles[i] == 2 && fitxa1 == -1) {
                fitxa1 = i;
            } else if (possibles[i] == 2 && fitxa1 != -1) {
                fitxa2 = i;
            }
        }
        if (fitxa1 != -1 && fitxa2 != -1) {
            if (jugador[torn].fitxesJugador.get(fitxa1).getNum2() == fitxesTauler )
        }
    }

}
