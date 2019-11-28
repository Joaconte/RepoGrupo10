package modelo.jugador;

import modelo.jugador.presupuesto.CompraInvalidaException;
import modelo.jugador.presupuesto.PresupuestoAgotadoException;
import modelo.pieza.Pieza;
import modelo.tablero.Tablero;

public class Jugador {


    private int numeroDeJugador;
    private Sector sector;
    private Ejercito ejercito;
    private String nombre;

    //---------Inicializacion---------//
    //DEJAR UNO SOLO
    public Jugador(int numeroDeJugador, String nombre){

        this.nombre = nombre;
        this.numeroDeJugador = numeroDeJugador;
        this.sector = new Sector(numeroDeJugador);
        this.ejercito = new Ejercito (numeroDeJugador);
    }


    public Jugador(int numeroDeJugador){

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

    //-----------SETTERS-------------//



    //----------Agrega Ubicacion A Unidad--------------//

    public void crearNuevaUnidad(Tablero tablero, String nombreUnidad, int posicionX, int posicionY) throws PiezaFueraDeSectorException, UbicacionInvalidaException, PresupuestoAgotadoException, CompraInvalidaException {
        if (!sector.esDelSector(posicionX)){ throw new PiezaFueraDeSectorException();}
        if (tablero.casillaEstaOcupada(posicionX,posicionY)){ throw new UbicacionInvalidaException();}
        Pieza pieza = ejercito.obtenerNuevaPieza(nombreUnidad,posicionX,posicionY);
        tablero.ocuparCasilla(pieza, posicionX, posicionY);
    }

    public void verificarSiEjercitoEstaListo() throws EjercitoIncompletoException {
        ejercito.verificarSiEstaIncompleto();
    }
}

    /*    public void quitarUnidad(Ubicacion ubicacion) {
        for (int i = 0; i < ejercito.size(); ++i) {
            if(ejercito.get(i).getUbicacion() == ubicacion){
                ejercito.remove(i);
            }
        }
    }

    private Unidad menuUnidades() {

        byte i = '1';
        Scanner capt = new Scanner(System.in);
        while (i != '0') {

            System.out.println("Ingrese 0 para terminar la compra de unidades");
            System.out.println("Ingrese 1 para seleccionar la unidad Infanteria");
            System.out.println("Ingrese 2 para seleccionar la unidad Jinete");
            System.out.println("Ingrese 3 para seleccionar la unidad Curandero");
            System.out.println("Ingrese 4 para seleccionar la unidad Catapulta");
            i = capt.nextByte();
            Unidad unidad = opcionesUnidades(i);
        }
        return null;
    }
    */
