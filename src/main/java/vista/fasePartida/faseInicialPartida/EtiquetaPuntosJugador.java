package vista.fasePartida.faseInicialPartida;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import modelo.Juego;

public class EtiquetaPuntosJugador {

    public Label etiqueta;
    public Juego juego;

    public EtiquetaPuntosJugador(Juego juego){

        etiqueta = new Label();
        this.juego = juego;
        etiqueta.setFont(new Font( "Arial", 25));
        etiqueta.setTextFill(Color.web("FFB900"));
        actualizarEtiqueta();
    }

    public void actualizarEtiqueta(){

        etiqueta.setText("Puntos : " + juego.getPuntosJugadorEnTurno());
    }

}