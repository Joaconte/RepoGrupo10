package vista;

import controlador.buttonHandlers.BotonAgregarJugadorEventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import modelo.Juego;

public class BotonAgregarJugadores extends Button {

    public BotonAgregarJugadores(CamposDeTexto camposDeTexto, Juego juego, VBox vbox){
        super();
        this.setMinHeight(20);
        this.setText( "Agregar Jugadores " );
        this.setOnAction(new BotonAgregarJugadorEventHandler( camposDeTexto.textoUno, camposDeTexto.textoDos,
                camposDeTexto.etiquetaUno ,camposDeTexto.etiquetaDos, juego, vbox));
    }
}
