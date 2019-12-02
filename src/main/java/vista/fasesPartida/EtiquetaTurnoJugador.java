package vista.fasesPartida;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import modelo.Juego;

public class EtiquetaTurnoJugador {

    public Label etiqueta;
    public Juego juego;
    String COLOR1= "0075FF";
    String COLOR2= "FF821F";
    int colorActual=2;

    public EtiquetaTurnoJugador( Juego juego ){

        etiqueta = new Label();
        this.juego = juego;
        etiqueta.setFont(new Font( "Arial", 25));
        actualizarEtiqueta();
    }

    public void actualizarEtiqueta(){

        etiqueta.setText("Turno de " + juego.getNombreJugadorEnTurno());
        if (colorActual==1) {
            etiqueta.setTextFill(Color.web(COLOR2));
            colorActual = 2;
        }else{
            etiqueta.setTextFill(Color.web(COLOR1));
            colorActual = 1;
        }
    }

}

