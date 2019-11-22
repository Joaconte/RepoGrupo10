package partida;

import jugador.PiezaFueraDeSectorException;
import jugador.Sector;
import pieza.tipos.JineteNoAsediadoException;

import partida.fase.*;
import pieza.tipos.*;
import tablero.Tablero;
import pieza.Pieza;
import jugador.Jugador;
import tablero.casilla.CasillaTieneUnidadException;

import java.util.ArrayList;


public class Partida {

    private FaseDePartida miFase = new FaseInicial();
    private Tablero tableroDePartida = new Tablero();
    private Jugador jugadorEnTurno =  new Jugador(1);
    private Jugador jugadorUno = new Jugador(1); //¿Los guardamos asi?
    private Jugador jugadorDos = new Jugador(2);

    //-----------GETTERS-----------//

    public Jugador getJugadorUno(){
        return jugadorUno;
    }

    public Jugador getJugadorDos(){
        return jugadorDos;
    }

    public Jugador getJugadorEnTurno(){
        return jugadorEnTurno;
    }


    //-----------SETTERS-----------//

    public void setJugadorUno(Jugador jugador){
        jugadorUno = jugador;
    }

    public void setJugadorDos(Jugador jugador){
        jugadorDos = jugador;
    }

    //---------------Metodos de Fase------------//

    public void cambiarFaseDePartida(FaseDePartida miNuevaFase){
        this.miFase = miNuevaFase;
    }


    public void agregarNuevaUbicacionAFicha(Pieza pieza, int posicionX, int posicionY) throws CasillaTieneUnidadException, JugadorNoPuedeException, PiezaFueraDeSectorException {
        validarUnMovimiento(pieza, posicionX, posicionY);
        miFase.agregarNuevaUbicacionAFicha(jugadorEnTurno, pieza, posicionX, posicionY);
        tableroDePartida.ocuparCasilla(pieza, posicionX, posicionY);
    }

    public void moverUnidadEnTablero(Pieza pieza, int unaPosicionInicial, int unaPosicionFinal){
        miFase.moverUnidadEnTablero(pieza, unaPosicionInicial,unaPosicionFinal);
        moverUnidadEnTablero(pieza, unaPosicionInicial,unaPosicionFinal);
    }

    public void terminarMiTurno(){
        miFase.terminarMiTurno();
    }

    public String darNombreDeFase(){
        return miFase.darNombreDeFase();
    }

    void atacar(Pieza atacante, Pieza atacada) throws JugadorNoPuedeException,PiezaAliadaNoAtacableException {
        validarUnAtaque(atacante, atacada);
        miFase.atacar(atacada, atacante, tablero);
    }



    //---------------Validaciones-Actualizaciones-----------

    void validarUnAtaque(Pieza atacante, Pieza atacada)throws PiezaAliadaNoAtacableException,JugadorNoPuedeException{
        if(!atacante.esEnemigo(atacada)){ throw new PiezaAliadaNoAtacableException();}
        if(atacante.getEquipo() != jugadorEnTurno.getNumeroDeJugador()){ throw new JugadorNoPuedeException();}
    }

    void validarUnMovimiento(Pieza pieza, int posicionX, int posicionY)throws CasillaTieneUnidadException,JugadorNoPuedeException{
        if(tableroDePartida.casillaEstaOcupada(posicionX, posicionY)== true ){ throw new CasillaTieneUnidadException();}
        if(pieza.getEquipo() != jugadorEnTurno.getNumeroDeJugador()) { throw new JugadorNoPuedeException();}
        }


    public void setDanioPorAtaque(Pieza atacante, Pieza atacada) {
        //Version para nada definitiva.
        atacada.enZonaAliada();
        Sector sector = jugadorEnTurno.getSector(); //por nullPointer Preguntar en clase.
        boolean estaEnElSector = sector.esDelSector(atacada.getUbicacion().getPosicionEnX());
        boolean sonEnemigas = atacada.esEnemigo(atacante); //Esto evita que catapulta penalice a aliados en su daño colateral.
        if (estaEnElSector && sonEnemigas){ atacada.enZonaEnemiga();}
        if (!estaEnElSector && !sonEnemigas){ atacada.enZonaEnemiga();}
    }


    //---------------Metodos de Jugadores------------

    public void setJugadorEnTurno(Jugador jugador){
        this.jugadorEnTurno = jugador;
    }

    public void agregarJugadores() {
        //¿Construir?
    }




}


