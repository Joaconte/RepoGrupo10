package modelo.partida.fase;

import modelo.jugador.PiezaFueraDeSectorException;
import modelo.jugador.PiezaNoEsDeJugadorException;
import modelo.jugador.UbicacionInvalidaException;
import modelo.jugador.presupuesto.CompraInvalidaException;
import modelo.jugador.presupuesto.PresupuestoAgotadoException;
import modelo.pieza.Ubicacion;
import modelo.pieza.ataque.PiezaAliadaNoAtacableException;
import modelo.jugador.Jugador;
import modelo.pieza.UnidadEstaMuertaException;
import modelo.pieza.ataque.DistanciaDeAtaqueInvalidaException;
import modelo.pieza.ataque.PiezaAtacante;
import modelo.pieza.Pieza;
import modelo.pieza.movimiento.Direccion;
import modelo.pieza.movimiento.NoSePuedeMoverException;
import modelo.pieza.sanacion.CurandoAEnemigoException;
import modelo.pieza.sanacion.UnidadNoSePuedeCurar;
import modelo.pieza.tipos.Curandero;
import modelo.pieza.tipos.CurandoCuraADistanciaCortaException;
import modelo.tablero.DesplazamientoInvalidoException;
import modelo.tablero.Tablero;
import modelo.tablero.casilla.NoHayUnidadEnPosicionException;

import java.util.ArrayList;

public class FaseMedia implements FaseDePartida{

    private static int ATAQUES_MAXIMOS = 3;
    private static int MOVIMIENTOS_MAXIMOS = 2;
    private int ataquesDeJugador;
    private int movimientosDeJugador;


    //Metodo que permite indicar que el jugador termina con las acciones de su turno.
    @Override
    public void finalizarTurno(Jugador jugadorEnTurno){
        ataquesDeJugador = 0;
        movimientosDeJugador = 0;
    }

    @Override
    public boolean esFaseInicial(){
        return false;
    }

    //Ataques o cura
    @Override
    public void atacar(PiezaAtacante atacante, Pieza atacada, Tablero tablero) throws JugadorYaRealizoLaAccionException, UnidadEstaMuertaException, DistanciaDeAtaqueInvalidaException, PiezaAliadaNoAtacableException {
        if(ataquesDeJugador == ATAQUES_MAXIMOS) throw new JugadorYaRealizoLaAccionException();
        atacante.atacar(atacada,tablero);
        ataquesDeJugador += 1;
    }

    @Override
    public void curarAAliado(Curandero piezaCurandera, Pieza otraPieza) throws UnidadNoSePuedeCurar, CurandoCuraADistanciaCortaException, CurandoAEnemigoException, JugadorYaRealizoLaAccionException {
        if(ataquesDeJugador == ATAQUES_MAXIMOS) throw new JugadorYaRealizoLaAccionException();
        piezaCurandera.curarAAliado(otraPieza);
        ataquesDeJugador +=1;
    }

    @Override
    public void moverUnidadEnTablero(Tablero tableroDePartida, Jugador jugadorEnTurno, Ubicacion ubicacionInicial, Ubicacion ubicacionFinal) throws UbicacionInvalidaException, NoHayUnidadEnPosicionException, DesplazamientoInvalidoException, NoSePuedeMoverException, PiezaNoEsDeJugadorException, JugadorYaRealizoLaAccionException {
        if(movimientosDeJugador == MOVIMIENTOS_MAXIMOS) throw new JugadorYaRealizoLaAccionException();
        if(!jugadorEnTurno.jugadorControlaUbicacion(ubicacionInicial)) throw new PiezaNoEsDeJugadorException();
        tableroDePartida.moverUnidad(ubicacionInicial, ubicacionFinal);
        movimientosDeJugador += 1;

    }

    public void moverBatallon(Tablero tableroDePartida , ArrayList<Ubicacion> ubicaciones, Direccion direccion ) throws JugadorYaRealizoLaAccionException {
        if(movimientosDeJugador == MOVIMIENTOS_MAXIMOS) throw new JugadorYaRealizoLaAccionException();
        tableroDePartida.moverBatallon(ubicaciones, direccion);
        movimientosDeJugador += 1;
    }

    public boolean formanBatallon(Tablero tableroDePartida, ArrayList<Ubicacion> ubicaciones) {
        return tableroDePartida.formanBatallon(ubicaciones);
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