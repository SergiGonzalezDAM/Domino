package domino.vistaText;

import domino.controlText.GestioDominoText;
import domino.model.Fitxa;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
//Falta verificar entrada de datos.

public class InterficieText {

    private Scanner input = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("Selecciona Jugada:"
                + "\n1. Passar"
                + "\n2. Col·locar 1 fitxa"
                + "\n3. Col·locar 2 dobles");
        return input.nextInt();
    }

    //Le tiene que llegar el jugador que está jugando del control
    public void mostrarJugador(String jugador) {
        System.out.println("¡Está jugando: " + jugador + " !");
    }

    //Le tiene que llegar un arraydequee con las fichas puestas en el tablero
    public void fitxesJugades(ArrayDeque<Fitxa> fichasJugadas) {
        System.out.println("Fitxes Tauler: ");
        for (Fitxa f : fichasJugadas) {
            System.out.print(f.toString());
        }
        System.out.println("");
        

    }

    //Le tiene que llegar un array con las fichas del jugador
    public void fitxesDisponibles(List<Fitxa> fitxas) {
        System.out.println("Fitxas Jugador: ");
        for (Fitxa f : fitxas) {
            System.out.print(f.toString());
        }
        System.out.println("");
    }

    //Le tiene que llegar el número de turno a jugar y el nombre del jugador que juega en ese turno
    public void torn(int torn) {
        System.out.println("Turno: " + torn);
    }

    public int demanarFitxa() {
        System.out.println("Escriu la posició de la fitxa que vols jugar: ");
        return input.nextInt();
    }

    public boolean demanarPosicioFitxa() {
        System.out.println("Selecciona posició:\n1.Esquerra\n2.Dreta");
        int valor = input.nextInt();
        boolean valorColocarFitxa = true;

        switch(valor)
        {
            case 1:
                valorColocarFitxa = true;
                break;
            case 2:
                valorColocarFitxa = false;
                break;
            default:
                System.out.println("Valor no vàlid");
                break;
        }
        return valorColocarFitxa;
    }

    public int numeroJugadores() {
        return Integer.parseInt(demanarFrase("Numero de jugadors que participaran: "));
    }

    public String[] nomJugadors(int jugadors) {
        String nomJugadors[] = new String[jugadors];
        for (int i = 0; i < nomJugadors.length; i++) {
            nomJugadors[i] = demanarFrase("Introdueix el nom del jugador" + i);
        }
        return nomJugadors;
    }

    public String demanarFrase(String missatge) {
        if (missatge != null) {
            System.out.println(missatge);
        }
        return input.nextLine();
    }

}
