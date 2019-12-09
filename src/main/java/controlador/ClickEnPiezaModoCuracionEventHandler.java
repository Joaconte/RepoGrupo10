package controlador;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import modelo.partida.JugadorNoPuedeManipularEsaPiezaException;
import modelo.partida.fase.JugadorYaRealizoLaAccionException;
import modelo.partida.fase.PiezaYaAtacoOCuroException;
import modelo.pieza.sanacion.CurandoAEnemigoException;
import modelo.pieza.sanacion.UnidadNoSePuedeCurar;
import modelo.pieza.tipos.Curandero;
import modelo.pieza.tipos.CurandoCuraADistanciaCortaException;
import resources.sonidos.Audio;
import vista.VistaDeTablero;
import vista.fasesPartida.faseMediaPartida.VistaPiezaClikeada;
import vista.vistaPiezas.VistaUnidad;

public class ClickEnPiezaModoCuracionEventHandler implements EventHandler<MouseEvent> {

    private VistaPiezaClikeada vistaUnidadClikeada;
    private VistaUnidad piezaClikeada;
    private Curandero pieza;
    private VistaDeTablero vistaDeTablero;

    public ClickEnPiezaModoCuracionEventHandler( VistaPiezaClikeada  vistaUnidadClikeada, VistaUnidad p, Curandero pieza, VistaDeTablero vistaDeTablero) {
        this.vistaUnidadClikeada=vistaUnidadClikeada;
        this.piezaClikeada=p;
        this.pieza=pieza;
        this.vistaDeTablero=vistaDeTablero;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        vistaUnidadClikeada.vistaActualizada(piezaClikeada);
        try {
            piezaClikeada.getJuego().curarAAliado(pieza,piezaClikeada.getPieza());
            vistaUnidadClikeada.vistaMensaje("Fue sanada con exito.");
            Audio.reproducirAtaque("heal");

        } catch (UnidadNoSePuedeCurar | CurandoCuraADistanciaCortaException | CurandoAEnemigoException | JugadorYaRealizoLaAccionException | PiezaYaAtacoOCuroException | JugadorNoPuedeManipularEsaPiezaException e) {
            vistaUnidadClikeada.vistaAlerta(e.getMessage());
        } finally {
            vistaDeTablero.tableroFaseMediaNormalizado();
        }
    }
}
