/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SCACV_Vista;

import SCACV_Controlador.*;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;

/**
 *
 * @author jlgallego99
 */
public class Salpicadero extends javax.swing.JPanel implements Runnable {
    Controlador controlador;
    private static final DecimalFormat decimales = new DecimalFormat("#.###");
    
    public Salpicadero() {
        initComponents();
        
        // Títulos del panel de cada parte del salpicadero
        salpicadero.setBorder(BorderFactory.createTitledBorder("Salpicadero"));
        velocimetro.setBorder(BorderFactory.createTitledBorder("Velocímetro"));
        cuentakilometros.setBorder(BorderFactory.createTitledBorder("Cuentakilómetros"));
        cuentarrevoluciones.setBorder(BorderFactory.createTitledBorder("Cuentarrevoluciones"));
    }
    
    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        salpicadero = new javax.swing.JPanel();
        velocimetro = new javax.swing.JPanel();
        valor_velocimetro = new javax.swing.JLabel();
        cuentakilometros = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        contador_total = new javax.swing.JLabel();
        contador_reciente = new javax.swing.JLabel();
        cuentarrevoluciones = new javax.swing.JPanel();
        rpm = new javax.swing.JLabel();

        valor_velocimetro.setText("jLabel1");

        javax.swing.GroupLayout velocimetroLayout = new javax.swing.GroupLayout(velocimetro);
        velocimetro.setLayout(velocimetroLayout);
        velocimetroLayout.setHorizontalGroup(
            velocimetroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(velocimetroLayout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(valor_velocimetro)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        velocimetroLayout.setVerticalGroup(
            velocimetroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(velocimetroLayout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(valor_velocimetro)
                .addContainerGap(92, Short.MAX_VALUE))
        );

        jLabel1.setText("Total:");

        jLabel2.setText("Reciente:");

        contador_total.setText("jLabel3");

        contador_reciente.setText("jLabel3");

        javax.swing.GroupLayout cuentakilometrosLayout = new javax.swing.GroupLayout(cuentakilometros);
        cuentakilometros.setLayout(cuentakilometrosLayout);
        cuentakilometrosLayout.setHorizontalGroup(
            cuentakilometrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cuentakilometrosLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(cuentakilometrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(28, 28, 28)
                .addGroup(cuentakilometrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(contador_reciente)
                    .addComponent(contador_total))
                .addContainerGap(291, Short.MAX_VALUE))
        );
        cuentakilometrosLayout.setVerticalGroup(
            cuentakilometrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cuentakilometrosLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(cuentakilometrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(contador_total))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addGroup(cuentakilometrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(contador_reciente))
                .addGap(48, 48, 48))
        );

        rpm.setText("jLabel3");

        javax.swing.GroupLayout cuentarrevolucionesLayout = new javax.swing.GroupLayout(cuentarrevoluciones);
        cuentarrevoluciones.setLayout(cuentarrevolucionesLayout);
        cuentarrevolucionesLayout.setHorizontalGroup(
            cuentarrevolucionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cuentarrevolucionesLayout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(rpm)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        cuentarrevolucionesLayout.setVerticalGroup(
            cuentarrevolucionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cuentarrevolucionesLayout.createSequentialGroup()
                .addContainerGap(94, Short.MAX_VALUE)
                .addComponent(rpm)
                .addGap(84, 84, 84))
        );

        javax.swing.GroupLayout salpicaderoLayout = new javax.swing.GroupLayout(salpicadero);
        salpicadero.setLayout(salpicaderoLayout);
        salpicaderoLayout.setHorizontalGroup(
            salpicaderoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(salpicaderoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(salpicaderoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(velocimetro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cuentakilometros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cuentarrevoluciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        salpicaderoLayout.setVerticalGroup(
            salpicaderoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(salpicaderoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(velocimetro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cuentakilometros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cuentarrevoluciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(salpicadero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(salpicadero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel contador_reciente;
    private javax.swing.JLabel contador_total;
    private javax.swing.JPanel cuentakilometros;
    private javax.swing.JPanel cuentarrevoluciones;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel rpm;
    private javax.swing.JPanel salpicadero;
    private javax.swing.JLabel valor_velocimetro;
    private javax.swing.JPanel velocimetro;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        while (true) {
            rpm.setText(Double.toString(controlador.getRPM()));
            valor_velocimetro.setText(decimales.format(controlador.getVelocidad()));
            contador_total.setText(decimales.format(controlador.getDistanciaAcumulada()));
            contador_reciente.setText(decimales.format(controlador.getDistanciaActual()));
            
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
