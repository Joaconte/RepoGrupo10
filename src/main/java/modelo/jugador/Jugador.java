package modelo.jugador;

import modelo.jugador.presupuesto.CompraInvalidaException;
import modelo.jugador.presupuesto.PresupuestoAgotadoException;
import modelo.pieza.Pieza;
import modelo.pieza.Ubicacion;
import modelo.pieza.movimiento.NoSePuedeMoverException;
import modelo.tablero.Tablero;

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
    public int getTamanioDelEjercito() {
        return this.ejercito.getTamanio();
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

    public boolean verificarSiEjercitoEstaListo(){
        return ejercito.estaCompleto();
    }


    public void moverUnidad(Ubicacion ubicacionInicial, Ubicacion ubicacionFinal) throws PiezaNoEsDeJugadorException, NoSePuedeMoverException {

        ejercito.moverUnidad(ubicacionInicial, ubicacionFinal);
    }

    public void actualizarEstadoTropas(Tablero tableroDePartida) {
        ejercito.actualizarEstadoTropas(tableroDePartida);
    }
}


