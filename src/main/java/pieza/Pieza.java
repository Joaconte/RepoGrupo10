package pieza;

import pieza.movimiento.*;
import pieza.recibirDanio.*;
import pieza.sanacion.*;

public abstract class Pieza {
    private int COSTO;
    private int VIDA_MAXIMA;
    private double vida;
    protected Ubicacion ubicacion;
    private int equipo;
    // strategy pattern
    private IModoMovimiento modoMovimiento;
    private IModoRecibirDanio modoRecibirDanio;
    private IModoSanacion modoSanacion;

    public Pieza(int costo, int vidaMaxima, double vida, int equipo, IModoMovimiento modoMovimiento, IModoSanacion modoSanacion) {
    this.COSTO=costo;
    this.VIDA_MAXIMA=vidaMaxima;
    this.vida=vida;
    this.equipo=equipo;
    this.modoMovimiento=modoMovimiento;
    this.modoSanacion=modoSanacion;
    this.modoRecibirDanio= new DanioZonaPropia();
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
        this.modoRecibirDanio = new DanioZonaEnemiga();
    }
    public void enZonaAliada(){
        this.modoRecibirDanio = new DanioZonaPropia();
    }

    // ver q no deje en negativos--- exceptions
    public void recibirDanio(double danioBase) throws UnidadEstaMuertaException {
        if (vida<=0) throw new UnidadEstaMuertaException();
        vida-= modoRecibirDanio.danio(danioBase);

    }

    public void sanar(int puntos) throws UnidadNoSePuedeCurar {
        vida += modoSanacion.restaurarPuntosDeVida(puntos);
        vida = Math.min(vida, VIDA_MAXIMA);
    }

    /*
    public void moverse(){
        movimiento.moverse();
    }
    */
    public void moverArriba() throws NoSePuedeMoverException {
        Ubicacion nueva = modoMovimiento.arriba(this.getUbicacion());
        this.setUbicacion(nueva);
    }

    public abstract String getNombre();
}
