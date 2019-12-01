package modelo.jugador;

public class Sector {

    private int primeraFila;
    private int ultimaFila;
    private int numeroDeSector;
    private int filasTotalesEnElSector = 10;

    public Sector(int numeroJugador){
        this.numeroDeSector=numeroJugador;
        this.primeraFila= (numeroJugador - 1 ) * filasTotalesEnElSector; //Se admite posicion 0.
        this.ultimaFila= (numeroJugador * filasTotalesEnElSector) - 1; //Se baja uno porque existe columna 0
    }

    //-----------GETTERS-----------//
    public int getPrimeraPos() {
        return primeraFila;
    }
    public int getUltimaPos() {
        return ultimaFila;
    }

    public boolean esDelSector(int numColumna){
        return (primeraFila<=numColumna && numColumna<=ultimaFila);
    }
}

