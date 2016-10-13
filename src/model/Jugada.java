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

    int torn;
    Jugador[] jugador;
    boolean tiradaPossible = false;

    public Jugada(int torn, Jugador[] jugador) {
        this.torn = torn;
        this.jugador = jugador;
    }

    public boolean esPotContinuar(Deque<Fitxa> fitxesTauler) {
        boolean cont = true;
        for (int i = 0; i < jugador[torn].fitxesJugador.size(); i++) {
            if (jugador[torn].fitxesJugador.get(i).getNum1() == fitxesTauler.getFirst().num1
                    || jugador[torn].fitxesJugador.get(i).getNum2() == fitxesTauler.getFirst().num1
                    || jugador[torn].fitxesJugador.get(i).getNum1() == fitxesTauler.getLast().num2
                    || jugador[torn].fitxesJugador.get(i).getNum2() == fitxesTauler.getLast().num2) {
                System.out.println("Es pot continuar");
                break;
            } else {
                cont = false;
                System.out.println("No es pot continuar");
            }
        }
        return cont;
    }
    
    
    public boolean[] possibleFitxa(Deque<Fitxa> fitxesTauler) {
        boolean[] possibles = new boolean[jugador[torn].fitxesJugador.size()];
        for (int i = 0; i < possibles.length; i++) {
            if (jugador[torn].fitxesJugador.get(i).getNum1() == fitxesTauler.getFirst().num1
                    || jugador[torn].fitxesJugador.get(i).getNum2() == fitxesTauler.getFirst().num1
                    || jugador[torn].fitxesJugador.get(i).getNum1() == fitxesTauler.getLast().num2
                    || jugador[torn].fitxesJugador.get(i).getNum2() == fitxesTauler.getLast().num2) {
                possibles[i] = true;
                tiradaPossible = true;
                
            }
        }
        return possibles;
    }

    //CAMBIAR TIRADA POSSIBLE
    public void colocarFitxa(Deque<Fitxa> fitxesTauler, int posicio, boolean[] possibles) {
        if (tiradaPossible == true) {
            Joc.passades = 0;
            if (possibles[posicio] == true) {
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

}
