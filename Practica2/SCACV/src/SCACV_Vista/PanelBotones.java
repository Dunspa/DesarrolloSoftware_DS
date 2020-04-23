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
        
        
        BotonEncender.addActionListener(this);
        BotonAcelerar.addActionListener(this);
        BotonFrenar.addActionListener(this);
        cambiarF.addActionListener(this);
        acelerar.addActionListener(this);
        apagado.addActionListener(this);
        mantener.addActionListener(this);
        reiniciar.addActionListener(this);
        cambiarA.addActionListener(this);
        repostar.addActionListener(this);
        revision.addActionListener(this);
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cambiarA){
            if (!BotonEncender.isSelected()) {
                va.setText("Correcto");
                controlador.setCuentaRevAceite(0.0);
            }
        }
        
        if (e.getSource() == cambiarF){
            if (!BotonEncender.isSelected()) {
                vf.setText("Correcto");
                controlador.setCuentaRevFrenos(0.0);
            }
            
        }
        
        if (e.getSource() == revision){
            if (!BotonEncender.isSelected()) {
                vr.setText("Correcto");
                controlador.setCuentaRevGeneral(0.0);
            }
        }
        
        if (e.getSource() == repostar){
            if (!BotonEncender.isSelected()) {
             controlador.setCombustible(500.0);
            }
        }
                
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
                radialm.setLcdValue(controlador.getVelocidadSCACV());
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
                radialm.setLcdValue(controlador.getVelocidadSCACV());
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
        reiniciar = new javax.swing.JToggleButton();
        apagado = new javax.swing.JToggleButton();
        revision = new javax.swing.JToggleButton();
        mantener = new javax.swing.JToggleButton();
        cambiarA = new javax.swing.JToggleButton();
        repostar = new javax.swing.JToggleButton();
        cambiarF = new javax.swing.JToggleButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        va = new javax.swing.JLabel();
        vf = new javax.swing.JLabel();
        vr = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        radialm = new eu.hansolo.steelseries.gauges.DisplayCircular();

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
        add(estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, -1, -1));

        scacv.setText("SCACV");
        add(scacv, new org.netbeans.lib.awtextra.AbsoluteConstraints(193, 145, -1, -1));

        acelerar.setText("ACELERAR");
        add(acelerar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, -1));

        reiniciar.setText("REINICIAR");
        add(reiniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 90, -1));

        apagado.setText("APAGADO");
        add(apagado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        revision.setText("REVISION GENERAL");
        add(revision, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 420, -1, -1));

        mantener.setText("MANTENER");
        add(mantener, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, -1, -1));

        cambiarA.setText("CAMBIAR ACEITE");
        cambiarA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambiarAActionPerformed(evt);
            }
        });
        add(cambiarA, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, -1, -1));

        repostar.setText("REPOSTAR");
        repostar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repostarActionPerformed(evt);
            }
        });
        add(repostar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 380, 140, -1));

        cambiarF.setText("CAMBIAR FRENOS");
        add(cambiarF, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 420, -1, -1));

        jLabel2.setText("Frenos:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 480, -1, -1));

        jLabel3.setText("Revision:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 480, -1, -1));

        va.setText("Correcto");
        add(va, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 480, -1, -1));

        vf.setText("Correcto");
        add(vf, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 480, -1, -1));

        vr.setText("Correcto");
        add(vr, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 480, -1, -1));

        jLabel7.setText("Aceite:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, -1, -1));

        radialm.setTitle("Velocidad Mantenida");
        radialm.setUnitString("Km/h");
        add(radialm, new org.netbeans.lib.awtextra.AbsoluteConstraints(261, 205, 120, 140));
    }// </editor-fold>//GEN-END:initComponents

    private void BotonEncenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEncenderActionPerformed

    }//GEN-LAST:event_BotonEncenderActionPerformed

    private void BotonAcelerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAcelerarActionPerformed

    }//GEN-LAST:event_BotonAcelerarActionPerformed

    private void BotonFrenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonFrenarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonFrenarActionPerformed

    private void cambiarAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambiarAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cambiarAActionPerformed

    private void repostarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repostarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_repostarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton BotonAcelerar;
    private javax.swing.JToggleButton BotonEncender;
    private javax.swing.JToggleButton BotonFrenar;
    private javax.swing.JToggleButton acelerar;
    private javax.swing.JToggleButton apagado;
    private javax.swing.JToggleButton cambiarA;
    private javax.swing.JToggleButton cambiarF;
    private javax.swing.JLabel estado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JToggleButton mantener;
    private eu.hansolo.steelseries.gauges.DisplayCircular radialm;
    private javax.swing.JToggleButton reiniciar;
    private javax.swing.JToggleButton repostar;
    private javax.swing.JToggleButton revision;
    private javax.swing.JLabel scacv;
    private javax.swing.JLabel va;
    private javax.swing.JLabel vf;
    private javax.swing.JLabel vr;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        while (true) {
            if (controlador.getEstadoPalanca() != EstadoPalanca.REINICIAR) {
                controlador.ejecutar();
            }
            
            if(controlador.getCuentaRevAceite() >= (5*Math.pow(10, 6))){
                va.setText("Problemas");
                controlador.setEstadoMotor(EstadoMotor.APAGADO);
            }
            
            if(controlador.getCuentaRevFrenos() >= (Math.pow(10, 8))){
                vf.setText("Problemas");
                controlador.setEstadoMotor(EstadoMotor.APAGADO);
            }
                        
            if(controlador.getCuentaRevGeneral() >= (Math.pow(10, 9))){
                vr.setText("Problemas");
                controlador.setEstadoMotor(EstadoMotor.APAGADO);
            }
            
            if(controlador.getCombustible() == 0){
                controlador.setEstadoMotor(EstadoMotor.APAGADO);
            }
            
            radialm.setLcdValue(controlador.getVelocidadSCACV());
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
