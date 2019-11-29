package modelo.partida;

import modelo.jugador.EjercitoIncompletoException;
import modelo.jugador.PiezaFueraDeSectorException;
import modelo.jugador.UbicacionInvalidaException;
import modelo.jugador.presupuesto.CompraInvalidaException;
import modelo.jugador.presupuesto.PresupuestoAgotadoException;
import modelo.pieza.ataque.PiezaAliadaNoAtacableException;
import modelo.pieza.UnidadEstaMuertaException;
import modelo.pieza.ataque.DistanciaDeAtaqueInvalidaException;
import modelo.pieza.ataque.PiezaAtacante;

import modelo.partida.fase.FaseDePartida;
import modelo.partida.fase.FaseInicial;
import modelo.tablero.Tablero;
import modelo.pieza.Pieza;
import modelo.jugador.Jugador;

import java.util.Random;


public class Partida {

    private FaseDePartida miFase = new FaseInicial();
    private Tablero tableroDePartida = new Tablero();
    private Jugador jugadorEnTurno;
    private Jugador jugadorUno;
    private Jugador jugadorDos;

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

    public void setJugadorUno(String nombreJugador){
        jugadorUno = new Jugador(1, nombreJugador);
    }

    public void setJugadorDos(String nombreJugador){
        jugadorDos = new Jugador(2, nombreJugador);
    }

    //---------------Acciones de Turno------------//


    void atacarPieza(PiezaAtacante atacante, Pieza atacada) throws JugadorNoPuedeException, PiezaAliadaNoAtacableException, UnidadEstaMuertaException, DistanciaDeAtaqueInvalidaException {
        validarJugadorTurno(atacante);
        miFase.atacar(atacante, atacada, tableroDePartida);
    }

    void colocarPieza(String nombreDeUnidad, int posicionEnX, int posicionEnY) throws UbicacionInvalidaException, PresupuestoAgotadoException, CompraInvalidaException, PiezaFueraDeSectorException {
        miFase.colocarPieza(jugadorEnTurno,tableroDePartida,nombreDeUnidad,posicionEnX,posicionEnY);
    }


    //---------------Metodos de Fase------------//

    public void pasarTurno() throws EjercitoIncompletoException {
        miFase.finalizarTurno(jugadorEnTurno);
        if (jugadorEnTurno==jugadorUno) setJugadorEnTurno(jugadorDos);
        else setJugadorEnTurno(jugadorUno);
        miFase = miFase.retornarProximaFase();
    }

    public boolean estaEnFaseInicial(){
        return miFase.esFaseInicial();
    }


    //---------------Validaciones-Actualizaciones-----------

    void validarJugadorTurno(Pieza piezaEnAccion)throws JugadorNoPuedeException{
        if(piezaEnAccion.getEquipo() != jugadorEnTurno.getNumeroDeJugador()){ throw new JugadorNoPuedeException();}
    }

    //---------------Metodos de Jugadores------------

    public void setJugadorEnTurno(Jugador jugador){
        this.jugadorEnTurno = jugador;
    }

    public void agregarJugadores(String jugadorUno, String jugadorDos) {

        Random rand = new Random();
        int n = rand.nextInt(2);
        if (n==0){

            setJugadorUno(jugadorUno);
            setJugadorDos(jugadorDos);
            setJugadorEnTurno(this.jugadorUno);

        } else{

            setJugadorUno(jugadorDos);
            setJugadorDos(jugadorUno);
            setJugadorEnTurno(this.jugadorUno);
        }
    }

}


