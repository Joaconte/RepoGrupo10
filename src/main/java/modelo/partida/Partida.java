package modelo.partida;

import modelo.jugador.*;
import modelo.jugador.presupuesto.CompraInvalidaException;
import modelo.jugador.presupuesto.PresupuestoAgotadoException;
import modelo.partida.fase.*;
import modelo.pieza.Ubicacion;
import modelo.pieza.ataque.PiezaAliadaNoAtacableException;
import modelo.pieza.UnidadEstaMuertaException;
import modelo.pieza.ataque.DistanciaDeAtaqueInvalidaException;
import modelo.pieza.ataque.PiezaAtacante;
import modelo.pieza.movimiento.Direccion;
import modelo.pieza.movimiento.NoSePuedeMoverException;
import modelo.pieza.sanacion.CurandoAEnemigoException;
import modelo.pieza.sanacion.UnidadNoSePuedeCurar;
import modelo.pieza.tipos.Curandero;
import modelo.pieza.tipos.CurandoCuraADistanciaCortaException;
import modelo.tablero.DesplazamientoInvalidoException;
import modelo.tablero.Tablero;
import modelo.pieza.Pieza;
import modelo.tablero.casilla.NoHayUnidadEnPosicionException;

import java.util.ArrayList;
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

    public Tablero getTableroDePartida() {
        return tableroDePartida;
    }

    //-----------SETTERS-----------//

    public void setJugadorUno(String nombreJugador){
        jugadorUno = new Jugador(1, nombreJugador);
    }

    public void setJugadorDos(String nombreJugador){
        jugadorDos = new Jugador(2, nombreJugador);
    }

    //---------------Acciones de Turno------------//


    public void atacarPieza(PiezaAtacante atacante, Pieza atacada) throws JugadorNoPuedeManipularEsaPiezaException, PiezaAliadaNoAtacableException, UnidadEstaMuertaException, DistanciaDeAtaqueInvalidaException, JugadorYaRealizoLaAccionException, PiezaYaAtacoException {
        validarJugadorTurno(atacante);
        miFase.atacar(atacante, atacada, tableroDePartida);
    }

    public Pieza crearPieza(String nombreDeUnidad, int posicionEnX, int posicionEnY) throws UbicacionInvalidaException, PresupuestoAgotadoException, CompraInvalidaException, PiezaFueraDeSectorException {
        return miFase.crearPieza(jugadorEnTurno,tableroDePartida,nombreDeUnidad,posicionEnX,posicionEnY);
    }

    public void moverUnidad(Ubicacion ubicacionInicial, Ubicacion ubicacionFinal) throws PiezaNoEsDeJugadorException, NoHayUnidadEnPosicionException, DesplazamientoInvalidoException, NoSePuedeMoverException, UbicacionInvalidaException, JugadorYaRealizoLaAccionException, PiezaYaMovioException {
        miFase.moverUnidadEnTablero(tableroDePartida, jugadorEnTurno, ubicacionInicial,ubicacionFinal);
    }


    public void curarAAliado(Curandero piezaCurandera, Pieza otraPieza) throws CurandoAEnemigoException, CurandoCuraADistanciaCortaException, UnidadNoSePuedeCurar, JugadorYaRealizoLaAccionException, PiezaYaAtacoException {
        miFase.curarAAliado(piezaCurandera,otraPieza);
    }

    public void moverBatallon( ArrayList<Ubicacion> ubicaciones, Direccion direccion ) throws JugadorYaRealizoLaAccionException, PiezaYaMovioException {
        miFase.moverBatallon(tableroDePartida, ubicaciones, direccion);
    }

    public boolean formanBatallon(ArrayList<Ubicacion> ubicaciones) {
        return miFase.formanBatallon(tableroDePartida, ubicaciones);
    }

    //---------------Metodos de Fase------------//

    public void pasarTurno() throws EjercitoIncompletoException {
        miFase.finalizarTurno(jugadorEnTurno);
        if (jugadorEnTurno.getNombre().equals(jugadorUno.getNombre())) setJugadorEnTurno(jugadorDos);
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

    public void actualizarTablero() {
        jugadorDos.actualizarEstadoTropas(tableroDePartida);
        jugadorUno.actualizarEstadoTropas(tableroDePartida);
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

     public boolean jugadorDosEsPerdedor(){
        return jugadorDos.jugadorEsPerdedor();
     }

    public boolean jugadorUnoEsPerdedor(){
        return jugadorUno.jugadorEsPerdedor();
    }

}


