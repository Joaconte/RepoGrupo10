package vista.fasesPartida.faseMediaPartida.botonesFaseMedia;

import controlador.buttonHandlers.accionDeTurno.BotonAtacarEventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import modelo.Juego;
import modelo.pieza.ataque.PiezaAtacante;
import vista.VistaDeTablero;

public class BotonAtacar extends Button {

    public BotonAtacar(PiezaAtacante piezaAtacante,  VistaDeTablero vistaDeTablero, HBox barraDeOpcionesDeUnidad){
        super("Atacar");
        this.setOnAction(new BotonAtacarEventHandler(piezaAtacante, vistaDeTablero, barraDeOpcionesDeUnidad));

    }

}
