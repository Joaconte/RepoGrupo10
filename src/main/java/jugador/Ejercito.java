package jugador;

import pieza.tipos.*;

import java.util.ArrayList;

public class Ejercito{

    private ArrayList<Curandero> curanderos = new ArrayList<Curandero>();
    private ArrayList<Jinete> jinetes = new ArrayList<Jinete>();
    private ArrayList<Catapulta> catapultas = new ArrayList<Catapulta>();
    private ArrayList<Infanteria> soldados = new ArrayList<Infanteria>();
    private int numeroDeEjercito;


    //---------Inicializacion---------//

    public Ejercito(int numeroDeJugador) {
        this.numeroDeEjercito =  numeroDeJugador;
    }

    //-----------GETTERS-----------//

    public int getNumeroDeEjercito(){ return numeroDeEjercito; }
    public int getTamanio(){ return (curanderos.size()+jinetes.size()+catapultas.size()+soldados.size()); };
    public int getCantidadCuranderos(){ return curanderos.size(); }
    public int getCantidadInfantes(){ return soldados.size(); }
    public int getCantidadCatapultas(){ return catapultas.size(); }
    public int getCantidadJinetes(){ return jinetes.size(); }

    //-----------Add-Remove-----------//

    public void agregarCurandero (Curandero unidad) {
        unidad.setEquipo(numeroDeEjercito);
        curanderos.add(unidad);
    }

    public void agregarJinete (Jinete unidad) {
        unidad.setEquipo(numeroDeEjercito);
        jinetes.add(unidad);
    }

    public void agregarInfante (Infanteria unidad) {
        unidad.setEquipo(numeroDeEjercito);
        soldados.add(unidad);
    }

    public void agregarCatapulta (Catapulta unidad) {
        unidad.setEquipo(numeroDeEjercito);
        catapultas.add(unidad);
    }
}

/*
    public boolean ubicacionEsValida(Ubicacion ubicacion) throws UbicacionInvalidaException {

        for (int i = 0; i < ejercito.size(); ++i) {
            if(ejercito.get(i).getUbicacion() == ubicacion){
                throw new UbicacionInvalidaException();
            }
        }
        return true;
    }

    public boolean ubicacionValida(int x, int y) {

        Ubicacion ubicacion = new Ubicacion(x,y);
        boolean booleano = false;
        try {
            booleano = ubicacionEsValida(ubicacion);
        } catch (UbicacionInvalidaException e) {
            System.out.println(e);
            booleano = false;
        }
        return booleano;
    }
}


     */




