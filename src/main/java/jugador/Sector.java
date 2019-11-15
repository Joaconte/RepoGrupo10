package jugador;

public class Sector {

    private int primeraColumna;
    private int ultimaColumna;

    public Sector(int primeraPos, int ultimaPos){
        this.primeraColumna = primeraPos;
        this.ultimaColumna = ultimaPos;
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

