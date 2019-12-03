package controlador.buttonHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import modelo.Juego;
import modelo.jugador.PiezaNoEsDeJugadorException;
import modelo.pieza.Pieza;
import modelo.pieza.Ubicacion;
import modelo.pieza.ataque.PiezaAtacante;
import modelo.pieza.movimiento.NoSePuedeMoverException;
import modelo.tablero.DesplazamientoInvalidoException;
import modelo.tablero.casilla.NoHayUnidadEnPosicionException;
import vista.VistaDeTablero;
import vista.fasesPartida.faseMediaPartida.BarraDeJugador;
import vista.fasesPartida.faseMediaPartida.botonesFaseMedia.PanelBotonesFaseMedia;
import vista.vistaPiezas.VistaUnidad;
import vista.vistaPiezas.VistaUnidadAtacante;


public class BotonAtacarEventHandler implements EventHandler<ActionEvent> {
private PanelBotonesFaseMedia panelBotonesFaseMedia;
private Juego juego;
private Label comunicador;
private BarraDeJugador barraDeJugador1;
private BarraDeJugador barraDeJugador2;
private VistaDeTablero vistaDeTablero;


    public BotonAtacarEventHandler(PanelBotonesFaseMedia panelBotonesFaseMedia,Juego juego, Label comunicador,BarraDeJugador barraDeJugador1,BarraDeJugador barraDeJugador2,VistaDeTablero vistaDeTablero){
    this.panelBotonesFaseMedia = panelBotonesFaseMedia;
    this.juego = juego;
    this.comunicador = comunicador;
    this.barraDeJugador1 = barraDeJugador1;
    this.barraDeJugador2 = barraDeJugador2;
    this.vistaDeTablero = vistaDeTablero;
}

    @Override
    public void handle(ActionEvent event) {
        this.comunicador.setText("Haga click en la pieza con la que desea atacar");
        this.comunicador.setTextFill(Color.web("#000000"));
        VistaUnidad vistaAtacante = (vistaDeTablero.getVistaDePiezaClikeada()).getVistaUnidadCompleta();/*
        PiezaAtacante atacante = vistaAtacante.getPieza();
        this.comunicador.setText("Haga click en la pieza que desea atacar");
        this.comunicador.setTextFill(Color.web("#000000"));
        VistaUnidad vistaAtacada = (vistaDeTablero.getVistaDePiezaClikeada()).getVistaUnidadCompleta();
        Pieza atacada = vistaAtacada.getPieza();
        atacante.atacar(atacada,juego.getTablero());*/
    }
}
