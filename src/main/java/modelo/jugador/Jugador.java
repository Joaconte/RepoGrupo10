package modelo.jugador;

import modelo.jugador.presupuesto.CompraInvalidaException;
import modelo.jugador.presupuesto.PresupuestoAgotadoException;
import modelo.partida.JugadorNoPuedeManipularEsaPiezaException;
import modelo.pieza.Pieza;
import modelo.pieza.Ubicacion;
import modelo.pieza.tipos.NoHayBatallonException;
import modelo.pieza.tipos.NoSirvenParaBatallonException;
import modelo.tablero.Tablero;

import java.util.ArrayList;

public class Jugador {


    private int numeroDeJugador;
    private Sector sector;
    private Ejercito ejercito;
    private String nombre;

    //---------Inicializacion---------//

    public Jugador(int numeroDeJugador, String nombre){

        this.nombre = nombre;
        this.numeroDeJugador = numeroDeJugador;
        this.sector = new Sector(numeroDeJugador);
        this.ejercito = new Ejercito (numeroDeJugador);
    }

    //-----------GETTERS-----------//

    public int getNumeroDeJugador(){
        return numeroDeJugador;
    }
    public Sector getSector(){
        return sector;
    }
    public String getNombre(){ return nombre;}
    public int getPuntos(){ return ejercito.getPresupuesto();}


    //----------Agrega Ubicacion A Unidad--------------//

    public Pieza crearNuevaUnidad(Tablero tablero, String nombreUnidad, int posicionX, int posicionY) throws PiezaFueraDeSectorException, UbicacionInvalidaException, PresupuestoAgotadoException, CompraInvalidaException {
        if (!sector.esDelSector(posicionY)){ throw new PiezaFueraDeSectorException();}
        if (tablero.casillaEstaOcupada(posicionX,posicionY)){ throw new UbicacionInvalidaException();}
        Pieza pieza = ejercito.obtenerNuevaPieza(nombreUnidad,posicionX,posicionY);
        tablero.ocuparCasilla(pieza, posicionX, posicionY);
        return pieza;
    }

    public boolean estaCompletoEjercito(){
        return ejercito.estaCompleto();
    }


    public boolean jugadorControlaUbicacion(Ubicacion ubicacionInicial) {
        return ejercito.dominaEstaUbicacion(ubicacionInicial);
    }

    public boolean jugadorEsPerdedor(){ return ejercito.estaDestruido(); }

    public void actualizarEstadoTropas(Tablero tableroDePartida) {
        ejercito.removerBajas(tableroDePartida);
    }

    public void formanBatallon(ArrayList<Pieza> piezas) throws NoSirvenParaBatallonException {
        ejercito.agregarBatallon(piezas);
    }
    public void desplazarBatallon(Tablero tablero, Ubicacion ubicacionInicial, Ubicacion  ubicacionFinal) throws NoHayBatallonException, UbicacionInvalidaException, JugadorNoPuedeManipularEsaPiezaException {
        if (!jugadorControlaUbicacion(ubicacionInicial)) throw new JugadorNoPuedeManipularEsaPiezaException();
        ejercito.desplazarBatallon(tablero,ubicacionInicial,ubicacionFinal);
    }
}


