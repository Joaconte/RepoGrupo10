package controlador.buttonHandlers.agregarPiezasEventHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import modelo.jugador.PiezaFueraDeSectorException;
import modelo.jugador.UbicacionInvalidaException;
import modelo.jugador.presupuesto.CompraInvalidaException;
import modelo.jugador.presupuesto.PresupuestoAgotadoException;
import modelo.pieza.Pieza;
import modelo.pieza.Ubicacion;
import vista.CamposDeTexto;
import vista.VistaDeTablero;
import vista.VistaDeUnidad;
import vista.fases.faseInicial.EtiquetaPuntosJugador;

public abstract class BotonAgregarPiezaEventHandler implements EventHandler<ActionEvent> {

    private Ubicacion ubicacion;
    private Label comunicadoTexto;
    private VistaDeTablero vistaDeTablero;
    private EtiquetaPuntosJugador etiquetaPuntos;
    private String nombre;

    public BotonAgregarPiezaEventHandler(Label etiquetaAlertas, Ubicacion ubicacion, VistaDeTablero vistaDeTablero, EtiquetaPuntosJugador etiquetaPuntos, String nombre) {

        this.ubicacion = ubicacion;
        comunicadoTexto = etiquetaAlertas;
        this.vistaDeTablero = vistaDeTablero;
        this.etiquetaPuntos= etiquetaPuntos;
        this.nombre = nombre;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        try {
            crearPiezaYAgregarATablero(ubicacion.getPosicionEnX(), ubicacion.getPosicionEnY(), vistaDeTablero);
            etiquetaPuntos.actualizarEtiqueta();
        }
        catch (NumberFormatException e){
            this.comunicadoTexto.setText("Debe ingresar numeros");
            this.comunicadoTexto.setTextFill(Color.web("#FF0000"));
        }
    }


    public void crearPiezaYAgregarATablero(int x, int y, VistaDeTablero vistaDeTablero){
        try {
            this.comunicadoTexto.setText("Tropa agregada con exito");
            this.comunicadoTexto.setTextFill(Color.web("#336600"));
            Pieza pieza = etiquetaPuntos.juego.crearPieza(nombre, x, y);
            VistaDeUnidad vistaDeUnidad = new VistaDeUnidad(vistaDeTablero, pieza, nombre.toLowerCase());

        }
        catch ( PiezaFueraDeSectorException e){
            this.comunicadoTexto.setText("Ubica la pieza en tu sector.");
            this.comunicadoTexto.setTextFill(Color.web("#FF0000")); }
        catch (PresupuestoAgotadoException e){
            this.comunicadoTexto.setText("Ya puedes acabar tu turno.");
            this.comunicadoTexto.setTextFill(Color.web("#FF0000")); }
        catch (UbicacionInvalidaException e){
            this.comunicadoTexto.setText("Ya hay una pieza en la casilla.");
            this.comunicadoTexto.setTextFill(Color.web("#FF0000")); }
        catch (CompraInvalidaException  e){
            this.comunicadoTexto.setText("Presupuesto insuficiente para la pieza.");
            this.comunicadoTexto.setTextFill(Color.web("#FF0000")); }


    }

}