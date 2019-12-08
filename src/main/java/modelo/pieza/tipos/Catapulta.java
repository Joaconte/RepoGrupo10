package modelo.pieza.tipos;

import modelo.pieza.Pieza;
import modelo.pieza.UnidadEstaMuertaException;
import modelo.pieza.ataque.*;
import modelo.pieza.sanacion.IModoSanacion;
import modelo.pieza.sanacion.SinSanacion;
import modelo.tablero.Tablero;

public class Catapulta extends PiezaAtacante {
    static final int COSTO = 5;
    static final int VIDA_MAXIMA = 50;
    static final int DANIO_DISTANCIA = 20;
    static final IModoAtaqueMasivo ATAQUE = new AtaqueADistanciaMasivo(DANIO_DISTANCIA);
    static final IModoSanacion MODO_CURACION = new SinSanacion();


    public Catapulta(int equipo, int posX, int posY){
        super(COSTO,VIDA_MAXIMA,equipo,  MODO_CURACION, ATAQUE, posX, posY);
    }

    public Catapulta(){
        super(COSTO,VIDA_MAXIMA,0, MODO_CURACION, ATAQUE, 0, 0);
    }


    @Override
    public void atacar(Pieza atacada, Tablero tablero) throws UnidadEstaMuertaException, DistanciaDeAtaqueInvalidaException, PiezaAliadaNoAtacableException {
        if(!this.esEnemigo(atacada)){ throw new PiezaAliadaNoAtacableException();}
        ATAQUE.atacarEnMasa(this, atacada, tablero.getPiezasAdycentesInfinitas(atacada.getPosicionEnColumnaQueOcupa(),atacada.getPosicionEnFilaQueOcupa()));
    }

    @Override
    public boolean esRefuerzoDeJinete() {
        return false;
    }


    @Override
    public String getSonidoAtaque(){return "catapulta";}

    @Override
    public void mover(int posFinalX, int posFinalY) throws NoSePuedeMoverException {
        throw new NoSePuedeMoverException();

    }

    @Override
    public boolean puedeTenerBatallon() {
        return false;
    }

    @Override
    public boolean sePuederMoverA(int posFinalX, int posFinalY) {
        return false;
    }
}
