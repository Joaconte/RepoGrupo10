package vista.fasesPartida.faseInicialPartida;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import modelo.Juego;

public class EtiquetaPresupuestoJugador {

    public Label etiqueta;
    // deberia ser privado
    public Juego juego;

    public EtiquetaPresupuestoJugador(Juego juego){

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