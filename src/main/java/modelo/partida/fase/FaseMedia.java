package modelo.partida.fase;

import modelo.jugador.PiezaFueraDeSectorException;
import modelo.jugador.PiezaNoEsDeJugadorException;
import modelo.jugador.UbicacionInvalidaException;
import modelo.jugador.presupuesto.CompraInvalidaException;
import modelo.jugador.presupuesto.PresupuestoAgotadoException;
import modelo.partida.JugadorNoPuedeManipularEsaPiezaException;
import modelo.pieza.Ubicacion;
import modelo.pieza.ataque.PiezaAliadaNoAtacableException;
import modelo.jugador.Jugador;
import modelo.pieza.UnidadEstaMuertaException;
import modelo.pieza.ataque.DistanciaDeAtaqueInvalidaException;
import modelo.pieza.ataque.PiezaAtacante;
import modelo.pieza.Pieza;
import modelo.pieza.tipos.NoHayBatallonException;
import modelo.pieza.tipos.NoSePuedeMoverException;
import modelo.pieza.sanacion.CurandoAEnemigoException;
import modelo.pieza.sanacion.UnidadNoSePuedeCurar;
import modelo.pieza.tipos.Curandero;
import modelo.pieza.tipos.CurandoCuraADistanciaCortaException;
import modelo.tablero.DesplazamientoInvalidoException;
import modelo.tablero.Tablero;
import modelo.tablero.casilla.NoHayUnidadEnPosicionException;

import java.util.ArrayList;

public class FaseMedia implements FaseDePartida{

    private boolean jugadorYaAtacoOCuro = false;
    private boolean jugadorYaMovio = false;


    //Metodo que permite indicar que el jugador termina con las acciones de su turno.
    @Override
    public void finalizarTurno(Jugador jugadorEnTurno){
        jugadorYaAtacoOCuro=false;
        jugadorYaMovio = false;
    }

    @Override
    public boolean esFaseInicial(){
        return false;
    }

    //Ataques o cura
    @Override
    public void atacar(PiezaAtacante atacante, Pieza atacada, Tablero tablero) throws JugadorYaRealizoLaAccionException, UnidadEstaMuertaException, DistanciaDeAtaqueInvalidaException, PiezaAliadaNoAtacableException {
        if(jugadorYaAtacoOCuro) throw new JugadorYaRealizoLaAccionException();
        atacante.atacar(atacada,tablero);
        jugadorYaAtacoOCuro=true;
    }

    @Override
    public void curarAAliado(Curandero piezaCurandera, Pieza otraPieza) throws UnidadNoSePuedeCurar, CurandoCuraADistanciaCortaException, CurandoAEnemigoException, JugadorYaRealizoLaAccionException {
        if(jugadorYaAtacoOCuro) throw new JugadorYaRealizoLaAccionException();
        piezaCurandera.curarAAliado(otraPieza);
        jugadorYaAtacoOCuro=true;
    }

    @Override
    public void moverUnidadEnTablero(Tablero tableroDePartida, Jugador jugadorEnTurno, Ubicacion ubicacionInicial, Ubicacion ubicacionFinal) throws UbicacionInvalidaException, NoHayUnidadEnPosicionException, DesplazamientoInvalidoException, NoSePuedeMoverException, PiezaNoEsDeJugadorException, JugadorYaRealizoLaAccionException {
        if(jugadorYaMovio) throw new JugadorYaRealizoLaAccionException();
        if(!jugadorEnTurno.jugadorControlaUbicacion(ubicacionInicial)) throw new PiezaNoEsDeJugadorException();
        tableroDePartida.moverUnidad(ubicacionInicial, ubicacionFinal);
        jugadorYaMovio=true;

    }

    public void moverBatallon(Jugador jugador, Tablero tableroDePartida , Ubicacion ubicacionInicial, Ubicacion ubicacionFinal ) throws JugadorYaRealizoLaAccionException, NoHayBatallonException, UbicacionInvalidaException, JugadorNoPuedeManipularEsaPiezaException {
        if(jugadorYaMovio) throw new JugadorYaRealizoLaAccionException();
        jugador.desplazarBatallon(tableroDePartida,ubicacionInicial,ubicacionFinal);
        jugadorYaMovio=true;
    }

    @Override
    public FaseDePartida retornarProximaFase() {
        return this;
    }

    @Override
    public Pieza crearPieza(Jugador jugadorEnTurno, Tablero tableroDePartida, String nombreDeUnidad, int posicionEnX, int posicionEnY) throws UbicacionInvalidaException, PresupuestoAgotadoException, CompraInvalidaException, PiezaFueraDeSectorException {
        throw new PresupuestoAgotadoException();
    }




}