/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Interfaz.Juego;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlos
 */
public class Generador extends Thread {

    private Juego juego;
    public static int velocidadGenerador;

    public Generador(Juego j) {
        this.juego = j;
        velocidadGenerador=1000;
    }

    public void run() {

        while (Notificador.detenerGeneradores) {

            Persona p = new Persona();
            juego.adicionar(p);
            try {
                Thread.sleep(velocidadGenerador);
            } catch (InterruptedException ex) {
                Logger.getLogger(Generador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    
    

}
