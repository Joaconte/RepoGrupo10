package controlador;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import modelo.partida.JugadorNoPuedeManipularEsaPiezaException;
import modelo.partida.fase.JugadorYaRealizoLaAccionException;
import modelo.partida.fase.PiezaYaAtacoException;
import modelo.pieza.sanacion.CurandoAEnemigoException;
import modelo.pieza.sanacion.UnidadNoSePuedeCurar;
import modelo.pieza.tipos.Curandero;
import modelo.pieza.tipos.CurandoCuraADistanciaCortaException;
import resources.sonidos.Audio;
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

        piezaClikeada.getEtiquetaDeTexto().setTextFill(Color.web("#FF0000"));
        try {
            vistaUnidadClikeada.getChildren().clear();
            vistaUnidadClikeada.getChildren().add(piezaClikeada.getVistaInformacion());
            piezaClikeada.getJuego().curarAAliado(pieza,piezaClikeada.getPieza());
            piezaClikeada.getVistaInformacion().actualizarDatosEnPartida();
            piezaClikeada.setEtiquetaDeTexto("Fue sanada con exito.");
            piezaClikeada.getEtiquetaDeTexto().setTextFill(Color.web("#336600"));
            Audio.reproducirAtaque("heal");

        } catch (UnidadNoSePuedeCurar unidadNoSePuedeCurar) {
            piezaClikeada.setEtiquetaDeTexto("Esta pieza no quiere ayuda.");
        } catch (CurandoCuraADistanciaCortaException e) {
            piezaClikeada.setEtiquetaDeTexto("Distancia de curacion invalida.");
        } catch (CurandoAEnemigoException e) {
            piezaClikeada.setEtiquetaDeTexto("No se puede curar a enemigos.");
        } catch (JugadorYaRealizoLaAccionException e) {
            piezaClikeada.setEtiquetaDeTexto("Solo 3 ataques o curas por turno.");
        } catch (PiezaYaAtacoException | JugadorNoPuedeManipularEsaPiezaException e) {
            piezaClikeada.setEtiquetaDeTexto(e.getMessage());
        }
        vistaDeTablero.tableroNormal();
    }
}
