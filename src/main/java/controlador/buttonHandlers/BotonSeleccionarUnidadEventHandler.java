package controlador.buttonHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import modelo.Juego;
import modelo.pieza.Pieza;
import modelo.pieza.Ubicacion;
import modelo.tablero.casilla.NoHayUnidadEnPosicionException;
import vista.CamposDeTexto;

public class BotonSeleccionarUnidadEventHandler implements EventHandler<ActionEvent> {

    private Ubicacion ubicacion;
    private Label comunicadoTexto;
    private Juego juego;

    public BotonSeleccionarUnidadEventHandler(Ubicacion ubicacion, Juego juego, Label etiquetaAlertas){

        this.ubicacion = ubicacion;
        comunicadoTexto = etiquetaAlertas;
        this.juego = juego;
    }

    @Override
    public void handle(ActionEvent event){

        try {
            Pieza unidad = juego.getUnidad(ubicacion.getPosicionEnX(), ubicacion.getPosicionEnY());
            String vida = Double.toString(unidad.getPuntosVida());
            this.comunicadoTexto.setText("Tiene "+ vida + " puntos de vida" );
            this.comunicadoTexto.setTextFill(Color.web("#000000"));

        }
        catch ( NoHayUnidadEnPosicionException e){

            this.comunicadoTexto.setText("No estas seleccionando ninguna unidad");
            this.comunicadoTexto.setTextFill(Color.web("#FF0000"));
        }

    }

}
