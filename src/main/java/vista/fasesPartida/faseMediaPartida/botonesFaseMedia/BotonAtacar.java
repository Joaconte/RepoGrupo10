package vista.fasesPartida.faseMediaPartida.botonesFaseMedia;

import controlador.buttonHandlers.BotonAtacarEventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import modelo.Juego;
import modelo.pieza.ataque.PiezaAtacante;
import vista.VistaDeTablero;

public class BotonAtacar extends Button {

    public BotonAtacar(PiezaAtacante piezaAtacante, Juego juego, Label comunicador, VistaDeTablero vistaDeTablero){
        super("Atacar");
        this.setOnAction(new BotonAtacarEventHandler(piezaAtacante, juego, comunicador, vistaDeTablero));

    }

}
