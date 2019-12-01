package controlador.buttonHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import modelo.Juego;
import modelo.jugador.EjercitoIncompletoException;
import vista.CamposDeTexto;
import vista.faseInicial.EtiquetaPuntosJugador;
import vista.faseInicial.EtiquetaTurnoJugador;

public class BotonSiguienteTurnoEventHandler implements EventHandler<ActionEvent> {

    private EtiquetaTurnoJugador etiquetaTurnoJugador;
    private Juego juego;
    private Label comunicadoTexto;
    private EtiquetaPuntosJugador etiquetaPuntosJugador;

    public BotonSiguienteTurnoEventHandler(EtiquetaTurnoJugador etiquetaTurnoJugador, EtiquetaPuntosJugador etiquetaPuntosJugador, Juego juego, CamposDeTexto camposDeTexto){
        this.etiquetaTurnoJugador = etiquetaTurnoJugador;
        this.juego = juego;
        this.comunicadoTexto = camposDeTexto.etiquetaUno;
        this.etiquetaPuntosJugador = etiquetaPuntosJugador;
    }


    @Override
    public void handle(ActionEvent event) {
        try{juego.cambiarTurno();
            etiquetaTurnoJugador.actualizarEtiqueta();
            etiquetaPuntosJugador.actualizarEtiqueta();
            comunicadoTexto.setText("Nuevo Turno iniciado");
            comunicadoTexto.setTextFill(Color.web("#336600"));
        }
        catch (EjercitoIncompletoException e){
            comunicadoTexto.setText("Tus tropas deben estar completas");
            comunicadoTexto.setTextFill(Color.web("#FF0000"));
        }
    }
}
