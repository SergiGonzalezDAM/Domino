package domino.controlText;

import domino.model.Joc;
import domino.model.Jugada;
import domino.vistaText.InterficieText;

public class GestioDominoText
{
    private Joc joc;
    private Jugada jugada;
    InterficieText vista;

    public GestioDominoText() 
    {
        vista = new InterficieText();
        this.joc = new Joc(vista.numeroJugadores(),28,7);
        //joc.iniciar(vista.nomJugadors(4));
        jugada = new Jugada(joc);
    }
    
    public void respostaOpcioMenuJugada()
    {
        //jugada.inicial();
        int seleccioMenu;
        while(!joc.isFinalitzat())
        {
            /*this.vista.torn(joc.getTorn());
            this.vista.mostrarJugador(joc.getJugadors()[joc.getTorn()].getNom());
            vista.fitxesJugades(joc.getFitxesJugades());*/
            this.vista.fitxesDisponibles(joc.getJugadors()[joc.getTorn()].getFitxes());
             

            boolean validar = false;
            do{
            seleccioMenu = vista.mostrarMenu();
            switch(seleccioMenu)
            {
                case 1:
                    jugada.passar();
                    break;
                case 2:
                    validar = jugada.colocarUnaFitxa(joc.getJugadors()[joc.getTorn()].getFitxes().get(vista.demanarFitxa()), vista.demanarPosicioFitxa());
                    break;
                case 3:
                    validar = jugada.colocarDosDobles(joc.getJugadors()[joc.getTorn()].getFitxes().get(vista.demanarFitxa()),vista.demanarPosicioFitxa(), joc.getJugadors()[joc.getTorn()].getFitxes().get(vista.demanarFitxa()),vista.demanarPosicioFitxa());
                    break;
            }
            joc.actualitzarEstat();
             }while(!validar);
        }
        System.out.println(joc.getGuanyador());
    }
}
