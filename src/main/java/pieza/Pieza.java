package pieza;

import pieza.movimiento.IModoMovimiento;
import pieza.movimiento.NoSePuedeMoverException;
import pieza.movimiento.SeMueveEnTodasDirecciones;
import pieza.movimiento.SinMovimientos;
import pieza.recibirDanio.*;
import pieza.sanacion.*;

public abstract class Pieza {
    private int COSTO;
    private int VIDA_MAXIMA;
    private double vida;
    protected Ubicacion ubicacion;
    protected int equipo;

    public Pieza(int costo, int vidaMaxima, double vida, Ubicacion ubicacion, int equipo, IModoMovimiento movimiento) {
        this.COSTO = costo;
        this.movimiento = movimiento;
    }

    // strategy pattern
    private IModoMovimiento movimiento;
    private IModoRecibirDanio comoRecibeDanio; // como recibe danio
    private IModoSanacion sanacion;

    // SETTER GETTER
    public int getCosto() {
        return COSTO;
    }
    protected void setCosto(int costo){
        COSTO = costo;
    }

    protected void setVida_Maxima(int vida){
        VIDA_MAXIMA = vida;
    }
    public void setVida(double vida){
        this.vida = vida;
    }
    public double getPuntosVida(){
        return vida;
    }

    public void puedeCurarse(){
        sanacion = new SanacionNormal();
    }
    public void noPuedeCurarse(){
        sanacion = new SinSanacion();
    }
    public void puedeMoverse() { movimiento = new SeMueveEnTodasDirecciones(); }
    public void noPuedeMoverse() { movimiento = new SinMovimientos(); }
    //---------------------------
    public Ubicacion getUbicacion(){
        return ubicacion;
    }
    public void setUbicacion(Ubicacion ubicacion){
        this.ubicacion = ubicacion;
    }
    public void setEquipo(int numJugador){
        equipo = numJugador;
    }
    public int getEquipo(){ return equipo;}

    public boolean esEnemigo(Pieza otra){
        return (this.getEquipo() != otra.getEquipo());
    }
    //-------------------------------------------
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
