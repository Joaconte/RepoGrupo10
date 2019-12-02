package vista.fasesPartida.faseMediaPartida;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import modelo.Juego;
import vista.VistaDeTablero;
import vista.fasesPartida.faseMediaPartida.botonesFaseMedia.PanelBotonesFaseMedia;

public class PantallaFaseMediaPartida extends BorderPane {

    private BarraDeJugador barraDeJugador1;
    private BarraDeJugador barraDeJugador2;
    private Label comunicador;

    public PantallaFaseMediaPartida(VistaDeTablero vistaDeTablero, Juego juego, Stage escenarioPrincipal){
        this.setPadding(new Insets(20));
        this.setCenter(vistaDeTablero);
        this.comunicador = new Label("Seleccione la accion que desea realizar.");
        this.barraDeJugador1 = new BarraDeJugador(juego.getNombreDeJugadorUno());
        barraDeJugador1.getChildren().add(comunicador);
        barraDeJugador1.getChildren().addAll(vistaDeTablero.getUbicacionDelCursor().textoUno,vistaDeTablero.getUbicacionDelCursor().textoDos);
        barraDeJugador1.getChildren().add(vistaDeTablero.getVistaDePiezaClikeada());
        this.barraDeJugador2 = new BarraDeJugador(juego.getNombreDeJugadorDos());
        this.setLeft(barraDeJugador1);
        this.setRight(barraDeJugador2);
        barraDeJugador2.setDisable(true);

        this.setTop(new PanelBotonesFaseMedia(barraDeJugador1, barraDeJugador2,juego,comunicador,vistaDeTablero));
    }
}
