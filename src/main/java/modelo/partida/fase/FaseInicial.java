package modelo.partida.fase;


import modelo.jugador.EjercitoIncompletoException;
import modelo.jugador.Jugador;
import modelo.jugador.PiezaFueraDeSectorException;
import modelo.jugador.UbicacionInvalidaException;
import modelo.jugador.presupuesto.CompraInvalidaException;
import modelo.jugador.presupuesto.PresupuestoAgotadoException;
import modelo.pieza.ataque.PiezaAtacante;
import modelo.pieza.Pieza;
import modelo.tablero.Tablero;

public class FaseInicial implements FaseDePartida{

    int turnos = 0;

    //Metodo que permite intercambiar fichas en dos posiciones cualesquiera en el sector del jugador.
    @Override
    public void moverUnidadEnTablero(Pieza pieza, int posicionFila, int posicionColumna){
    }

    //Metodo que permite indicar que el jugador termina con las acciones de su turno.
    @Override
    public void finalizarTurno(Jugador jugadorEnTurno) throws EjercitoIncompletoException {
        if (!jugadorEnTurno.verificarSiEjercitoEstaListo()) throw new EjercitoIncompletoException();
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
    public void colocarPieza(Jugador jugadorEnTurno, Tablero tableroDePartida, String nombreDeUnidad, int posicionEnX, int posicionEnY) throws UbicacionInvalidaException, PresupuestoAgotadoException, CompraInvalidaException, PiezaFueraDeSectorException {
        jugadorEnTurno.crearNuevaUnidad(tableroDePartida,nombreDeUnidad,posicionEnX,posicionEnY);
    }


}