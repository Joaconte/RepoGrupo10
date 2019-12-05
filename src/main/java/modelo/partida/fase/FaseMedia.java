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

    public void moverBatallon(Tablero tableroDePartida , ArrayList<Ubicacion> ubicaciones, Direccion direccion ) throws JugadorYaRealizoLaAccionException, PiezaYaMovioException {
        if( movimientosDeJugador == MOVIMIENTOS_MAXIMOS) throw new JugadorYaRealizoLaAccionException();
        else if( batallonYaMovio(ubicaciones)) throw new PiezaYaMovioException();
        tableroDePartida.moverBatallon(ubicaciones, direccion);
        movimientosDeJugador += 1;
        for ( int i = 0 ; i < ubicaciones.size(); i++)
            ubicacionesQueMovieron.add(ubicaciones.get(i));
    }

    public boolean batallonYaMovio(ArrayList<Ubicacion> ubicaciones){
        for ( int i = 0 ; i < ubicaciones.size(); i++)
            return ubicacionYaHizoAccion(ubicaciones.get(i), ubicacionesQueMovieron);
        return false;
    }

    public boolean ubicacionYaHizoAccion (Ubicacion ubicacion, ArrayList<Ubicacion> ubicaciones){
        for (int j = 0; j < ubicaciones.size(); j++)
            return (sonLaMismaUbicacion(ubicaciones.get(j), ubicacion));
        return false;
    }

    public boolean sonLaMismaUbicacion(Ubicacion ubicacion1, Ubicacion ubicacion2){

        return (ubicacion1.getPosicionEnX() == ubicacion2.getPosicionEnX() &&
                ubicacion1.getPosicionEnY() == ubicacion2.getPosicionEnY());
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