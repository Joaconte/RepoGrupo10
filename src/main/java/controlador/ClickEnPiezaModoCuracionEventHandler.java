package controlador;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import modelo.pieza.sanacion.CurandoAEnemigoException;
import modelo.pieza.sanacion.UnidadNoSePuedeCurar;
import modelo.pieza.tipos.Curandero;
import modelo.pieza.tipos.CurandoCuraADistanciaCortaException;
import vista.VistaDeTablero;
import vista.vistaPiezas.VistaUnidad;

public class ClickEnPiezaModoCuracionEventHandler implements EventHandler<MouseEvent> {

    private VBox vistaUnidadClikeada;
    private VistaUnidad piezaClikeada;
    private Curandero pieza;
    private VistaDeTablero vistaDeTablero;

    public ClickEnPiezaModoCuracionEventHandler(VBox vistaUnidadClikeada, VistaUnidad p, Curandero pieza, VistaDeTablero vistaDeTablero) {
        this.vistaUnidadClikeada=vistaUnidadClikeada;
        this.piezaClikeada=p;
        this.pieza=pieza;
        this.vistaDeTablero=vistaDeTablero;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {

        try {
            piezaClikeada.getJuego().curarAAliado(pieza,piezaClikeada.getPieza());
            vistaUnidadClikeada.getChildren().clear();
            vistaUnidadClikeada.getChildren().add(piezaClikeada.getVistaInformacion());
            piezaClikeada.setEtiquetaDeTexto("Fue sanada con exito.");
            piezaClikeada.getEtiquetaDeTexto().setTextFill(Color.web("#336600"));
            vistaDeTablero.tableroNormal();

        } catch (UnidadNoSePuedeCurar unidadNoSePuedeCurar) {
            piezaClikeada.setEtiquetaDeTexto("Esta pieza no quiere ayuda.");
            piezaClikeada.getEtiquetaDeTexto().setTextFill(Color.web("#FF0000"));
            vistaDeTablero.tableroNormal();
        } catch (CurandoCuraADistanciaCortaException e) {
            piezaClikeada.setEtiquetaDeTexto("Distancia de curacion invalida.");
            piezaClikeada.getEtiquetaDeTexto().setTextFill(Color.web("#FF0000"));
            vistaDeTablero.tableroNormal();
        } catch (CurandoAEnemigoException e) {
            piezaClikeada.setEtiquetaDeTexto("No se puede curar a enemigos.");
            piezaClikeada.getEtiquetaDeTexto().setTextFill(Color.web("#FF0000"));
            vistaDeTablero.tableroNormal();
        }

    }
}
