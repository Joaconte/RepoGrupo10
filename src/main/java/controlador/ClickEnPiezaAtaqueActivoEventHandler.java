package controlador;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import modelo.partida.JugadorNoPuedeManipularEsaPiezaException;
import modelo.pieza.UnidadEstaMuertaException;
import modelo.pieza.ataque.DistanciaDeAtaqueInvalidaException;
import modelo.pieza.ataque.PiezaAliadaNoAtacableException;
import modelo.pieza.ataque.PiezaAtacante;
import vista.VistaDeTablero;
import vista.vistaPiezas.VistaUnidadParaTablero;

public class ClickEnPiezaAtaqueActivoEventHandler implements EventHandler<MouseEvent> {
    private VistaUnidadParaTablero vistaPiezaClikeada;
    private VistaUnidadParaTablero piezaClikeada;
    private PiezaAtacante piezaAtacante;
    private VistaDeTablero vistaDeTablero;

    public ClickEnPiezaAtaqueActivoEventHandler(VistaUnidadParaTablero vistaUnidadClikeada, VistaUnidadParaTablero p, PiezaAtacante piezaAtacante, VistaDeTablero vistaDeTablero) {
        this.vistaPiezaClikeada=vistaUnidadClikeada;
        this.piezaClikeada = p;
        this.piezaAtacante= piezaAtacante;
        this.vistaDeTablero = vistaDeTablero;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        try {
            vistaPiezaClikeada.setVistaUnidad(piezaClikeada.getVistaUnidad());
            vistaPiezaClikeada.setInformacionUnidad();
            vistaPiezaClikeada.getVistaUnidad().getJuego().atacar(piezaAtacante,vistaPiezaClikeada.getVistaUnidad().getPieza());
            vistaDeTablero.tableroNormal();
        }catch (PiezaAliadaNoAtacableException e){
            vistaPiezaClikeada.getVistaUnidad().setEtiquetaDeTexto("Pieza Aliadas no se atacan.");
            vistaDeTablero.tableroNormal();
        }
        catch (UnidadEstaMuertaException | JugadorNoPuedeManipularEsaPiezaException e){
            vistaPiezaClikeada.getVistaUnidad().setEtiquetaDeTexto("Error con las piezas seleccionada.");
            vistaDeTablero.tableroNormal();
        }
        catch (DistanciaDeAtaqueInvalidaException e){
            vistaPiezaClikeada.getVistaUnidad().setEtiquetaDeTexto("La distancia de ataque es incorrecta.");
            vistaDeTablero.tableroNormal();
        }

    }
}
