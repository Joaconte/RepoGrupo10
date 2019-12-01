package modelo.partida.fase;

import modelo.jugador.EjercitoIncompletoException;
import modelo.jugador.UbicacionInvalidaException;
import modelo.jugador.presupuesto.CompraInvalidaException;
import modelo.jugador.presupuesto.PresupuestoAgotadoException;
import modelo.pieza.ataque.PiezaAliadaNoAtacableException;
import modelo.jugador.Jugador;
import modelo.jugador.PiezaFueraDeSectorException;
import modelo.pieza.UnidadEstaMuertaException;
import modelo.pieza.ataque.DistanciaDeAtaqueInvalidaException;
import modelo.pieza.ataque.PiezaAtacante;
import modelo.pieza.Pieza;
import modelo.tablero.Tablero;

public interface FaseDePartida{

    //Metodos abstractos implementados por las subclases

    void moverUnidadEnTablero(Pieza pieza, int numeroFila, int numeroColumna);

    void finalizarTurno(Jugador jugadorEnTurno) throws EjercitoIncompletoException;

    boolean esFaseInicial();

    void atacar(PiezaAtacante atacante, Pieza atacada, Tablero tablero) throws UnidadEstaMuertaException, DistanciaDeAtaqueInvalidaException, PiezaAliadaNoAtacableException;

    FaseDePartida retornarProximaFase();

    Pieza crearPieza(Jugador jugadorEnTurno, Tablero tableroDePartida, String nombreDeUnidad, int posicionEnX, int posicionEnY) throws UbicacionInvalidaException, PresupuestoAgotadoException, CompraInvalidaException, PiezaFueraDeSectorException;
}