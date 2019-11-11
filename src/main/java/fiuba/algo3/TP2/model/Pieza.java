package fiuba.algo3.TP2.model;

import fiuba.algo3.TP2.exception.UnidadEstaMuertaException;
import fiuba.algo3.TP2.exception.UnidadNoSePuedeCurar;

public abstract class Pieza {
    private int COSTO;
    private int VIDA_MAXIMA;
    private double vida;

    protected Ubicacion ubicacion;
    protected int equipo;

    // strategy pattern
    private IModoMovimiento movimiento;
    private IModoRecibirDanio comoRecibeDanio;
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

    //---------------------------
    public Ubicacion getUbicacion(){
        return ubicacion;
    }
    public void setEquipo(int numJugador){
        equipo = numJugador;
    }

    public int getEquipo(){ return equipo;}

    public boolean esEnemigo(Pieza otra){
        return (this.getEquipo()!= otra.getEquipo());
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

   /* public void moverse(){
        movimiento.moverse();
    }*/

}

