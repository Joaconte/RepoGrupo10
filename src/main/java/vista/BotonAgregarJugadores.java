package vista;

import controlador.buttonHandlers.BotonAgregarJugadorEventHandler;
import javafx.scene.control.Button;
import modelo.Juego;

public class BotonAgregarJugadores extends Button {

    public BotonAgregarJugadores(CamposDeTexto camposDeTexto, Juego juego){
        super();
        this.setMinHeight(20);
        this.setText( "Agregar Jugadores " );
        this.setOnAction(new BotonAgregarJugadorEventHandler( camposDeTexto.textoUno, camposDeTexto.textoDos,
                camposDeTexto.etiquetaUno ,camposDeTexto.etiquetaDos, juego));
    }
}
