package vista.fasesPartida.faseMediaPartida.botonesFaseMedia;

import controlador.buttonHandlers.BotonAtacarEventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import modelo.Juego;
import vista.VistaDeTablero;
import vista.fasesPartida.faseMediaPartida.BarraDeJugador;

public class BotonAtacar extends Button {

    public BotonAtacar(PanelBotonesFaseMedia panelBotonesFaseMedia, Juego juego, Label comunicador, BarraDeJugador barraDeJugador1, BarraDeJugador barraDeJugador2, VistaDeTablero vistaDeTablero){
        super("Atacar");
        this.setOnAction(new BotonAtacarEventHandler(panelBotonesFaseMedia, juego, comunicador, barraDeJugador1, barraDeJugador2, vistaDeTablero));

    }

}
