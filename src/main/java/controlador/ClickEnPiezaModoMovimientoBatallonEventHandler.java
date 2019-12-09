package controlador;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import modelo.Juego;
import modelo.jugador.UbicacionInvalidaException;
import modelo.partida.JugadorNoPuedeManipularEsaPiezaException;
import modelo.partida.fase.JugadorYaRealizoLaAccionException;
import modelo.partida.fase.PiezaYaMovioException;
import modelo.pieza.tipos.Infanteria;
import modelo.pieza.tipos.NoHayBatallonException;
import modelo.pieza.tipos.NoSePuedeMoverException;
import modelo.tablero.DesplazamientoInvalidoException;
import resources.sonidos.Audio;
import vista.VistaDeTablero;
import vista.fasesPartida.faseMediaPartida.VistaPiezaClikeada;
import vista.vistaPiezas.VistaUnidad;

public class ClickEnPiezaModoMovimientoBatallonEventHandler implements EventHandler<MouseEvent> {
    private VistaDeTablero vistaDeTablero;
    private Juego juego;
    private int ubicacionFinalX;
    private int ubicacionFinalY;
    private VistaUnidad vistaDeUnidad;
    private VistaPiezaClikeada vistaUnidadClikeada;

    public ClickEnPiezaModoMovimientoBatallonEventHandler(VistaPiezaClikeada  vistaUnidadClikeada, int i, int j, VistaDeTablero vistaDeTablero, VistaUnidad vistaUnidad) {
        this.ubicacionFinalX = i;
        this.ubicacionFinalY = j;
        this.vistaDeTablero = vistaDeTablero;
        this.vistaDeUnidad =vistaUnidad;
        this.vistaUnidadClikeada=vistaUnidadClikeada;
        this.juego = vistaUnidad.getJuego();

    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        vistaDeUnidad.barraDeOpcionesNoVisible();
        vistaUnidadClikeada.vistaActualizada(vistaDeUnidad);
        try {
            juego.moverBatallon((Infanteria) vistaDeUnidad.getPieza(),ubicacionFinalX,ubicacionFinalY);
            vistaDeTablero.actualizarUbicaciones();
            vistaUnidadClikeada.vistaMensaje("Batallon Movido.");
            Audio.reproducirMovimientoAPie();

        } catch (DesplazamientoInvalidoException | NoSePuedeMoverException | NoHayBatallonException | JugadorNoPuedeManipularEsaPiezaException | JugadorYaRealizoLaAccionException | UbicacionInvalidaException | PiezaYaMovioException j) {
            vistaUnidadClikeada.vistaAlerta(j.getMessage()); }
        finally {
            vistaDeTablero.tableroFaseMediaNormalizado();
            vistaDeTablero.restablecerTableroMovimiento();
        }

    }
}
