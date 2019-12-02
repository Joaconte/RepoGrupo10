package controlador.buttonHandlers.fase.faseInicial;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import modelo.Juego;
import modelo.jugador.EjercitoIncompletoException;
import vista.CamposDeTexto;
import vista.VistaDeTablero;
import vista.fases.faseInicial.EtiquetaPuntosJugador;
import vista.fases.faseInicial.EtiquetaTurnoJugador;
import vista.fases.faseJuego.VistaFaseJuego;

public class BotonSiguienteTurnoEventHandler implements EventHandler<ActionEvent> {

    private EtiquetaTurnoJugador etiquetaTurnoJugador;
    private Juego juego;
    private Label comunicadoTexto;
    private EtiquetaPuntosJugador etiquetaPuntosJugador;
    private VBox vbox;
    private HBox hbox;
    private VistaDeTablero vistaDeTablero;

    public BotonSiguienteTurnoEventHandler(EtiquetaTurnoJugador etiquetaTurnoJugador, EtiquetaPuntosJugador etiquetaPuntosJugador, Juego juego, Label etiquetaAlertas, VBox vbox, HBox hbox, VistaDeTablero vistaDeTablero){
        this.etiquetaTurnoJugador = etiquetaTurnoJugador;
        this.juego = juego;
        this.comunicadoTexto = etiquetaAlertas;
        this.etiquetaPuntosJugador = etiquetaPuntosJugador;
        this.vbox = vbox;
        this.hbox = hbox;
        this.vistaDeTablero = vistaDeTablero;
    }


    @Override
    public void handle(ActionEvent event) {
        try{juego.cambiarTurno();
            etiquetaTurnoJugador.actualizarEtiqueta();
            etiquetaPuntosJugador.actualizarEtiqueta();
            comunicadoTexto.setText("Nuevo Turno iniciado");
            comunicadoTexto.setTextFill(Color.web("#336600"));
            if (juego.seEncuentraEnFaseDeJuego()){
                vbox.getChildren().clear();
                VistaFaseJuego faseJuego= new VistaFaseJuego(juego, hbox, vistaDeTablero);
            }
        }
        catch (EjercitoIncompletoException e){
            comunicadoTexto.setText("Tus tropas deben estar completas");
            comunicadoTexto.setTextFill(Color.web("#FF0000"));
        }
    }
}
