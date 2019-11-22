package tablero;

import pieza.Ubicacion;
import tablero.casilla.Casilla;

import java.util.ArrayList;
import java.util.List;

// revisar el nombre. No es representativo de lo que hace
// no tiene estado. No será que las responsabilidades tienen que estar en otro objeto? Tal vez Tablero
public class GestorDeMovimientos {

    public ArrayList<Casilla> buscarCasillasLibresAdyacentes(Ubicacion ubicacion, List<Columna> columnas){
        ArrayList<Casilla> resultado = buscarLibresYAdyacentes(ubicacion, columnas);
        return resultado;
    }

    public ArrayList<Casilla> buscarLibresYAdyacentes(Ubicacion ubicacion, List<Columna> columnas){
        ArrayList<Casilla> listadoDeCasillasLibres = new ArrayList<Casilla>();

        int posicionEnX = ubicacion.getPosicionEnX();
        int posicionEnY = ubicacion.getPosicionEnY();

        //Limites
        int inicioX = posicionEnX-1;
        int finX = posicionEnX+1;
        int inicioY = posicionEnY-1;
        int finY = posicionEnY+1;

        //Problemas de borde
        if (posicionEnX == 1){
            inicioX = 1;
        }
        if (posicionEnX == 19){
            finX = 19;
        }
        if (posicionEnY == 1){
            inicioY = 1;
        }
        if (posicionEnY == 19){
            finY = 19;
        }

        for (int i = inicioX; i <= finX ; i++){

            Columna columna = columnas.get(i);
            for (int j = inicioY; j <= finY ; j++){

                Casilla casilla = columna.getCasilla(j);

                if ( estaLibreLaCasilla( casilla )){
                    listadoDeCasillasLibres.add(casilla);

                }
            }
        }

        return listadoDeCasillasLibres;
    }

    public boolean estaLibreLaCasilla(Casilla casilla){
        return (casilla.getEstado().equals("Libre"));
    }
}
