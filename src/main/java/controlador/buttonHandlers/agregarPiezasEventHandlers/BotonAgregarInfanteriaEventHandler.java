package controlador.buttonHandlers.agregarPiezasEventHandlers;


import javafx.scene.control.Label;
import modelo.Juego;
import modelo.pieza.Pieza;
import modelo.pieza.tipos.Infanteria;
import vista.VistaDeTablero;
import vista.fasesPartida.faseInicialPartida.BarraLateralOpciones;
import vista.fasesPartida.faseInicialPartida.EtiquetaPresupuestoJugador;
import vista.vistaPiezas.VistaUnidadInfanteria;

public class BotonAgregarInfanteriaEventHandler extends BotonAgregarPiezaEventHandler{

    public BotonAgregarInfanteriaEventHandler(VistaDeTablero vistaDeTablero, BarraLateralOpciones vistaLateral, Juego juego) {

        super( vistaDeTablero, "Infanteria",vistaLateral,juego);

    }

    @Override
    void agregarPiezaATablero(Pieza pieza,Juego juego) {
        VistaUnidadInfanteria vistaDeUnidad = new VistaUnidadInfanteria((Infanteria) pieza ,vistaDeTablero,"infanteria",juego);
        vistaDeUnidad.crearVistaEnTablero();
    }
}

