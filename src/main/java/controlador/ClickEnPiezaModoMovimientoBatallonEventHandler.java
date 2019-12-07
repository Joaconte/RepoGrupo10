package controlador;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import modelo.Juego;
import modelo.jugador.UbicacionInvalidaException;
import modelo.partida.JugadorNoPuedeManipularEsaPiezaException;
import modelo.partida.fase.JugadorYaRealizoLaAccionException;
import modelo.pieza.tipos.Infanteria;
import modelo.pieza.tipos.NoHayBatallonException;
import modelo.pieza.tipos.NoSePuedeMoverException;
import modelo.tablero.DesplazamientoInvalidoException;
import resources.sonidos.Audio;
import vista.VistaDeTablero;
import vista.vistaPiezas.VistaUnidad;

public class ClickEnPiezaModoMovimientoBatallonEventHandler implements EventHandler<MouseEvent> {
    private Label etiquetaTexto;
    private VistaDeTablero vistaDeTablero;
    private Juego juego;
    private int ubicacionFinalX;
    private int ubicacionFinalY;
    private VistaUnidad vistaDeUnidad;

    public ClickEnPiezaModoMovimientoBatallonEventHandler(int i, int j, VistaDeTablero vistaDeTablero, VistaUnidad vistaUnidad, Label etiquetaTexto) {
        this.ubicacionFinalX = i;
        this.ubicacionFinalY = j;
        this.vistaDeTablero = vistaDeTablero;
        this.vistaDeUnidad =vistaUnidad;
        this.etiquetaTexto= etiquetaTexto;
        this.juego = vistaUnidad.getJuego();

    }

    @Override
    public void handle(MouseEvent mouseEvent) {

        this.etiquetaTexto.setTextFill(Color.web("#FF0000"));
        try {
            juego.moverBatallon((Infanteria) vistaDeUnidad.getPieza(),ubicacionFinalX,ubicacionFinalY);
            vistaDeTablero.actualizarUbicaciones();
            etiquetaTexto.setText("Batallon movido");
            this.etiquetaTexto.setTextFill(Color.web("#000000"));
            Audio.reproducirMovimientoAPie();

        } catch (NoHayBatallonException | JugadorNoPuedeManipularEsaPiezaException | JugadorYaRealizoLaAccionException | UbicacionInvalidaException j) {
            etiquetaTexto.setText(j.getMessage());
            vistaDeTablero.tableroNormal();
        } catch (DesplazamientoInvalidoException e) {
            e.printStackTrace();
        } catch (NoSePuedeMoverException e) {
            e.printStackTrace();
        }
        vistaDeTablero.tableroNormal();
        vistaDeTablero.restablecerTableroMovimiento();
    }
}
