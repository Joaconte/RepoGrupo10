package controlador.barraMenu;



import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modelo.Juego;
import resources.sonidos.Audio;
import vista.faseBienvenida.PantallaBienvenida;

import javax.swing.*;


public class OpcionNuevoJuegoEventHandler implements EventHandler<ActionEvent> {

    private Stage escenario;
    public OpcionNuevoJuegoEventHandler(Stage escenario ) {
        this.escenario=escenario;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        int respuesta = JOptionPane.showConfirmDialog(null,"¿Está seguro que deseas volver al inicio?","Alerta!",
                JOptionPane.YES_NO_OPTION);
        if (respuesta == 0){
            Juego juegoNuevo = new Juego();
            PantallaBienvenida pantallaBienvenida = new PantallaBienvenida(escenario, juegoNuevo);
            Audio.reproducirMusica("intro");
            Scene escenaDeJuego = new Scene(pantallaBienvenida, 550, 600);
            escenario.setScene(escenaDeJuego);
        }
    }
}
