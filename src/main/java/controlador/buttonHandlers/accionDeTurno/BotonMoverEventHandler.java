package controlador.buttonHandlers.accionDeTurno;

import controlador.ClickEnZonaEventHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import modelo.Juego;
import modelo.jugador.PiezaNoEsDeJugadorException;
import modelo.pieza.Ubicacion;
import modelo.pieza.movimiento.NoSePuedeMoverException;
import modelo.tablero.DesplazamientoInvalidoException;
import modelo.tablero.casilla.NoHayUnidadEnPosicionException;

import vista.VistaDeTablero;

public class BotonMoverEventHandler implements EventHandler<ActionEvent> {

    private Ubicacion ubicacion;
    private Label comunicadoTexto;
    private Juego juego;
    private VistaDeTablero vistaDeTablero;

    public BotonMoverEventHandler(Ubicacion ubicacion, Juego juego, Label etiquetaAlerta, VistaDeTablero vistaDeTablero) {

        this.ubicacion = ubicacion;
        comunicadoTexto = etiquetaAlerta;
        this.juego = juego;
        this.vistaDeTablero = vistaDeTablero;
    }

    @Override
    public void handle(ActionEvent event) {

        try {

            //vistaDeTablero.moverUnidad( );
            juego.moverUnidad(ubicacion, vistaDeTablero.getUbicacionDelCursor());

            new ClickEnZonaEventHandler(vistaDeTablero.getVistaDePiezaClikeada(), vistaDeTablero.getRectanguloDeMovimiento(),vistaDeTablero.getUbicacionDelCursor());

            this.comunicadoTexto.setText("Moviste la unidad correctamente");
            this.comunicadoTexto.setTextFill(Color.web("#000000"));

        } catch (PiezaNoEsDeJugadorException | DesplazamientoInvalidoException | NoSePuedeMoverException | NoHayUnidadEnPosicionException e) {
            this.comunicadoTexto.setText(e.getMessage());
            this.comunicadoTexto.setTextFill(Color.web("#FF0000"));
        }
    }
}
