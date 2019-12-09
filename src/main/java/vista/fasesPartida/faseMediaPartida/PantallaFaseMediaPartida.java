package vista.fasesPartida.faseMediaPartida;

import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import modelo.Juego;
import resources.sonidos.Audio;
import vista.BarraMenu;
import vista.VistaDeTablero;
import vista.fasesPartida.faseMediaPartida.botonesFaseMedia.BotonPasarTurno;

public class PantallaFaseMediaPartida extends BorderPane {

    private BarraDeJugador barraDeJugador1;
    private BarraDeJugador barraDeJugador2;
    private Juego juego;
    private VistaDeTablero vistaDeTablero;

    public PantallaFaseMediaPartida(VistaDeTablero vistaDeTablero, Juego juego, Stage escenarioPrincipal){
        Audio.reproducirJugando();

        this.setPadding(new Insets(20));
        this.barraDeJugador1 = new BarraDeJugador(juego.getNombreDeJugadorUno(), 1);
        this.barraDeJugador2 = new BarraDeJugador(juego.getNombreDeJugadorDos(), 2);
        this.juego=juego;
        this.vistaDeTablero=vistaDeTablero;

        //-------------------------

        vistaCentro();
        vistaIzquierda();
        vistaDerecha();
        vistaArriba(escenarioPrincipal);
    }

    private void vistaCentro() {
        this.setCenter(vistaDeTablero);
        vistaDeTablero.tableroFaseMediaNormalizado();
    }

    private void vistaIzquierda(){
        this.setLeft(barraDeJugador1);
        barraDeJugador2.getChildren().addAll(  new BotonPasarTurno(juego,this,vistaDeTablero));
        barraDeJugador2.setDisable(true);
        barraDeJugador2.setBarraRival(barraDeJugador1);

    }

    private void vistaDerecha(){
        this.setRight(barraDeJugador2);
        barraDeJugador1.getChildren().addAll( new BotonPasarTurno(juego,this,vistaDeTablero));
        barraDeJugador1.getChildren().add( vistaDeTablero.getVistaDePiezaClikeada());
        barraDeJugador1.setBarraRival(barraDeJugador2);

    }

    private void vistaArriba(Stage escenarioPrincipal){
        this.setTop(new BarraMenu(escenarioPrincipal));
    }

    public void vistaNuevoTurno(){
        barraDeJugador1.invertirEstadoDeshabilitado();
        barraDeJugador2.invertirEstadoDeshabilitado();
        barraDeJugador1.agregarAVista(vistaDeTablero.getVistaDePiezaClikeada(),juego.getNombreJugadorEnTurno());
        barraDeJugador2.agregarAVista(vistaDeTablero.getVistaDePiezaClikeada(),juego.getNombreJugadorEnTurno());

    }

    public void vistaAlertas(String texto){
        barraDeJugador1.vistaAlertas(texto,juego.getNombreJugadorEnTurno());
        barraDeJugador2.vistaAlertas(texto,juego.getNombreJugadorEnTurno());

    }
}
