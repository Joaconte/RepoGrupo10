package pieza.tipos;

import pieza.Pieza;
import pieza.ataque.AtaqueVariable;
import pieza.ataque.PiezaAtacante;
import pieza.movimiento.IModoMovimiento;
import pieza.movimiento.SeMueveEnTodasDirecciones;
import pieza.sanacion.IModoSanacion;
import pieza.sanacion.SanacionNormal;

import java.util.ArrayList;

public class Jinete extends PiezaAtacante {
    static final int COSTO = 3;
    static final int VIDA_MAXIMA = 100;
    static final int DANIO_CUERPO = 5;
    static final int DANIO_MEDIO =0;
    static final int DANIO_DISTANCIA = 0;
    static final IModoMovimiento MOVIMIENTO = new SeMueveEnTodasDirecciones();
    static final IModoSanacion MODO_CURACION = new SanacionNormal();

    public Jinete(int equipo) {
        super(COSTO, VIDA_MAXIMA, VIDA_MAXIMA, equipo, MOVIMIENTO,  MODO_CURACION, new AtaqueVariable(),DANIO_CUERPO, DANIO_MEDIO,DANIO_DISTANCIA);
    }


    public void atacar(Pieza atacada, Tablero tablero) {


    }


    public void obtenerModoDeAtaque(ArrayList<Pieza> piezas) {
        boolean estaAsediado=false;
        if (piezas.size()!=0){estaAsediado=true;}
        for (int i=0; i <piezas.size(); i++ ){
            if ((!this.esEnemigo(piezas.get(i))) && piezas.get(i).getCosto() == 1){ estaAsediado=false; }
        }
    }



}
