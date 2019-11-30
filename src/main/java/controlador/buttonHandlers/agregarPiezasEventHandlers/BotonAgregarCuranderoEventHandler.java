package controlador.buttonHandlers.agregarPiezasEventHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import modelo.pieza.Pieza;
import modelo.pieza.tipos.Curandero;
import vista.VistaDeTablero;
import vista.VistaDeUnidad;

public class BotonAgregarCuranderoEventHandler extends BotonAgregarPiezaEventHandler implements EventHandler<ActionEvent> {

    public BotonAgregarCuranderoEventHandler(TextField textoUno, TextField textoDos, Label etiquetaUno, VistaDeTablero vistaDeTablero) {

        super.initialize( textoUno, textoDos, etiquetaUno, vistaDeTablero);

    }

    @Override
    public void crearPiezaYAgregarATablero(int x, int y, VistaDeTablero vistaDeTablero) {

        Pieza pieza = new Curandero(1, x, y);
        vistaDeTablero.getTablero().agregarPieza(pieza);
        VistaDeUnidad vistaDeUnidad = new VistaDeUnidad(vistaDeTablero, pieza, "curandero");

    }

}
