package pieza.tipos;

import pieza.Pieza;
import pieza.UnidadEstaMuertaException;
import pieza.ataque.*;
import pieza.movimiento.IModoMovimiento;
import pieza.movimiento.SeMueveEnTodasDirecciones;
import pieza.sanacion.IModoSanacion;
import pieza.sanacion.SanacionNormal;
import tablero.Tablero;

public class Infanteria extends PiezaAtacante {
    static final int COSTO = 1;
    static final int VIDA_MAXIMA = 100;
    static final int DANIO_CUERPO = 10;
    static final int DANIO_MEDIO = 0;
    static final int DANIO_DISTANCIA = 0;
    static final IModoMovimiento MOVIMIENTO = new SeMueveEnTodasDirecciones();
    static final IModoAtaque ATAQUE = new AtaqueCuerpoACuerpo();
    static final IModoSanacion MODO_CURACION = new SanacionNormal();

    public Infanteria(int equipo){
        super(COSTO, VIDA_MAXIMA, VIDA_MAXIMA, equipo, MOVIMIENTO, MODO_CURACION, ATAQUE, DANIO_CUERPO, DANIO_MEDIO, DANIO_DISTANCIA);

    }

    @Override
    public void atacar(Pieza oponente, Tablero tablero) throws UnidadEstaMuertaException, DistanciaDeAtaqueInvalidaException, PiezaAliadaNoAtacableException {
        if(!this.esEnemigo(oponente)){ throw new PiezaAliadaNoAtacableException();}
        super.ejecutarUnModoDeAtaque(oponente);
    }
}
