package vista.fasesPartida.faseMediaPartida.botonesFaseMedia;

import controlador.buttonHandlers.accionDeTurno.BotonAtacarEventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modelo.Juego;
import modelo.pieza.ataque.PiezaAtacante;
import vista.VistaDeTablero;

public class BotonAtacar extends Button {

    public BotonAtacar(PiezaAtacante piezaAtacante,  VistaDeTablero vistaDeTablero, VBox barraDeOpcionesDeUnidad){
        super("Atacar");
        this.setMinWidth(140);
        this.setOnAction(new BotonAtacarEventHandler(piezaAtacante, vistaDeTablero, barraDeOpcionesDeUnidad));

    }

}
