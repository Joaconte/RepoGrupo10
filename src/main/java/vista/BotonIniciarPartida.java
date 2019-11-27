package vista;

import controlador.buttonHandlers.BotonAgregarJugadorEventHandler;
import controlador.buttonHandlers.BotonIniciarPartidaEventHandler;
import javafx.scene.control.Button;
import modelo.Juego;

public class BotonIniciarPartida extends Button {

    public BotonIniciarPartida(Juego juego){
        super();
        this.setMinHeight(20);
        this.setText( "Iniciar partida" );
        this.setOnAction(new BotonIniciarPartidaEventHandler( juego ));
    }
}
