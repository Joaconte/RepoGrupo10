package pieza.tipos;

import pieza.Pieza;
import pieza.UnidadEstaMuertaException;
import pieza.ataque.*;
import pieza.movimiento.IModoMovimiento;
import pieza.movimiento.SeMueveEnTodasDirecciones;
import pieza.sanacion.IModoSanacion;
import pieza.sanacion.SanacionNormal;
import tablero.Tablero;

import java.util.Comparator;

public class Infanteria extends PiezaAtacante {
    static final int COSTO = 1;
    static final int VIDA_MAXIMA = 100;
    static final int DANIO_CUERPO = 10;
    static final int DANIO_MEDIO = 0;
    static final int DANIO_DISTANCIA = 0;
    static final IModoMovimiento MOVIMIENTO = new SeMueveEnTodasDirecciones();
    static final IModoAtaque ATAQUE = new AtaqueCuerpoACuerpo();
    static final IModoSanacion MODO_CURACION = new SanacionNormal();

    public Infanteria(int equipo,int posX, int posY){
        super(COSTO, VIDA_MAXIMA, equipo, MOVIMIENTO, MODO_CURACION, ATAQUE, DANIO_CUERPO, DANIO_MEDIO, DANIO_DISTANCIA, posX, posY);

    }

    @Override
    public String getNombre(){ return "Infanteria";}

    @Override
    public void atacar(Pieza oponente, Tablero tablero) throws UnidadEstaMuertaException, DistanciaDeAtaqueInvalidaException, PiezaAliadaNoAtacableException {
        if(!this.esEnemigo(oponente)){ throw new PiezaAliadaNoAtacableException();}
        ATAQUE.atacar(this, oponente ,this.ubicacion.getDistanciaAOtroPunto(oponente.getUbicacion()));
    }


    /* Para ordenar los soldados del batallon y moverlos*/

    public static Comparator<Infanteria> ubicacionAscComparator = Infanteria::compareAsc;

    private static int compareAsc(Infanteria soldado1, Infanteria soldado2) {
        boolean soldado2AntesDeSoldado1 = (((soldado2.getUbicacion().getPosicionEnY()) < (soldado1.getUbicacion().getPosicionEnY())) ||
                (((soldado2.getUbicacion().getPosicionEnY()) == (soldado1.getUbicacion().getPosicionEnY())) && ((soldado2.getUbicacion().getPosicionEnX()) < (soldado1.getUbicacion().getPosicionEnX()))));
        boolean mismaUbicacion = (soldado2.getUbicacion().getPosicionEnX() == soldado1.getUbicacion().getPosicionEnX()) &&
                (soldado2.getUbicacion().getPosicionEnY() == soldado1.getUbicacion().getPosicionEnY());
        return (soldado2AntesDeSoldado1 ? 1 :
                (mismaUbicacion ? 0 : -1));
    }

    public static Comparator<Infanteria> ubicacionDesComparator = Infanteria::compareDes;

    private static int compareDes(Infanteria soldado1, Infanteria soldado2) {
        boolean soldado2AntesDeSoldado1 = (((soldado2.getUbicacion().getPosicionEnY()) < (soldado1.getUbicacion().getPosicionEnY())) ||
                (((soldado2.getUbicacion().getPosicionEnY()) == (soldado1.getUbicacion().getPosicionEnY())) && ((soldado2.getUbicacion().getPosicionEnX()) < (soldado1.getUbicacion().getPosicionEnX()))));
        boolean mismaUbicacion = (soldado2.getUbicacion().getPosicionEnX() == soldado1.getUbicacion().getPosicionEnX()) &&
                (soldado2.getUbicacion().getPosicionEnY() == soldado1.getUbicacion().getPosicionEnY());
        return (soldado2AntesDeSoldado1 ? -1 :
                (mismaUbicacion ? 0 : 1));
    }
}
