/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Interfaz.Juego;
import sounds.Sonido;

/**
 *
 * @author carlos
 */
public class Notificador extends Thread {

    public static Juego juego;
    public static boolean detenerGeneradores;
    public static boolean detenerObjetos;
    public static String estado = "";
    public static boolean detenerNotificador;

    public Notificador(Juego j, String e) {

        this.juego = j;
        estado = "generar";
        detenerGeneradores = true;
        detenerObjetos = true;
        detenerNotificador = true;
    }

    @Override
    public void run() {

        while (detenerNotificador) {
            if (estado.equals("generar")) {
                Generador g = new Generador(juego);
                g.start();
                estado = "normal";
            }
            if (estado.equals("normal")) {

                if (Juego.puntajeTotal == 0) {
                    this.mensajeria(Juego.puntajeTotal);
                } else if (((Juego.puntajeTotal % 10) == 0)) {
                    this.mensajeria(Juego.puntajeTotal);
                    Sonido.ganar();

                    estado = "rapido";
                    Juego.puntajeTotal = Juego.puntajeTotal + 1;
                }
             
  
            }
            if (estado.equals("rapido")) {
                if (Juego.velocidad > 0) {
                    Juego.velocidad = Juego.velocidad - 1;
                }

                estado = "normal";

            }

            continue;
        }
    }

    private void mensajeria(int val) {

        
        
        switch (val) {
            case 0:
                juego.getPanelInferior().getjLabel1().setText("BUENO CHIQUITIN EN TUS MANOS ESTA ELIMINAR LA CORRUPCION");
                break;
            case 10:
                juego.getPanelInferior().getjLabel1().setText("MUY BIEN, LLEVAS " + Juego.puntajeTotal + " RECTORES PISADOS. CONTINUA ASI..");
                break;
            case 20:
                juego.getPanelInferior().getjLabel1().setText("MUY BIEN, LLEVAS " + Juego.puntajeTotal + " RECTORES PISADOS. AHORA LAS COSAS NO SERAN TAN FACILES");
                break;
            case 30:
                juego.getPanelInferior().getjLabel1().setText("ASI ES, LLEVAS " + Juego.puntajeTotal + " RECTORES PISADOS. USTED ES EL PUTAS BEBE..");
                break;
            default:
                juego.getPanelInferior().getjLabel1().setText("PAPI, LLEVAS " + Juego.puntajeTotal + " RECTORES PISADOS. ERES LO MAXIMO..");
        }
        
        

    }
}
