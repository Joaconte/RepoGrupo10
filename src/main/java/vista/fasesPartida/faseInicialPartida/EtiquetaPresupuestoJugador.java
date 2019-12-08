package vista.fasesPartida.faseInicialPartida;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import modelo.Juego;

public class EtiquetaPresupuestoJugador extends Label{

    private Juego juego;

    public EtiquetaPresupuestoJugador(Juego juego){
        super();
        this.juego = juego;
        this.setFont(new Font( "Arial", 25));
        this.setTextFill(Color.web("FFB900"));
        actualizarEtiqueta();
        this.setMinWidth(390);
        this.setAlignment(Pos.CENTER);
        this.setStyle("-fx-background-color: gray;");
    }

    public void actualizarEtiqueta(){
        this.setTextFill(Color.web("FFB900"));
        this.setText("Puntos : " + juego.getPuntosJugadorEnTurno());
    }

    public void actualizarEtiqueta(String texto,String color){
        this.setText(texto);
        this.setTextFill(Color.web(color));

    }
}