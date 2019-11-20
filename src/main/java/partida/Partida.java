package partida;

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

import java.util.ArrayList;


public class Partida {

    private FaseDePartida miFase = new FaseInicial();
    private Tablero tableroDePartida = new Tablero();
    private Jugador jugadorEnTurno =  new Jugador(1);
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

    void atacar(Catapulta atacante, Pieza atacada) throws JugadorNoPuedeException,PiezaAtacadaEnRangoIncorrectoException,PiezaAliadaNoAtacableException {
        if(!atacante.esEnemigo(atacada)){ throw new PiezaAliadaNoAtacableException();}
        ArrayList<Pieza> atacadas = tableroDePartida.getPiezasEnAdyacencia(atacada.getUbicacion());
        for(int i=0; i< atacadas.size(); i++){
            atacada=atacadas.get(i);
            setDanioPorAtaque(atacante, atacada);
            miFase.atacar(atacante, atacada);
        }
    };

    void atacar(Infanteria atacante, Pieza atacada) throws JugadorNoPuedeException,PiezaAtacadaEnRangoIncorrectoException,PiezaAliadaNoAtacableException{
        if(!atacante.esEnemigo(atacada)){ throw new PiezaAliadaNoAtacableException();}
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

    void pedirAJineteQueActualiceSuEstado(Jinete unJinete){
        unJinete.setearEstados();
        ArrayList<Pieza> piezasQueRodean = tableroDePartida.getPiezasEnAdyacencia(unJinete.getUbicacion());
        for(int i=0; i< piezasQueRodean.size(); i++){ unJinete.analizarCercanias(piezasQueRodean.get(i));}
        unJinete.confirmarModo();
    }

    public void setDanioPorAtaque(Pieza atacante, Pieza atacada) {
        //Version para nada definitiva.
        atacada.enZonaAliada();
        Sector sector = this.jugadorEnTurno.getSector(); //por nullPointer Preguntar en clase.
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

   //---------------Metodos Para testear un par de cosas (Modificar cuando se defina)------------

    public void colocarUnaFichaEnElTablero(Pieza pieza, int posColumna, int posFila){
        tableroDePartida.ocuparCasilla(pieza, posColumna, posFila);
    }
    public void cambiarAFaseMedia (){
        miFase=new FaseMedia();
    }
}
