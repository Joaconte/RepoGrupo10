package controlador.buttonHandlers.agregarPiezasEventHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import modelo.jugador.PiezaFueraDeSectorException;
import modelo.jugador.UbicacionInvalidaException;
import modelo.jugador.presupuesto.CompraInvalidaException;
import modelo.jugador.presupuesto.PresupuestoAgotadoException;
import modelo.pieza.Pieza;
import modelo.pieza.Ubicacion;
import resources.sonidos.Audio;
import vista.VistaDeTablero;
import vista.fasesPartida.faseInicialPartida.EtiquetaPresupuestoJugador;

public abstract class BotonAgregarPiezaEventHandler implements EventHandler<ActionEvent> {

    private Ubicacion ubicacion;
    private Label textoComunicador;
    protected VistaDeTablero vistaDeTablero;
    private EtiquetaPresupuestoJugador etiquetaPuntos;
    private String nombre;

    public BotonAgregarPiezaEventHandler(Ubicacion ubicacion, VistaDeTablero vistaDeTablero, EtiquetaPresupuestoJugador etiquetaPuntos, String nombre, Label etiquetaComunicadora) {

        this.ubicacion = ubicacion;
        textoComunicador = etiquetaComunicadora;
        this.vistaDeTablero = vistaDeTablero;
        this.etiquetaPuntos= etiquetaPuntos;
        this.nombre = nombre;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            int x = ubicacion.getPosicionEnX();
            int y = ubicacion.getPosicionEnY();
            crearPiezaYAgregarATablero(x, y, vistaDeTablero);
            etiquetaPuntos.actualizarEtiqueta();
        } catch (NumberFormatException e) {
            this.textoComunicador.setText("Debe ingresar numeros");
            this.textoComunicador.setTextFill(Color.web("#FF0000"));
        }

    }

    public void crearPiezaYAgregarATablero(int x, int y, VistaDeTablero vistaDeTablero){
        try {
            agregarPiezaATablero( etiquetaPuntos.juego.crearPieza(nombre, x, y));
            this.textoComunicador.setText("Tropa agregada con exito");
            this.textoComunicador.setTextFill(Color.web("#336600"));
            //Audio.reproducirCreacionUnidad(nombre);
        }
        catch ( PiezaFueraDeSectorException e){
            this.textoComunicador.setText("Ubica la pieza en tu sector.");
            this.textoComunicador.setTextFill(Color.web("#FF0000")); }
        catch (PresupuestoAgotadoException e){
            this.textoComunicador.setText("Ya puedes acabar tu turno.");
            this.textoComunicador.setTextFill(Color.web("#FF0000")); }
        catch (UbicacionInvalidaException e){
            this.textoComunicador.setText("Ya hay una pieza en la casilla.");
            this.textoComunicador.setTextFill(Color.web("#FF0000")); }
        catch (CompraInvalidaException  e){
            this.textoComunicador.setText("Presupuesto insuficiente para la pieza.");
            this.textoComunicador.setTextFill(Color.web("#FF0000")); }
    }

    abstract void agregarPiezaATablero(Pieza pieza);

}