package controlador;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import modelo.Juego;
import modelo.jugador.PiezaNoEsDeJugadorException;
import modelo.jugador.UbicacionInvalidaException;
import modelo.partida.JugadorNoPuedeManipularEsaPiezaException;
import modelo.partida.fase.JugadorYaRealizoLaAccionException;
import modelo.partida.fase.PiezaYaMovioException;
import modelo.pieza.Ubicacion;
import modelo.pieza.tipos.NoHayBatallonException;
import modelo.pieza.tipos.NoSePuedeMoverException;
import modelo.tablero.DesplazamientoInvalidoException;
import modelo.tablero.casilla.NoHayUnidadEnPosicionException;
import resources.sonidos.Audio;
import vista.VistaDeTablero;
import vista.vistaPiezas.VistaUnidad;

public class ClickEnPiezaModoMovimientoBatallonEventHandler implements EventHandler<MouseEvent> {
    private Ubicacion ubicacionFinal;
    private Ubicacion ubicacionInicial;
    private Label etiquetaTexto;
    private VistaDeTablero vistaDeTablero;
    private Juego juego;

    public ClickEnPiezaModoMovimientoBatallonEventHandler(int i, int j, VistaDeTablero vistaDeTablero, VistaUnidad vistaUnidad, Label etiquetaTexto) {
        this.ubicacionFinal = new Ubicacion(i,j);
        this.ubicacionInicial = vistaUnidad.getPieza().getUbicacion();
        this.vistaDeTablero = vistaDeTablero;
        this.etiquetaTexto= etiquetaTexto;
        this.juego = vistaUnidad.getJuego();

    }

    @Override
    public void handle(MouseEvent mouseEvent) {

        this.etiquetaTexto.setTextFill(Color.web("#FF0000"));
        try {
            juego.moverBatallon(ubicacionInicial, ubicacionFinal);
            vistaDeTablero.actualizarUbicaciones();
            etiquetaTexto.setText("Batallon movido");
            this.etiquetaTexto.setTextFill(Color.web("#000000"));
            Audio.reproducirMovimientoAPie();

        } catch (NoHayBatallonException | JugadorNoPuedeManipularEsaPiezaException | JugadorYaRealizoLaAccionException | UbicacionInvalidaException j) {
            etiquetaTexto.setText(j.getMessage());
            vistaDeTablero.tableroNormal();
        }
        vistaDeTablero.tableroNormal();
        vistaDeTablero.restablecerTableroMovimiento();
    }
}
