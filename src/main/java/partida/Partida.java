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

    //---------------Metodos de Fase------------//

    public void cambiarFaseDePartida(FaseDePartida miNuevaFase){
        this.miFase = miNuevaFase;
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

    void atacar(PiezaAtacante atacante, Pieza atacada) throws JugadorNoPuedeException, PiezaAliadaNoAtacableException, UnidadEstaMuertaException, DistanciaDeAtaqueInvalidaException {
        miFase.atacar(atacante, atacada, tableroDePartida);
    }



    //---------------Validaciones-Actualizaciones-----------

    void validarUnAtaque(Pieza atacante, Pieza atacada)throws PiezaAliadaNoAtacableException,JugadorNoPuedeException{
        if(atacante.getEquipo() != jugadorEnTurno.getNumeroDeJugador()){ throw new JugadorNoPuedeException();}
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


