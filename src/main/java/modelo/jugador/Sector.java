package modelo.jugador;

public class Sector {

    private int primeraColumna;
    private int ultimaColumna;
    private int numeroDeSector;
    private int columnasTotalesEnElSector = 10;

    public Sector(int numeroJugador){
        this.numeroDeSector=numeroJugador;
        this.primeraColumna= (numeroJugador - 1 ) * columnasTotalesEnElSector; //Se admite posicion 0.
        this.ultimaColumna= (numeroJugador * columnasTotalesEnElSector) - 1; //Se baja uno porque existe columna 0
    }

    //-----------GETTERS-----------//
    public int getPrimeraPos() {
        return primeraColumna;
    }
    public int getUltimaPos() {
        return ultimaColumna;
    }

    public boolean esDelSector(int numColumna){
        return (primeraColumna<=numColumna && numColumna<=ultimaColumna);
    }
}

