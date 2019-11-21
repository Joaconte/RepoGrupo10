package partida;

import jugador.PiezaFueraDeSectorException;
import jugador.Sector;
import partida.ataques.JineteAsediadoException;
import partida.ataques.JineteNoAsediadoException;
import partida.ataques.PiezaAtacadaEnRangoIncorrectoException;

import partida.fase.*;
import pieza.Ubicacion;
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

    void comprarUnaTropa(int costo){
        miFase.comprarUnaTropa(costo, jugadorEnTurno);
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

    void atacar(Catapulta atacante, Pieza atacada) throws JugadorNoPuedeException,PiezaAtacadaEnRangoIncorrectoException,PiezaAliadaNoAtacableException {

        if(!atacante.esEnemigo(atacada)){ throw new PiezaAliadaNoAtacableException();}
        validarUnAtaque(atacante, atacada);
        ArrayList<Pieza> atacadas = tableroDePartida.getPiezasEnAdyacencia(atacada.getUbicacion());
        for(int i=0; i< atacadas.size(); i++){
            atacada=atacadas.get(i);
            setDanioPorAtaque(atacante, atacada);
            miFase.atacar(atacante, atacada); //Preguntar
        }
    }

    void atacar(Infanteria atacante, Pieza atacada) throws JugadorNoPuedeException,PiezaAtacadaEnRangoIncorrectoException,PiezaAliadaNoAtacableException{

        if(!atacante.esEnemigo(atacada)){ throw new PiezaAliadaNoAtacableException();}
        validarUnAtaque(atacante, atacada);
        setDanioPorAtaque(atacante, atacada);
        miFase.atacar(atacante, atacada);
    };

    void atacar(Jinete atacante, Pieza atacada) throws JugadorNoPuedeException,PiezaAtacadaEnRangoIncorrectoException,JineteAsediadoException,JineteNoAsediadoException,PiezaAliadaNoAtacableException{
        validarUnAtaque(atacante, atacada);
        pedirAJineteQueActualiceSuEstado(atacante);
        setDanioPorAtaque(atacante, atacada);
        miFase.atacar(atacante, atacada);
    };


    //---------------Validaciones-Actualizaciones-----------

    void validarUnAtaque(Pieza atacante, Pieza atacada)throws PiezaAliadaNoAtacableException,JugadorNoPuedeException{
        if(!atacante.esEnemigo(atacada)){ throw new PiezaAliadaNoAtacableException();}
        if(atacante.getEquipo() != jugadorEnTurno.getNumeroDeJugador()){ throw new JugadorNoPuedeException();}
    }

    void validarUnMovimiento(Pieza pieza, int posicionX, int posicionY)throws CasillaTieneUnidadException,JugadorNoPuedeException{
        if(tableroDePartida.getEstadoCasilla(posicionX, posicionY)=="Ocupada"){ throw new CasillaTieneUnidadException();}
        if(pieza.getEquipo() != jugadorEnTurno.getNumeroDeJugador()) { throw new JugadorNoPuedeException();}
        }

    void pedirAJineteQueActualiceSuEstado(Jinete unJinete){
        ArrayList<Pieza> piezasQueRodean = tableroDePartida.getCasillasEnAdyacenciaCercana(unJinete.getUbicacion());
        for(int i=0; i< piezasQueRodean.size(); i++){
            unJinete.analizarCercanias(piezasQueRodean.get(i));
        }
        unJinete.confirmarModo();
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


