package vista.fasesPartida.faseMediaPartida;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import modelo.Juego;
import resources.sonidos.Audio;
import vista.BarraMenu;
import vista.VistaDeTablero;
import vista.fasesPartida.faseMediaPartida.botonesFaseMedia.BotonPasarTurno;

public class PantallaFaseMediaPartida extends BorderPane {

    private BarraDeJugador barraDeJugador1;
    private BarraDeJugador barraDeJugador2;
    private Label comunicador;

    public PantallaFaseMediaPartida(VistaDeTablero vistaDeTablero, Juego juego, Stage escenarioPrincipal){
        Audio.reproducirJugando();

        this.setPadding(new Insets(20));
        this.setCenter(vistaDeTablero);
        vistaDeTablero.tableroNormal();
        this.comunicador = new Label("Seleccione la accion que desea realizar.");
        this.barraDeJugador1 = new BarraDeJugador(juego.getNombreDeJugadorUno(), 1);
        this.barraDeJugador2 = new BarraDeJugador(juego.getNombreDeJugadorDos(), 2);

        barraDeJugador1.getChildren().add( new BotonPasarTurno(juego,comunicador,barraDeJugador1,barraDeJugador2,vistaDeTablero));
        barraDeJugador2.getChildren().add( new BotonPasarTurno(juego,comunicador,barraDeJugador1,barraDeJugador2,vistaDeTablero));
        barraDeJugador1.getChildren().add(comunicador);
        barraDeJugador1.getChildren().add( vistaDeTablero.getVistaDePiezaClikeada());


        //-------------------------
        this.setLeft(barraDeJugador1);
        this.setRight(barraDeJugador2);
        barraDeJugador2.setDisable(true);
        this.setTop(new BarraMenu(escenarioPrincipal));
    }
}
