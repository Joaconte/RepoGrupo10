package controlador.buttonHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import modelo.Juego;
import modelo.jugador.EjercitoIncompletoException;
import vista.CamposDeTexto;
import vista.fasePartida.faseInicialPartida.EtiquetaPuntosJugador;
import vista.fasePartida.EtiquetaTurnoJugador;

public class BotonConfirmarEjercitoEventHandler implements EventHandler<ActionEvent> {

    private EtiquetaTurnoJugador etiquetaTurnoJugador;
    private Juego juego;
    private Label comunicadoTexto;
    private EtiquetaPuntosJugador etiquetaPuntosJugador;

    public BotonConfirmarEjercitoEventHandler(EtiquetaTurnoJugador etiquetaTurnoJugador, EtiquetaPuntosJugador etiquetaPuntosJugador, Juego juego, CamposDeTexto camposDeTexto, Stage escenarioPrincipal){
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
            comunicadoTexto.setText(juego.getNombreJugadorEnTurno() + " prepara tus tropas");
            comunicadoTexto.setTextFill(Color.web("#336600"));
            if (!juego.estaEnFaseInicial()){

            }
        }
        catch (EjercitoIncompletoException e){
            comunicadoTexto.setText("Tus tropas deben estar completas");
            comunicadoTexto.setTextFill(Color.web("#FF0000"));
        }
    }
}
