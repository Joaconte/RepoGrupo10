package controlador.barraMenu;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javax.swing.*;

public class OpcionSalirEventHandler implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent event) {
        int respuesta = JOptionPane.showConfirmDialog(null,"¿Está seguro que desea salir?","Alerta!",
                JOptionPane.YES_NO_OPTION);
        if (respuesta == 0){
            System.exit(0);
        }
    }
}
