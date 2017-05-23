package domino.model;

import javax.swing.JButton;

public class ConfigFichaBoton extends JButton {

    private int[] valoresFitxa;

    public ConfigFichaBoton(int[] valoresFitxa) {
        super();
        this.valoresFitxa = valoresFitxa;
    }

    public void setValue(int[] valoresFitxa) {
        this.valoresFitxa = valoresFitxa;
    }

    public int[] getValue() {
        return valoresFitxa;
    }
}
