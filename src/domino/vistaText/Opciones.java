/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domino.vistaText;

import domino.controlText.GestionDominoUI;
import java.util.ArrayList;

/**
 *
 * @author ALUMNEDAM
 */
public class Opciones extends javax.swing.JFrame {

    private int numeroJugadores;
    public ArrayList<String> nombreJugadores;

    public Opciones(GestionDominoUI c) {
        initComponents();
        this.btnJugar.addActionListener(c);
        jTextFieldJugador1.setVisible(false);
        jTextFieldJugador2.setVisible(false);
        jLabel3.setVisible(false);
        jLabel4.setVisible(false);
        nombreJugadores = new ArrayList();
    }

    public int getNumeroJugadores() {
        return numeroJugadores;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldJugadores = new javax.swing.JTextField();
        btnGuardarNumeroJugadores = new javax.swing.JButton();
        jTextFieldJugador2 = new javax.swing.JTextField();
        btnJugar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextFieldJugador1 = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nº Jugadores(2):");

        jLabel2.setText("Nombres:");

        jTextFieldJugadores.setText("2");

        btnGuardarNumeroJugadores.setText("Guardar Jugadores");
        btnGuardarNumeroJugadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarNumeroJugadoresActionPerformed(evt);
            }
        });

        btnJugar.setText("Jugar");
        btnJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJugarActionPerformed(evt);
            }
        });

        jLabel3.setText("J1");

        jLabel4.setText("J2");

        jScrollPane1.setViewportView(jTextFieldJugador1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldJugador2)
                    .addComponent(jTextFieldJugadores, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 166, Short.MAX_VALUE)
                        .addComponent(btnJugar)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnGuardarNumeroJugadores)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldJugadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardarNumeroJugadores))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldJugador2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(btnJugar))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
/**
     * Este método nos indica que hemos presionado el botón de guardar
     * jugadores, así, nosotros sabremos cuantos jugadores hay y mostramos los
     * componentes ideales para estos jugadores
     *
     * @param evt
     */
    private void btnGuardarNumeroJugadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarNumeroJugadoresActionPerformed
        numeroJugadores = Integer.parseInt(jTextFieldJugadores.getText());
        switch (numeroJugadores) {
            case 2:
                jTextFieldJugador1.setVisible(true);
                jTextFieldJugador2.setVisible(true);
                jLabel3.setVisible(true);
                jLabel4.setVisible(true);
                break;
        }
    }//GEN-LAST:event_btnGuardarNumeroJugadoresActionPerformed
    public ArrayList<String> getNombreJugadores() {
        switch (numeroJugadores) {
            case 2:
                nombreJugadores.add(jTextFieldJugador1.getText());
                nombreJugadores.add(jTextFieldJugador2.getText());
                break;
        }

        return nombreJugadores;
    }

    private void btnJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJugarActionPerformed

    }//GEN-LAST:event_btnJugarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardarNumeroJugadores;
    private javax.swing.JButton btnJugar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextFieldJugador1;
    private javax.swing.JTextField jTextFieldJugador2;
    private javax.swing.JTextField jTextFieldJugadores;
    // End of variables declaration//GEN-END:variables
}
