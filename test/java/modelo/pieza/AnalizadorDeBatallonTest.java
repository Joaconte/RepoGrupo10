package modelo.pieza;

import modelo.pieza.tipos.Infanteria;
import org.junit.Test;
import modelo.pieza.tipos.AnalizadorDeBatallon;
import modelo.pieza.tipos.Curandero;

import java.util.ArrayList;

import static org.junit.Assert.*;


public class AnalizadorDeBatallonTest {
    @Test
    public void test01DevuelveFalseSiAlgunaDelasPiezasNoEsAliada() {
        AnalizadorDeBatallon aux = new AnalizadorDeBatallon();
        ArrayList<Pieza> piezas = new ArrayList<>();
        Infanteria soldado1 = new Infanteria(1,1,1);
        Curandero curandero = new Curandero(2,1,2);
        Infanteria soldado2 = new Infanteria(1,1,3);
        piezas.add(soldado1);
        piezas.add(curandero);
        piezas.add(soldado2);
        assertFalse(aux.son3Aliados(piezas));
    }

    @Test
    public void test02DevuelveTrueSiTodaslasPiezasSonDelMismoEquipo() {
        AnalizadorDeBatallon aux = new AnalizadorDeBatallon();
        Infanteria soldado1 = new Infanteria(1,1,1);
        Curandero curandero = new Curandero(1,1,2);
        Infanteria soldado2 = new Infanteria(1,1,3);
        ArrayList<Pieza> piezas = new ArrayList<>();
        piezas.add(soldado1);
        piezas.add(curandero);
        piezas.add(soldado2);
        assertTrue(aux.son3Aliados(piezas));
    }

    @Test
    public void test03DevuelveFalseSiAlgunaDelasPiezasNoEsDeInfanteria() {
        AnalizadorDeBatallon aux = new AnalizadorDeBatallon();
        Infanteria soldado1 = new Infanteria(1,1,1);
        Curandero curandero = new Curandero(2,1,2);
        Infanteria soldado2 = new Infanteria(1,1,3);

        ArrayList<Pieza> piezas = new ArrayList<>();
        piezas.add(soldado1);
        piezas.add(curandero);
        piezas.add(soldado2);
        assertFalse(aux.los3SonDeInfanteria(piezas));
    }

    @Test
    public void test04DevuelveTrueSiTodaslasPiezasSonDeInfanteria() {
        AnalizadorDeBatallon aux = new AnalizadorDeBatallon();
        Infanteria soldado1 = new Infanteria(1,1,1);
        Infanteria curandero = new Infanteria(2,1,2);
        Infanteria soldado2 = new Infanteria(1,1,3);

        ArrayList<Pieza> piezas = new ArrayList<>();
        piezas.add(soldado1);
        piezas.add(curandero);
        piezas.add(soldado2);
        assertTrue(aux.los3SonDeInfanteria(piezas));
    }

    @Test
    public void test05SonAliadosDeInfanteriaDevuelveFalseSiAlgunaPiezaEsEnemiga() {
        AnalizadorDeBatallon aux = new AnalizadorDeBatallon();
        Infanteria soldado1 = new Infanteria(1,1,1);
        Pieza curandero = new Infanteria(2,1,2);
        Infanteria soldado2 = new Infanteria(1,1,3);

        ArrayList<Pieza> piezas = new ArrayList<>();
        piezas.add(soldado1);
        piezas.add(curandero);
        piezas.add(soldado2);
        assertFalse(aux.sonAliadosDeInfanteria(piezas));
    }

    @Test
    public void test06SonAliadosDeInfanteriaDevuelveFalseSiAlgunaPiezaNoEsDeInfanteria() {
        AnalizadorDeBatallon aux = new AnalizadorDeBatallon();
        Infanteria soldado1 = new Infanteria(1,1,1);
        Pieza curandero = new Curandero(1,1,2);
        Infanteria soldado2 = new Infanteria(1,1,3);

        ArrayList<Pieza> piezas = new ArrayList<>();
        piezas.add(soldado1);
        piezas.add(curandero);
        piezas.add(soldado2);
        assertFalse(aux.sonAliadosDeInfanteria(piezas));
    }

    @Test
    public void test07SonAliadosDeInfanteriaDevuelveTrueSiTodasLasPiezasSonDeInfanteriaYSonDelMismoEquipo() {
        AnalizadorDeBatallon aux = new AnalizadorDeBatallon();
        Infanteria soldado1 = new Infanteria(1,1,1);
        Pieza curandero = new Infanteria(1,1,2);
        Infanteria soldado2 = new Infanteria(1,1,3);

        ArrayList<Pieza> piezas = new ArrayList<>();
        piezas.add(soldado1);
        piezas.add(curandero);
        piezas.add(soldado2);
        assertTrue(aux.sonAliadosDeInfanteria(piezas));
    }
    @Test
    public void test08DevuelveFalseSiAlgunaDeLasPiezasNoEstaPegadaAOtra() {
        AnalizadorDeBatallon aux = new AnalizadorDeBatallon();
        Infanteria soldado1 = new Infanteria(1,1,1);
        Pieza curandero = new Infanteria(2,1,2);
        Infanteria soldado2 = new Infanteria(1,1,4);

        ArrayList<Pieza> piezas = new ArrayList<>();
        piezas.add(soldado1);
        piezas.add(curandero);
        piezas.add(soldado2);
        assertFalse(aux.estanContiguos(piezas));
    }

    @Test
    public void test09DevuelveTrueSiLasPiezasEstanContiguasEnElMismoX() {
        AnalizadorDeBatallon aux = new AnalizadorDeBatallon();
        Infanteria soldado1 = new Infanteria(1,1,1);
        Pieza curandero = new Infanteria(2,1,2);
        Infanteria soldado2 = new Infanteria(1,1,3);

        ArrayList<Pieza> piezas = new ArrayList<>();
        piezas.add(soldado1);
        piezas.add(curandero);
        piezas.add(soldado2);
        assertTrue(aux.estanContiguos(piezas));
    }

    @Test
    public void test10DevuelveTrueSiLasPiezasEstanContiguasEnElMismoY() {
        AnalizadorDeBatallon aux = new AnalizadorDeBatallon();
        Infanteria soldado1 = new Infanteria(1,2,1);
        Pieza curandero = new Infanteria(2,1,1);
        Infanteria soldado2 = new Infanteria(1,3,1);

        ArrayList<Pieza> piezas = new ArrayList<>();
        piezas.add(soldado1);
        piezas.add(curandero);
        piezas.add(soldado2);

        assertTrue(aux.estanContiguos(piezas));
    }

    @Test
    public void test11DevuelveTrueSiLasPiezasEstanContiguasEnCualquierDireccion() {
        AnalizadorDeBatallon aux = new AnalizadorDeBatallon();
        Infanteria soldado1 = new Infanteria(1,1,1);
        Pieza curandero = new Infanteria(2,3,1);
        Infanteria soldado2 = new Infanteria(1,2,2);

        ArrayList<Pieza> piezas = new ArrayList<>();
        piezas.add(soldado1);
        piezas.add(curandero);
        piezas.add(soldado2);

        assertTrue(aux.estanContiguos(piezas));
    }

    @Test
    public void test12DevuelveTrueSiLas3PiezasEstanEnDiagonal() {
        AnalizadorDeBatallon aux = new AnalizadorDeBatallon();
        Infanteria soldado1 = new Infanteria(1,1,1);
        Pieza curandero = new Infanteria(2,2,2);
        Infanteria soldado2 = new Infanteria(1,3,3);

        ArrayList<Pieza> piezas = new ArrayList<>();
        piezas.add(soldado1);
        piezas.add(curandero);
        piezas.add(soldado2);

        assertTrue(aux.estanContiguos(piezas));
    }

    @Test
    public void test13FormanBatallonDevuelveFalseSi3PiezasEstanContiguasPeroNoSonTodasDeInfanteria() {
        AnalizadorDeBatallon aux = new AnalizadorDeBatallon();
        Infanteria soldado1 = new Infanteria(1,1,1);
        Curandero curandero = new Curandero(1,2,1);
        Infanteria soldado2 = new Infanteria(1,3,1);

        ArrayList<Pieza> piezas = new ArrayList<>();
        piezas.add(soldado1);
        piezas.add(curandero);
        piezas.add(soldado2);

        assertFalse(aux.formanBatallon(piezas));
    }

    @Test
    public void test14FormanBatallonDevuelveFalseSi3InfanteriaEstanContiguasPeroNoSonAliados() {
        AnalizadorDeBatallon aux = new AnalizadorDeBatallon();
        Infanteria soldado1 = new Infanteria(1,1,1);
        Infanteria curandero = new Infanteria(2,2,1);
        Infanteria soldado2 = new Infanteria(1,3,1);

        ArrayList<Pieza> piezas = new ArrayList<>();
        piezas.add(soldado1);
        piezas.add(curandero);
        piezas.add(soldado2);
        assertFalse(aux.formanBatallon(piezas));
    }

    @Test
    public void test15FormanBatallonDevuelveFalseSi3InfanteriaSonAliadosPeroNoSonEstanContiguos() {
        AnalizadorDeBatallon aux = new AnalizadorDeBatallon();
        Infanteria soldado1 = new Infanteria(1,1,1);
        Infanteria curandero = new Infanteria(1,2,1);
        Infanteria soldado2 = new Infanteria(1,2,3);

        ArrayList<Pieza> piezas = new ArrayList<>();
        piezas.add(soldado1);
        piezas.add(curandero);
        piezas.add(soldado2);
        assertFalse(aux.formanBatallon(piezas));
    }
}
