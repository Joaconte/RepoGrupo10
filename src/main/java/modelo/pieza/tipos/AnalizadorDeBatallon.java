package modelo.pieza.tipos;

import modelo.pieza.Pieza;

import java.util.ArrayList;

public class AnalizadorDeBatallon {

    public boolean son3Aliados(ArrayList<Pieza> piezas){
       if (piezas.size()==3){
           Pieza p1 = piezas.get(0);
           Pieza p2 = piezas.get(1);
           Pieza p3 = piezas.get(2);
           return ((!p1.esEnemigo(p2))&(!p1.esEnemigo(p3))&(!p2.esEnemigo(p3)));
       } else {
           return false;
       }

    }


    public boolean los3SonDeInfanteria(ArrayList<Pieza> piezas){
        if (piezas.size()==3) {
            Pieza p1 = piezas.get(0);
            Pieza p2 = piezas.get(1);
            Pieza p3 = piezas.get(2);

            // uso de reflexion
            return(p1.getClass() == Infanteria.class)&(p2.getClass()== Infanteria.class)&(p3.getClass()== Infanteria.class);
        } else {
            return false;
        }

    }

    public boolean estanContiguos(ArrayList<Pieza> piezas){
        Pieza p1 = piezas.get(0);
        Pieza p2 = piezas.get(1);
        Pieza p3 = piezas.get(2);
        int distanciaP1aP2 = p1.getUbicacion().getDistanciaAOtroPunto(p2.getUbicacion());
        int distanciaP1aP3 = p1.getUbicacion().getDistanciaAOtroPunto(p3.getUbicacion());
        int distanciaP2aP3 = p2.getUbicacion().getDistanciaAOtroPunto(p3.getUbicacion());
        int distanciaTotal = distanciaP1aP2+distanciaP1aP3+distanciaP2aP3;
        return (distanciaTotal<=4);
    }

    public boolean sonAliadosDeInfanteria(ArrayList<Pieza> piezas){

        return ((son3Aliados(piezas))&(los3SonDeInfanteria(piezas)));
    }

    public boolean formanBatallon(ArrayList<Pieza> piezas){
        return (sonAliadosDeInfanteria(piezas)) & (estanContiguos(piezas));
    }

}
