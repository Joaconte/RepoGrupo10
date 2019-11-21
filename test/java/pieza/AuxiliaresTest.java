package pieza;

import org.junit.Test;
import pieza.tipos.Auxiliares;
import pieza.tipos.Curandero;
import pieza.tipos.Infanteria;

import static org.junit.Assert.*;


public class AuxiliaresTest {
    @Test
    public void test01DevuelveFalseSiAlgunaDelasPiezasNoEsAliada() {
        Auxiliares aux = new Auxiliares();
        Infanteria soldado1 = new Infanteria();
        soldado1.setUbicacion(new Ubicacion(1,1));
        soldado1.setEquipo(1);
        Curandero curandero = new Curandero();
        curandero.setUbicacion(new Ubicacion(1,2));
        curandero.setEquipo(2);
        Infanteria soldado2 = new Infanteria();
        soldado2.setUbicacion(new Ubicacion(1,3));
        soldado2.setEquipo(1);
        assertFalse(aux.son3Aliados(soldado1,soldado2,curandero));
    }

    @Test
    public void test02DevuelveTrueSiTodaslasPiezasSonDelMismoEquipo() {
        Auxiliares aux = new Auxiliares();
        Infanteria soldado1 = new Infanteria();
        soldado1.setUbicacion(new Ubicacion(1,1));
        soldado1.setEquipo(1);
        Curandero curandero = new Curandero();
        curandero.setUbicacion(new Ubicacion(1,2));
        curandero.setEquipo(1);
        Infanteria soldado2 = new Infanteria();
        soldado2.setUbicacion(new Ubicacion(1,3));
        soldado2.setEquipo(1);
        assertTrue(aux.son3Aliados(soldado1,soldado2,curandero));
    }

    @Test
    public void test03DevuelveFalseSiAlgunaDelasPiezasNoEsDeInfanteria() {
        Auxiliares aux = new Auxiliares();
        Infanteria soldado1 = new Infanteria();
        soldado1.setUbicacion(new Ubicacion(1,1));
        soldado1.setEquipo(1);
        Curandero curandero = new Curandero();
        curandero.setUbicacion(new Ubicacion(1,2));
        curandero.setEquipo(2);
        Infanteria soldado2 = new Infanteria();
        soldado2.setUbicacion(new Ubicacion(1,3));
        soldado2.setEquipo(1);
        assertFalse(aux.los3SonDeInfanteria(soldado1,soldado2,curandero));
    }

    @Test
    public void test04DevuelveTrueSiTodaslasPiezasSonDeInfanteria() {
        Auxiliares aux = new Auxiliares();
        Infanteria soldado1 = new Infanteria();
        soldado1.setUbicacion(new Ubicacion(1,1));
        soldado1.setEquipo(1);
        Pieza curandero = new Infanteria();
        curandero.setUbicacion(new Ubicacion(1,2));
        curandero.setEquipo(2);
        Infanteria soldado2 = new Infanteria();
        soldado2.setUbicacion(new Ubicacion(1,3));
        soldado2.setEquipo(1);
        assertTrue(aux.los3SonDeInfanteria(soldado1,soldado2,curandero));
    }

    @Test
    public void test05SonAliadosDeInfanteriaDevuelveFalseSiAlgunaPiezaEsEnemiga() {
        Auxiliares aux = new Auxiliares();
        Infanteria soldado1 = new Infanteria();
        soldado1.setUbicacion(new Ubicacion(1,1));
        soldado1.setEquipo(1);
        Pieza curandero = new Infanteria();
        curandero.setUbicacion(new Ubicacion(1,2));
        curandero.setEquipo(2);
        Infanteria soldado2 = new Infanteria();
        soldado2.setUbicacion(new Ubicacion(1,3));
        soldado2.setEquipo(1);
        assertFalse(aux.sonAliadosDeInfanteria(soldado1,soldado2,curandero));
    }

    @Test
    public void test06SonAliadosDeInfanteriaDevuelveFalseSiAlgunaPiezaNoEsDeInfanteria() {
        Auxiliares aux = new Auxiliares();
        Infanteria soldado1 = new Infanteria();
        soldado1.setUbicacion(new Ubicacion(1,1));
        soldado1.setEquipo(1);
        Pieza curandero = new Curandero();
        curandero.setUbicacion(new Ubicacion(1,2));
        curandero.setEquipo(1);
        Infanteria soldado2 = new Infanteria();
        soldado2.setUbicacion(new Ubicacion(1,3));
        soldado2.setEquipo(1);
        assertFalse(aux.sonAliadosDeInfanteria(soldado1,soldado2,curandero));
    }

    @Test
    public void test07SonAliadosDeInfanteriaDevuelveTrueSiTodasLasPiezasSonDeInfanteriaYSonDelMismoEquipo() {
        Auxiliares aux = new Auxiliares();
        Infanteria soldado1 = new Infanteria();
        soldado1.setUbicacion(new Ubicacion(1,1));
        soldado1.setEquipo(1);
        Pieza curandero = new Infanteria();
        curandero.setUbicacion(new Ubicacion(1,2));
        curandero.setEquipo(1);
        Infanteria soldado2 = new Infanteria();
        soldado2.setUbicacion(new Ubicacion(1,3));
        soldado2.setEquipo(1);
        assertTrue(aux.sonAliadosDeInfanteria(soldado1,soldado2,curandero));
    }
    @Test
    public void test08DevuelveFalseSiAlgunaDeLasPiezasNoEstaPegadaAOtra() {
        Auxiliares aux = new Auxiliares();
        Infanteria soldado1 = new Infanteria();
        soldado1.setUbicacion(new Ubicacion(1,1));
        soldado1.setEquipo(1);
        Pieza curandero = new Infanteria();
        curandero.setUbicacion(new Ubicacion(1,2));
        curandero.setEquipo(2);
        Infanteria soldado2 = new Infanteria();
        soldado2.setUbicacion(new Ubicacion(1,4));
        soldado2.setEquipo(1);
        assertFalse(aux.estanContiguos(soldado1,soldado2,curandero));
    }

    @Test
    public void test09DevuelveTrueSiLasPiezasEstanContiguasEnElMismoX() {
        Auxiliares aux = new Auxiliares();
        Infanteria soldado1 = new Infanteria();
        soldado1.setUbicacion(new Ubicacion(1,1));
        soldado1.setEquipo(1);
        Pieza curandero = new Infanteria();
        curandero.setUbicacion(new Ubicacion(1,2));
        curandero.setEquipo(2);
        Infanteria soldado2 = new Infanteria();
        soldado2.setUbicacion(new Ubicacion(1,3));
        soldado2.setEquipo(1);
        assertTrue(aux.estanContiguos(soldado1,soldado2,curandero));
    }

    @Test
    public void test10DevuelveTrueSiLasPiezasEstanContiguasEnElMismoY() {
        Auxiliares aux = new Auxiliares();
        Infanteria soldado1 = new Infanteria();
        soldado1.setUbicacion(new Ubicacion(2,1));
        soldado1.setEquipo(1);
        Pieza curandero = new Infanteria();
        curandero.setUbicacion(new Ubicacion(1,1));
        curandero.setEquipo(2);
        Infanteria soldado2 = new Infanteria();
        soldado2.setUbicacion(new Ubicacion(3,1));
        soldado2.setEquipo(1);
        assertTrue(aux.estanContiguos(soldado1,soldado2,curandero));
    }

    @Test
    public void test11DevuelveTrueSiLasPiezasEstanContiguasEnCualquierDireccion() {
        Auxiliares aux = new Auxiliares();
        Infanteria soldado1 = new Infanteria();
        soldado1.setUbicacion(new Ubicacion(1,1));
        soldado1.setEquipo(1);
        Pieza curandero = new Infanteria();
        curandero.setUbicacion(new Ubicacion(3,1));
        curandero.setEquipo(2);
        Infanteria soldado2 = new Infanteria();
        soldado2.setUbicacion(new Ubicacion(2,2));
        soldado2.setEquipo(1);
        assertTrue(aux.estanContiguos(soldado1,soldado2,curandero));
    }

    @Test
    public void test12DevuelveTrueSiLas3PiezasEstanEnDiagonal() {
        Auxiliares aux = new Auxiliares();
        Infanteria soldado1 = new Infanteria();
        soldado1.setUbicacion(new Ubicacion(1,1));
        soldado1.setEquipo(1);
        Pieza curandero = new Infanteria();
        curandero.setUbicacion(new Ubicacion(2,2));
        curandero.setEquipo(2);
        Infanteria soldado2 = new Infanteria();
        soldado2.setUbicacion(new Ubicacion(3,3));
        soldado2.setEquipo(1);
        assertTrue(aux.estanContiguos(soldado1,soldado2,curandero));
    }

    @Test
    public void test13FormanBatallonDevuelveFalseSi3PiezasEstanContiguasPeroNoSonTodasDeInfanteria() {
        Auxiliares aux = new Auxiliares();
        Infanteria soldado1 = new Infanteria();
        soldado1.setUbicacion(new Ubicacion(1,1));
        soldado1.setEquipo(1);
        Pieza curandero = new Curandero();
        curandero.setUbicacion(new Ubicacion(2,1));
        curandero.setEquipo(1);
        Infanteria soldado2 = new Infanteria();
        soldado2.setUbicacion(new Ubicacion(3,1));
        soldado2.setEquipo(1);
        assertFalse(aux.formanBatallon(soldado1,soldado2,curandero));
    }

    @Test
    public void test14FormanBatallonDevuelveFalseSi3InfanteriaEstanContiguasPeroNoSonAliados() {
        Auxiliares aux = new Auxiliares();
        Infanteria soldado1 = new Infanteria();
        soldado1.setUbicacion(new Ubicacion(1,1));
        soldado1.setEquipo(1);
        Pieza curandero = new Infanteria();
        curandero.setUbicacion(new Ubicacion(2,1));
        curandero.setEquipo(2);
        Infanteria soldado2 = new Infanteria();
        soldado2.setUbicacion(new Ubicacion(3,1));
        soldado2.setEquipo(1);
        assertFalse(aux.formanBatallon(soldado1,soldado2,curandero));
    }

    @Test
    public void test15FormanBatallonDevuelveFalseSi3InfanteriaEstanContiguasSonAliadosPeroNoSonEstanContiguos() {
        Auxiliares aux = new Auxiliares();
        Infanteria soldado1 = new Infanteria();
        soldado1.setUbicacion(new Ubicacion(1,1));
        soldado1.setEquipo(1);
        Pieza curandero = new Infanteria();
        curandero.setUbicacion(new Ubicacion(2,1));
        curandero.setEquipo(1);
        Infanteria soldado2 = new Infanteria();
        soldado2.setUbicacion(new Ubicacion(2,3));
        soldado2.setEquipo(1);
        assertFalse(aux.formanBatallon(soldado1,soldado2,curandero));
    }
}
