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

    private static int ATAQUES_MAXIMOS = 3;
    private static int MOVIMIENTOS_MAXIMOS = 2;
    private int ataquesDeJugador;
    private int movimientosDeJugador;
    ArrayList<Ubicacion> ubicacionesQueAtacaron = new ArrayList<>();
    ArrayList<Ubicacion> ubicacionesQueMovieron = new ArrayList<>();


    //Metodo que permite indicar que el jugador termina con las acciones de su turno.
    @Override
    public void finalizarTurno(Jugador jugadorEnTurno){
        ataquesDeJugador = 0;
        movimientosDeJugador = 0;
        ubicacionesQueAtacaron.clear();
        ubicacionesQueMovieron.clear();
    }

    @Override
    public boolean esFaseInicial(){
        return false;
    }

    //Ataques o cura
    @Override
    public void atacar(PiezaAtacante atacante, Pieza atacada, Tablero tablero) throws JugadorYaRealizoLaAccionException, UnidadEstaMuertaException, DistanciaDeAtaqueInvalidaException, PiezaAliadaNoAtacableException, PiezaYaAtacoException {
        if(ataquesDeJugador == ATAQUES_MAXIMOS) throw new JugadorYaRealizoLaAccionException();
        else if (ubicacionYaHizoAccion(atacante.getUbicacion(), ubicacionesQueAtacaron)) throw new PiezaYaAtacoException();
        atacante.atacar(atacada,tablero);
        ataquesDeJugador += 1;
        ubicacionesQueAtacaron.add(atacante.getUbicacion());
    }

    @Override
    public void curarAAliado(Curandero piezaCurandera, Pieza otraPieza) throws UnidadNoSePuedeCurar, CurandoCuraADistanciaCortaException, CurandoAEnemigoException, JugadorYaRealizoLaAccionException, PiezaYaAtacoException {
        if(ataquesDeJugador == ATAQUES_MAXIMOS) throw new JugadorYaRealizoLaAccionException();
        else if (ubicacionYaHizoAccion(piezaCurandera.getUbicacion(), ubicacionesQueAtacaron)) throw new PiezaYaAtacoException();
        piezaCurandera.curarAAliado(otraPieza);
        ataquesDeJugador +=1;
        ubicacionesQueAtacaron.add(piezaCurandera.getUbicacion());
    }

    @Override
    public void moverUnidadEnTablero(Tablero tableroDePartida, Jugador jugadorEnTurno, Ubicacion ubicacionInicial, Ubicacion ubicacionFinal) throws UbicacionInvalidaException, NoHayUnidadEnPosicionException, DesplazamientoInvalidoException, NoSePuedeMoverException, PiezaNoEsDeJugadorException, JugadorYaRealizoLaAccionException, PiezaYaMovioException {
        if(movimientosDeJugador == MOVIMIENTOS_MAXIMOS) throw new JugadorYaRealizoLaAccionException();
        else if (ubicacionYaHizoAccion(ubicacionInicial, ubicacionesQueMovieron)) throw new PiezaYaMovioException();
        else if (!jugadorEnTurno.jugadorControlaUbicacion(ubicacionInicial)) throw new PiezaNoEsDeJugadorException();
        tableroDePartida.moverUnidad(ubicacionInicial, ubicacionFinal);
        movimientosDeJugador += 1;
        ubicacionesQueMovieron.add(ubicacionFinal);

    }

    @Override
    public void moverBatallon(Jugador jugador, Tablero tableroDePartida , Ubicacion ubicacionInicial, Ubicacion ubicacionFinal ) throws JugadorYaRealizoLaAccionException, NoHayBatallonException, UbicacionInvalidaException, JugadorNoPuedeManipularEsaPiezaException {
        if(movimientosDeJugador == MOVIMIENTOS_MAXIMOS) throw new JugadorYaRealizoLaAccionException();
        jugador.desplazarBatallon(tableroDePartida,ubicacionInicial,ubicacionFinal);
        movimientosDeJugador += 1;
        ubicacionesQueMovieron.add(ubicacionFinal);
    }


    public boolean ubicacionYaHizoAccion (Ubicacion ubicacion, ArrayList<Ubicacion> ubicaciones){
        for (int j = 0; j < ubicaciones.size(); j++)
            if (sonLaMismaUbicacion(ubicaciones.get(j), ubicacion))
                return true;
        return false;
    }

    public boolean sonLaMismaUbicacion(Ubicacion ubicacion1, Ubicacion ubicacion2){

        return (ubicacion1.getPosicionEnX() == ubicacion2.getPosicionEnX() &&
                ubicacion1.getPosicionEnY() == ubicacion2.getPosicionEnY());
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