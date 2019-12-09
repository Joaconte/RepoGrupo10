package controlador.barraMenu;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;
import modelo.Juego;
import resources.sonidos.Audio;
import vista.fasesPartida.faseInicialPartida.PantallaFaseInicialPartida;

import javax.swing.*;

public class OpcionReiniciarPartidaEventHandler implements EventHandler<ActionEvent> {

    private Stage escenario;
    private Juego juego;

    public OpcionReiniciarPartidaEventHandler(Stage escenario, Juego juego){
        this.escenario=escenario;
        this.juego=juego;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        int respuesta = JOptionPane.showConfirmDialog(null,"¿Está seguro que deseas otra partida?","Alerta!",
                JOptionPane.YES_NO_OPTION);
        if (respuesta == 0){
            String nombre1 = juego.getNombreDeJugadorDos();
            String nombre2 = juego.getNombreDeJugadorUno();
            juego.setPartida();
            juego.agregarJugadores(nombre1, nombre2);

            PantallaFaseInicialPartida pantallaFaseInicialPartida = new PantallaFaseInicialPartida(juego, escenario);
            ScrollPane barras = new ScrollPane(pantallaFaseInicialPartida);
            Scene escenaFaseInicial = new Scene (barras,1200,950);
            escenario.setScene(escenaFaseInicial);
            escenario.setResizable(true);
            Audio.reproducirClick();
        }
    }
}

