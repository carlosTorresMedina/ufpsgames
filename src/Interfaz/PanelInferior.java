/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.awt.Color;
import javax.swing.JLabel;

/**
 *
 * @author carlos
 */
public class PanelInferior extends  javax.swing.JPanel {
   private JLabel jLabel1;
    
    
    public PanelInferior(){
   this.initComponent();
    }
    
    private void initComponent(){
            jLabel1=new JLabel();
     
         jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
         jLabel1.setBackground(new Color(255, 255, 153));
         jLabel1.setSize(this.getWidth(), this.getHeight());
         jLabel1.setText("ACABA CON LOS RECOTORES");
    

       
        
          javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    
    
    
    
    
}
