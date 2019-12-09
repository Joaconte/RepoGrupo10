package vista.vistaPiezas;

import javafx.geometry.Pos;
import modelo.Juego;
import modelo.pieza.Pieza;
import modelo.pieza.ataque.PiezaAtacante;
import vista.VistaDeTablero;
import vista.fasesPartida.faseMediaPartida.botonesFaseMedia.BotonAtacar;
import vista.fasesPartida.faseMediaPartida.botonesFaseMedia.BotonCrearBatallon;
import vista.fasesPartida.faseMediaPartida.botonesFaseMedia.BotonMover;

import java.util.ArrayList;

public class VistaUnidadAtacante extends VistaUnidad{
    protected PiezaAtacante piezaAtacante;


    public VistaUnidadAtacante(PiezaAtacante piezaAtacante, VistaDeTablero vistaDeTablero, String nombre, Juego juego){
        super(piezaAtacante,vistaDeTablero,nombre, juego);
        this.piezaAtacante = piezaAtacante;
        barraDeOpcionesDeUnidad.setAlignment(Pos.CENTER);
        vistaDatos.getChildren().add(barraDeOpcionesDeUnidad);
    }

    @Override
    public PiezaAtacante getPieza() {
        return piezaAtacante;
    }

    public void barraDeOpciones(){
        actualizacionVistaDeOpciones();
        barraDeOpcionesDeUnidad.getChildren().clear();
        barraDeOpcionesDeUnidad.getChildren().add(new BotonAtacar(piezaAtacante,vistaDeTablero,barraDeOpcionesDeUnidad));
        barraDeOpcionesDeUnidad.getChildren().add(new BotonMover(this,vistaDeTablero,barraDeOpcionesDeUnidad));

    }



}
