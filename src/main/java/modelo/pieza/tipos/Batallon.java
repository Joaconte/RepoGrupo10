package modelo.pieza.tipos;

import modelo.pieza.Pieza;
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
        AtomicBoolean contiene= new AtomicBoolean(false);
        soldados.forEach(p ->{ if (p.estaEnElLugar(infante)) { contiene.set(true); } });
        return contiene.get();
    }

    public void ordenarFormacion(ArrayList<Pieza> piezas, ArrayList<Integer> ubicacionesX, ArrayList<Integer> ubicacionesY, int posicionXFinal, int posicionYFinal) {

        ArrayList<Pieza> soldados = new ArrayList<>(this.soldados);

        int variacionX = piezas.get(0).darCambioDePosicionEnXQueNecesitaParaMoverseA(posicionXFinal);
        int variacionY = piezas.get(0).darCambioDePosicionEnYQueNecesitaParaMoverseA(posicionYFinal);

        ubicacionesX.add(posicionXFinal);
        ubicacionesY.add(posicionYFinal);

        soldados.remove(piezas.get(0));

        soldados.stream().filter(p-> !p.chocariaCon(soldados, variacionX, variacionY)).forEach(p->{
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
}