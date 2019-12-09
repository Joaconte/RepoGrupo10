package controlador;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import modelo.Juego;
import modelo.partida.JugadorNoPuedeManipularEsaPiezaException;
import modelo.partida.fase.JugadorYaRealizoLaAccionException;
import modelo.partida.fase.PiezaYaAtacoOCuroException;
import modelo.pieza.UnidadEstaMuertaException;
import modelo.pieza.ataque.DistanciaDeAtaqueInvalidaException;
import modelo.pieza.ataque.PiezaAliadaNoAtacableException;
import modelo.pieza.ataque.PiezaAtacante;
import vista.juegoTerminado.PantallaJuegoTerminado;
import resources.sonidos.Audio;
import vista.VistaDeTablero;
import vista.fasesPartida.faseMediaPartida.VistaPiezaClikeada;
import vista.vistaPiezas.VistaUnidad;

public class ClickEnPiezaAtaqueActivoEventHandler implements EventHandler<MouseEvent> {
    private VistaPiezaClikeada vistaPiezaClikeada;
    private VistaUnidad piezaClikeada;
    private PiezaAtacante piezaAtacante;
    private VistaDeTablero vistaDeTablero;
    private Stage stage;
    private ScrollPane panelConBarrasDeMovimiento = new ScrollPane();

    public ClickEnPiezaAtaqueActivoEventHandler(VistaPiezaClikeada vistaUnidadClikeada, VistaUnidad p, PiezaAtacante piezaAtacante, VistaDeTablero vistaDeTablero, Stage stage) {
        this.vistaPiezaClikeada=vistaUnidadClikeada;
        this.piezaClikeada=p;
        this.piezaAtacante=piezaAtacante;
        this.vistaDeTablero=vistaDeTablero;
        this.stage=stage;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        vistaDeTablero.tableroFaseMediaNormalizado();
        try {
            Juego juego = piezaClikeada.getJuego();
            vistaPiezaClikeada.vistaActualizada(piezaClikeada);
            juego.atacar(piezaAtacante,piezaClikeada.getPieza());
            juego.actualizarTablero();

            piezaClikeada.getVistaInformacion().actualizarDatosEnPartida();
            vistaPiezaClikeada.vistaMensaje("Fue atacada con exito.");
            vistaDeTablero.actualizarTableroPorMuertas();
            Audio.reproducirAtaque(piezaAtacante.getSonidoAtaque());

            if(juego.jugadorUnoEsPerdedor() || juego.jugadorDosEsPerdedor()){
                PantallaJuegoTerminado pantalla= new PantallaJuegoTerminado(juego, stage, "Error",vistaDeTablero);
                if(juego.jugadorUnoEsPerdedor() && !juego.jugadorDosEsPerdedor()){
                    pantalla = new PantallaJuegoTerminado(juego, stage, "Gana jugador: " + juego.getNombreDeJugadorDos(),vistaDeTablero);
                } else if (!juego.jugadorUnoEsPerdedor() && juego.jugadorDosEsPerdedor()){
                    pantalla = new PantallaJuegoTerminado(juego, stage, "Gana jugador: " + juego.getNombreDeJugadorUno(),vistaDeTablero);
                } else if (juego.jugadorUnoEsPerdedor() && juego.jugadorDosEsPerdedor()){
                    pantalla = new PantallaJuegoTerminado(juego, stage, "El juego queda empatado",vistaDeTablero);
                }
                panelConBarrasDeMovimiento.setContent(pantalla);
                Scene escenaFaseInicial = new Scene (panelConBarrasDeMovimiento,1200,950);
                stage.setScene(escenaFaseInicial);
            }
        }catch (PiezaYaAtacoOCuroException | JugadorYaRealizoLaAccionException| DistanciaDeAtaqueInvalidaException | PiezaAliadaNoAtacableException | UnidadEstaMuertaException | JugadorNoPuedeManipularEsaPiezaException e){
            vistaPiezaClikeada.vistaAlerta(e.getMessage());
        }
        finally {
            vistaPiezaClikeada.vistaActualizada(piezaClikeada);
        }

    }
}
