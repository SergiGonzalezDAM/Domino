/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domino.controlText;

import domino.model.Fitxa;
import domino.model.Joc;
import domino.model.Jugada;
import domino.vistaText.Juego;
import domino.vistaText.Opciones;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author ALUMNEDAM
 */
public class GestionDominoUI implements ActionListener {

    private Joc joc;
    private Jugada jugada;
    Opciones opciones;
    Juego juego;
    ArrayList<String> nombreJugadores;
    ArrayList<JButton> arrayBotones;
    int opcionMenu;
    ArrayList<Fitxa> jugador1;
    ArrayList<Fitxa> jugador2;

    public GestionDominoUI() {
        opciones = new Opciones(this);
        opciones.setVisible(true);
        jugador1 = new ArrayList();
        jugador2 = new ArrayList();
    }

    /**
     * Sobreescribimos el método actionPerformed por que implementamos
     * ActionListener debido a que aquí, desde el control, gestionaremos el
     * juego entero, en este método, reciviremos las respuestas de todos los
     * botones del juego
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String respuestaBoton = e.getActionCommand();
        //boolean entrar = false;

        switch (respuestaBoton) {
            case "Jugar":
                nombreJugadores = opciones.getNombreJugadores();
                this.joc = new Joc(opciones.getNumeroJugadores(), 28, 7);
                joc.iniciar(nombreJugadores);
                jugada = new Jugada(joc);
                juego = new Juego(nombreJugadores, this);
                juego.setVisible(true);
                opciones.setVisible(false);
                jugada.inicial();
                for (int i = 0; i < opciones.getNumeroJugadores(); i++) {
                    generarBotones(joc.getJugadors()[i].getFitxes(), i);
                    this.juego.imprimirBotones(i);
                }
                break;
            case "Pasar":
                jugada.passar();
                break;
            default:
                switch (joc.getTorn()) {
                    //Turno para jugar yo
                    case 0:
                        int[] array = new int[2];
                        String numeros[] = respuestaBoton.split(",");
                        array[0] = Integer.parseInt(numeros[0]);
                        array[1] = Integer.parseInt(numeros[1]);
                        Fitxa f = new Fitxa(array);
                        boolean girar = juego.orientacionFicha();
                        jugada.colocarUnaFitxa(f, girar);
                        if (!girar) {
                            f.canviarOrientacio();
                        }
                        juego.actualizarFichaJugador(jugador1, joc.getTorn(), f);
                        break;
                }
                joc.actualitzarEstat();
                break;
        }
        this.juego.imprimirFichasJugadas(joc.getFitxesJugades());
    }

    public ArrayList<Fitxa> getJugador1() {
        return jugador1;
    }

    /**
     * Este método se encarga de generar, en un primer momento, todos los
     * botones con las imágenes idoneas para cada botón
     *
     * @param fitxas
     * @param numeroJugador
     * @return
     */
    public ArrayList<JButton> generarBotones(List<Fitxa> fitxas, int numeroJugador) {
        arrayBotones = new ArrayList();
        if (numeroJugador == 0) {
            //Mis botones
            for (Fitxa f : fitxas) {
                jugador1.add(f);
                JButton b = new JButton();
                String numeros[] = f.toString().split(",");
                ImageIcon im = new ImageIcon("imagenes\\" + numeros[0] + "" + "" + numeros[1] + "v.gif");
                b.setActionCommand(f.toString());
                b.addActionListener(this);
                b.setIcon(im);
                arrayBotones.add(b);
            }
        } else {
            for (Fitxa f : fitxas) {
                JButton b = new JButton();
                jugador2.add(f);
                ImageIcon im = new ImageIcon("imagenes\\backv.gif");
                b.setActionCommand(f.toString());
                b.setIcon(im);
                arrayBotones.add(b);
            }
        }
        return arrayBotones;
    }

    public ArrayList<JButton> getArrayBotones() {
        return arrayBotones;
    }

}
