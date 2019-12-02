package vista.fasesPartida;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import modelo.Juego;

public class EtiquetaTurnoJugador {

    public Label etiqueta;
    public Juego juego;

    public EtiquetaTurnoJugador( Juego juego ){

        etiqueta = new Label();
        this.juego = juego;
        etiqueta.setFont(new Font( "Arial", 25));
        etiqueta.setTextFill(Color.web("FF821F"));
        actualizarEtiqueta();
    }

    public void actualizarEtiqueta(){

        etiqueta.setText("Turno de " + juego.getNombreJugadorEnTurno());
    }

}

