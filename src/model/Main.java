package model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ALUMNEDAM
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Joc joc = new Joc();

        joc.crearJugadors();
        joc.crearFitxes();
        joc.repartirFitxes();

        joc.llistaJugadors[0].MostraFitxes();
        System.out.println("");
        joc.llistaJugadors[1].MostraFitxes();
        System.out.println("");

        joc.llistaJugadors[2].MostraFitxes();
        System.out.println("");

        joc.llistaJugadors[3].MostraFitxes();

    }

}
