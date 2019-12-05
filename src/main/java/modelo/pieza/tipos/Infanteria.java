package modelo.pieza.tipos;

import modelo.pieza.ataque.*;
import modelo.pieza.sanacion.IModoSanacion;
import modelo.pieza.sanacion.SanacionNormal;

public class Infanteria extends PiezaAtacante {
    static final int COSTO = 1;
    static final int VIDA_MAXIMA = 100;
    static final int DANIO_CUERPO = 10;
    static final int DANIO_MEDIO = 0;
    static final int DANIO_DISTANCIA = 0;
    static final IModoAtaque ATAQUE = new AtaqueCuerpoACuerpo();
    static final IModoSanacion MODO_CURACION = new SanacionNormal();

    public Infanteria(int equipo,int posX, int posY){
        super(COSTO, VIDA_MAXIMA, equipo, MODO_CURACION, ATAQUE, DANIO_CUERPO, DANIO_MEDIO, DANIO_DISTANCIA, posX, posY);
    }

    public Infanteria(){
        super(COSTO, VIDA_MAXIMA, 0, MODO_CURACION, ATAQUE, DANIO_CUERPO, DANIO_MEDIO, DANIO_DISTANCIA, 0, 0);
    }


    @Override
    public String getSonidoAtaque(){return "espada";}

    @Override
    public boolean esRefuerzoDeJinete() {
        return true;
    }
}
