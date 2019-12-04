package controlador.buttonHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import modelo.Juego;
import modelo.pieza.ataque.PiezaAtacante;
import vista.VistaDeTablero;


public class BotonAtacarEventHandler implements EventHandler<ActionEvent> {
private Label comunicador;
private VistaDeTablero vistaDeTablero;
private PiezaAtacante piezaAtacante;


    public BotonAtacarEventHandler(PiezaAtacante piezaAtacante, Juego juego, Label comunicador, VistaDeTablero vistaDeTablero){
    this.comunicador = comunicador;
    this.vistaDeTablero = vistaDeTablero;
    this.piezaAtacante = piezaAtacante;
}

    @Override
    public void handle(ActionEvent event) {
        this.comunicador.setText("Haga click a la pieza con la que desea atacar");
        this.comunicador.setTextFill(Color.web("#000000"));
        vistaDeTablero.tableroEnModoAtaque(piezaAtacante);
    }
}
