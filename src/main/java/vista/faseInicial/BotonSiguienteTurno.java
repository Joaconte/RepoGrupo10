package vista.faseInicial;

import controlador.buttonHandlers.BotonSiguienteTurnoEventHandler;
import javafx.scene.control.Button;
import modelo.Juego;
import vista.CamposDeTexto;

public class BotonSiguienteTurno extends Button {
    public  BotonSiguienteTurno(EtiquetaTurnoJugador etiquetaTurnoJugador, EtiquetaPuntosJugador etiquetaPuntosJugador, Juego juego, CamposDeTexto camposDeTexto) {
        super("Termirnar mi turno");
        this.setMinHeight(30);
        this.setOnAction(new BotonSiguienteTurnoEventHandler(etiquetaTurnoJugador, etiquetaPuntosJugador, juego, camposDeTexto));
    }
}
