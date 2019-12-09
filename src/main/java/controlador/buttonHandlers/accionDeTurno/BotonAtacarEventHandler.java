package controlador.buttonHandlers.accionDeTurno;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import modelo.Juego;
import modelo.pieza.ataque.PiezaAtacante;
import resources.sonidos.Audio;
import vista.VistaDeTablero;


public class BotonAtacarEventHandler implements EventHandler<ActionEvent> {
private VistaDeTablero vistaDeTablero;
private PiezaAtacante piezaAtacante;
private HBox barra;


    public BotonAtacarEventHandler(PiezaAtacante piezaAtacante,  VistaDeTablero vistaDeTablero, HBox barraDeOpcionesDeUnidad){
    this.vistaDeTablero = vistaDeTablero;
    this.piezaAtacante = piezaAtacante;
    this.barra = barraDeOpcionesDeUnidad;
}

    @Override
    public void handle(ActionEvent event) {
        vistaDeTablero.vistaComunicacion("Haga click a la pieza a la que desea atacar");
        vistaDeTablero.tableroEnModoAtaque(piezaAtacante);
        barra.setVisible(false);
        Audio.reproducirInterfaz("click");
    }
}
