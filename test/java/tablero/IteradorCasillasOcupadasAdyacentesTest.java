package tablero;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

import org.mockito.Mockito;
import pieza.Ubicacion;
import pieza.tipos.Jinete;

import java.util.ArrayList;

public class IteradorCasillasOcupadasAdyacentesTest {

    @Test
    public void test00BusquedaDeCasillasEncuentraUnaCasillaPorUbicacion() {

        Columna unaColumna = new Columna(1,3);
        Ubicacion ubicacionOcupada = new Ubicacion(1,1);

        ArrayList<Columna> listadoDeUnaColumna = new ArrayList<Columna>();
        listadoDeUnaColumna.add(unaColumna);

        IteradorCasillasOcupadasAdyacentes iterador = new IteradorCasillasOcupadasAdyacentes();
        iterador.setCantidadColumnas(1);
        iterador.setCantidadColumnas(3);

        Casilla casillaEncontrada = iterador.getCasillaMedianteUbicacion(ubicacionOcupada,listadoDeUnaColumna);

        assertEquals(unaColumna.getCasilla(1),casillaEncontrada);
    }


    @Test
    public void test01UnTableroDeUnaColumnaSoloTieneUnaDireccionVecinaASuPrimerCasilla() {

        Columna unaColumna = new Columna(1,20);
        ArrayList<Columna> listadoDeUnaColumna = new ArrayList<Columna>();
        listadoDeUnaColumna.add(unaColumna);

        IteradorCasillasOcupadasAdyacentes iterador = new IteradorCasillasOcupadasAdyacentes();
        iterador.setCantidadColumnas(1);
        iterador.actualizarSiguienteUbicaciones(new Ubicacion(1,1));

        assertEquals(1,iterador.getSiguientesUbicaciones().size());
    }

    @Test
    public void test02UnTableroDe2ColumnasSoloTieneTresCasillasVecinasASuPrimerVertice() {

        Columna unaColumna = new Columna(1,20);
        Columna otraColumna = new Columna(2,20);
        ArrayList<Columna> listadoDeUnaColumna = new ArrayList<Columna>();
        listadoDeUnaColumna.add(unaColumna);
        listadoDeUnaColumna.add(otraColumna);

        IteradorCasillasOcupadasAdyacentes iterador = new IteradorCasillasOcupadasAdyacentes();
        iterador.setCantidadColumnas(2);
        iterador.actualizarSiguienteUbicaciones(new Ubicacion(1,1));

        assertEquals(3,iterador.getSiguientesUbicaciones().size());
    }

    @Test
    public void test03UnTableroDe3ColumnasTiene8CasillasVecinasASuCasillaCentral() {

        Columna unaColumna = new Columna(1,3);
        Columna otraColumna = new Columna(2,3);
        Columna otraColumna2 = new Columna(3,3);
        ArrayList<Columna> listadoDeUnaColumna = new ArrayList<Columna>();
        listadoDeUnaColumna.add(unaColumna);
        listadoDeUnaColumna.add(otraColumna);
        listadoDeUnaColumna.add(otraColumna2);

        IteradorCasillasOcupadasAdyacentes iterador = new IteradorCasillasOcupadasAdyacentes();
        iterador.setCantidadColumnas(3);
        iterador.setCantidadFilas(3);

        iterador.actualizarSiguienteUbicaciones(new Ubicacion(2,2));
        assertEquals(8,iterador.getSiguientesUbicaciones().size());
    }

    @Test
    public void test04BusquedaDeCasillasOcupadasAdyacentesSinAdyacentesOcupadasDevuelveSoloLaCasillaEvaluada() {

        Columna unaColumna = new Columna(1,3);
        ArrayList<Columna> listadoDeUnaColumna = new ArrayList<Columna>();
        listadoDeUnaColumna.add(unaColumna);

        unaColumna.ocuparCasilla(new Jinete(),1 );
        Casilla casillaOcupada = unaColumna.getCasilla(1);
        Ubicacion ubicacionOcupada = new Ubicacion(1,1);

        IteradorCasillasOcupadasAdyacentes iterador = new IteradorCasillasOcupadasAdyacentes();
        iterador.setCantidadColumnas(1);
        iterador.setCantidadFilas(3);

        ArrayList<Casilla> resultado = iterador.buscarCasillasOcupadasAdyacentes(ubicacionOcupada,listadoDeUnaColumna,casillaOcupada);

        assertEquals(casillaOcupada,resultado.get(0));
        assertEquals(1,resultado.size());
    }

    @Test
    public void test05BusquedaDeCasillasOcupadasAdyacentesCon2AdyacentesDevuelveLas3CasillasCorrectamente() {

        Columna unaColumna = new Columna(1,3);
        unaColumna.ocuparCasilla(new Jinete(),1 );
        unaColumna.ocuparCasilla(new Jinete(),2 );
        unaColumna.ocuparCasilla(new Jinete(),3 );

        ArrayList<Columna> listadoDeUnaColumna = new ArrayList<Columna>();
        listadoDeUnaColumna.add(unaColumna);
        Casilla casillaOcupada = unaColumna.getCasilla(2);
        Ubicacion ubicacionOcupada = new Ubicacion(1,2);

        IteradorCasillasOcupadasAdyacentes iterador = new IteradorCasillasOcupadasAdyacentes();
        iterador.setCantidadColumnas(1);
        iterador.setCantidadFilas(3);

        ArrayList<Casilla> resultado = iterador.buscarCasillasOcupadasAdyacentes(ubicacionOcupada,listadoDeUnaColumna,casillaOcupada);

        assertEquals(3,resultado.size());

    }


    @Test
    public void test06BusquedaDeCasillasDejaTodasLasCasillasSinMarcasCorrectamente() {

        Columna unaColumna = new Columna(1,3);
        unaColumna.ocuparCasilla(new Jinete(),1 );
        unaColumna.ocuparCasilla(new Jinete(),2 );

        ArrayList<Columna> listadoDeUnaColumna = new ArrayList<Columna>();
        Ubicacion ubicacionOcupada = new Ubicacion(1,1);
        Casilla casillaOcupada = unaColumna.getCasilla(2);
        listadoDeUnaColumna.add(unaColumna);

        IteradorCasillasOcupadasAdyacentes iterador = new IteradorCasillasOcupadasAdyacentes();
        iterador.setCantidadColumnas(1);
        iterador.setCantidadFilas(3);
        ArrayList<Casilla> resultado = iterador.buscarCasillasOcupadasAdyacentes(ubicacionOcupada,listadoDeUnaColumna,casillaOcupada);

        assertEquals(false,unaColumna.getCasilla(1).getFueRevisada());
        assertEquals(false,unaColumna.getCasilla(2).getFueRevisada());
        assertEquals(false,unaColumna.getCasilla(3).getFueRevisada());
    }

}
