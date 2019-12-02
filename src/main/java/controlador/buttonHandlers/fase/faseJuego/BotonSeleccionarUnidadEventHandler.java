package controlador.buttonHandlers.fase.faseJuego;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import modelo.Juego;
import modelo.pieza.Pieza;
import modelo.pieza.Ubicacion;
import modelo.tablero.casilla.NoHayUnidadEnPosicionException;

import java.nio.file.attribute.PosixFileAttributes;

public class BotonSeleccionarUnidadEventHandler implements EventHandler<ActionEvent> {

    private Ubicacion ubicacionVariable;
    private Ubicacion ubicacionEstatica;
    private Label comunicadoTexto;
    private Juego juego;

    public BotonSeleccionarUnidadEventHandler(Ubicacion ubicacionVariable, Ubicacion ubicacionEstatica, Juego juego, Label etiquetaAlertas){

        this.ubicacionVariable = ubicacionVariable;
        this.ubicacionEstatica = ubicacionEstatica;
        comunicadoTexto = etiquetaAlertas;
        this.juego = juego;
    }

    @Override
    public void handle(ActionEvent event){

        int posX = ubicacionVariable.getPosicionEnX();
        int posY = ubicacionVariable.getPosicionEnY();

        ubicacionEstatica.setPosicionEnX(posX);
        ubicacionEstatica.setPosicionEnY(posY);

        try {
            Pieza unidad = juego.getUnidad(posX, posY);
            String vida = Double.toString(unidad.getPuntosVida());
            this.comunicadoTexto.setText("Tiene "+ vida + " puntos de vida" );
            this.comunicadoTexto.setTextFill(Color.web("#000000"));

        }
        catch ( NoHayUnidadEnPosicionException e){

            this.comunicadoTexto.setText(e.getMessage());
            this.comunicadoTexto.setTextFill(Color.web("#FF0000"));
        }

    }

}
