package modelo.pieza.tipos;

import modelo.pieza.Pieza;

import java.util.ArrayList;

public class AnalizadorDeBatallon {

    public boolean son3Aliados(ArrayList<Pieza> piezas){
        Pieza p1 = piezas.get(0);
        Pieza p2 = piezas.get(1);
        Pieza p3 = piezas.get(2);
        return ((!p1.esEnemigo(p2))&&(!p1.esEnemigo(p3))&&(!p2.esEnemigo(p3)));
    }


    public boolean los3SonDeInfanteria(ArrayList<Pieza> piezas){
        Pieza p1 = piezas.get(0);
        Pieza p2 = piezas.get(1);
        Pieza p3 = piezas.get(2);
        return p1.puedeTenerBatallon() && p2.puedeTenerBatallon() && p3.puedeTenerBatallon();
    }


    public boolean estanContiguos(ArrayList<Pieza> piezas) {
        Pieza p1 = piezas.get(0);
        Pieza p2 = piezas.get(1);
        Pieza p3 = piezas.get(2);
        return p1.esContiguoAAlguno(p2, p3) && p2.esContiguoAAlguno(p1, p3) && p3.esContiguoAAlguno(p1, p2);
    }

    public boolean siguenContiguos(ArrayList<Pieza> piezas){
        return estanContiguos(piezas) && estanTodosVivos(piezas);
    }

    public boolean estanTodosVivos(ArrayList<Pieza> piezas) {
        Pieza p1 = piezas.get(0);
        Pieza p2 = piezas.get(1);
        Pieza p3 = piezas.get(2);
        return !p1.estaMuerta() && !p2.estaMuerta() && !p3.estaMuerta();
    }
    public boolean formanCorrectamente(ArrayList<Pieza> piezas){
        Pieza p1 = piezas.get(0);
        Pieza p2 = piezas.get(1);
        Pieza p3 = piezas.get(2);
        return p1.getDistanciaAOtraPieza(p2)!=0 && p1.getDistanciaAOtraPieza(p3)!=0 && p2.getDistanciaAOtraPieza(p3)!=0;
    }

    public boolean sonAliadosDeInfanteria(ArrayList<Pieza> piezas){
        return ((son3Aliados(piezas))&(los3SonDeInfanteria(piezas)));
    }

    public boolean formanBatallon(ArrayList<Pieza> piezas){
        if (piezas.size()!=3) return false;
        return (sonAliadosDeInfanteria(piezas)) && ( estanTodosVivos(piezas)) && (estanContiguos(piezas)) && formanCorrectamente(piezas);
    }



}
