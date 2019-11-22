package tablero;

import pieza.Pieza;
import pieza.Ubicacion;
import tablero.casilla.Casilla;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tablero {
    private static final int FILAS = 20;
    private static final int COLUMNAS = 20;
    private List<Columna> columnas = new ArrayList<Columna>();


    public Tablero(){
        for (int numeroDeColumna=1; numeroDeColumna<(COLUMNAS+1); numeroDeColumna++)
            columnas.add(new Columna(numeroDeColumna, FILAS));
    }

    public void ocuparCasilla(Pieza pieza, int numeroDeColumna, int numeroDeFila){
        Columna unaColumna = columnas.get(numeroDeColumna-1);
        unaColumna.ocuparCasilla(pieza, numeroDeFila);
    }

    // se usa solo en pruebas
    public void desocuparCasilla(int numeroDeColumna, int numeroDeFila){
        Columna unaColumna = columnas.get(numeroDeColumna-1);
        unaColumna.desocuparCasilla(numeroDeFila);
    }

    public int getTamanio(){
        return FILAS * COLUMNAS;
    }

    public int getCantidadColumnasCreadas(){
        return columnas.size();
    }

    // solo se usa en las pruebas, además devuelve string cuando la consulta puede ser booleana
    public String getEstadoCasilla(int numeroDeLaColumna, int numeroDeLaFila){
        Columna unaColumna = columnas.get(numeroDeLaColumna-1);
        return unaColumna.getEstadoCasillaDeLaFila(numeroDeLaFila);
    }

    // no se usa desde afuera, debería ser privado
    public Casilla getCasilla(Ubicacion ubicacion){
        return columnas.get(ubicacion.getPosicionEnX()-1).getCasilla(ubicacion.getPosicionEnY());
    }

    public ArrayList<Pieza> getCasillasEnAdyacenciaCercana(Ubicacion  ubicacionOcupada){
        Casilla unaCasilla= getCasilla(ubicacionOcupada);
        BuscadorCasillasAdyacentes iterador= new BuscadorCasillasAdyacentes();
        ArrayList<Casilla> casillasAdyacentes = iterador.buscarCasillasOcupadasEnDistanciaCorta(ubicacionOcupada, columnas, unaCasilla);
        return buscarPiezasEnCasillas(casillasAdyacentes);
    }

    // faltan pruebas
    public ArrayList<Casilla> getCasillasLibresEnAdyacencia(Ubicacion ubicacionOcupada) {
        GestorDeMovimientos gestorDeMovimientos = new GestorDeMovimientos();
        return gestorDeMovimientos.buscarCasillasLibresAdyacentes(ubicacionOcupada, columnas);
    }

    public ArrayList<Pieza> getPiezasEnAdyacencia(Ubicacion ubicacionOcupada){
        Casilla unaCasilla= getCasilla(ubicacionOcupada);
        BuscadorCasillasAdyacentes iterador= new BuscadorCasillasAdyacentes();
        ArrayList<Casilla>casillasAdyacentes =iterador.buscarCasillasOcupadasAdyacentes(ubicacionOcupada,columnas,unaCasilla);

        return buscarPiezasEnCasillas(casillasAdyacentes);

    }

//    public List<Pieza> piezasEnTornoAPosicion(Ubicacion ubicacion) {
//        this.casillasAdyascentesA(ubicacion).stream()
//                .filter(c -> c.getEstado().equals("Libre"))
//                .map(c -> c.getContenido())
//                .toArray();
//    }
//    private List<Casilla> casillasAdyascentesA(Ubicacion ubicacion) {
//        return Collections.emptyList();
//    }

    // debería ser privado
    public ArrayList<Pieza> buscarPiezasEnCasillas(ArrayList<Casilla> lista){

        ArrayList<Pieza> piezasAdyacentes = new ArrayList<Pieza>();
        for (int i = 0; i < lista.size() ; i++){
            piezasAdyacentes.add( lista.get(i).getContenido());
        }
        return piezasAdyacentes;
    }

}


