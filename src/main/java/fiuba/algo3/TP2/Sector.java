package model;

public class Sector {

    private int primeraPos;
    private int ultimaPos;

    public Sector(int primeraPos, int ultimaPos){
        this.primeraPos = primeraPos;
        this.ultimaPos = ultimaPos;
    }

    //-----------GETTERS-----------//
    public int getPrimeraPos() {
        return primeraPos;
    }
    public int getUltimaPos() {
        return ultimaPos;
    }
}

