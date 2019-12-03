package controlador.buttonHandlers.accionDeTurno;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import modelo.Juego;
import modelo.jugador.EjercitoIncompletoException;
import vista.VistaDeTablero;
import vista.fasesPartida.faseMediaPartida.BarraDeJugador;
import vista.fasesPartida.faseMediaPartida.botonesFaseMedia.PanelBotonesFaseMedia;


public class BotonPasarTurnoEventHandler implements EventHandler<ActionEvent> {

    private Juego juego;
    private PanelBotonesFaseMedia panelBotonesFaseMedia;
    private Label comunicador;
    private  BarraDeJugador barraDeJugador1;
    private  BarraDeJugador barraDeJugador2;
    private  VistaDeTablero vistaDeTablero;

    public BotonPasarTurnoEventHandler(PanelBotonesFaseMedia panelBotonesFaseMedia, Juego juego, Label comunicador, BarraDeJugador barraDeJugador1, BarraDeJugador barraDeJugador2, VistaDeTablero vistaDeTablero) {
        this.panelBotonesFaseMedia = panelBotonesFaseMedia;
        this.juego = juego;
        this.comunicador=comunicador;
        this.barraDeJugador1 = barraDeJugador1;
        this.barraDeJugador2= barraDeJugador2;
        this.vistaDeTablero = vistaDeTablero;
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            juego.cambiarTurno();
            panelBotonesFaseMedia.modificarBloqueoDeBotonAtaque(false);
            panelBotonesFaseMedia.modificarBloqueoDeBotonCura(false);
            panelBotonesFaseMedia.modificarBloqueoDeBotonMover(false);
            barraDeJugador1.invertirEstadoDeshabilitado();
            barraDeJugador2.invertirEstadoDeshabilitado();
            vistaDeTablero.getVistaDePiezaClikeada().getChildren().clear();

            if (juego.getNombreJugadorEnTurno() == juego.getNombreDeJugadorUno()){
                barraDeJugador1.getChildren().addAll(comunicador,vistaDeTablero.getVistaDePiezaClikeada());}
            else barraDeJugador2.getChildren().addAll(comunicador,vistaDeTablero.getVistaDePiezaClikeada());
        } catch (EjercitoIncompletoException e) {
            e.printStackTrace();
        }


    }
}
