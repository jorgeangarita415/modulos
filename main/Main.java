package Main;

import view.ClienteView;

/**
 * Clase principal que lanza la aplicación.
 */
public class Main {
    public static void main(String[] args) {
        ClienteView vista = new ClienteView();
        vista.setVisible(true);
    }
}
