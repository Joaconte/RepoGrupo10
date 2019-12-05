package controlador;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import modelo.partida.JugadorNoPuedeManipularEsaPiezaException;
import modelo.pieza.Pieza;
import modelo.pieza.tipos.NoSirvenParaBatallonException;
import vista.VistaDeTablero;
import vista.vistaPiezas.VistaUnidad;

import java.util.ArrayList;

public class ClickEnPiezaModoCrearBatallonEventHandler implements EventHandler<MouseEvent> {

    private VBox vistaUnidadClickeada;
    private VistaUnidad nuevoCandidato;
    private ArrayList<Pieza> batallon;
    private VistaDeTablero vistaDeTablero;

    public ClickEnPiezaModoCrearBatallonEventHandler(VBox vistaUnidadClikeada, VistaUnidad p, ArrayList<Pieza> piezas, VistaDeTablero vistaDeTablero) {
        this.batallon = piezas;
        this.nuevoCandidato = p;
        this.vistaUnidadClickeada = vistaUnidadClikeada;
        this.vistaDeTablero = vistaDeTablero;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        if (batallon.size()==2){
            //TODO
            batallon.add(nuevoCandidato.getPieza());
            vistaUnidadClickeada.getChildren().clear();
            vistaUnidadClickeada.getChildren().add(nuevoCandidato.getVistaInformacion());
            try {
                nuevoCandidato.getJuego().formarBatallon(batallon);
                nuevoCandidato.setEtiquetaDeTexto("Batallon Creado.");
                vistaDeTablero.tableroNormal();
            } catch (NoSirvenParaBatallonException | JugadorNoPuedeManipularEsaPiezaException e) {
                vistaDeTablero.tableroNormal();
                nuevoCandidato.setEtiquetaDeTexto("Piezas incompatibles a batallon.");
            }
        }
        else {
            vistaUnidadClickeada.getChildren().clear();
            vistaUnidadClickeada.getChildren().add(nuevoCandidato.getVistaInformacion());
            nuevoCandidato.setEtiquetaDeTexto("Elije a otra pieza mas.");
            batallon.add(nuevoCandidato.getPieza());
            vistaDeTablero.tableroEnModoArmarBatallon(batallon);
        }
    }
}
