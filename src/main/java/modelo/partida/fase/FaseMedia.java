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

import java.util.ArrayList;
import java.util.List;

public class FaseMedia implements FaseDePartida{

    private static int ATAQUES_MAXIMOS = 3;
    private static int MOVIMIENTOS_MAXIMOS = 2;
    private int ataquesDeJugador;
    private int movimientosDeJugador;
    private List<Pieza> piezasAtaqueOCura = new ArrayList<>();
    private List<Pieza> piezaMovidas = new ArrayList<>();


    //Metodo que permite indicar que el jugador termina con las acciones de su turno.
    @Override
    public void finalizarTurno(Jugador jugadorEnTurno){
        ataquesDeJugador = 0;
        movimientosDeJugador = 0;
        piezasAtaqueOCura.clear();
        piezaMovidas.clear();
    }

    @Override
    public boolean esFaseInicial(){
        return false;
    }

    //Ataques o cura
    @Override
    public void atacar(PiezaAtacante atacante, Pieza atacada, Tablero tablero) throws JugadorYaRealizoLaAccionException, UnidadEstaMuertaException, DistanciaDeAtaqueInvalidaException, PiezaAliadaNoAtacableException, PiezaYaAtacoOCuroException {
        if(ataquesDeJugador == ATAQUES_MAXIMOS) throw new JugadorYaRealizoLaAccionException();
        if(piezasAtaqueOCura.contains(atacante)) throw new PiezaYaAtacoOCuroException();
        atacante.atacar(atacada,tablero);
        ataquesDeJugador += 1;
        piezasAtaqueOCura.add(atacante);
    }

    @Override
    public void curarAAliado(Curandero piezaCurandera, Pieza otraPieza) throws UnidadNoSePuedeCurar, CurandoCuraADistanciaCortaException, CurandoAEnemigoException, JugadorYaRealizoLaAccionException, PiezaYaAtacoOCuroException {
        if(ataquesDeJugador == ATAQUES_MAXIMOS) throw new JugadorYaRealizoLaAccionException();
        if(piezasAtaqueOCura.contains(piezaCurandera)) throw new PiezaYaAtacoOCuroException();
        piezaCurandera.curarAAliado(otraPieza);
        piezasAtaqueOCura.add(piezaCurandera);
        ataquesDeJugador +=1;
    }

    @Override
    public void moverUnidadEnTablero(Tablero tableroDePartida, Pieza pieza, int posFinalX, int posFinalY) throws DesplazamientoInvalidoException, NoSePuedeMoverException, JugadorYaRealizoLaAccionException, UbicacionInvalidaException, PiezaYaMovioException {
        if(movimientosDeJugador == MOVIMIENTOS_MAXIMOS) throw new JugadorYaRealizoLaAccionException();
        if(piezaMovidas.contains(pieza)) throw new PiezaYaMovioException();
        tableroDePartida.moverUnidad(pieza, posFinalX, posFinalY);
        piezaMovidas.add(pieza);
        movimientosDeJugador += 1;

    }

    @Override
    public void moverBatallon(Jugador jugadorEnTurno, Tablero tableroDePartida, Infanteria infante, int posicionXFinal, int posicionYFinal) throws JugadorYaRealizoLaAccionException, NoHayBatallonException, DesplazamientoInvalidoException, NoSePuedeMoverException, PiezaYaMovioException, UbicacionInvalidaException {
        if(movimientosDeJugador == MOVIMIENTOS_MAXIMOS) throw new JugadorYaRealizoLaAccionException();
        if(piezaMovidas.contains(infante)) throw new PiezaYaMovioException();
        jugadorEnTurno.desplazarBatallon(tableroDePartida,infante,posicionXFinal,posicionYFinal);
        movimientosDeJugador += 1;
        piezaMovidas.add(infante);
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