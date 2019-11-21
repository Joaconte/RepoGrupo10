package tablero;

import pieza.Ubicacion;
import pieza.movimiento.SeMueveEnTodasDirecciones;

import java.util.ArrayList;
import java.util.List;

public class BuscadorCasillasAdyacentes extends SeMueveEnTodasDirecciones {

    private ArrayList<Casilla> listadoDeCasillaOcupadas;
    protected ArrayList<Ubicacion> siguientesUbicaciones = new ArrayList<>();
    protected int cantidadColumnas =20;
    protected int cantidadFilas = 20;


     /*----------Inicializadores-----------*/

    public BuscadorCasillasAdyacentes(){
        this.listadoDeCasillaOcupadas = new ArrayList<>();
    }
    public BuscadorCasillasAdyacentes(int cantidadColumnas, int cantidadFilas){
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
                BuscadorCasillasAdyacentes iterador = new BuscadorCasillasAdyacentes(cantidadColumnas,cantidadFilas);
                listadoDeCasillaOcupadas.addAll(iterador.buscarOcupadasYAdyacentes(ubicacionSiguiente,columnas,casillaSiguiente));
            }
        }
        listadoDeCasillaOcupadas.add(casillaActual);;
        return  listadoDeCasillaOcupadas;
    }

    /*-----------------Direcciones--------------------*/

    public void registrarSiguientesUbicaciones(Ubicacion ubicacion) {

        siguientesUbicaciones.add(abajo(ubicacion));
        siguientesUbicaciones.add(arriba(ubicacion));
        siguientesUbicaciones.add(derecha(ubicacion));
        siguientesUbicaciones.add(izquierda(ubicacion));
        siguientesUbicaciones.add(arribaDerecha(ubicacion));
        siguientesUbicaciones.add(arribaIzquierda(ubicacion));
        siguientesUbicaciones.add(abajoDerecha(ubicacion));
        siguientesUbicaciones.add(abajoIzquierda(ubicacion));

        for (int i=this.siguientesUbicaciones.size()-1; i>-1; i--){
            Ubicacion ubicacionSiguiente = (this.siguientesUbicaciones.get(i));
            if (!esValidaLaUbicacion(ubicacionSiguiente)){this.siguientesUbicaciones.remove(i);}
        }
    }

    public boolean esValidaLaUbicacion(Ubicacion ubicacion){
        boolean esCorrectaPosicionEnX = (ubicacion.getPosicionEnX()>(0) && ubicacion.getPosicionEnX()< cantidadColumnas +1);
        boolean esCorrectaPosicionEnY = (ubicacion.getPosicionEnY()>(0) && ubicacion.getPosicionEnY()< cantidadFilas +1);
        return (esCorrectaPosicionEnX && esCorrectaPosicionEnY);
    }

    public  ArrayList<Ubicacion> getSiguientesUbicaciones(){ return this.siguientesUbicaciones;}

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
