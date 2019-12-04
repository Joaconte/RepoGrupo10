package modelo.partida;

import modelo.jugador.*;
import modelo.jugador.presupuesto.CompraInvalidaException;
import modelo.jugador.presupuesto.PresupuestoAgotadoException;
import modelo.pieza.Ubicacion;
import modelo.pieza.ataque.PiezaAliadaNoAtacableException;
import modelo.pieza.UnidadEstaMuertaException;
import modelo.pieza.ataque.DistanciaDeAtaqueInvalidaException;
import modelo.pieza.ataque.PiezaAtacante;

import modelo.partida.fase.FaseDePartida;
import modelo.partida.fase.FaseInicial;
import modelo.pieza.movimiento.NoSePuedeMoverException;
import modelo.tablero.DesplazamientoInvalidoException;
import modelo.tablero.Tablero;
import modelo.pieza.Pieza;
import modelo.tablero.casilla.NoHayUnidadEnPosicionException;

import java.util.Random;


public class Partida {

    private FaseDePartida miFase = new FaseInicial();
    private Tablero tableroDePartida;
    private Jugador jugadorEnTurno;
    private Jugador jugadorUno;
    private Jugador jugadorDos;

    public Partida(){
        tableroDePartida = new Tablero();
    }

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

    public String getNombreJugadorEnTurno(){ return jugadorEnTurno.getNombre();}

    public int getPuntosJugadorEnTurno(){ return jugadorEnTurno.getPuntos();}


    //-----------SETTERS-----------//

    public void setJugadorUno(String nombreJugador){
        jugadorUno = new Jugador(1, nombreJugador);
    }

    public void setJugadorDos(String nombreJugador){
        jugadorDos = new Jugador(2, nombreJugador);
    }

    //---------------Acciones de Turno------------//


    public void atacarPieza(PiezaAtacante atacante, Pieza atacada) throws JugadorNoPuedeManipularEsaPiezaException, PiezaAliadaNoAtacableException, UnidadEstaMuertaException, DistanciaDeAtaqueInvalidaException {
        validarJugadorTurno(atacante);
        miFase.atacar(atacante, atacada, tableroDePartida);
    }

    public Pieza crearPieza(String nombreDeUnidad, int posicionEnX, int posicionEnY) throws UbicacionInvalidaException, PresupuestoAgotadoException, CompraInvalidaException, PiezaFueraDeSectorException {
        return miFase.crearPieza(jugadorEnTurno,tableroDePartida,nombreDeUnidad,posicionEnX,posicionEnY);
    }

    public void moverUnidad(Ubicacion ubicacionInicial, Ubicacion ubicacionFinal) throws PiezaNoEsDeJugadorException, NoHayUnidadEnPosicionException, DesplazamientoInvalidoException, NoSePuedeMoverException {

        try {
            jugadorEnTurno.moverUnidad(ubicacionInicial, ubicacionFinal);
            tableroDePartida.moverUnidad(ubicacionInicial, ubicacionFinal);
        }
        catch (PiezaNoEsDeJugadorException e){
            throw new PiezaNoEsDeJugadorException();
        }
    }

    //---------------Metodos de Fase------------//

    public void pasarTurno() throws EjercitoIncompletoException {
        miFase.finalizarTurno(jugadorEnTurno);
        if (jugadorEnTurno.getNombre()==jugadorUno.getNombre()) setJugadorEnTurno(jugadorDos);
        else setJugadorEnTurno(jugadorUno);
        miFase = miFase.retornarProximaFase();
    }

    public boolean estaEnFaseInicial(){
        return miFase.esFaseInicial();
    }


    //---------------Validaciones-Actualizaciones-----------

    void validarJugadorTurno(Pieza piezaEnAccion)throws JugadorNoPuedeManipularEsaPiezaException {
        if(piezaEnAccion.getEquipo() != jugadorEnTurno.getNumeroDeJugador()){ throw new JugadorNoPuedeManipularEsaPiezaException();}
    }

    //---------------Metodos de Jugadores------------

    public void setJugadorEnTurno(Jugador jugador){
        this.jugadorEnTurno = jugador;
    }

    public void agregarJugadores(String jugadorUno, String jugadorDos) {

        Random rand = new Random();
        int n = rand.nextInt(2);
        if (n == 0) {

            setJugadorUno(jugadorUno);
            setJugadorDos(jugadorDos);
            setJugadorEnTurno(this.jugadorUno);

        } else {

            setJugadorUno(jugadorDos);
            setJugadorDos(jugadorUno);
            setJugadorEnTurno(this.jugadorUno);
        }
    }

    public Tablero getTableroDePartida() {
        return tableroDePartida;
    }


    public void actualizarTablero() {
        jugadorDos.actualizarEstadoTropas(tableroDePartida);
        jugadorUno.actualizarEstadoTropas(tableroDePartida);
    }
}


