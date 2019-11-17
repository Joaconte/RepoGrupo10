package jugador;

public class Sector {

    private int columnaEnQueIniciaElSector;
    private int columnaEnQueTerminaElSector;
    private int numeroDeSector;
    private int columnasTotalesEnElSector = 10;

    public Sector(int numeroJugador){
        this.numeroDeSector=numeroJugador;
        this.columnaEnQueTerminaElSector = numeroJugador * columnasTotalesEnElSector; //conteo de jugador inicia en 1
        this.columnaEnQueIniciaElSector = columnaEnQueTerminaElSector - (columnasTotalesEnElSector-1);
    }

    //-----------GETTERS-----------//
    public int getPrimeraPos() {
        return columnaEnQueIniciaElSector;
    }
    public int getUltimaPos() {
        return columnaEnQueTerminaElSector;
    }

    public boolean esDelSector(int numColumna){
        return (columnaEnQueIniciaElSector<=numColumna && numColumna<=columnaEnQueTerminaElSector);
    }
}

