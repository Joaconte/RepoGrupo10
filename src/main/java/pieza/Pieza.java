package pieza;

import pieza.movimiento.*;
import pieza.recibirDanio.*;
import pieza.sanacion.*;

public abstract class Pieza {
    private int costo;
    private int vida_maxima;
    private double vida;
    protected Ubicacion ubicacion;
    private int equipo;
    // strategy pattern
    private IModoMovimiento modoMovimiento;
    private ICalculadorDeDanio danioARecibir;
    private IModoSanacion modoSanacion;

    // Constructores
    public Pieza(int costo, int vidaMaxima, int equipo, IModoMovimiento modoMovimiento, IModoSanacion modoSanacion) {
    this.costo = costo;
    this.vida_maxima = vidaMaxima;
    this.vida = vidaMaxima;
    this.equipo = equipo;
    this.modoMovimiento = modoMovimiento;
    this.modoSanacion = modoSanacion;
    this.danioARecibir = new DanioZonaPropia();
    }

    public Pieza(int costo, int vidaMaxima, int equipo, IModoMovimiento modoMovimiento, IModoSanacion modoSanacion, int posX, int posY) {
        this.costo = costo;
        this.vida_maxima = vidaMaxima;
        this.vida = vidaMaxima;
        this.equipo = equipo;
        this.modoMovimiento = modoMovimiento;
        this.modoSanacion = modoSanacion;
        // verificar si esta en su zona consultando a tablero?
        this.ubicacion = new Ubicacion(posX, posY);
        this.danioARecibir = new DanioZonaPropia();
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
    public int getCosto(){ return costo;}
    public boolean esEnemigo(Pieza otra){
        return (this.getEquipo() != otra.getEquipo());
    }

    // METODOS

    public void enZonaEnemiga(){
        this.danioARecibir = new DanioZonaEnemiga();
    }
    public void enZonaAliada(){
        this.danioARecibir = new DanioZonaPropia();
    }

    // ver q no deje en negativos--- exceptions
    public void recibirDanio(double danioBase) throws UnidadEstaMuertaException {
        if (vida<=0) throw new UnidadEstaMuertaException();
        vida-= danioARecibir.danio(danioBase);

    }

    public void sanar(int puntos) throws UnidadNoSePuedeCurar {
        vida += modoSanacion.restaurarPuntosDeVida(puntos);
        vida = Math.min(vida, vida_maxima);
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
