package controlador.buttonHandlers.agregarPiezasEventHandlers;


import javafx.scene.control.Label;
import modelo.pieza.Pieza;
import modelo.pieza.tipos.Infanteria;
import vista.VistaDeTablero;
import vista.fasesPartida.faseInicialPartida.EtiquetaPresupuestoJugador;
import vista.vistaPiezas.VistaUnidadInfanteria;

public class BotonAgregarInfanteriaEventHandler extends BotonAgregarPiezaEventHandler{

    public BotonAgregarInfanteriaEventHandler( VistaDeTablero vistaDeTablero, EtiquetaPresupuestoJugador etiquetaPuntos, Label etiquteComunicadora) {

        super( vistaDeTablero, etiquetaPuntos, "Infanteria",etiquteComunicadora);

    }

    @Override
    void agregarPiezaATablero(Pieza pieza) {
        VistaUnidadInfanteria vistaDeUnidad = new VistaUnidadInfanteria((Infanteria) pieza ,vistaDeTablero,"infanteria",etiquetaPuntos.juego);
        vistaDeUnidad.crearVistaEnTablero();
    }
}

