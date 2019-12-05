package controlador;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import modelo.Juego;
import modelo.jugador.PiezaNoEsDeJugadorException;
import modelo.jugador.UbicacionInvalidaException;
import modelo.partida.fase.JugadorYaRealizoLaAccionException;
import modelo.pieza.Pieza;
import modelo.pieza.Ubicacion;
import modelo.pieza.movimiento.NoSePuedeMoverException;
import modelo.tablero.DesplazamientoInvalidoException;
import modelo.tablero.casilla.NoHayUnidadEnPosicionException;
import vista.VistaDeTablero;
import vista.vistaPiezas.VistaUnidad;

public class ClickEnPiezaModoMovimientoEventHandler implements EventHandler<MouseEvent> {

    private Ubicacion ubicacionFinal;
    private Ubicacion ubicacionInicial;
    private Label etiquetaTexto;
    private VistaDeTablero vistaDeTablero;
    private Juego juego;

    public ClickEnPiezaModoMovimientoEventHandler(int i, int j, VistaDeTablero vistaDeTablero, VistaUnidad vistaUnidad, Label etiquetaTexto) {
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
            juego.moverUnidad(ubicacionInicial, ubicacionFinal);
            vistaDeTablero.actualizarUbicacion(ubicacionInicial,ubicacionFinal);
            etiquetaTexto.setText("Se movio correctamente");
            this.etiquetaTexto.setTextFill(Color.web("#000000"));

        } catch (PiezaNoEsDeJugadorException | NoSePuedeMoverException | UbicacionInvalidaException | DesplazamientoInvalidoException | NoHayUnidadEnPosicionException | JugadorYaRealizoLaAccionException j) {
            etiquetaTexto.setText(j.getMessage());
        }

        vistaDeTablero.tableroNormal();
        vistaDeTablero.restablecerTableroMovimiento();
    }
}

/*
    @Override
    public void handle(MouseEvent mouseEvent) {

        if (movimientosActuales <= MOVIMIENTOS_POR_TURNO) {

}
*/