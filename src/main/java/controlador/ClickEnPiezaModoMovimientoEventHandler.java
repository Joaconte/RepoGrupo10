package controlador;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
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
import vista.vistaPiezas.VistaUnidad;

public class ClickEnPiezaModoMovimientoEventHandler implements EventHandler<MouseEvent> {

    private  int ubicacionFinalX;
    private  int ubicacionFinalY;
    private Label etiquetaTexto;
    private VistaDeTablero vistaDeTablero;
    private Juego juego;
    private VistaUnidad vistaDeUnidad;

    public ClickEnPiezaModoMovimientoEventHandler(int i, int j, VistaDeTablero vistaDeTablero, VistaUnidad vistaUnidad, Label etiquetaTexto) {
        this.ubicacionFinalX = i;
        this.ubicacionFinalY=j;
        this.vistaDeTablero = vistaDeTablero;
        this.etiquetaTexto= etiquetaTexto;
        this.juego = vistaUnidad.getJuego();
        this.vistaDeUnidad=vistaUnidad;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {


        this.etiquetaTexto.setTextFill(Color.web("#FF0000"));
        try {
            juego.moverUnidad(vistaDeUnidad.getPieza() ,ubicacionFinalX, ubicacionFinalY);
            vistaDeTablero.actualizarUbicaciones();
            etiquetaTexto.setText("Se movio correctamente");
            this.etiquetaTexto.setTextFill(Color.web("#000000"));
            Audio.reproducirMovimientoAPie();


       } catch (NoSePuedeMoverException | NoHayUnidadEnPosicionException | DesplazamientoInvalidoException e) {
            etiquetaTexto.setText(e.getMessage());
        } catch (UbicacionInvalidaException | JugadorYaRealizoLaAccionException | PiezaYaMovioException e) {
            etiquetaTexto.setText(e.getMessage());
        } catch (JugadorNoPuedeManipularEsaPiezaException e) {
            e.printStackTrace();
        }
        vistaDeTablero.tableroNormal();
        vistaDeTablero.restablecerTableroMovimiento();
    }
}