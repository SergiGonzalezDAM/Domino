/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domino.vistaText;

import domino.controlText.GestionDominoUI;
import domino.model.Fitxa;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Label;
import java.util.ArrayDeque;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author ALUMNEDAM
 */
public class Juego extends javax.swing.JFrame {

    JPanel pnord, pImatges, pCentre, pSud, pEst, pOest;
    ArrayList<String> nombreJugadores;
    GestionDominoUI c;

    public Juego(ArrayList<String> nombreJugadores, GestionDominoUI c) {
        super("Domino");
        this.nombreJugadores = nombreJugadores;
        this.c = c;
        //this.pack();
        configuracio();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("Juego");

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("Jugadores");
        jCheckBoxMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jCheckBoxMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 531, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 409, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBoxMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem1ActionPerformed

    }//GEN-LAST:event_jCheckBoxMenuItem1ActionPerformed
    /**
     * Método que se encarga de generar en un primer momento el tablero, con las
     * zonas marcadas mediante colores. Se ha seleccionado expresamente el verde
     * como fondo principal para poder destacar así las fichas que estén jugadas
     */
    private void configuracio() {

        pSud = new JPanel();
        pOest = new JPanel();
        pEst = new JPanel();
        pCentre = new JPanel();
        pnord = new JPanel();

        pnord.setBackground(Color.GRAY);
        pSud.setBackground(Color.GRAY);
        pOest.setBackground(Color.GRAY);
        pEst.setBackground(Color.GRAY);
        pCentre.setBackground(Color.GREEN);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Label label1 = new Label(nombreJugadores.get(0));
        Label label2 = new Label(nombreJugadores.get(1));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(800, 800));
        //posicio x,y centrada al cetre de la pantalla
        this.setLocationRelativeTo(null);
        //retornem el panell principal
        this.getContentPane();
        this.setLayout(new BorderLayout());
        pSud.add(label1);
        pnord.add(label2);
        //this.add(pnord,BorderLayout.NORTH);
        this.add(pnord, BorderLayout.NORTH);
        this.add(pSud, BorderLayout.SOUTH);
        this.add(pOest, BorderLayout.WEST);
        this.add(pEst, BorderLayout.EAST);
        this.add(pCentre, BorderLayout.CENTER);
        this.pack();
    }

    /**
     * Este método se encarga de imprimir los botones en un primer momento, le
     * llega el turno del jugador y mediante el array generado en el control,
     * con todos los botones, vamos colocandolos en el tablero
     *
     * @param numeroJugador
     */
    public void imprimirBotones(int numeroJugador) {
        JButton boton;
        ArrayList<JButton> arrayBotones = c.getArrayBotones();
        JButton pasar = new JButton("PASAR");
        switch (numeroJugador) {
            case 0:
                for (int i = 0; i < arrayBotones.size(); i++) {
                    boton = arrayBotones.get(i);
                    pSud.add(boton);

                }
                pasar.addActionListener(c);
                pasar.setActionCommand("Pasar");
                pSud.add(pasar);
                break;
            case 1:
                for (int i = 0; i < arrayBotones.size(); i++) {
                    boton = arrayBotones.get(i);
                    pnord.add(boton);
                }
                break;
            //Futuras implementaciones, OTROS JUGADORES
            case 2:
                break;
            case 3:
                break;
        }

    }

    /**
     * Este método se encarga de actualizar las fichas del mazo, le llega, array
     * de fichas, turno y ficha jugada, la ficha jugada es básicamente para
     * eliminarla después del array, entonces, a partir de el array de fichas
     * genera de nuevo todos los botones, pero esta vez actualizados a la nueva
     * situación del juego
     *
     * @param juego
     * @param jugador
     * @param fichaJugada
     */
    public void actualizarFichaJugador(ArrayList<Fitxa> juego, int jugador, Fitxa fichaJugada) {

        JButton pasar = new JButton("PASAR");
        ArrayList<JButton> arrayBotones = c.getArrayBotones();
        switch (jugador) {
            case 0:

                pSud.removeAll();
                for (int i = 0; i < juego.size(); i++) {
                    JButton b = new JButton();
                    String numeros[] = juego.get(i).toString().split(",");
                    ImageIcon im = new ImageIcon("imagenes\\" + numeros[0] + "" + "" + numeros[1] + "v.gif");
                    b.setActionCommand(juego.get(i).toString());
                    b.addActionListener(c);
                    b.setIcon(im);
                    if (!fichaJugada.toString().equals(juego.get(i).toString())) {
                        pSud.add(b);
                    } else {
                        c.getJugador1().remove(juego.get(i));
                    }
                }
                pasar.addActionListener(c);
                pasar.setActionCommand("Pasar");
                pSud.add(pasar);
                break;
        }
        pSud.updateUI();
        pnord.updateUI();
    }

    /**
     * Le llega el array de fichas jugadas y las imprime en el tablero de juego
     *
     * @param fichasJugadas
     */
    public void imprimirFichasJugadas(ArrayDeque<Fitxa> fichasJugadas) {
        pCentre.removeAll();
        System.out.println("Fitxes Tauler: ");
        for (Fitxa f : fichasJugadas) {
            JButton b = new JButton();
            String numeros[] = f.toString().split(",");
            System.out.print(f.toString());
            ImageIcon im = new ImageIcon("imagenes\\" + numeros[0] + "" + "" + numeros[1] + "v.gif");
            b.setIcon(im);
            pCentre.add(b);
        }

        pCentre.updateUI();

    }

    /**
     * Muetra un panel de forma temporal para elegir donde colocar la ficha
     *
     * @return
     */
    public boolean orientacionFicha() {
        boolean orienzacion = true;
        Object[] izquierdaDerecha = {"Izquierda",
            "Derecha"};
        int orientacionFicha = JOptionPane.showOptionDialog(null,
                "Seleccione una opcion", "Respuesta menu",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                izquierdaDerecha,
                izquierdaDerecha[1]);

        switch (orientacionFicha) {
            case 0:
                orienzacion = true;
                break;
            case 1:
                orienzacion = false;
                break;
        }

        return orienzacion;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
