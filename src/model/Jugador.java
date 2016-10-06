/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author ALUMNEDAM
 */
public class Jugador {

    String nom;
    ArrayList<Fitxa> fitxesJugador;

    public Jugador(String nom) {
        this.nom = nom;
        fitxesJugador = new ArrayList<Fitxa>();
    }

    public void MostraFitxes() {
        System.out.println("Jugador " + nom + ", té " + fitxesJugador.size() + " fitxes.");
        for (int j = 0; j < 7; j++) {
            System.out.println("Fitxa numero " + j + "-> " + fitxesJugador.get(j) + " | ");
        }
    }
}
