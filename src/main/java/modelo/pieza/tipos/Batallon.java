package modelo.pieza.tipos;

import modelo.pieza.Pieza;
import modelo.pieza.movimiento.Ubicacion;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class Batallon {
    private AnalizadorDeBatallon analizadorDeBatallon = new AnalizadorDeBatallon();
    private ArrayList<Pieza> soldados;

    public Batallon(ArrayList<Pieza> piezas) throws NoSirvenParaBatallonException {
        if (!analizadorDeBatallon.formanBatallon(piezas)) {
            throw new NoSirvenParaBatallonException();
        }
        soldados = piezas;
    }

    public boolean siguenContiguos(){
        return analizadorDeBatallon.estanContiguos(soldados);
    }


    public boolean contiene(Pieza infante) {
        return soldados.contains(infante);
    }

    public void ordenarFormacion(ArrayList<Pieza> piezas, ArrayList<Integer> ubicacionesX, ArrayList<Integer> ubicacionesY, int posicionXFinal, int posicionYFinal) {

        ArrayList<Pieza> soldados = new ArrayList<>(this.soldados);

        int variacionX = piezas.get(0).darVariacionEnXPara(posicionXFinal);
        int variacionY = piezas.get(0).darVariacionEnYPara(posicionYFinal);

        ubicacionesX.add(posicionXFinal);
        ubicacionesY.add(posicionYFinal);

        soldados.remove(piezas.get(0));

        soldados.stream().filter(p-> !chocariaCon(p,soldados, variacionX, variacionY)).forEach(p->{
                    piezas.add(p);
                    ubicacionesX.add(p.getPosicionEnColumnaQueOcupa()+variacionX);
                    ubicacionesY.add(p.getPosicionEnFilaQueOcupa()+variacionY);
        });

        soldados.stream().filter(p-> !piezas.contains(p)).forEach(p->{
            piezas.add(p);
            ubicacionesX.add(p.getPosicionEnColumnaQueOcupa()+variacionX);
            ubicacionesY.add(p.getPosicionEnFilaQueOcupa()+variacionY);
        });

    }

    public boolean chocariaCon(Pieza pieza, ArrayList<Pieza> listadoDeSoldados, int variacionX, int variacionY){
        Ubicacion ubicacionTentativa = pieza.darUbicacionTentativa(variacionX,variacionY);
        AtomicBoolean choca = new AtomicBoolean(false);
        listadoDeSoldados.stream().filter(p->p.getDistanciaAUbicacion(ubicacionTentativa)==0).forEach(p->choca.set(true));
        return choca.get();
    }
}