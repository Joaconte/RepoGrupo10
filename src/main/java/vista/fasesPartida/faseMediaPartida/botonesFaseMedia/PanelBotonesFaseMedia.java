package vista.fasesPartida.faseMediaPartida.botonesFaseMedia;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import modelo.Juego;
import vista.VistaDeTablero;
import vista.fasesPartida.faseMediaPartida.BarraDeJugador;


public class PanelBotonesFaseMedia extends HBox {

    private BotonCrearBatallon botonCrearBatallon;
    private BotonAtacar botonAtacar;
    private BotonCurar botonCurar;
    private BotonMover botonMover;
    private BotonPasarTurno botonPasarTurno;

    public PanelBotonesFaseMedia(BarraDeJugador barraDeJugador1, BarraDeJugador barraDeJugador2, Juego juego, Label comunicador, VistaDeTablero vistaDeTablero){
        this.setSpacing(3);
        this.setAlignment(Pos.CENTER);

        this.botonAtacar = new BotonAtacar(this, barraDeJugador1,barraDeJugador2);
        this.botonCurar = new BotonCurar(this, barraDeJugador1,barraDeJugador2);
        this.botonCrearBatallon = new BotonCrearBatallon(this, barraDeJugador1,barraDeJugador2);
        //this.botonMover = new BotonMover(ubicacionInicial, ubicacionFinal, juego, comunicador, vistaDeTablero);
        this.botonPasarTurno = new BotonPasarTurno(this, juego,comunicador,barraDeJugador1,barraDeJugador2,vistaDeTablero);

        this.getChildren().add(botonAtacar);
        this.getChildren().add(botonCrearBatallon);
        this.getChildren().add(botonCurar);
        //this.getChildren().add(botonMover);
        this.getChildren().add(botonPasarTurno);

    }

    public void modificarBloqueoDeBotonAtaque(Boolean estado){
        botonAtacar.setDisable(estado);
    }

    public void modificarBloqueoDeBotonCura(Boolean estado){
        botonCurar.setDisable(estado);
    }

    public void modificarBloqueoDeBotonMover(Boolean estado){
       // botonMover.setDisable(estado);
    }

}

