package Interfaz;

import Clases.Generador;
import Clases.Notificador;

import Clases.Persona;
import java.awt.Color;
import java.awt.Image;
import java.awt.Label;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.edisoncor.gui.panel.PanelImage;
import sounds.Sonido;

public class Juego extends javax.swing.JFrame {
    
    private Notificador notificador;
    
    private final JPanel jPanel1;
    public static JLabel jPuntaje;
    public static int puntajeTotal = 0;
    
    public PanelImage jUniversidad;
    public static JLabel jLabel2;
    public static JLabel jLabel3;
    public static JLabel jLabel4;
    public static PanelImage panelImage1;
    
    public static int velocidad;
    
    private Puntaje puntaje;
    private final Login login;
    private final PanelInferior pie;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    public String nombre;
    
    public String ruta = "";

    /**
     * constructor
     */
    public Juego() {
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        panelImage1 = new org.edisoncor.gui.panel.PanelImage();
        jUniversidad = new org.edisoncor.gui.panel.PanelImage();
        jPuntaje = new javax.swing.JLabel();
        
        initComponents();
        this.setLocationRelativeTo(null);
        
        login = new Login();
        pie = new PanelInferior();
        mostrarLogin();
        mostrarPanelInferior();
        EventosExternos();
        this.icono();
        puntaje = new Puntaje(this);
        this.jPanel1.setSize(400, 600);
        this.ocultarObjetos(true);
    }

    /**
     * adiciona los objetos al tablero
     *
     * @param jPersona
     */
    public synchronized void adicionar(Persona jPersona) {
        
        int n = (int) Math.floor(Math.random() * (0 - (250 + 1)) + (250 + 1));
        panelImage1.add(jPersona.getImagen());
        jPersona.getImagen().setBounds(850, n, 90, 84);
        jPersona.getImagen().setVisible(true);
        jPersona.start();
        
    }

    /**
     * coloca icono, titulo, tamaño a la aplicacion.
     */
    private void icono() {
        
        this.setSize(850, 400);
        this.setTitle("UFPSGAMES");
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/icono.jpg"));
        setIconImage(icon);
        this.setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * inicializa los componentes basicos.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        
        jPanel1.setBackground(new java.awt.Color(1, 1, 1));
        
        panelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo1.jpg"))); // NOI18N

        panelImage1.setLayout(null);
        
        jUniversidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ufps.png"))); // NOI18N

        javax.swing.GroupLayout jUniversidadLayout = new javax.swing.GroupLayout(jUniversidad);
        jUniversidad.setLayout(jUniversidadLayout);
        jUniversidadLayout.setHorizontalGroup(
                jUniversidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 580, Short.MAX_VALUE)
        );
        jUniversidadLayout.setVerticalGroup(
                jUniversidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 180, Short.MAX_VALUE)
        );
        
        panelImage1.add(jUniversidad);
        
        jUniversidad.setBounds(0, 0, 70, 330);
        jPuntaje.setFont(new java.awt.Font("Tahoma", 1, 40)); // NOI18N
        jPuntaje.setForeground(new java.awt.Color(255, 255, 255));
        jPuntaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPuntaje.setText(Juego.puntajeTotal + "");
        panelImage1.add(jPuntaje);
        jPuntaje.setBounds(230, 15, 400, 49);

//       
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(panelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                        .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pack();
    }
    
    private void EventosExternos() {
        login.jButton1.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        nombre = this.login.jTextField1.getText();
        this.panel1.setVisible(false);
        Empezar();
        
    }
    
    public void Empezar() {
        this.ocultarObjetos(true);
        Juego.velocidad = 12;
        this.notificador = new Notificador(this, "generar");
        
        this.notificador.start();
        this.setTitle("UFPSGAMES - " + nombre);
    }
    
    public void mostrarPuntaje() {
        this.ocultarObjetos(false);
        panel2 = new JPanel();
        panel2.setBounds(0, 0, 900, 400);
        panel2.add(puntaje);
        puntaje.setBounds(0, 0, panel2.getWidth(), panel2.getHeight());
        panelImage1.add(panel2);
        panel2.setBackground(new Color(255, 255, 153));
        puntaje.setVisible(true);
        puntaje.mostrar();
        panel2.setVisible(true);
    }
    
    private void ocultarObjetos(boolean val) {
        this.jUniversidad.setVisible(val);
        this.pie.setVisible(val);
        Juego.jPuntaje.setVisible(val);
    }
    
    public void EmpezarNuevo() {
        Juego.puntajeTotal = 0;
        jPuntaje.setText(Juego.puntajeTotal + "");
        this.panel2.setVisible(false);
        Empezar();
        
        puntaje = new Puntaje(this);
    }

    /**
     * coloca el panel mostrarLogin
     */
    private void mostrarLogin() {
        panel1 = new JPanel();
        panel1.setBounds(220, 120, 400, 140);
        panel1.add(login);
        login.setBounds(0, 0, panel1.getWidth(), panel1.getHeight());
        panelImage1.add(panel1);
        panel1.setBackground(new Color(255, 255, 153));
        login.setVisible(true);
        panel1.setVisible(true);
    }

    /**
     * coloca el panel inferior
     */
    private void mostrarPanelInferior() {
        panel3 = new JPanel();
        panel3.setBounds(0, 330, 850, 50);
        panel3.add(pie);
        pie.setBounds(0, 0, panel3.getWidth(), panel3.getHeight());
        panelImage1.add(panel3);
        panel3.setBackground(new Color(255, 255, 153));
        pie.setVisible(true);
        panel3.setVisible(true);
    }
    
    public PanelInferior getPanelInferior() {
        return this.pie;
    }
    
}
