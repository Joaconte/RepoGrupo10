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
    public void atacar(PiezaAtacante atacante, Pieza atacada, Tablero tablero) throws UnidadEstaMuertaException, DistanciaDeAtaqueInvalidaException, PiezaAliadaNoAtacableException {
        atacante.atacar(atacada,tablero);
    }

    @Override
    public void curarAAliado(Curandero piezaCurandera, Pieza otraPieza) throws UnidadNoSePuedeCurar, CurandoCuraADistanciaCortaException, CurandoAEnemigoException {
        piezaCurandera.curarAAliado(otraPieza);
    }

    @Override
    public void moverUnidadEnTablero(Tablero tableroDePartida, Jugador jugadorEnTurno, Ubicacion ubicacionInicial, Ubicacion ubicacionFinal) throws UbicacionInvalidaException, NoHayUnidadEnPosicionException, DesplazamientoInvalidoException, NoSePuedeMoverException, PiezaNoEsDeJugadorException {
        if(!jugadorEnTurno.piezaEsDeJugador(ubicacionInicial)) throw new PiezaNoEsDeJugadorException();
        tableroDePartida.moverUnidad(ubicacionInicial, ubicacionFinal);

    }

    public void moverBatallon(Tablero tableroDePartida , ArrayList<Ubicacion> ubicaciones, Direccion direccion ){
        tableroDePartida.moverBatallon(ubicaciones, direccion);
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