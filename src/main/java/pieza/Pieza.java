package pieza;

import pieza.movimiento.*;
import pieza.recibirDanio.*;
import pieza.sanacion.*;

public abstract class Pieza {
    private int COSTO;
    private int VIDA_MAXIMA;
    private double vida;
    protected Ubicacion ubicacion;
    protected int equipo;
    // strategy pattern
    private IModoMovimiento movimiento;
    private IModoRecibirDanio comoRecibeDanio; // como recibe danio
    private IModoSanacion sanacion;

    public Pieza(int costo, int vidaMaxima, double vida,  int equipo, IModoMovimiento movimiento,IModoSanacion modoSanacion) {
        this.COSTO = costo;
        this.VIDA_MAXIMA = vidaMaxima;
        this.vida = vida;
        this.movimiento = movimiento;
        this.equipo = equipo;
        this.sanacion = modoSanacion;
    }


    // SETTER GETTER

    public void setVida(double vida){
        this.vida = vida;
    }
    public double getPuntosVida(){
        return vida;
    }

    public Ubicacion getUbicacion(){
        return ubicacion;
    }
    public void setUbicacion(Ubicacion ubicacion){
        this.ubicacion = ubicacion;
    }

    public int getEquipo(){ return equipo;}
    public int getCosto(){ return COSTO;}
    public boolean esEnemigo(Pieza otra){
        return (this.getEquipo() != otra.getEquipo());
    }

    // METODOS

    public void enZonaEnemiga(){
        this.comoRecibeDanio = new DanioZonaEnemiga();
    }
    public void enZonaAliada(){
        this.comoRecibeDanio = new DanioZonaPropia();
    }

    // ver q no deje en negativos--- exceptions
    public void recibirDanio(double danioBase) throws UnidadEstaMuertaException {
        if (vida<=0) throw new UnidadEstaMuertaException();
        vida-=comoRecibeDanio.danio(danioBase);

    }

    public void sanar(int puntos) throws UnidadNoSePuedeCurar {
        vida += sanacion.restaurarPuntosDeVida(puntos);
        vida = Math.min(vida, VIDA_MAXIMA);
    }

    /*
    public void moverse(){
        movimiento.moverse();
    }
    public void moverArriba() throws NoSePuedeMoverException {
        Ubicacion nueva = movimiento.arriba(this.getUbicacion());
        this.setUbicacion(nueva);
    }*/
}
