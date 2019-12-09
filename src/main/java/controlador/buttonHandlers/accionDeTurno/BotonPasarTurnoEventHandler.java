package controlador.buttonHandlers.accionDeTurno;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.Juego;
import modelo.jugador.EjercitoIncompletoException;
import resources.sonidos.Audio;
import vista.VistaDeTablero;
import vista.fasesPartida.faseMediaPartida.PantallaFaseMediaPartida;


public class BotonPasarTurnoEventHandler implements EventHandler<ActionEvent> {

    private Juego juego;
    private  VistaDeTablero vistaDeTablero;
    private PantallaFaseMediaPartida vistaFaseMedia;

    public BotonPasarTurnoEventHandler(Juego juego, PantallaFaseMediaPartida vistaFaseMedia , VistaDeTablero vistaDeTablero) {
        this.juego = juego;
        this.vistaDeTablero = vistaDeTablero;
        this.vistaFaseMedia=vistaFaseMedia;
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            juego.cambiarTurno();
            vistaFaseMedia.vistaNuevoTurno();
            vistaDeTablero.vistaNuevaAccionTurno();
            Audio.reproducirInterfaz("switch");

        } catch (EjercitoIncompletoException e) {
            vistaFaseMedia.vistaAlertas("Error de carga de Ejercito");
        }


    }
}
