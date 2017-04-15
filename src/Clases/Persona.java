/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Interfaz.GamerOver;
import Interfaz.Juego;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import sounds.Sonido;

/**
 *
 * @author carlos
 */
public class Persona extends Thread {

    private int transversal;
    private boolean pocision;
    static int velocidad;
    private JLabel imagen;
    private String tipo;
    private boolean detener;

    public Persona() {

        this.imagen = new JLabel();

        this.tipoPersona();
        velocidad = 14;
        this.detener = true;
    }

    /**
     * genera los tipos de objetos
     */
    private void tipoPersona() {
        int val = (int) (Math.random() * 10);

        if (val > 5) {

            this.tipo = "normal";
            this.imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/estudiante.png")));
        } else {
            this.imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/parra1.png")));
            this.tipo = "parra";
        }

    }

    public void run() {
        this.evento();
        while (Notificador.detenerObjetos) {

            if (!this.detener) {
                break;
            }
            int x = this.imagen.getLocation().x;
            int y = this.imagen.getLocation().y;
            y = this.movimientoTransversal(y);
            this.imagen.setLocation((x - 2), (y));
            this.ValidarLLegada();

            try {
                Thread.sleep(Juego.velocidad);
            } catch (InterruptedException ex) {
                Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        try {

            Thread.sleep(250);
            this.imagen.setVisible(false);
        } catch (InterruptedException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * genera el movimiento transversal
     * @param y
     * @return 
     */
    private int movimientoTransversal(int y) {
        if (transversal != 0) {
            y = this.validarTransversal(y);
            transversal = transversal - 1;
        } else {
            transversal = (int) Math.floor(Math.random() * (0 - (60 + 1)) + (60 + 1));
            int v = (int) Math.floor(Math.random() * (0 - (10 + 1)) + (10 + 1));

            if (v < 5) {
                pocision = false;
            } else {
                pocision = true;
            }

        }

        return y;

    }

    public void evento() {

        this.getImagen().addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {

                MouseClickedAdicionar(evt);
            }
        });
    }

    private void MouseClickedAdicionar(java.awt.event.MouseEvent evt) {
        if (this.tipo.equals("parra")) {
            Sonido.puntos();
            Juego.puntajeTotal += 1;
            Juego.jPuntaje.setText(Juego.puntajeTotal + "");
        } else {

            Sonido.perder();
            Notificador.detenerObjetos = false;
            Notificador.detenerGeneradores = false;
            Notificador.detenerNotificador = false;
            this.mostrarGamerOver();
        }

        this.imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/pisada.png")));
        this.detener = false;

    }

    private int validarTransversal(int y) {
        if (pocision) {
            if (y + 1 == 240) {
                y = y - 1;
                pocision = false;
                return y;
            } else {
                y = y + 1;
                return y;
            }
        } else {

            if (y - 1 == 0) {
                y = y + 1;
                pocision = true;
                return y;
            } else {
                y = y - 1;
                return y;
            }
        }

    }

    public void ValidarLLegada() {
        int x = this.imagen.getLocation().x;

        if (x == 0) {

            if (this.tipo.equals("parra")) {
                Sonido.perder();
                this.mostrarGamerOver();
            }

            this.detener = false;
        }
    }

    private void mostrarGamerOver() {
        GamerOver gamerover = new GamerOver(Notificador.juego, true);
        Notificador.detenerObjetos = false;
        Notificador.detenerGeneradores = false;
        Notificador.detenerNotificador = false;
        gamerover.setVisible(true);
    }

    public JLabel getImagen() {
        return this.imagen;
    }
}
