package modelo.partida.fase;

import modelo.jugador.*;
import modelo.jugador.presupuesto.CompraInvalidaException;
import modelo.jugador.presupuesto.PresupuestoAgotadoException;
import modelo.pieza.Ubicacion;
import modelo.pieza.ataque.PiezaAliadaNoAtacableException;
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

public interface FaseDePartida{

    //Metodos abstractos implementados por las subclases

    void finalizarTurno(Jugador jugadorEnTurno) throws EjercitoIncompletoException;

    boolean esFaseInicial();

    void atacar(PiezaAtacante atacante, Pieza atacada, Tablero tablero) throws UnidadEstaMuertaException, DistanciaDeAtaqueInvalidaException, PiezaAliadaNoAtacableException;

    FaseDePartida retornarProximaFase();

    Pieza crearPieza(Jugador jugadorEnTurno, Tablero tableroDePartida, String nombreDeUnidad, int posicionEnX, int posicionEnY) throws UbicacionInvalidaException, PresupuestoAgotadoException, CompraInvalidaException, PiezaFueraDeSectorException;

    void curarAAliado(Curandero piezaCurandera, Pieza otraPieza) throws UnidadNoSePuedeCurar, CurandoCuraADistanciaCortaException, CurandoAEnemigoException;

    void moverUnidadEnTablero(Tablero tableroDePartida, Jugador jugadorEnTurno, Ubicacion ubicacionInicial, Ubicacion ubicacionFinal) throws UbicacionInvalidaException, NoHayUnidadEnPosicionException, DesplazamientoInvalidoException, NoSePuedeMoverException, PiezaNoEsDeJugadorException;

    void moverBatallon(Tablero tableroDePartida, ArrayList<Ubicacion> ubicaciones, Direccion direccion);

    boolean formanBatallon(Tablero tableroDePartida, ArrayList<Ubicacion> ubicaciones);
}