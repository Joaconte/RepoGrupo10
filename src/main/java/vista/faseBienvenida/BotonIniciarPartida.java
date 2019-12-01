package vista.faseBienvenida;

import controlador.buttonHandlers.BotonAgregarJugadorEventHandler;
import controlador.buttonHandlers.BotonIniciarPartidaEventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.Juego;

public class BotonIniciarPartida extends Button {

    public BotonIniciarPartida(Juego juego, Stage escenarioPrincipal){
        super();
        this.setMinHeight(20);
        this.setText( "Iniciar partida" );
        this.setOnAction(new BotonIniciarPartidaEventHandler( juego, escenarioPrincipal ));
    }
}
