package partida;

import jugador.Sector;
import pieza.UnidadEstaMuertaException;
import pieza.ataque.DistanciaDeAtaqueInvalidaException;
import pieza.ataque.PiezaAliadaNoAtacableException;
import pieza.ataque.PiezaAtacante;

import partida.fase.*;
import tablero.Tablero;
import pieza.Pieza;
import jugador.Jugador;


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

    //---------------Acciones de Turno------------//


    void atacar(PiezaAtacante atacante, Pieza atacada) throws JugadorNoPuedeException, PiezaAliadaNoAtacableException, UnidadEstaMuertaException, DistanciaDeAtaqueInvalidaException {
        validarJugadorTurno(atacante);
        miFase.atacar(atacante, atacada, tableroDePartida);
    }

    public void terminarMiTurno(){
        miFase.terminarMiTurno();
    }

    //---------------Metodos de Fase------------//

    public void cambiarFaseDePartida(FaseDePartida miNuevaFase){
        this.miFase = miNuevaFase;
    }

    public String darNombreDeFase(){
        return miFase.darNombreDeFase();
    }


    //---------------Validaciones-Actualizaciones-----------

    void validarJugadorTurno(Pieza piezaEnAccion)throws JugadorNoPuedeException{
        if(piezaEnAccion.getEquipo() != jugadorEnTurno.getNumeroDeJugador()){ throw new JugadorNoPuedeException();}
    }

    //---------------Metodos de Jugadores------------

    public void setJugadorEnTurno(Jugador jugador){
        this.jugadorEnTurno = jugador;
    }

    public void agregarJugadores() {
        //¿Construir?
    }




}


