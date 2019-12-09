package vista.fasesPartida.faseInicialPartida;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import modelo.Juego;

public class EtiquetaTurnoJugador extends Label {

    private Juego juego;
    String COLOR1= "0075FF";
    String COLOR2= "FF821F";
    int colorActual=2;

    public EtiquetaTurnoJugador( Juego juego ){
        super();
        this.juego = juego;
        this.setFont(new Font( "Arial", 25));
        actualizarEtiqueta();
        this.setMinWidth(390);
        this.setAlignment(Pos.CENTER);
        this.setStyle("-fx-background-color: gray;");
    }

    public void actualizarEtiqueta(){

        super.setText("Turno de " + juego.getNombreJugadorEnTurno());
        if (colorActual==1) {
            this.setTextFill(Color.web(COLOR2));
            colorActual = 2;
        }else{
            this.setTextFill(Color.web(COLOR1));
            colorActual = 1;
        }
    }

}

