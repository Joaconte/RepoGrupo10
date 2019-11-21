package tablero;

import pieza.Ubicacion;

import java.util.ArrayList;
import java.util.List;

public class iteradorDeCasillasAdyacentes extends IteradorDe8Direcciones {

    private ArrayList<Casilla> listadoDeCasillaOcupadas;


     /*----------Inicializadores-----------*/

    public iteradorDeCasillasAdyacentes(){
        this.listadoDeCasillaOcupadas = new ArrayList<>();
    }
    public iteradorDeCasillasAdyacentes(int cantidadColumnas,int cantidadFilas){
        this.listadoDeCasillaOcupadas = new ArrayList<>();
        this.cantidadColumnas = cantidadColumnas;
        this.cantidadFilas = cantidadFilas;
    }

    /*----------------Vaciar listas --------------*/

    private void vaciarListas() {
        listadoDeCasillaOcupadas.clear();
        siguientesUbicaciones.clear();
    }

    /*----------------Buscar Casillas Ocupadas En Distancia Corta--------------*/

    public ArrayList<Casilla> buscarCasillasOcupadasEnDistanciaCorta(Ubicacion ubicacion, List<Columna> columnas, Casilla casilla){
        vaciarListas();;
        ArrayList<Casilla> resultado = buscarOcupadasYAdyacentesEnDistanciaCorta(ubicacion, columnas, casilla);
        desmarcarCasillasVisitadas();
        return resultado;
    }

    private ArrayList<Casilla> buscarOcupadasYAdyacentesEnDistanciaCorta(Ubicacion ubicacion, List<Columna> columnas, Casilla casilla) {
        casilla.setFueRevisada(true);
        registrarSiguientesUbicaciones(ubicacion);
        int tamanioSiguientesUbicaciones = siguientesUbicaciones.size();
        for (int i = 0; i< tamanioSiguientesUbicaciones; i++){
            registrarSiguientesUbicaciones(siguientesUbicaciones.get(i));
        }
        for (int i = 0; i<siguientesUbicaciones.size() ; i++){
            Ubicacion ubicacionSiguiente = siguientesUbicaciones.get(i);
            Casilla casillaSiguiente = getCasillaMedianteUbicacion(ubicacionSiguiente,columnas);
            if (estaOcupadaLaCasilla(casillaSiguiente) && !fueVisitada(casillaSiguiente)){
                listadoDeCasillaOcupadas.add(casillaSiguiente);
                casillaSiguiente.setFueRevisada(true);
            }
        }
        return listadoDeCasillaOcupadas;
    }


    /*---------------Buscar adayacentes ocupadas sin limite---------------*/

    public ArrayList<Casilla> buscarCasillasOcupadasAdyacentes(Ubicacion ubicacion, List<Columna> columnas, Casilla casilla){
        vaciarListas();
        ArrayList<Casilla> resultado = buscarOcupadasYAdyacentes(ubicacion, columnas, casilla);
        desmarcarCasillasVisitadas();
        return resultado;
    }


    public ArrayList<Casilla> buscarOcupadasYAdyacentes(Ubicacion ubicacion, List<Columna> columnas, Casilla casillaActual){
        casillaActual.setFueRevisada(true);
        this.registrarSiguientesUbicaciones(ubicacion);

        for (int i = 0; i<siguientesUbicaciones.size() ; i++){
            Ubicacion ubicacionSiguiente = siguientesUbicaciones.get(i);
            Casilla casillaSiguiente = getCasillaMedianteUbicacion(ubicacionSiguiente,columnas);
             if (estaOcupadaLaCasilla(casillaSiguiente) && !fueVisitada(casillaSiguiente)){
                iteradorDeCasillasAdyacentes iterador = new iteradorDeCasillasAdyacentes(cantidadColumnas,cantidadFilas);
                listadoDeCasillaOcupadas.addAll(iterador.buscarOcupadasYAdyacentes(ubicacionSiguiente,columnas,casillaSiguiente));
            }
        }
        listadoDeCasillaOcupadas.add(casillaActual);;
        return  listadoDeCasillaOcupadas;
    }



    /*-----------------Obtencion-Casillas--------------*/

    public Casilla getCasillaMedianteUbicacion(Ubicacion ubicacion, List<Columna> columnas) {
        int posicionColumna = ubicacion.getPosicionEnX();
        int posicionEnFila = ubicacion.getPosicionEnY();
        return columnas.get(posicionColumna-1).getCasilla(posicionEnFila);
    }

    public boolean estaOcupadaLaCasilla(Casilla casilla){
        return (casilla.getEstado() == "Ocupada");
    }


    public boolean fueVisitada(Casilla casilla){
        return casilla.getFueRevisada();
    }

    public void desmarcarCasillasVisitadas(){
        for (int posicionEnLista=0; posicionEnLista<listadoDeCasillaOcupadas.size(); posicionEnLista++){
            listadoDeCasillaOcupadas.get(posicionEnLista).setFueRevisada(false);
        }
    }
}
