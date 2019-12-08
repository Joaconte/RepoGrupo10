package modelo.pieza;

import modelo.jugador.Sector;
import modelo.pieza.movimiento.Ubicacion;
import modelo.pieza.recibirDanio.*;
import modelo.pieza.sanacion.*;
import modelo.pieza.tipos.NoSePuedeMoverException;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class Pieza {
    private int costo;
    private int vida_maxima;
    private double vida;
    protected Ubicacion ubicacion;
    private int equipo;
    // strategy pattern
    private ICalculadorDeDanio danioARecibir;
    private IModoSanacion modoSanacion;
    protected static final int CAPACIDAD_DESPLAZAMIENTO = 1;

    // Constructores
    public Pieza(int costo, int vidaMaxima, int equipo, IModoSanacion modoSanacion, int posX, int posY) {
        this.costo = costo;
        this.vida_maxima = vidaMaxima;
        this.vida = vidaMaxima;
        this.equipo = equipo;
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

    public int getEquipo(){ return equipo;}

    public int getCosto(){ return costo;}

    public boolean esEnemigo(Pieza otra){
        return (this.getEquipo() != otra.getEquipo());
    }

    // METODOS

    public void recibirPenalizacion() {
        Sector sector = new Sector(equipo);
        if (!sector.esDelSector(ubicacion.getPosicionEnY())) { this.danioARecibir = new DanioZonaEnemiga(); }
        else this.danioARecibir = new DanioZonaPropia();
    }


    public int getDistanciaAOtraPieza(Pieza pieza) { //Mantiene encapsulamiento o es exceso?
        return pieza.getDistanciaAUbicacion(ubicacion);
    }
    public int getDistanciaAUbicacion(Ubicacion ubicacionOtra){
        return this.ubicacion.getDistanciaAOtroPunto(ubicacionOtra);
    }

    public int getDistanciaAOtroPunto(int posicionXFinal, int posicionYFinal){
        return ubicacion.getDistanciaAOtroPunto(posicionXFinal,posicionYFinal);
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

    public boolean esContiguoAAlguno(Pieza pieza, Pieza pieza2){
        return getDistanciaAOtraPieza(pieza)<2 || getDistanciaAOtraPieza(pieza2)<2;
    }

    public boolean esDelEquipo(int numeroDeJugador){return numeroDeJugador==equipo;}

    public abstract boolean sePuederMoverA(int posFinalX, int posFinalY);

    public void mover(int posFinalX, int posFinalY) throws NoSePuedeMoverException {
        ubicacion= ubicacion.desplazarA(posFinalX,posFinalY);
    }

    public abstract boolean puedeTenerBatallon();

    public int darVariacionEnXPara(int unaPosicionEnX){return ubicacion.getVariacionEnX(unaPosicionEnX);}

    public  int darVariacionEnYPara(int unaPosicionEnY){return ubicacion.getVariacionEnY(unaPosicionEnY);}

    public Ubicacion darUbicacionTentativa(int variacionX, int variacionY){
        return ubicacion.desplazarPorVariacion(variacionX,variacionY);
    }

    public int getPosicionEnColumnaQueOcupa(){
        return ubicacion.getPosicionEnX();
    }

    public int getPosicionEnFilaQueOcupa(){
        return ubicacion.getPosicionEnY();
    }

    public boolean estaEnElLugar(Pieza pieza ){
        return getDistanciaAOtraPieza(pieza)==0;
    };

    public boolean estaViva(){ return vida>0;}

}
