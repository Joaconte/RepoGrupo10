package modelo.pieza;

import modelo.jugador.Sector;
import modelo.pieza.movimiento.*;
import modelo.pieza.recibirDanio.*;
import modelo.pieza.sanacion.*;
import modelo.tablero.Tablero;

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
    public Pieza(int costo, int vidaMaxima, int equipo, IModoMovimiento modoMovimiento, IModoSanacion modoSanacion, int posX, int posY) {
        this.costo = costo;
        this.vida_maxima = vidaMaxima;
        this.vida = vidaMaxima;
        this.equipo = equipo;
        this.modoMovimiento = modoMovimiento;
        this.modoSanacion = modoSanacion;
        this.ubicacion = new Ubicacion(posX, posY);
        this.danioARecibir = new DanioZonaPropia();
    }

    // SETTER GETTER

    public double getPuntosVida(){
        return vida;
    }

    public int getVidaMaxima(){
        return vida_maxima;
    }

    public Ubicacion getUbicacion(){
        return ubicacion;
    }

    public void setUbicacion(int x, int y){
            this.ubicacion.setPosicionEnX(x);
            this.ubicacion.setPosicionEnY(y);
    }

    public int getEquipo(){ return equipo;}

    public int getCosto(){ return costo;}

    public boolean esEnemigo(Pieza otra){
        return (this.getEquipo() != otra.getEquipo());
    }

    // METODOS

    public void evaluarZonaDeDanio(Sector sector) {
        if (sector.esDelSector(ubicacion.getPosicionEnX())) { this.danioARecibir = new DanioZonaEnemiga(); }
        else this.danioARecibir = new DanioZonaPropia();
    }

    public int getDistanciaAOtraPieza(Pieza pieza) {
        return ubicacion.getDistanciaAOtroPunto(pieza.getUbicacion());
    }

    public void recibirDanio(double danioBase) throws UnidadEstaMuertaException {
        if (vida<=0) throw new UnidadEstaMuertaException();
        vida-= danioARecibir.danio(danioBase);
        vida = Math.max(vida, 0);
    }

    public void sanar(int puntos) throws UnidadNoSePuedeCurar {
        vida += modoSanacion.restaurarPuntosDeVida(puntos);
        vida = Math.min(vida, vida_maxima);
    }
    public abstract boolean esRefuerzoDeJinete();



    public void mover(Ubicacion ubicacion) throws NoSePuedeMoverException {
        this.getUbicacion().setPosicionEnX(ubicacion.getPosicionEnX());
        this.getUbicacion().setPosicionEnY(ubicacion.getPosicionEnY());
    }

    public void mover(Direccion direccion){
        int nuevoX = this.getUbicacion().getPosicionEnX()+direccion.getDesplazamientoEnX();
        int nuevoY = this.getUbicacion().getPosicionEnY()+direccion.getDesplazamientoEnY();
        this.ubicacion = new Ubicacion(nuevoX,nuevoY);
    }
}
