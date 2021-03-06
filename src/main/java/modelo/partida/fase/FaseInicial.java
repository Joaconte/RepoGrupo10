package modelo.partida.fase;


import modelo.jugador.EjercitoIncompletoException;
import modelo.jugador.Jugador;
import modelo.jugador.PiezaFueraDeSectorException;
import modelo.jugador.UbicacionInvalidaException;
import modelo.jugador.presupuesto.CompraInvalidaException;
import modelo.jugador.presupuesto.PresupuestoAgotadoException;
import modelo.partida.JugadorNoPuedeManipularEsaPiezaException;
import modelo.pieza.Pieza;
import modelo.pieza.ataque.PiezaAtacante;
import modelo.pieza.movimiento.Ubicacion;
import modelo.pieza.tipos.Curandero;
import modelo.pieza.tipos.Infanteria;
import modelo.pieza.tipos.NoHayBatallonException;
import modelo.tablero.Tablero;

public class FaseInicial implements FaseDePartida{

    int turnos = 0;


    //Metodo que permite indicar que el jugador termina con las acciones de su turno.
    @Override
    public void finalizarTurno(Jugador jugadorEnTurno) throws EjercitoIncompletoException {
        if (!jugadorEnTurno.estaCompletoEjercito()) throw new EjercitoIncompletoException();
        turnos ++;
    }

    @Override
    public boolean esFaseInicial(){
        return true;
    }

    //Ataques y curacion
    @Override
    public void atacar(PiezaAtacante atacante, Pieza atacada, Tablero tablero) {
    }


    @Override
    public FaseDePartida retornarProximaFase() {
        if (turnos == 2){return new FaseMedia();}
        return this;
    }

    @Override
    public Pieza crearPieza(Jugador jugadorEnTurno, Tablero tableroDePartida, String nombreDeUnidad, int posicionEnX, int posicionEnY) throws UbicacionInvalidaException, PresupuestoAgotadoException, CompraInvalidaException, PiezaFueraDeSectorException {
        return jugadorEnTurno.crearNuevaUnidad(tableroDePartida,nombreDeUnidad,posicionEnX,posicionEnY);
    }

    @Override
    public void curarAAliado(Curandero piezaCurandera, Pieza otraPieza){

    }

    @Override
    public void moverUnidadEnTablero(Tablero tableroDePartida, Pieza pieza, int posXFin, int posYFin) {

    }

    @Override
    public void moverBatallon(Jugador jugadorEnTurno, Tablero tableroDePartida, Infanteria infante, int posicionXFinal, int posicionYFinal) {

    }





}