package modelo.pieza.tipos;


import modelo.pieza.Pieza;

import java.util.Comparator;

public class Ordenamientos {
    /* Para ordenar */

    public static Comparator<Pieza> ubicacionAscComparator = Ordenamientos::compareAsc;

    private static int compareAsc(Pieza soldado1, Pieza soldado2) {
        boolean soldado2AntesDeSoldado1 = (((soldado2.getUbicacion().getPosicionEnY()) < (soldado1.getUbicacion().getPosicionEnY())) ||
                (((soldado2.getUbicacion().getPosicionEnY()) == (soldado1.getUbicacion().getPosicionEnY())) && ((soldado2.getUbicacion().getPosicionEnX()) < (soldado1.getUbicacion().getPosicionEnX()))));
        boolean mismaUbicacion = (soldado2.getUbicacion().getPosicionEnX() == soldado1.getUbicacion().getPosicionEnX()) &&
                (soldado2.getUbicacion().getPosicionEnY() == soldado1.getUbicacion().getPosicionEnY());
        return (soldado2AntesDeSoldado1 ? 1 :
                (mismaUbicacion ? 0 : -1));
    }

    public static Comparator<Pieza> ubicacionDesComparator = Ordenamientos::compareDes;

    private static int compareDes(Pieza soldado1, Pieza soldado2) {
        boolean soldado2AntesDeSoldado1 = (((soldado2.getUbicacion().getPosicionEnY()) < (soldado1.getUbicacion().getPosicionEnY())) ||
                (((soldado2.getUbicacion().getPosicionEnY()) == (soldado1.getUbicacion().getPosicionEnY())) && ((soldado2.getUbicacion().getPosicionEnX()) < (soldado1.getUbicacion().getPosicionEnX()))));
        boolean mismaUbicacion = (soldado2.getUbicacion().getPosicionEnX() == soldado1.getUbicacion().getPosicionEnX()) &&
                (soldado2.getUbicacion().getPosicionEnY() == soldado1.getUbicacion().getPosicionEnY());
        return (soldado2AntesDeSoldado1 ? -1 :
                (mismaUbicacion ? 0 : 1));
    }
}
