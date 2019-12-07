package modelo.pieza.tipos;

import modelo.pieza.ataque.*;
import modelo.pieza.sanacion.IModoSanacion;
import modelo.pieza.sanacion.SanacionNormal;

public class Infanteria extends PiezaAtacante {
    static final int COSTO = 1;
    static final int VIDA_MAXIMA = 100;
    static final int DANIO_CUERPO = 10;
    static final IModoAtaque ATAQUE = new AtaqueCuerpoACuerpo(DANIO_CUERPO);
    static final IModoSanacion MODO_CURACION = new SanacionNormal();

    public Infanteria(int equipo,int posX, int posY){
        super(COSTO, VIDA_MAXIMA, equipo, MODO_CURACION, ATAQUE, posX, posY);
    }

    public Infanteria(){
        super(COSTO, VIDA_MAXIMA, 0, MODO_CURACION, ATAQUE, 0, 0);
    }


    @Override
    public String getSonidoAtaque(){return "espada";}

    @Override
    public boolean esRefuerzoDeJinete() {
        return true;
    }

    @Override
    public boolean sePuederMoverA(int posFinalX, int posFinalY) {
        return CAPACIDAD_DESPLAZAMIENTO == ubicacion.getDistanciaAOtroPunto(posFinalX,posFinalY);
    }

    @Override
    public boolean puedeTenerBatallon() {
        return true;
    }
}
