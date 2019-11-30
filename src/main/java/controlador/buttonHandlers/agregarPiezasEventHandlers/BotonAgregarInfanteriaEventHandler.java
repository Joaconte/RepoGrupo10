package controlador.buttonHandlers.agregarPiezasEventHandlers;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import modelo.pieza.Pieza;
import modelo.pieza.tipos.Infanteria;
import vista.VistaDeTablero;
import vista.VistaDeUnidad;
import vista.faseInicial.EtiquetaPuntosJugador;

public class BotonAgregarInfanteriaEventHandler extends BotonAgregarPiezaEventHandler{

    public BotonAgregarInfanteriaEventHandler(TextField textoUno, TextField textoDos, Label etiquetaUno, VistaDeTablero vistaDeTablero, EtiquetaPuntosJugador etiquetaPuntos) {

        super.initialize( textoUno, textoDos, etiquetaUno, vistaDeTablero, etiquetaPuntos);

    }

    @Override
    public void crearPiezaYAgregarATablero(int x, int y, VistaDeTablero vistaDeTablero) {

        Pieza pieza = new Infanteria(1, x, y);
        etiquetaPuntos.juego.agregarPieza(pieza);
        VistaDeUnidad vistaDeUnidad = new VistaDeUnidad(vistaDeTablero, pieza, "infanteria");

    }
}
