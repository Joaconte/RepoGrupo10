package controlador.buttonHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.Juego;
import modelo.pieza.Pieza;
import modelo.pieza.tipos.Infanteria;
import modelo.tablero.Tablero;
import vista.VistaDeTablero;
import vista.VistaDeUnidad;

public class BotonIniciarPartidaEventHandler implements EventHandler<ActionEvent> {

    private Juego juego;
    private VBox vbox;
    private Stage stage;

    public BotonIniciarPartidaEventHandler(Juego juego, VBox vbox, Stage stage) {

        this.juego = juego;
        this.vbox = vbox;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        juego.arrancarPartida();
        vbox.getChildren().clear();

        VistaDeTablero vistaDeTablero = new VistaDeTablero(juego.getTablero());
        vbox.getChildren().add(vistaDeTablero);
        agregarUnidad(vistaDeTablero, juego.getTablero());

    }

    public void agregarUnidad( VistaDeTablero vistaDeTablero, Tablero tablero ){

        Pieza unidad = new Infanteria(1,0,0);
        tablero.agregarPieza(unidad);
        VistaDeUnidad vistaDeUnidad = new VistaDeUnidad(vistaDeTablero, unidad);
        tablero.addObserver(vistaDeUnidad);


    }
}
