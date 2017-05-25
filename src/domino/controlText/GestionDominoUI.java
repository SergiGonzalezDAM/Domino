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
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

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

    public GestionDominoUI() {
        opciones = new Opciones(this);
        opciones.setVisible(true);
    }

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
                System.out.println("PASARRRRRRRRRRRRRRRR");
                jugada.passar();
                break;
            default:
                switch (joc.getTorn()) {
                    case 0:
                        //AQUÍ ESTÁ EL FALLO, NO AÑADE AL ARRAY DE FICHAS JUGADAS
                        int [] array = new int[2];
                        String numeros[] = respuestaBoton.split(",");
                        array[0] = Integer.parseInt(numeros[0]);
                        array[1] = Integer.parseInt(numeros[1]);
                        Fitxa f = new Fitxa(array);
                        jugada.colocarUnaFitxa(f, juego.orientacionFicha());
                        System.out.println("Ficha Jugada con éxito");
                        break;
                }
                joc.actualitzarEstat();
                break;
        }
        this.juego.imprimirFichasJugadas(joc.getFitxesJugades());
    }

    public ArrayList<JButton> generarBotones(List<Fitxa> fitxas, int numeroJugador) {
        arrayBotones = new ArrayList();
        if (numeroJugador == 0) {
            for (Fitxa f : fitxas) {
                JButton b = new JButton();
                String numeros[] = f.toString().split(",");
                System.out.print(f.toString());
                ImageIcon im = new ImageIcon("imagenes\\" + numeros[0]+""+""+numeros[1] + ".gif");
                b.setActionCommand(f.toString());
                b.addActionListener(this);
                b.setIcon(im);
                arrayBotones.add(b);
            }
        } else {
            for (Fitxa f : fitxas) {
                JButton b = new JButton();
                System.out.println(f.toString());
                ImageIcon im = new ImageIcon("imagenes\\back.gif");
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
