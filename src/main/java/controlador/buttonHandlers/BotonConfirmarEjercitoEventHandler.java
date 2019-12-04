package controlador.buttonHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import modelo.Juego;
import modelo.jugador.EjercitoIncompletoException;
import vista.VistaDeTablero;
import vista.fasesPartida.faseInicialPartida.EtiquetaPresupuestoJugador;
import vista.fasesPartida.EtiquetaTurnoJugador;
import vista.fasesPartida.faseMediaPartida.PantallaFaseMediaPartida;

public class BotonConfirmarEjercitoEventHandler implements EventHandler<ActionEvent> {

    private EtiquetaTurnoJugador etiquetaTurnoJugador;
    private Juego juego;
    private Label comunicadoTexto;
    private EtiquetaPresupuestoJugador etiquetaPresupuestoJugador;
    private VistaDeTablero vistaDeTablero;
    private Stage escenarioPrincipal;

    public BotonConfirmarEjercitoEventHandler(EtiquetaTurnoJugador etiquetaTurnoJugador, EtiquetaPresupuestoJugador etiquetaPresupuestoJugador, Juego juego, Label comunicadoTexto, Stage escenarioPrincipal, VistaDeTablero vistaDeTablero){
        this.etiquetaTurnoJugador = etiquetaTurnoJugador;
        this.juego = juego;
        this.comunicadoTexto = comunicadoTexto;
        this.etiquetaPresupuestoJugador = etiquetaPresupuestoJugador;
        this.vistaDeTablero = vistaDeTablero;
        this.escenarioPrincipal= escenarioPrincipal;

    }


    @Override
    public void handle(ActionEvent event) {
        try{
            juego.cambiarTurno();
            etiquetaTurnoJugador.actualizarEtiqueta();
            etiquetaPresupuestoJugador.actualizarEtiqueta();
            comunicadoTexto.setText(juego.getNombreJugadorEnTurno() + " prepara tus tropas");
            comunicadoTexto.setTextFill(Color.web("#336600"));

            if (!juego.estaEnFaseInicial()){

                PantallaFaseMediaPartida pantallaFaseMediaPartida = new PantallaFaseMediaPartida(vistaDeTablero, juego , escenarioPrincipal);
                ScrollPane panelConBarrasDeMovimiento = new ScrollPane();
                panelConBarrasDeMovimiento.setContent(pantallaFaseMediaPartida);
                Scene escenaFaseInicial = new Scene (panelConBarrasDeMovimiento,1200,950);
                escenarioPrincipal.setScene(escenaFaseInicial);

            }
        }
        catch (EjercitoIncompletoException e){
            comunicadoTexto.setText("Tus tropas deben estar completas");
            comunicadoTexto.setTextFill(Color.web("#FF0000"));
        }
    }
}
