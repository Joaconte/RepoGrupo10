package partida;

import partida.ataques.JineteAsediadoException;
import partida.ataques.JineteNoAsediadoException;
import partida.ataques.PiezaAtacadaEnRangoIncorrectoException;

import partida.fase.*;
import pieza.tipos.*;
import tablero.Tablero;
import pieza.Pieza;
import jugador.Jugador;

import java.util.ArrayList;


public class Partida{

    private FaseDePartida miFase = new FaseInicial();
    private Tablero tableroDePartida = new Tablero();
    private Jugador jugadorEnTurno;
    private Jugador jugadorUno = new Jugador(1); //¿Los guardamos asi?
    private Jugador jugadorDos = new Jugador(2);


    //---------------Metodos de Fase------------
    public void cambiarFaseDePartida(FaseDePartida miNuevaFase){
        this.miFase = miNuevaFase;
    }

    public void moverUnidadEnTablero(Pieza pieza, int unaPosicionInicial, int unaPosicionFinal){ //por ahora String esta puesta por poner algo.
        miFase.moverUnidadEnTablero(pieza, unaPosicionInicial,unaPosicionFinal);
    }

    public void terminarMiTurno(){
        miFase.terminarMiTurno();
    }

    public String darNombreDeFase(){
        return miFase.darNombreDeFase();
    }

    //---------------Metodos de Ataque------------

    void atacar(Catapulta atacante, Pieza atacada) throws PiezaAtacadaEnRangoIncorrectoException,PiezaAliadaNoAtacableException {
        if(!atacante.esEnemigo(atacada)){ throw new PiezaAliadaNoAtacableException();}

        ArrayList<Pieza> atacadas = tableroDePartida.getPiezasEnAdyacencia(atacada.getUbicacion());
        for(int i=0; i< atacadas.size(); i++){
            atacada=atacadas.get(i);
            miFase.atacar(atacante, atacada, jugadorEnTurno);
        }
    };

    void atacar(Infanteria atacante, Pieza atacada) throws PiezaAtacadaEnRangoIncorrectoException,PiezaAliadaNoAtacableException{
        if(!atacante.esEnemigo(atacada)){ throw new PiezaAliadaNoAtacableException();}

        miFase.atacar(atacante, atacada, jugadorEnTurno);
    };

    void atacar(Jinete atacante, Pieza atacada) throws PiezaAtacadaEnRangoIncorrectoException,JineteAsediadoException, JineteNoAsediadoException,PiezaAliadaNoAtacableException{
        if(!atacante.esEnemigo(atacada)){ throw new PiezaAliadaNoAtacableException();}

        ArrayList<Pieza> piezasQueRodean = tableroDePartida.getPiezasEnAdyacencia(atacante.getUbicacion());
        boolean conRefuerzo = false;
        boolean conAsedio = false;
        for(int i=0; i< piezasQueRodean.size(); i++){
            Pieza pieza=piezasQueRodean.get(i);
            if (pieza.getCosto()==1 && !atacante.esEnemigo(pieza)) conRefuerzo = true;
            if (atacante.esEnemigo(pieza)) conAsedio = true;
        }
        atacante.estaAsediado(conRefuerzo,conAsedio);
        miFase.atacar(atacante, atacada, jugadorEnTurno);
    };

    //---------------Metodos de Jugadores------------

    public void agregarJugadores() {
        //¿Construir?
    }


}
