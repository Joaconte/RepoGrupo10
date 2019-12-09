package controlador.buttonHandlers.accionDeTurno;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox;
import modelo.pieza.ataque.PiezaAtacante;
import resources.sonidos.Audio;
import vista.VistaDeTablero;


public class BotonAtacarEventHandler implements EventHandler<ActionEvent> {
private VistaDeTablero vistaDeTablero;
private PiezaAtacante piezaAtacante;
private VBox barra;


    public BotonAtacarEventHandler(PiezaAtacante piezaAtacante,  VistaDeTablero vistaDeTablero, VBox barraDeOpcionesDeUnidad){
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
