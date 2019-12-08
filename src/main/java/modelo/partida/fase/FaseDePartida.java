package modelo.partida.fase;

import modelo.jugador.EjercitoIncompletoException;
import modelo.jugador.Jugador;
import modelo.jugador.PiezaFueraDeSectorException;
import modelo.jugador.UbicacionInvalidaException;
import modelo.jugador.presupuesto.CompraInvalidaException;
import modelo.jugador.presupuesto.PresupuestoAgotadoException;
import modelo.partida.JugadorNoPuedeManipularEsaPiezaException;
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


public interface FaseDePartida{

    //Metodos abstractos implementados por las subclases

    void finalizarTurno(Jugador jugadorEnTurno) throws EjercitoIncompletoException;

    boolean esFaseInicial();

    void atacar(PiezaAtacante atacante, Pieza atacada, Tablero tablero) throws UnidadEstaMuertaException, DistanciaDeAtaqueInvalidaException, PiezaAliadaNoAtacableException, JugadorYaRealizoLaAccionException, PiezaYaAtacoException;

    FaseDePartida retornarProximaFase();

    Pieza crearPieza(Jugador jugadorEnTurno, Tablero tableroDePartida, String nombreDeUnidad, int posicionEnX, int posicionEnY) throws UbicacionInvalidaException, PresupuestoAgotadoException, CompraInvalidaException, PiezaFueraDeSectorException;

    void curarAAliado(Curandero piezaCurandera, Pieza otraPieza) throws UnidadNoSePuedeCurar, CurandoCuraADistanciaCortaException, CurandoAEnemigoException, JugadorYaRealizoLaAccionException, PiezaYaAtacoException;

    void moverUnidadEnTablero(Tablero tableroDePartida,  Pieza pieza, int posicionXFinal, int posicionYFinal) throws UbicacionInvalidaException, NoHayUnidadEnPosicionException, DesplazamientoInvalidoException, NoSePuedeMoverException,  JugadorYaRealizoLaAccionException, PiezaYaMovioException;

    void moverBatallon(Jugador jugadorEnTurno, Tablero tableroDePartida, Infanteria infante, int posicionXFinal, int posicionYFinal) throws JugadorYaRealizoLaAccionException, NoHayBatallonException, UbicacionInvalidaException, JugadorNoPuedeManipularEsaPiezaException, DesplazamientoInvalidoException, NoSePuedeMoverException;

}