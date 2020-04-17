/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SCACV_Vista;

import SCACV_Controlador.*;
import SCACV_Modelo.EstadoMotor;
import SCACV_Modelo.EstadoPalanca;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jlgallego99
 */
public class PanelBotones extends javax.swing.JPanel implements Runnable, ActionListener{
    Controlador controlador;
    private static final DecimalFormat decimales = new DecimalFormat("#.###");
    
    /**
     * Creates new form PanelBotones
     */
    public PanelBotones() {
        initComponents();
        BotonEncender.setForeground(Color.GREEN);
        BotonEncender.setText("ENCENDER");
        estado.setText("APAGADO");
        estado.setForeground(Color.RED);
        scacv.setText("SCACV: Apagado");
        scacv.setForeground(Color.RED);
        apagado.setSelected(true);
        acelerar.setEnabled(false);
        reiniciar.setEnabled(false);
        
        velocidad_scacv.setText("0.0");
        
        BotonEncender.addActionListener(this);
        BotonAcelerar.addActionListener(this);
        BotonFrenar.addActionListener(this);
        acelerar.addActionListener(this);
        apagado.addActionListener(this);
        mantener.addActionListener(this);
        reiniciar.addActionListener(this);
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == BotonEncender) {
            if (BotonEncender.isSelected()) {
                BotonEncender.setForeground(Color.RED);
                BotonEncender.setText("APAGAR");
                estado.setText("ENCENDIDO");
                estado.setForeground(Color.GREEN);
                controlador.setEstadoMotor(EstadoMotor.ENCENDIDO);
            }
            else {
                BotonEncender.setForeground(Color.GREEN);
                BotonEncender.setText("ENCENDER");
                estado.setText("APAGADO");
                estado.setForeground(Color.RED);
                controlador.setEstadoMotor(EstadoMotor.APAGADO);
                BotonAcelerar.setSelected(false);
                BotonFrenar.setSelected(false);
                scacv.setText("SCACV: Apagado");
                scacv.setForeground(Color.RED);
                apagado.setSelected(true);
                reiniciar.setSelected(false);
                mantener.setSelected(false);
                acelerar.setEnabled(false);
                reiniciar.setEnabled(false);
            }
        }
        else if (e.getSource() == BotonAcelerar) {
            estado.setText("ENCENDIDO");
            estado.setForeground(Color.GREEN);
            controlador.setEstadoMotor(EstadoMotor.ENCENDIDO);
            acelerar.setEnabled(true);
            
            if (BotonEncender.isSelected() && apagado.isSelected() && BotonAcelerar.isSelected()) {
                estado.setText("ACELERANDO");
                estado.setForeground(Color.GREEN);
                controlador.setEstadoMotor(EstadoMotor.ACELERANDO);
                controlador.setEstadoPalanca(EstadoPalanca.APAGADO);
                BotonFrenar.setSelected(false);
                acelerar.setEnabled(false);
            }
            else {
                BotonAcelerar.setSelected(false);
            }
        }
        else if (e.getSource() == BotonFrenar) {
            estado.setText("ENCENDIDO");
            estado.setForeground(Color.GREEN);
            controlador.setEstadoMotor(EstadoMotor.ENCENDIDO);
            BotonAcelerar.setEnabled(true);
            
            if (BotonFrenar.isSelected()) {
                estado.setText("FRENANDO");
                estado.setForeground(Color.RED);
                controlador.setEstadoMotor(EstadoMotor.FRENANDO);
                controlador.setEstadoPalanca(EstadoPalanca.APAGADO);
                scacv.setText("SCACV: Apagado");
                scacv.setForeground(Color.RED);
                apagado.setSelected(true);
                BotonAcelerar.setSelected(false);
                acelerar.setSelected(false);
                mantener.setSelected(false);
                reiniciar.setSelected(false);
            }
            else {
                BotonFrenar.setSelected(false);
            }
        }
        else if (e.getSource() == acelerar) {
            if (BotonEncender.isSelected()) {
                reiniciar.setSelected(false);
                controlador.setEstadoPalanca(EstadoPalanca.ACELERAR);
                scacv.setText("SCACV: Encendido");
                scacv.setForeground(Color.GREEN);
                controlador.setEstadoMotor(EstadoMotor.ACELERANDO);
                BotonFrenar.setSelected(false);
                mantener.setSelected(false);
                apagado.setSelected(false);
            }
            else {
                acelerar.setSelected(false);
            }
        }
        else if (e.getSource() == mantener) {
            if (BotonEncender.isSelected()) {
                controlador.setEstadoPalanca(EstadoPalanca.MANTENER);
                velocidad_scacv.setText(decimales.format(controlador.getVelocidadSCACV()));
                scacv.setText("SCACV: Encendido");
                scacv.setForeground(Color.GREEN);
                BotonAcelerar.setEnabled(false);
                apagado.setSelected(false);
                acelerar.setEnabled(true);
                reiniciar.setEnabled(true);
                reiniciar.setSelected(false);
                acelerar.setSelected(false);
            }
            else {
                mantener.setSelected(false);
            }
        }
        else if (e.getSource() == reiniciar) {
            if (BotonEncender.isSelected() && apagado.isSelected()) {
                controlador.setEstadoPalanca(EstadoPalanca.REINICIAR);
                controlador.setEstadoMotor(EstadoMotor.ACELERANDO);
                velocidad_scacv.setText(decimales.format(controlador.getVelocidadSCACV()));
                scacv.setText("SCACV: Encendido");
                scacv.setForeground(Color.GREEN);
                apagado.setSelected(false);
            }
            else {
                reiniciar.setSelected(false);
            }
        }
        else if (e.getSource() == apagado) {
            if (BotonEncender.isSelected() && (mantener.isSelected() || acelerar.isSelected())) {
                controlador.setEstadoPalanca(EstadoPalanca.APAGADO);
                scacv.setText("SCACV: Apagado");
                scacv.setForeground(Color.RED);
                acelerar.setSelected(false);
                acelerar.setEnabled(false);
                reiniciar.setEnabled(true);
                reiniciar.setSelected(false);
                BotonAcelerar.setSelected(false);
                BotonAcelerar.setEnabled(true);
                mantener.setSelected(false);
                controlador.setEstadoMotor(EstadoMotor.ENCENDIDO);
            }
            else {
                apagado.setSelected(false);
            }
        }
        
        controlador.ejecutar();
        this.repaint();
        this.revalidate();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        BotonEncender = new javax.swing.JToggleButton();
        BotonAcelerar = new javax.swing.JToggleButton();
        BotonFrenar = new javax.swing.JToggleButton();
        estado = new javax.swing.JLabel();
        scacv = new javax.swing.JLabel();
        acelerar = new javax.swing.JToggleButton();
        mantener = new javax.swing.JToggleButton();
        reiniciar = new javax.swing.JToggleButton();
        apagado = new javax.swing.JToggleButton();
        velocidad_scacv = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Mandos");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 12, -1, -1));

        BotonEncender.setText("ENCENDER");
        BotonEncender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonEncenderActionPerformed(evt);
            }
        });
        add(BotonEncender, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 96, -1, -1));

        BotonAcelerar.setText("ACELERAR");
        BotonAcelerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAcelerarActionPerformed(evt);
            }
        });
        add(BotonAcelerar, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 96, -1, -1));

        BotonFrenar.setText("FRENAR");
        BotonFrenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonFrenarActionPerformed(evt);
            }
        });
        add(BotonFrenar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 96, 91, -1));

        estado.setText("jLabel2");
        add(estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 59, -1, -1));

        scacv.setText("SCACV");
        add(scacv, new org.netbeans.lib.awtextra.AbsoluteConstraints(193, 145, -1, -1));

        acelerar.setText("ACELERAR");
        add(acelerar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, -1, -1));

        mantener.setText("MANTENER");
        add(mantener, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 240, -1, -1));

        reiniciar.setText("REINICIAR");
        add(reiniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 300, -1, -1));

        apagado.setText("APAGADO");
        add(apagado, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        velocidad_scacv.setText("jLabel2");
        add(velocidad_scacv, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void BotonEncenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEncenderActionPerformed

    }//GEN-LAST:event_BotonEncenderActionPerformed

    private void BotonAcelerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAcelerarActionPerformed

    }//GEN-LAST:event_BotonAcelerarActionPerformed

    private void BotonFrenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonFrenarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonFrenarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton BotonAcelerar;
    private javax.swing.JToggleButton BotonEncender;
    private javax.swing.JToggleButton BotonFrenar;
    private javax.swing.JToggleButton acelerar;
    private javax.swing.JToggleButton apagado;
    private javax.swing.JLabel estado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JToggleButton mantener;
    private javax.swing.JToggleButton reiniciar;
    private javax.swing.JLabel scacv;
    private javax.swing.JLabel velocidad_scacv;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        while (true) {
            if (controlador.getEstadoPalanca() != EstadoPalanca.REINICIAR) {
                controlador.ejecutar();
            }
            
            velocidad_scacv.setText(decimales.format(controlador.getVelocidadSCACV()));
            this.repaint();
            this.revalidate();
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(PanelBotones.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
