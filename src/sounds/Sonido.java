package sounds;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Sonido {

    private static File file;
    private static String ruta;
 

 

    public static void perder() {
        file = new File(".");
        ruta = file.getAbsolutePath();
        Thread hilo = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1);
                    FileInputStream fis;
                    Player player;
                    try{
                        fis = new FileInputStream(ruta + "/src/sounds/No.mp3");
                    } catch(FileNotFoundException e){
                        fis = new FileInputStream(ruta + "/complementos/No.mp3");
                    }
                    BufferedInputStream bis = new BufferedInputStream(fis);
                    player = new Player(bis);
                    player.play();
                    stop();
                } catch (InterruptedException | JavaLayerException | FileNotFoundException e) {
                }
            }
        };
        hilo.start();
    }
    
    public static void puntos() {
        file = new File(".");
        ruta = file.getAbsolutePath();
        Thread hilo = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1);
                    FileInputStream fis;
                    Player player;
                    try{
                        fis = new FileInputStream(ruta + "/src/sounds/puntos.mp3");
                    } catch(FileNotFoundException e){
                        fis = new FileInputStream(ruta + "/complementos/puntos.mp3");
                    }
                    BufferedInputStream bis = new BufferedInputStream(fis);
                    player = new Player(bis);
                    player.play();
                    stop();
                } catch (InterruptedException | JavaLayerException | FileNotFoundException e) {
                }
            }
        };
        hilo.start();
    }
    
     public static void ganar() {
        file = new File(".");
        ruta = file.getAbsolutePath();
        Thread hilo = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1);
                    FileInputStream fis;
                    Player player;
                    try{
                        fis = new FileInputStream(ruta + "/src/sounds/ganar.mp3");
                    } catch(FileNotFoundException e){
                        fis = new FileInputStream(ruta + "/complementos/ganar.mp3");
                    }
                    BufferedInputStream bis = new BufferedInputStream(fis);
                    player = new Player(bis);
                    player.play();
                    stop();
                } catch (InterruptedException | JavaLayerException | FileNotFoundException e) {
                }
            }
        };
        hilo.start();
    }


}
