package controlador.buttonHandlers.agregarPiezasEventHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.Juego;
import modelo.jugador.PiezaFueraDeSectorException;
import modelo.jugador.UbicacionInvalidaException;
import modelo.jugador.presupuesto.CompraInvalidaException;
import modelo.jugador.presupuesto.PresupuestoAgotadoException;
import modelo.pieza.Pieza;
import resources.sonidos.Audio;
import vista.VistaDeTablero;
import vista.fasesPartida.faseInicialPartida.BarraLateralOpciones;

public abstract class BotonAgregarPiezaEventHandler implements EventHandler<ActionEvent> {

    protected VistaDeTablero vistaDeTablero;
    private String nombre;
    private BarraLateralOpciones vistaLateral;
    private Juego juego;

    public BotonAgregarPiezaEventHandler(VistaDeTablero vistaDeTablero, String nombre, BarraLateralOpciones vistaLateral, Juego juego) {

        this.juego=juego;
        this.vistaDeTablero = vistaDeTablero;
        this.nombre = nombre;
        this.vistaLateral=vistaLateral;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            crearPiezaYAgregarATablero(vistaDeTablero.getUbicacionDelCursorX(), vistaDeTablero.getUbicacionDelCursorY());

        } catch (Exception e) {
            vistaLateral.vistaAlertas(e.getMessage());
            Audio.reproducirAlerta();
        }

    }

    public void crearPiezaYAgregarATablero(int x, int y){
        try {
            agregarPiezaATablero( juego.crearPieza(nombre, x, y),juego);
            Audio.reproducirCreacionUnidad(nombre.toLowerCase());
            vistaLateral.vistaPuntosActualizada(nombre);
        }
        catch ( PiezaFueraDeSectorException e){ vistaLateral.vistaAlertas("Ubica la pieza en tu sector."); }
        catch (PresupuestoAgotadoException e){ vistaLateral.vistaAlertas("Ya puedes acabar tu turno.");}
        catch (UbicacionInvalidaException e){ vistaLateral.vistaAlertas("Casilla ocupada.");}
        catch (CompraInvalidaException  e){ vistaLateral.vistaAlertas("Presupuesto insuficiente para la pieza.");}
    }

    abstract void agregarPiezaATablero(Pieza pieza, Juego juego);

}