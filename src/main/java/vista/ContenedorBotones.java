package vista;

import javafx.scene.layout.HBox;
import modelo.Juego;


public class ContenedorBotones extends HBox {

    public ContenedorBotones(CamposDeTexto camposDeTexto, Juego juego){

        super();
        setHeight(20);
        this.getChildren().add( new BotonAgregarJugadores(camposDeTexto, juego ) );
    }

}
