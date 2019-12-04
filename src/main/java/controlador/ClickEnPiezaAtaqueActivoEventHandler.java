package controlador;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import modelo.partida.JugadorNoPuedeManipularEsaPiezaException;
import modelo.pieza.UnidadEstaMuertaException;
import modelo.pieza.ataque.DistanciaDeAtaqueInvalidaException;
import modelo.pieza.ataque.PiezaAliadaNoAtacableException;
import modelo.pieza.ataque.PiezaAtacante;
import vista.VistaDeTablero;
import vista.vistaPiezas.VistaUnidad;

public class ClickEnPiezaAtaqueActivoEventHandler implements EventHandler<MouseEvent> {
    private VBox vistaPiezaClikeada;
    private VistaUnidad piezaClikeada;
    private PiezaAtacante piezaAtacante;
    private VistaDeTablero vistaDeTablero;


    public ClickEnPiezaAtaqueActivoEventHandler(VBox vistaUnidadClikeada, VistaUnidad p, PiezaAtacante piezaAtacante, VistaDeTablero vistaDeTablero) {
        this.vistaPiezaClikeada=vistaUnidadClikeada;
        this.piezaClikeada=p;
        this.piezaAtacante=piezaAtacante;
        this.vistaDeTablero=vistaDeTablero;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        try {
            vistaPiezaClikeada.getChildren().clear();
            vistaPiezaClikeada.getChildren().add(piezaClikeada.getVistaInformacion());
            piezaClikeada.getJuego().atacar(piezaAtacante,piezaClikeada.getPieza());
            piezaClikeada.getVistaInformacion();
            piezaClikeada.setEtiquetaDeTexto("Fue atacada con exito.");
            vistaDeTablero.tableroNormal();

        }catch (PiezaAliadaNoAtacableException e){
            piezaClikeada.setEtiquetaDeTexto("Pieza Aliadas no se atacan.");
            vistaDeTablero.tableroNormal();
        }
        catch (UnidadEstaMuertaException | JugadorNoPuedeManipularEsaPiezaException e){
            piezaClikeada.setEtiquetaDeTexto("Error con las piezas seleccionada.");
            vistaDeTablero.tableroNormal();
        }
        catch (DistanciaDeAtaqueInvalidaException e){
            piezaClikeada.setEtiquetaDeTexto("La distancia de ataque es incorrecta.");
            vistaDeTablero.tableroNormal();
        }

    }
}
