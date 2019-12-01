package modelo.pieza.tipos;

import modelo.pieza.ataque.*;
import modelo.pieza.movimiento.IModoMovimiento;
import modelo.pieza.movimiento.SeMueveEnTodasDirecciones;
import modelo.pieza.sanacion.IModoSanacion;
import modelo.pieza.sanacion.SanacionNormal;


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

    @Override
    public boolean esRefuerzoDeJinete() {
        return true;
    }
}
