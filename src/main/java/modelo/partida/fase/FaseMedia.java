package modelo.partida.fase;

import modelo.jugador.Jugador;
import modelo.jugador.UbicacionInvalidaException;
import modelo.jugador.presupuesto.PresupuestoAgotadoException;
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
    public void moverUnidadEnTablero(Tablero tableroDePartida, Pieza pieza, int posFinalX, int posFinalY) throws DesplazamientoInvalidoException, NoSePuedeMoverException, JugadorYaRealizoLaAccionException, UbicacionInvalidaException {
        if(movimientosDeJugador == MOVIMIENTOS_MAXIMOS) throw new JugadorYaRealizoLaAccionException();
        tableroDePartida.moverUnidad(pieza, posFinalX, posFinalY);
        pieza.mover(posFinalX,posFinalY);
        movimientosDeJugador += 1;

    }

    @Override
    public void moverBatallon(Jugador jugadorEnTurno, Tablero tableroDePartida, Infanteria infante, int posicionXFinal, int posicionYFinal) throws JugadorYaRealizoLaAccionException, NoHayBatallonException, DesplazamientoInvalidoException, NoSePuedeMoverException {
        if(movimientosDeJugador == MOVIMIENTOS_MAXIMOS) throw new JugadorYaRealizoLaAccionException();
        jugadorEnTurno.desplazarBatallon(tableroDePartida,infante,posicionXFinal,posicionYFinal);
        movimientosDeJugador += 1;
    }


    @Override
    public FaseDePartida retornarProximaFase() {
        return this;
    }

    @Override
    public Pieza crearPieza(Jugador jugadorEnTurno, Tablero tableroDePartida, String nombreDeUnidad, int posicionEnX, int posicionEnY) throws PresupuestoAgotadoException {
        throw new PresupuestoAgotadoException();
    }




}