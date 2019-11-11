package jugador;

import pieza.Pieza;

import java.util.ArrayList;
import java.util.List;

public class Ejercito{

    private List<Pieza> ejercito = new ArrayList<Pieza>();
    private int numeroDeEjercito;

    //---------Inicializacion---------//

    public Ejercito(int numeroDeJugador) {
        this.numeroDeEjercito =  numeroDeJugador;
    }

    //-----------GETTERS-----------//

    public int getNumeroDeEjercito(){ return numeroDeEjercito; };
    public int getTamanio(){ return ejercito.size(); };

    //-----------Add-Remove-----------//

    public void agregarPieza (Pieza unidad) {
        unidad.setEquipo(numeroDeEjercito);
        ejercito.add(unidad);
    }
    public void removerPieza (int ubicacionUnidad) {
        ejercito.remove(ubicacionUnidad);
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




