package vista.faseBienvenida;

import controlador.buttonHandlers.BotonAgregarJugadorEventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import modelo.Juego;

public class BotonAgregarJugadores extends Button {

    public BotonAgregarJugadores(Juego juego,MenuCargaJugadores menu, Stage stage){
        super();
        this.setMinHeight(20);
        this.setText( "Agregar Jugadores " );
        this.setOnAction(new BotonAgregarJugadorEventHandler(juego, menu, stage));
    }
}
