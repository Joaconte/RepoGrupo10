package controlador.buttonHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import modelo.Juego;
import modelo.pieza.Pieza;
import modelo.tablero.casilla.NoHayUnidadEnPosicionException;
import vista.CamposDeTexto;

public class BotonSeleccionarUnidadEventHandler implements EventHandler<ActionEvent> {

    private TextField textFieldUno;
    private TextField textFieldDos;
    private Label comunicadoTexto;
    private Juego juego;

    public BotonSeleccionarUnidadEventHandler(CamposDeTexto camposDeTexto, Juego juego){

        textFieldUno = camposDeTexto.textoUno;
        textFieldDos = camposDeTexto.textoDos;
        comunicadoTexto = camposDeTexto.etiquetaUno;
        this.juego = juego;

    }

    @Override
    public void handle(ActionEvent event){

        String sX = this.textFieldUno.getText();
        String sY = this.textFieldDos.getText();
        int x = Integer.parseInt(sX);
        int y = Integer.parseInt(sY);

        try {
            Pieza unidad = juego.getUnidad(x, y);
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
