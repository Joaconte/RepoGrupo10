package modelo.partida.fase;

import modelo.jugador.PiezaFueraDeSectorException;
import modelo.jugador.UbicacionInvalidaException;
import modelo.jugador.presupuesto.CompraInvalidaException;
import modelo.jugador.presupuesto.PresupuestoAgotadoException;
import modelo.pieza.ataque.PiezaAliadaNoAtacableException;
import modelo.jugador.Jugador;
import modelo.pieza.UnidadEstaMuertaException;
import modelo.pieza.ataque.DistanciaDeAtaqueInvalidaException;
import modelo.pieza.ataque.PiezaAtacante;
import modelo.pieza.Pieza;
import modelo.tablero.Tablero;
import modelo.tablero.casilla.NoHayUnidadEnPosicionException;

public class FaseMedia implements FaseDePartida{

    private boolean jugadorYaAtacoOCuro = false;
    private boolean jugadorYaMovio = false;

    //Metodo que permite que una ficha se ubique en una casilla adyacente vacia, del tablero.
    @Override
    public void moverUnidadEnTablero(Pieza pieza, int numeroColumna, int numeroFila){
        //Construir
    }

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
    public void atacar(PiezaAtacante atacante, Pieza atacada, Tablero tablero) throws UnidadEstaMuertaException, DistanciaDeAtaqueInvalidaException, PiezaAliadaNoAtacableException, NoHayUnidadEnPosicionException {
        atacante.atacar(atacada,tablero);
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