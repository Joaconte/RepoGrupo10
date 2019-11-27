package modelo.pieza;

import modelo.pieza.tipos.Infanteria;
import org.junit.Test;
import modelo.pieza.tipos.Auxiliares;
import modelo.pieza.tipos.Curandero;

import static org.junit.Assert.*;


public class AuxiliaresTest {
    @Test
    public void test01DevuelveFalseSiAlgunaDelasPiezasNoEsAliada() {
        Auxiliares aux = new Auxiliares();

        Infanteria soldado1 = new Infanteria(1,1,1);
        Curandero curandero = new Curandero(2,1,2);
        Infanteria soldado2 = new Infanteria(1,1,3);

        assertFalse(aux.son3Aliados(soldado1,soldado2,curandero));
    }

    @Test
    public void test02DevuelveTrueSiTodaslasPiezasSonDelMismoEquipo() {
        Auxiliares aux = new Auxiliares();
        Infanteria soldado1 = new Infanteria(1,1,1);
        Curandero curandero = new Curandero(1,1,2);;
        Infanteria soldado2 = new Infanteria(1,1,3);

        assertTrue(aux.son3Aliados(soldado1,soldado2,curandero));
    }

    @Test
    public void test03DevuelveFalseSiAlgunaDelasPiezasNoEsDeInfanteria() {
        Auxiliares aux = new Auxiliares();
        Infanteria soldado1 = new Infanteria(1,1,1);
        Curandero curandero = new Curandero(2,1,2);
        Infanteria soldado2 = new Infanteria(1,1,3);

        assertFalse(aux.los3SonDeInfanteria(soldado1,soldado2,curandero));
    }

    @Test
    public void test04DevuelveTrueSiTodaslasPiezasSonDeInfanteria() {
        Auxiliares aux = new Auxiliares();
        Infanteria soldado1 = new Infanteria(1,1,1);
        Infanteria curandero = new Infanteria(2,1,2);
        Infanteria soldado2 = new Infanteria(1,1,3);

        assertTrue(aux.los3SonDeInfanteria(soldado1,soldado2,curandero));
    }

    @Test
    public void test05SonAliadosDeInfanteriaDevuelveFalseSiAlgunaPiezaEsEnemiga() {
        Auxiliares aux = new Auxiliares();
        Infanteria soldado1 = new Infanteria(1,1,1);
        Pieza curandero = new Infanteria(2,1,2);
        Infanteria soldado2 = new Infanteria(1,1,3);

        assertFalse(aux.sonAliadosDeInfanteria(soldado1,soldado2,curandero));
    }

    @Test
    public void test06SonAliadosDeInfanteriaDevuelveFalseSiAlgunaPiezaNoEsDeInfanteria() {
        Auxiliares aux = new Auxiliares();
        Infanteria soldado1 = new Infanteria(1,1,1);
        Pieza curandero = new Curandero(1,1,2);
        Infanteria soldado2 = new Infanteria(1,1,3);

        assertFalse(aux.sonAliadosDeInfanteria(soldado1,soldado2,curandero));
    }

    @Test
    public void test07SonAliadosDeInfanteriaDevuelveTrueSiTodasLasPiezasSonDeInfanteriaYSonDelMismoEquipo() {
        Auxiliares aux = new Auxiliares();
        Infanteria soldado1 = new Infanteria(1,1,1);
        Pieza curandero = new Infanteria(1,1,2);
        Infanteria soldado2 = new Infanteria(1,1,3);

        assertTrue(aux.sonAliadosDeInfanteria(soldado1,soldado2,curandero));
    }
    @Test
    public void test08DevuelveFalseSiAlgunaDeLasPiezasNoEstaPegadaAOtra() {
        Auxiliares aux = new Auxiliares();
        Infanteria soldado1 = new Infanteria(1,1,1);
        Pieza curandero = new Infanteria(2,1,2);
        Infanteria soldado2 = new Infanteria(1,1,4);

        assertFalse(aux.estanContiguos(soldado1,soldado2,curandero));
    }

    @Test
    public void test09DevuelveTrueSiLasPiezasEstanContiguasEnElMismoX() {
        Auxiliares aux = new Auxiliares();
        Infanteria soldado1 = new Infanteria(1,1,1);
        Pieza curandero = new Infanteria(2,1,2);
        Infanteria soldado2 = new Infanteria(1,1,3);

        assertTrue(aux.estanContiguos(soldado1,soldado2,curandero));
    }

    @Test
    public void test10DevuelveTrueSiLasPiezasEstanContiguasEnElMismoY() {
        Auxiliares aux = new Auxiliares();
        Infanteria soldado1 = new Infanteria(1,2,1);
        Pieza curandero = new Infanteria(2,1,1);
        Infanteria soldado2 = new Infanteria(1,3,1);

        assertTrue(aux.estanContiguos(soldado1,soldado2,curandero));
    }

    @Test
    public void test11DevuelveTrueSiLasPiezasEstanContiguasEnCualquierDireccion() {
        Auxiliares aux = new Auxiliares();
        Infanteria soldado1 = new Infanteria(1,1,1);
        Pieza curandero = new Infanteria(2,3,1);
        Infanteria soldado2 = new Infanteria(1,2,2);

        assertTrue(aux.estanContiguos(soldado1,soldado2,curandero));
    }

    @Test
    public void test12DevuelveTrueSiLas3PiezasEstanEnDiagonal() {
        Auxiliares aux = new Auxiliares();
        Infanteria soldado1 = new Infanteria(1,1,1);
        Pieza curandero = new Infanteria(2,2,2);
        Infanteria soldado2 = new Infanteria(1,3,3);

        assertTrue(aux.estanContiguos(soldado1,soldado2,curandero));
    }

    @Test
    public void test13FormanBatallonDevuelveFalseSi3PiezasEstanContiguasPeroNoSonTodasDeInfanteria() {
        Auxiliares aux = new Auxiliares();
        Infanteria soldado1 = new Infanteria(1,1,1);
        Curandero curandero = new Curandero(1,2,1);
        Infanteria soldado2 = new Infanteria(1,3,1);

        assertFalse(aux.formanBatallon(soldado1,soldado2,curandero));
    }

    @Test
    public void test14FormanBatallonDevuelveFalseSi3InfanteriaEstanContiguasPeroNoSonAliados() {
        Auxiliares aux = new Auxiliares();
        Infanteria soldado1 = new Infanteria(1,1,1);
        Infanteria curandero = new Infanteria(2,2,1);
        Infanteria soldado2 = new Infanteria(1,3,1);

        assertFalse(aux.formanBatallon(soldado1,soldado2,curandero));
    }

    @Test
    public void test15FormanBatallonDevuelveFalseSi3InfanteriaSonAliadosPeroNoSonEstanContiguos() {
        Auxiliares aux = new Auxiliares();
        Infanteria soldado1 = new Infanteria(1,1,1);
        Infanteria curandero = new Infanteria(1,2,1);
        Infanteria soldado2 = new Infanteria(1,2,3);

        assertFalse(aux.formanBatallon(soldado1,soldado2,curandero));
    }
}
