package controlador;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import modelo.partida.JugadorNoPuedeManipularEsaPiezaException;
import modelo.pieza.Pieza;
import modelo.pieza.tipos.NoSirvenParaBatallonException;
import vista.VistaDeTablero;
import vista.VistaPiezaClikeada;
import vista.vistaPiezas.VistaUnidad;

import java.util.ArrayList;

public class ClickEnPiezaModoCrearBatallonEventHandler implements EventHandler<MouseEvent> {

    private VistaPiezaClikeada  vistaUnidadClickeada;
    private VistaUnidad nuevoCandidato;
    private ArrayList<Pieza> batallon;
    private VistaDeTablero vistaDeTablero;

    public ClickEnPiezaModoCrearBatallonEventHandler(VistaPiezaClikeada vistaUnidadClikeada, VistaUnidad p, ArrayList<Pieza> piezas, VistaDeTablero vistaDeTablero) {
        this.batallon = piezas;
        this.nuevoCandidato = p;
        this.vistaUnidadClickeada = vistaUnidadClikeada;
        this.vistaDeTablero = vistaDeTablero;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        vistaUnidadClickeada.vistaActualizada(nuevoCandidato.getVistaInformacion());
        if (batallon.size()==2){
            batallon.add(nuevoCandidato.getPieza());
            vistaDeTablero.tableroFaseMediaNormalizado();
            try {
                nuevoCandidato.getJuego().formarBatallon(batallon);
                vistaUnidadClickeada.vistaMensaje("Batallon Creado.");
            } catch (NoSirvenParaBatallonException | JugadorNoPuedeManipularEsaPiezaException e) {
                vistaUnidadClickeada.vistaAlerta("Piezas incompatibles a batallon.");
            }
        }
        else {
            vistaUnidadClickeada.vistaMensaje("Elije a otra pieza mas.");
            batallon.add(nuevoCandidato.getPieza());
            vistaDeTablero.tableroEnModoArmarBatallon(batallon);
        }
    }
}
