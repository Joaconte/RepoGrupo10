package fiuba.algo3.TP2.model;

import fiuba.algo3.TP2.exception.JugadorSinPuntosException;
import fiuba.algo3.TP2.exception.PuntosInsuficientesException;
import fiuba.algo3.TP2.exception.UbicacionInvalidaException;

import java.util.ArrayList;
import java.util.List;



public class Jugador {

    private int puntos;
    private String nombre;
    private Sector sector;
    private List<Pieza> ejercito = new ArrayList<Pieza>();

    public Jugador(String nombre, Sector sector){
        this.nombre = nombre;
        this.sector = sector;
        puntos = 20;
    }

    //-----------GETTERS-----------//
    public String getNombre(){
        return nombre;
    }
    public Sector getSector(){
        return sector;
    }
    public int getPuntos(){
        return puntos;
    }
    public List<Pieza> getEjercito(){ return ejercito;}

    public void descontarPuntos( int costoUnidad) throws PuntosInsuficientesException {

        if (puntos < costoUnidad) {
            throw new PuntosInsuficientesException();
        }
        else {
            puntos = puntos - costoUnidad;
        }
    }

    public Pieza agregarYDevolverUnidad(int i) {

        Pieza unidad = opcionesUnidades(i);
        int costo = unidad.getCosto();
        try { agregarUnidad(unidad);

        }catch (JugadorSinPuntosException e) {
            System.out.println(e);
            return null;
        }
        return unidad;
    }

    public void agregarUnidad(Pieza unidad) throws JugadorSinPuntosException{

        if (puntos == 0) {
            throw new JugadorSinPuntosException();
        }
        else {
            try {
                descontarPuntos(unidad.getCosto());

            } catch (PuntosInsuficientesException e) {
                System.out.println(e);
                return;
            }

            ejercito.add(unidad);
        }
    }

    public void quitarUnidad(Ubicacion ubicacion) {
        for (int i = 0; i < ejercito.size(); ++i) {
            if(ejercito.get(i).getUbicacion() == ubicacion){
                ejercito.remove(i);
            }
        }
    }

    public boolean tieneEjercito(){
        if (ejercito.size() != 0 ){
            return true;
        }
        return false;
    }

    /*
    private Unidad menuUnidades() {

        byte i = '1';
        Scanner capt = new Scanner(System.in);
        while (i != '0') {

            System.out.println("Ingrese 0 para terminar la compra de unidades");
            System.out.println("Ingrese 1 para seleccionar la unidad Infanteria");
            System.out.println("Ingrese 2 para seleccionar la unidad Jinete");
            System.out.println("Ingrese 3 para seleccionar la unidad Curandero");
            System.out.println("Ingrese 4 para seleccionar la unidad Catapulta");
            i = capt.nextByte();
            Unidad unidad = opcionesUnidades(i);
        }
        return null;
    }
    */


    private Pieza opcionesUnidades(int i){

        switch (i){
            case 0:
                break;
            case 1: //INFANTERIA
                break;
            case 2: //JINETE
                break;
            case 3: //CURANDERO
                break;
            case 4: //CATAPULTA
                break;
            default:
                System.out.println("Dato ingresado invalido");
        }
        return null;
    }

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
