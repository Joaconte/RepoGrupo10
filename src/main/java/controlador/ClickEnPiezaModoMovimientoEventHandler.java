package controlador;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import modelo.Juego;
import modelo.jugador.UbicacionInvalidaException;
import modelo.partida.JugadorNoPuedeManipularEsaPiezaException;
import modelo.partida.fase.JugadorYaRealizoLaAccionException;
import modelo.partida.fase.PiezaYaMovioException;
import modelo.pieza.tipos.NoSePuedeMoverException;
import modelo.tablero.DesplazamientoInvalidoException;
import modelo.tablero.casilla.NoHayUnidadEnPosicionException;
import resources.sonidos.Audio;
import vista.VistaDeTablero;
import vista.VistaPiezaClikeada;
import vista.vistaPiezas.VistaUnidad;

public class ClickEnPiezaModoMovimientoEventHandler implements EventHandler<MouseEvent> {

    private  int ubicacionFinalX;
    private  int ubicacionFinalY;
    private VistaDeTablero vistaDeTablero;
    private Juego juego;
    private VistaUnidad vistaDeUnidad;
    private VistaPiezaClikeada vistaPiezaClikeada;

    public ClickEnPiezaModoMovimientoEventHandler(int i, int j, VistaDeTablero vistaDeTablero, VistaUnidad vistaUnidad, VistaPiezaClikeada vista) {
        this.ubicacionFinalX = i;
        this.ubicacionFinalY=j;
        this.vistaDeTablero = vistaDeTablero;
        this.juego = vistaUnidad.getJuego();
        this.vistaDeUnidad=vistaUnidad;
        this.vistaPiezaClikeada = vista;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        vistaPiezaClikeada.vistaActualizada(vistaDeUnidad.getVistaInformacion());
        try {
            juego.moverUnidad(vistaDeUnidad.getPieza() ,ubicacionFinalX, ubicacionFinalY);
            vistaDeTablero.actualizarUbicaciones();
            vistaPiezaClikeada.vistaMensaje("Movimiento existoso.");
            Audio.reproducirMovimientoAPie();
       } catch (NoSePuedeMoverException | JugadorNoPuedeManipularEsaPiezaException| NoHayUnidadEnPosicionException | DesplazamientoInvalidoException | UbicacionInvalidaException | JugadorYaRealizoLaAccionException | PiezaYaMovioException e) {
            vistaPiezaClikeada.vistaAlerta(e.getMessage());
        }
        finally {
            vistaDeTablero.tableroFaseMediaNormalizado();
            vistaDeTablero.restablecerTableroMovimiento();
        }

    }
}