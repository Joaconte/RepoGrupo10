package controlador.buttonHandlers.agregarPiezasEventHandlers;


import javafx.scene.control.Label;
import modelo.pieza.Pieza;
import modelo.pieza.Ubicacion;
import modelo.pieza.tipos.Infanteria;
import vista.VistaDeTablero;
import vista.fasesPartida.faseInicialPartida.EtiquetaPresupuestoJugador;
import vista.vistaPiezas.VistaInfanteria;

public class BotonAgregarInfanteriaEventHandler extends BotonAgregarPiezaEventHandler{

    public BotonAgregarInfanteriaEventHandler(Ubicacion ubicacion, VistaDeTablero vistaDeTablero, EtiquetaPresupuestoJugador etiquetaPuntos, Label etiquteComunicadora) {

        super(ubicacion, vistaDeTablero, etiquetaPuntos, "Infanteria",etiquteComunicadora);

    }

    @Override
    void agregarPiezaATablero(Pieza pieza) {
        VistaInfanteria VistaDeUnidad = new VistaInfanteria((Infanteria) pieza ,vistaDeTablero);
    }
}

