package modelo.partida;

import modelo.jugador.EjercitoIncompletoException;
import modelo.jugador.Jugador;
import modelo.jugador.PiezaFueraDeSectorException;
import modelo.jugador.UbicacionInvalidaException;
import modelo.jugador.presupuesto.CompraInvalidaException;
import modelo.jugador.presupuesto.PresupuestoAgotadoException;
import modelo.partida.fase.*;
import modelo.pieza.Pieza;
import modelo.pieza.UnidadEstaMuertaException;
import modelo.pieza.ataque.DistanciaDeAtaqueInvalidaException;
import modelo.pieza.ataque.PiezaAliadaNoAtacableException;
import modelo.pieza.ataque.PiezaAtacante;
import modelo.pieza.sanacion.CurandoAEnemigoException;
import modelo.pieza.sanacion.UnidadNoSePuedeCurar;
import modelo.pieza.tipos.*;
import modelo.tablero.DesplazamientoInvalidoException;
import modelo.tablero.Tablero;
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

    public void atacarPieza(PiezaAtacante atacante, Pieza atacada) throws JugadorNoPuedeManipularEsaPiezaException, PiezaAliadaNoAtacableException, UnidadEstaMuertaException, DistanciaDeAtaqueInvalidaException, JugadorYaRealizoLaAccionException, PiezaYaAtacoOCuroException {
        if(!jugadorEnTurno.esTuPieza(atacante)){ throw new JugadorNoPuedeManipularEsaPiezaException();}
        miFase.atacar(atacante, atacada, tableroDePartida);
    }

    public Pieza crearPieza(String nombreDeUnidad, int posicionEnX, int posicionEnY) throws UbicacionInvalidaException, PresupuestoAgotadoException, CompraInvalidaException, PiezaFueraDeSectorException {
        return miFase.crearPieza(jugadorEnTurno,tableroDePartida,nombreDeUnidad,posicionEnX,posicionEnY);
    }

    public void moverUnidad(Pieza pieza, int posicionXFinal, int posicionYFinal) throws NoHayUnidadEnPosicionException, DesplazamientoInvalidoException, NoSePuedeMoverException, UbicacionInvalidaException, JugadorYaRealizoLaAccionException, PiezaYaMovioException, JugadorNoPuedeManipularEsaPiezaException {
        if(!jugadorEnTurno.esTuPieza(pieza)){ throw new JugadorNoPuedeManipularEsaPiezaException();}
        miFase.moverUnidadEnTablero(tableroDePartida, pieza, posicionXFinal, posicionYFinal);
    }

    public void curarAAliado(Curandero piezaCurandera, Pieza otraPieza) throws CurandoAEnemigoException, CurandoCuraADistanciaCortaException, UnidadNoSePuedeCurar, JugadorYaRealizoLaAccionException, PiezaYaAtacoOCuroException, JugadorNoPuedeManipularEsaPiezaException {
        if(!jugadorEnTurno.esTuPieza(piezaCurandera)){ throw new JugadorNoPuedeManipularEsaPiezaException();}
        miFase.curarAAliado(piezaCurandera,otraPieza);
    }

    public void moverBatallon( Infanteria infante, int posicionXFinal, int posicionYFinal ) throws JugadorYaRealizoLaAccionException, NoHayBatallonException, UbicacionInvalidaException, JugadorNoPuedeManipularEsaPiezaException, DesplazamientoInvalidoException, NoSePuedeMoverException, PiezaYaMovioException {
        if(!jugadorEnTurno.esTuPieza(infante)){ throw new JugadorNoPuedeManipularEsaPiezaException();}
        miFase.moverBatallon(jugadorEnTurno, tableroDePartida, infante, posicionXFinal,posicionYFinal);

    }

    public void formanBatallon(ArrayList<Pieza> piezas) throws JugadorNoPuedeManipularEsaPiezaException, NoSirvenParaBatallonException {
        if(!jugadorEnTurno.esTuPieza(piezas.get(0))){ throw new JugadorNoPuedeManipularEsaPiezaException();}
        jugadorEnTurno.formanBatallon(piezas);
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

    public void actualizarTablero() {
        tableroDePartida.removerTropasMuertas();
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

        } else {

            setJugadorUno(jugadorDos);
            setJugadorDos(jugadorUno);
        }
        setJugadorEnTurno(this.jugadorUno);
    }

     public boolean jugadorDosEsPerdedor(){
        return jugadorDos.jugadorEsPerdedor();
     }

    public boolean jugadorUnoEsPerdedor(){
        return jugadorUno.jugadorEsPerdedor();
    }

}


