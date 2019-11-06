package model;

import exception.JugadorSinPuntosException;
import exception.PuntosInsuficientesException;

import java.util.ArrayList;
import java.util.List;
import model.Sector;
import model.Unidad;
import org.mockito.Mockito;


public class Jugador {

    private int puntos;
    private String nombre;
    private Sector sector;
    private List<Unidad> ejercito = new ArrayList<Unidad>();

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
    public List<Unidad> getEjercito(){ return ejercito;}
    public Unidad getUltimaUnidadAgregada(){

        int ultima = ejercito.size();
        return ejercito.get(ultima);
    }

    public void descontarPuntos( int costoUnidad) throws PuntosInsuficientesException {

        if (puntos < costoUnidad) {
            throw new PuntosInsuficientesException();
        }
        else {
            puntos = puntos - costoUnidad;
        }
    }

    public Unidad agregarYDevolverUnidad() {

        Unidad unidad = Mockito.mock(Unidad.class);
        int costo = unidad.getCosto();
        try { agregarUnidad(unidad);

        }catch (JugadorSinPuntosException e) {
            System.out.println(e);
            return null;
        }
        return unidad;
    }

    public void agregarUnidad(Unidad unidad) throws JugadorSinPuntosException{

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

}
