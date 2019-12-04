package controlador;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import modelo.Juego;
import modelo.partida.JugadorNoPuedeManipularEsaPiezaException;
import modelo.pieza.UnidadEstaMuertaException;
import modelo.pieza.ataque.DistanciaDeAtaqueInvalidaException;
import modelo.pieza.ataque.PiezaAliadaNoAtacableException;
import modelo.pieza.ataque.PiezaAtacante;
import vista.PantallaJuegoTerminado;
import vista.VistaDeTablero;
import vista.vistaPiezas.VistaUnidad;

public class ClickEnPiezaAtaqueActivoEventHandler implements EventHandler<MouseEvent> {
    private VBox vistaPiezaClikeada;
    private VistaUnidad piezaClikeada;
    private PiezaAtacante piezaAtacante;
    private VistaDeTablero vistaDeTablero;
    private Stage stage;
    private ScrollPane panelConBarrasDeMovimiento = new ScrollPane();

    public ClickEnPiezaAtaqueActivoEventHandler(VBox vistaUnidadClikeada, VistaUnidad p, PiezaAtacante piezaAtacante, VistaDeTablero vistaDeTablero, Stage stage) {
        this.vistaPiezaClikeada=vistaUnidadClikeada;
        this.piezaClikeada=p;
        this.piezaAtacante=piezaAtacante;
        this.vistaDeTablero=vistaDeTablero;
        this.stage=stage;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        try {
            Juego juego = piezaClikeada.getJuego();
            vistaPiezaClikeada.getChildren().clear();
            vistaPiezaClikeada.getChildren().add(piezaClikeada.getVistaInformacion());

            juego.atacar(piezaAtacante,piezaClikeada.getPieza());
            juego.actualizarTablero();

            piezaClikeada.getVistaInformacion().actualizarDatosEnPartida();
            piezaClikeada.setEtiquetaDeTexto("Fue atacada con exito.");
            piezaClikeada.getEtiquetaDeTexto().setTextFill(Color.web("#336600"));

            vistaDeTablero.tableroNormal();
            vistaDeTablero.actualizarTableroPorMuertas();


            if(juego.jugadorUnoEsPerdedor() && !juego.jugadorDosEsPerdedor()){
                PantallaJuegoTerminado pantalla = new PantallaJuegoTerminado(juego, stage, "Gana jugador: " + juego.getNombreDeJugadorDos());
                panelConBarrasDeMovimiento.setContent(pantalla);
                Scene escenaFaseInicial = new Scene (panelConBarrasDeMovimiento,1200,950);
                stage.setScene(escenaFaseInicial);
            } else if (!juego.jugadorUnoEsPerdedor() && juego.jugadorDosEsPerdedor()){
                PantallaJuegoTerminado pantalla = new PantallaJuegoTerminado(juego, stage, "Gana jugador: " + juego.getNombreDeJugadorUno());
                panelConBarrasDeMovimiento.setContent(pantalla);
                Scene escenaFaseInicial = new Scene (panelConBarrasDeMovimiento,1200,950);
                stage.setScene(escenaFaseInicial);
            } else if (juego.jugadorUnoEsPerdedor() && juego.jugadorDosEsPerdedor()){
                PantallaJuegoTerminado pantalla = new PantallaJuegoTerminado(juego, stage, "El juego queda empatado");
                panelConBarrasDeMovimiento.setContent(pantalla);
                Scene escenaFaseInicial = new Scene (panelConBarrasDeMovimiento,1200,950);
                stage.setScene(escenaFaseInicial);
            }

        }catch (PiezaAliadaNoAtacableException e){
            piezaClikeada.setEtiquetaDeTexto("Pieza Aliadas no se atacan.");
            piezaClikeada.getEtiquetaDeTexto().setTextFill(Color.web("#FF0000"));
            vistaDeTablero.tableroNormal();
        }
        catch (UnidadEstaMuertaException | JugadorNoPuedeManipularEsaPiezaException e){
            piezaClikeada.setEtiquetaDeTexto("Error con las piezas seleccionada.");
            piezaClikeada.getEtiquetaDeTexto().setTextFill(Color.web("#FF0000"));
            vistaDeTablero.tableroNormal();
        }
        catch (DistanciaDeAtaqueInvalidaException e){
            piezaClikeada.setEtiquetaDeTexto("La distancia de ataque es incorrecta.");
            piezaClikeada.getEtiquetaDeTexto().setTextFill(Color.web("#FF0000"));
            vistaDeTablero.tableroNormal();
        }

    }
}
