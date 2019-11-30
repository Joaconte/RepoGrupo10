package controlador.buttonHandlers.agregarPiezasEventHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import modelo.pieza.Pieza;
import modelo.pieza.tipos.Catapulta;
import vista.VistaDeTablero;
import vista.VistaDeUnidad;
import vista.faseInicial.EtiquetaPuntosJugador;

public class BotonAgregarCatapultaEventHandler extends BotonAgregarPiezaEventHandler {

    public BotonAgregarCatapultaEventHandler(TextField textoUno, TextField textoDos, Label etiquetaUno, VistaDeTablero vistaDeTablero, EtiquetaPuntosJugador etiquetaPuntos) {

        super.initialize( textoUno, textoDos, etiquetaUno, vistaDeTablero, etiquetaPuntos);

    }


    @Override
    public void crearPiezaYAgregarATablero(int x, int y, VistaDeTablero vistaDeTablero) {

        Pieza pieza = new Catapulta(1, x, y);
        etiquetaPuntos.juego.agregarPieza(pieza);
        VistaDeUnidad vistaDeUnidad = new VistaDeUnidad(vistaDeTablero, pieza, "catapulta");

    }
}
